package com.challenge.shapes;

public class Line {

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
