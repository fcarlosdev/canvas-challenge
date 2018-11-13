package com.challenge.shapes;

public class Rectangle {

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
