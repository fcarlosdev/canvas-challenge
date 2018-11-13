package com.challenge.commands;

import com.challenge.shapes.Canvas;

public class DrawCanvasOperation implements CommandOperation {
		
	private Canvas drawingArea;
	
	public DrawCanvasOperation(int width, int height) {
		drawingArea = new Canvas(width, height);
	}
	
	@Override
	public Canvas execute() {			
		return drawingArea.createCanvas();
	}

}
