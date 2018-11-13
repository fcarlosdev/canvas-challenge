package com.challenge.commands;

import com.challenge.shapes.Canvas;
import com.challenge.shapes.Point;
import com.challenge.shapes.Rectangle;

public class DrawRectangleOperation implements CommandOperation {

	
	private Rectangle rectangle;
	private Canvas drawingArea;
	private Point initialPosition;
	private Point finalPosition;

	public DrawRectangleOperation(Canvas drawingArea, Point initialPosition, Point finalPosition) {
		
		rectangle = new Rectangle();
		this.drawingArea = drawingArea;
		this.initialPosition = initialPosition;
		this.finalPosition = finalPosition;
	}
	
	@Override
	public Canvas execute() {
		return rectangle.draw(drawingArea, initialPosition, finalPosition);
	}

}
