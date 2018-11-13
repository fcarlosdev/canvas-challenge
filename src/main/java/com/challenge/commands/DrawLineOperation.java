package com.challenge.commands;

import com.challenge.shapes.Canvas;
import com.challenge.shapes.Line;
import com.challenge.shapes.Point;

public class DrawLineOperation implements CommandOperation {

	private Line line;
	private Canvas drawingArea;
	private Point ini;
	private Point end;
	
	public DrawLineOperation(Canvas drawingArea, Point ini, Point end) {
		line = new Line();
		this.drawingArea = drawingArea;
		this.ini = ini;
		this.end = end;
	}
	
	@Override
	public Canvas execute() {	
		return line.drawLine(drawingArea, ini, end);
	}

}
