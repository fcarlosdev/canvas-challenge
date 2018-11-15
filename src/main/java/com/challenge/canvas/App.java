package com.challenge.canvas;

import com.challenge.commands.*;
import com.challenge.shapes.Canvas;
import com.challenge.shapes.Point;
import com.challenge.validation.*;

import java.util.Scanner;

public class App {

	private static Canvas canvas;
	private static ParametersValidator paramsValidator;

	public static void main(String[] args) {

		String enteredCommand = "";
		Scanner command = new Scanner(System.in);
		CommandExecutor executor = new CommandExecutor();


		while (!enteredCommand.equals("Q")) {

			System.out.print("Enter a command: ");
			String[] commandParts = command.nextLine().split(" ");
			enteredCommand = commandParts[0];

			if (enteredCommand.equals("C")) {

			    paramsValidator = new CanvasParamsValidator();

				if (paramsValidator.validateParameters(commandParts)) {
                    int width = Integer.parseInt(commandParts[1])+2;
                    int height = Integer.parseInt(commandParts[2])+2;
                    executeCommand(executor, new DrawCanvasOperation(width, height));
                } else {
                    System.out.println("Invalid parameters.");
                }

			} else if (enteredCommand.equals("L")) {
				if (canvas == null) {
					System.out.println("No canvas created");
				} else {

                    paramsValidator = new LineParamsValidator();

				    if (paramsValidator.validateParameters(commandParts)) {
                        Point start = new Point(Integer.parseInt(commandParts[1]), Integer.parseInt(commandParts[2]));
                        Point finish = new Point(Integer.parseInt(commandParts[3]), Integer.parseInt(commandParts[4]));
                        executeCommand(executor, new DrawLineOperation(canvas, start, finish));
                    } else {
                        System.out.println("Invalid parameters.");
                    }
                }

            } else if (enteredCommand.equals("R")) {
                if (canvas == null) {
                    System.out.println("No canvas created");
                } else {

                    paramsValidator = new RectangleParamsValidator();

                    if (paramsValidator.validateParameters(commandParts)) {
                        Point start = new Point(Integer.parseInt(commandParts[1]),Integer.parseInt(commandParts[2]));
                        Point finish = new Point(Integer.parseInt(commandParts[3]),Integer.parseInt(commandParts[4]));
                        executeCommand(executor, new DrawRectangleOperation(canvas,start, finish));
                    } else {
                        System.out.println("Invalid parameters.");
                    }
                }
            } else if (enteredCommand.equals("B")) {

                if (canvas == null) {
                    System.out.println("No canvas created");
                } else {

                    paramsValidator = new BucketFillParamsValidator();

                    if (paramsValidator.validateParameters(commandParts)) {
                        Point location = new Point(Integer.parseInt(commandParts[1]), Integer.parseInt(commandParts[2]));
                        String color = commandParts[3];
                        executeCommand(executor, new BucketFillOperation(canvas, location, color));
                    } else {
                        System.out.println("Invalid parameters.");
                    }
				}

			} else if (enteredCommand.equals("Q")) {
				System.out.println("End of the program");
				System.exit(1);
			} else {
				System.out.println("Command invalid!");
			}
		}

		command.close();
	}


	private static void executeCommand(CommandExecutor executor, CommandOperation command) {
		canvas = executor.executeOperation(command);
		displayCanvas(canvas.getDrawingArea());
	}

	private static void displayCanvas(String[][] printableArea) {

		for (int y = 0; y < canvas.getHeight(); y++) {

			for (int x = 0; x < canvas.getWidth(); x++) {

				if (printableArea[x][y] != null) {

					if (printableArea[x][y] != "nf") {
						System.out.print(printableArea[x][y]);
					} else {
						System.out.print(" ");
					}
				}
			}
			System.out.println();
		}

	}

}
