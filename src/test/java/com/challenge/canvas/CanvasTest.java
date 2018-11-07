package com.challenge.canvas;

import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;

public class CanvasTest extends TestCase {

	private Canvas canvas;
	
	@Before
	public void setUp() {		
		canvas = new Canvas();
	}

	@Test
	public void testCriarCanvasTwentyWidthByFourHeight() {

		StringBuffer canvasCreated = new StringBuffer();		
		canvasCreated.append("--------------------\n");
		canvasCreated.append("|                  |\n");
		canvasCreated.append("|                  |\n");
		canvasCreated.append("|                  |\n");
		canvasCreated.append("|                  |\n");
		canvasCreated.append("--------------------\n");  		
		
//		System.out.println(canvasCreated.toString());
		
		assertEquals(canvasCreated.toString(), canvas.drawCanvas(20,4).toString());
			
	}
	
	@Test
	public void testGetHeight() {
		assertEquals(0, canvas.getHeight());
	}
	
	@Test
	public void testGetWidth() {
		assertEquals(0, canvas.getWidth());
	}

}
