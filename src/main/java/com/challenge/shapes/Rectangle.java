package com.challenge.shapes;

import com.challenge.components.Canvas;
import com.challenge.components.Point;

public class Rectangle extends Shape {

	private Point from;
	private Point till;

	public Rectangle() {
	}

	public Rectangle(Point from, Point till) {
		this.from = from;
		this.till = till;
	}

	public void drawShapeAt(Canvas drawingArea) {

		if (from.getX() == till.getX() || from.getY() == till.getY()) {
			System.out.println("Enter different points");
		} else {

			for (int x = from.getX(); x <= till.getX(); x++) {

				for (int y = from.getY(); y <= till.getY(); y++) {

					if ((x == from.getX() || x == till.getX()) || (y == from.getY() || y == till.getY()) ) {
						drawingArea.getDrawingArea()[x][y] = "x";
					} else {
						drawingArea.getDrawingArea()[x][y] = "nf";
					}
				}
			}

		}

	}

	public Canvas draw(Canvas drawingArea, Point initialPosition, Point finalPosition) {
		
		if (initialPosition.getX() == finalPosition.getX() || initialPosition.getY() == finalPosition.getY()) {
			System.out.println("Enter different points");
		} else {

			for (int x = initialPosition.getX(); x <= finalPosition.getX(); x++) {

				for (int y = initialPosition.getY(); y <= finalPosition.getY(); y++) {

				  if ((x == initialPosition.getX() || x == finalPosition.getX()) || (y == initialPosition.getY() || y == finalPosition.getY()) ) {
					  drawingArea.getDrawingArea()[x][y] = "x";
				  } else {
					  drawingArea.getDrawingArea()[x][y] = "nf";
				  }
				}
			}

		}		
		return drawingArea;
	}

}
