package com.challenge.canvas;

/**
 * Hello world!
 *
 */
public class App {
	
	public static void main(String[] args) {
		
		int lines = 6;
		int columns = 22;
		
		String canvas[][] = new String[lines][columns];
				
		
		
		for (int i = 0; i < lines; i++) {			
			for (int j = 0; j < columns; j++) {
				if (i == 0 || i == 5) {
					canvas[i][j] = "-";
				} else {
					if (j == 0 || j == (columns-1)) {
						canvas[i][j] = "|";
					} else {
						canvas[i][j] = " ";						
					}
				}
			}
		}
		
		
		//Draw a horizontal line L 1 2 6 2
		
		for (int col = 1; col <= 6; col++) {
			canvas[2][col] = "x";
		}
		
		
		//Draw a vertical line L 6 3 6 4
		
		int column = 6;
		int line1 = 3;
		int line2 = 4;
		
		for (int ln = line1; ln < (line2+1); ln++) {
			
			for (int m = 0; m < 6; m++) {
				if (m > 0) {
					canvas[ln][m] = "nf";					
				}
			}
			
			canvas[ln][column] = "x";
		}
		
		//Draw Rectangle R 14 1 18 3		
		
		int lnIni = 1;
		int lnFim = 3;
		
		int colIni = 14;
		int colFim = 18;
		
		for (int line = lnIni; line < (lnFim + 1); line++ ) {
			
			
			for (int col = colIni; col <= colFim; col++) {
				if (line%2 == 0 ) {
					if (col != colIni && col != colFim) {
						canvas[line][col] = "nf";						
					} else {
						canvas[line][col] = "x";
					}
				} else {					
					canvas[line][col] = "x";
				}				
			}
		}
		
		
				
		//Bucket fill 10 3 o
		for (int l = 0; l < lines; l++) {
			
			for (int c = 0; c < columns; c++) {
				
				if (canvas[l][c] == " ") {
					
					canvas[l][c] = "o";
				}
			}
		}
		
			
		
		//Print canvas
		
		for(int line = 0; line < lines; line++) {
			
			for (int col = 0; col < columns; col++) {
				if (canvas[line][col] == "nf") {
					System.out.print(" ");
				} else {
					
					System.out.print(canvas[line][col]);
				}
			}
			
			System.out.println();
		}
		
		
	}
		
}
/*  
----------------------
|oooooooooooooxxxxxoo|
|xxxxxxooooooox   xoo|
|     xoooooooxxxxxoo|
|     xoooooooooooooo|
----------------------


----------------------
|             xxxxx  |
|xxxxxx       x   x  |
|     x       xxxxx  |
|     x              |
----------------------

*/