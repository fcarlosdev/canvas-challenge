package com.challenge.tools;

import com.challenge.shapes.Canvas;
import com.challenge.shapes.Point;

public class BucketFill {		
	
	private Canvas canvas;

	public Canvas fillArea(Canvas canvas, Point location, String color) {
		
		this.canvas = canvas;
		
		canvas.getDrawingArea()[location.getX()][location.getY()] = color;

		for (int x = (location.getX()-1); x > 0; x--) {

			if (emptySpot(x, location.getY())) {
			 canvas.getDrawingArea()[x][location.getY()] = color;
			}
		}

		for (int x = (location.getX()+1); x < (canvas.getWidth() - 1); x++) {
			if (emptySpot(x, location.getY())) {
				canvas.getDrawingArea()[x][location.getY()] = color;
			}
		}

		for (int y = (location.getY()-1); y > 0; y--) {
			if (emptySpot(location.getX(), y)) {
				canvas.getDrawingArea()[location.getX()][y] = color;
			}
		}

		for (int y = (location.getY()+1); y < (canvas.getHeight() -1); y++) {
			if (emptySpot(location.getX(), y)) {
				canvas.getDrawingArea()[location.getX()][y] = color;
			}
		}

		for (int x = (location.getX()-1); x > 0; x--) {

			for ( int y = (location.getY()-1); y > 0; y--) {

				if (emptySpot(x, y)) {
					canvas.getDrawingArea()[x][y] = color;
				}
			}
		}

		for (int x = (location.getX()+1); x < (canvas.getWidth()-1); x++) {

			for ( int y = (location.getY()+1); y < (canvas.getHeight() - 1); y++) {

				if (emptySpot(x, y)) {
					canvas.getDrawingArea()[x][y] = color;
				}
			}
		}

		for (int x = (location.getX()+1); x < (canvas.getWidth()-1); x++) {

			for ( int y = (location.getY()-1); y > 0; y--) {

				if (emptySpot(x, y)) {
					canvas.getDrawingArea()[x][y] = color;
				}

			}
		}

		for (int x = (location.getX()-1); x > 0; x--) {

			for ( int y = (location.getY()+1); y < (canvas.getHeight() - 1); y++) {

				if (emptySpot(x, y)) {
					canvas.getDrawingArea()[x][y] = color;
				}
			}
		}
				
		
		return canvas;
	}
	

	private boolean emptySpot(int x, int y) {
		return insideLimit(x,y) && (canvas.getDrawingArea()[x][y] == " ");
	}

	private boolean insideLimit(int x, int y) {
		return (( x > 0 && x < canvas.getWidth()) && ( y > 0 && y < canvas.getHeight()));
	}


}
