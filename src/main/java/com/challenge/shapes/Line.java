package com.challenge.shapes;

import com.challenge.components.Canvas;
import com.challenge.components.Point;

public class Line extends Shape {

	private Point from;
	private Point till;

	public Line() {
	}

	public Line(Point from, Point till) {
		this.from = from;
		this.till = till;
	}

	public void drawShapeAt(Canvas canvas) {

		if (from.getX() != till.getX() && from.getY() == till.getY()) {

			for (int x = from.getX(); x <= till.getX(); x++) {
				canvas.getDrawingArea()[x][from.getY()] = "x";
			}

		} else if (from.getX() == till.getX() && from.getY() != till.getY()) {

			for (int y = from.getY(); y <= till.getY(); y++) {
				canvas.getDrawingArea()[from.getX()][y] = "x";
				if ( from.getX() > 1) {
					for (int x = (from.getX()-1); x > 0; x--) {
						canvas.getDrawingArea()[x][y] = "nf";
					}
				} else if ( from.getX() < (canvas.getWidth() - 1)) {
					for (int x = (from.getX()+1); x < canvas.getWidth(); x++) {
						canvas.getDrawingArea()[x][y] = "nf";
					}
				}
			}
		}

	}


	public Canvas drawLine(Canvas canvas, Point ini, Point end) {
		
		if (ini.getX() != end.getX() && ini.getY() == end.getY()) {

			for (int x = ini.getX(); x <= end.getX(); x++) {
				canvas.getDrawingArea()[x][ini.getY()] = "x";
			}

		} else if (ini.getX() == end.getX() && ini.getY() != end.getY()) {

			for (int y = ini.getY(); y <= end.getY(); y++) {
				canvas.getDrawingArea()[ini.getX()][y] = "x";
				if ( ini.getX() > 1) {
					for (int x = (ini.getX()-1); x > 0; x--) {
						canvas.getDrawingArea()[x][y] = "nf";
					}
				} else if ( ini.getX() < (canvas.getWidth() - 1)) {
					for (int x = (ini.getX()+1); x < canvas.getWidth(); x++) {
						canvas.getDrawingArea()[x][y] = "nf";
					}
				}
			}
		}
		
		return canvas;
	}

}
