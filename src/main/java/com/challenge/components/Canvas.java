package com.challenge.components;

public class Canvas {

	private int width;
	private int height;
	private String[][] drawingArea;

	public Canvas(int width, int height) {

		this.width = (width + 2);
		this.height = (height + 2);
		drawingArea = new String[this.width][this.height];
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public String[][] getDrawingArea() {
		return drawingArea;
	}

	public Canvas createCanvas() {

		drawingArea = new String[width][height];

		for (int y = 0; y < height; y++) {

			for (int x = 0; x < width; x++) {

				if (y == 0 || y == (height-1)) {
					drawingArea[x][y] = "-";
				} else if (x != 0 && x != (width-1)) {
					drawingArea[x][y] = " ";
				} else {
					drawingArea[x][y] = "|";
					drawingArea[x][y] = "|";
				}
			}

		}
				
		return this;
	}

	public void drawCanvas() {

		for (int y = 0; y < height; y++) {

			for (int x = 0; x < width; x++) {

				if (drawingArea[x][y] != null) {

					if (drawingArea[x][y] != "nf") {
						System.out.print(drawingArea[x][y]);
					} else {
						System.out.print(" ");
					}
				}
			}
			System.out.println();
		}

	}

}
