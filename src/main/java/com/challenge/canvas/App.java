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
				
		   int x1 = Integer.parseInt(commandParts[1]);
		   int y1 = Integer.parseInt(commandParts[2]);
		   int x2 = Integer.parseInt(commandParts[3]);
		   int y2 = Integer.parseInt(commandParts[4]);
				
		   if (x1 != x2 && y1 == y2) {
		
		     for (int x = x1; x <= x2; x++) {	
			canvas[x][y1] = "x";
		     }
						
		   } else if (x1 == x2 && y1 != y2) {
		       for (int y = y1; y <= y2; y++) {						
			  canvas[x1][y] = "x";
		       }
		   }
				
		   displayCanvas(canvas);
				
		}
			
	    } else if (enteredCommand.equals("R")) {
			
	    } else if (enteredCommand.equals("B")) {
			
	    }  else if (enteredCommand.equals("Q")) {
	 	 System.out.println("Leaving the program");
	    }else {				
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

	private static void displayCanvas(String[][] canvas) {
		
		for (int y = 0; y < height; y++) {

			for (int x = 0; x < width; x++) {

				if (canvas[x][y] != null) {

					System.out.print(canvas[x][y]);
				}
			}

			System.out.println();
		}
	}
			
}
