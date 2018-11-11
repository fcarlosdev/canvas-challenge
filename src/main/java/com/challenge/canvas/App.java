package com.challenge.canvas;

public class App {

	private static int width;
	private static int height;

	private static String[][] canvas = null;

	public static void main(String[] args) {

		String enteredCommand = "";
		Scanner command = new Scanner(System.in);

		while (!enteredCommand.equals("Q")) {

			System.out.print("Enter a command: ");
			String[] commandParts = command.nextLine().split(" ");
			enteredCommand = commandParts[0];

			if (enteredCommand.equals("C")) {
				createCanvas(Integer.parseInt(commandParts[1])+2, Integer.parseInt(commandParts[2])+2);
				displayCanvas(canvas);
			} else if (enteredCommand.equals("L")) {
				if (canvas == null) {
					System.out.println("No canvas created");
				} else {
					createLine(commandParts);
					displayCanvas(canvas);
				}
			} else if (enteredCommand.equals("R")) {
				if (canvas == null) {
					System.out.println("No canvas created");
				} else {
					createRectangle(commandParts);
					displayCanvas(canvas);
				}
			} else if (enteredCommand.equals("B")) {

				if (canvas == null) {
					System.out.println("No canvas created");
				} else {
					bucketFill(commandParts);
					displayCanvas(canvas);
				}

			} else if (enteredCommand.equals("Q")) {
				System.out.println("End of the program");
			} else {
				System.out.println("Command invalid!");
			}
		}

		command.close();
	}

	private static void createCanvas(int w, int h) {

		width  = w;
		height = h;

		canvas = new String[width][height];

		for (int y = 0; y < height; y++) {

			for (int x = 0; x < width; x++) {

				if (y == 0 || y == (height-1)) {
					canvas[x][y] = "-";
				} else if (x != 0 && x != (width-1)) {
					canvas[x][y] = " ";
				} else {
					canvas[x][y] = "|";
					canvas[x][y] = "|";
				}
			}

		}
	}

	private static void createLine(String[] params) {

		int x1 = Integer.parseInt(params[1]);
		int y1 = Integer.parseInt(params[2]);
		int x2 = Integer.parseInt(params[3]);
		int y2 = Integer.parseInt(params[4]);

		if (x1 != x2 && y1 == y2) {

			for (int x = x1; x <= x2; x++) {
				canvas[x][y1] = "x";
			}

		} else if (x1 == x2 && y1 != y2) {

			for (int y = y1; y <= y2; y++) {
				canvas[x1][y] = "x";
				if ( x1 > 1) {
					for (int x = x1; x > 0; x--) {
						canvas[x][y] = "nf";
					}
				} else if ( x1 < (width - 1)) {
					for (int x = x1; x < width; x++) {
						canvas[x][y] = "nf";
					}
				}
			}
		}
	}

	private static void createRectangle(String[] params) {

		int x1 = Integer.parseInt(params[1]);
		int y1 = Integer.parseInt(params[2]);
		int x2 = Integer.parseInt(params[3]);
		int y2 = Integer.parseInt(params[4]);


		if (x1 == x2 || y1 == y2) {
			System.out.println("Enter different points");
		} else {

			for (int x = x1; x <= x2; x++) {

				for (int y = y1; y <= y2; y++) {

				  if ((x == x1 || x == x2) || (y == y1 || y == y2) ) {
					  canvas[x][y] = "x";
				  } else {
					  canvas[x][y] = "nf";
				  }
				}
			}

		}
	}

	private static void bucketFill(String[] params) {

		int x1 = Integer.parseInt(params[1]);
		int y1 = Integer.parseInt(params[2]);
		String color = params[3];

		canvas[x1][y1] = color;

		for (int x = (x1-1); x > 0; x--) {

			if (emptySpot(x, y1)) {
			 canvas[x][y1] = color;
			}
		}

		for (int x = (x1+1); x < (width - 1); x++) {
			if (emptySpot(x, y1)) {
				canvas[x][y1] = color;
			}
		}

		for (int y = (y1-1); y > 0; y--) {
			if (emptySpot(x1, y)) {
				canvas[x1][y] = color;
			}
		}

		for (int y = (y1+1); y < (height -1); y++) {
			if (emptySpot(x1, y)) {
				canvas[x1][y] = color;
			}
		}

		for (int x = (x1-1); x > 0; x--) {

			for ( int y = (y1-1); y > 0; y--) {

				if (emptySpot(x, y)) {
					canvas[x][y] = color;
				}
			}
		}

		for (int x = (x1+1); x < (width-1); x++) {

			for ( int y = (y1+1); y < (height - 1); y++) {

				if (emptySpot(x, y)) {
					canvas[x][y] = color;
				}
			}
		}

		for (int x = (x1+1); x < (width-1); x++) {

			for ( int y = (y1-1); y > 0; y--) {

				if (emptySpot(x, y)) {
					canvas[x][y] = color;
				}

			}
		}

		for (int x = (x1-1); x > 0; x--) {

			for ( int y = (y1+1); y < (height - 1); y++) {

				if (emptySpot(x, y)) {
					canvas[x][y] = color;
				}
			}
		}
	}

	private static void displayCanvas(String[][] canvas) {

		for (int y = 0; y < height; y++) {

			for (int x = 0; x < width; x++) {

				if (canvas[x][y] != null) {

					if (canvas[x][y] != "nf") {
						System.out.print(canvas[x][y]);
					} else {
						System.out.print(" ");
					}
				}
			}
			System.out.println();
		}

	}

	private static boolean emptySpot(int x, int y) {
		return insideLimit(x,y) && (canvas[x][y] == " ");
	}

	private static boolean insideLimit(int x, int y) {
		return (( x > 0 && x < width) && ( y > 0 && y < height));
	}
}
