package com.challenge.shapes;

public class Canvas {

	private int width;
	private int height;
	private String[][] drawingArea;

	public Canvas(int width, int height) {

		this.width = width;
		this.height = height;
		drawingArea = new String[width][height];
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

}
