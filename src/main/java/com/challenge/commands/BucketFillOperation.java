package com.challenge.commands;

import com.challenge.shapes.Canvas;
import com.challenge.shapes.Point;
import com.challenge.tools.BucketFill;

public class BucketFillOperation implements CommandOperation {

	private BucketFill bucketFill;
	private Canvas drawingArea;
	private Point location;
	private String color;
	
	public BucketFillOperation(Canvas drawingArea, Point location, String color) {
		this.bucketFill = new BucketFill();
		this.drawingArea = drawingArea;
		this.location = location;
		this.color = color;
	}
	
	@Override
	public Canvas execute() {		
		return bucketFill.fillArea(drawingArea, location, color);
	}

}
