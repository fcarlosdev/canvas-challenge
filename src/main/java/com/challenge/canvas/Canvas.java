package com.challenge.canvas;

public class Canvas {

	
	private int width;
	private int height;
		
	public Canvas() { }

	public int getWidth() {
		return width;
	}


	public int getHeight() {
		return height;
	}


	public String drawCanvas(int width, int height) {
				
		StringBuffer canvas = new StringBuffer();
		
		canvas.append(createHorizontalLine(width));						
		canvas.append(createVerticalLine(height, width));		
		canvas.append(createHorizontalLine(width));
		
//		System.out.println(canvas.toString());
		
		return canvas.toString();
	}
	
	private String createHorizontalLine(int size) {
		return String.format("%"+size+"s", " ").replace(" ", "-").concat("\n");
	}
	
	private String createVerticalLine(int height, int sizeSpaceBetween) {
		
		String verticalLine = "";
		
		for (int line = 0; line < height; line++) {
			verticalLine += String.format("|" + String.format("%"+(sizeSpaceBetween-2)+"s", " ") +"|\n");			
		}
								
		return verticalLine;
	}
	
}
