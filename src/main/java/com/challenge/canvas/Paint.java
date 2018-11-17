package com.challenge.canvas;

import com.challenge.commands.BucketFillCommand;
import com.challenge.commands.CreateCanvasCommand;
import com.challenge.commands.drawLineCommand;
import com.challenge.components.Canvas;
import com.challenge.components.Point;
import com.challenge.enums.CommandType;
import com.challenge.factories.*;
import com.challenge.validation.*;

import java.util.Scanner;

public class Paint {

    public static void main(String[] args) {

        Canvas canvas         = null;
        String command        = "";
        String[] commandParts;
        ParametersValidator paramsValidator;

        final CommandFactory cf = CommandFactory.init();
        final ShapeFactories df = new ShapeFactory();
        final ToolFactories tf  = new ToolBucketFillFactory();

        Scanner readCommand = new Scanner(System.in);

        while (!command.equals("Q")) {

            System.out.print("Enter a command: ");
            command = readCommand.nextLine();


            commandParts = command.split(" ");

            if (commandParts[0].equals(CommandType.CREATE_CANVAS.getValue())) {

                paramsValidator = new CanvasParamsValidator();

                if (paramsValidator.validateParameters(commandParts)) {
                    if (canvas == null) {
                        canvas = new Canvas(Integer.parseInt(commandParts[1]), Integer.parseInt(commandParts[2]));
                    }
                    cf.addCommand(CommandType.CREATE_CANVAS.getValue(), new CreateCanvasCommand(canvas));
                    cf.executeCommand(CommandType.CREATE_CANVAS.getValue());
                    canvas.drawCanvas();

                } else {
                    System.out.println("Invalid parameters.");
                }

            } else if (commandParts[0].equals(CommandType.DRAW_LINE.getValue())) {

                if (canvas == null) {
                    System.out.println("No canvas created");
                } else {

                    paramsValidator = new LineParamsValidator();

                    if (paramsValidator.validateParameters(commandParts)) {

                        Point from = new Point(Integer.parseInt(commandParts[1]), Integer.parseInt(commandParts[2]));
                        Point till = new Point(Integer.parseInt(commandParts[3]), Integer.parseInt(commandParts[4]));

                        cf.addCommand(CommandType.DRAW_LINE.getValue(), new drawLineCommand(canvas, df.createLine(from,till)));
                        cf.executeCommand(CommandType.DRAW_LINE.getValue());
                        canvas.drawCanvas();

                    } else {
                        System.out.println("Invalid parameters.");
                    }
                }

            } else if (commandParts[0].equals(CommandType.DRAW_RECTANGLE.getValue())) {

                if (canvas == null) {
                    System.out.println("No canvas created");
                } else {

                    paramsValidator = new RectangleParamsValidator();

                    if (paramsValidator.validateParameters(commandParts)) {

                        Point from = new Point(Integer.parseInt(commandParts[1]), Integer.parseInt(commandParts[2]));
                        Point till = new Point(Integer.parseInt(commandParts[3]), Integer.parseInt(commandParts[4]));

                        cf.addCommand(CommandType.DRAW_RECTANGLE.getValue(), new drawLineCommand(canvas, df.createRectangle(from,till)));
                        cf.executeCommand(CommandType.DRAW_RECTANGLE.getValue());
                        canvas.drawCanvas();

                    } else {
                        System.out.println("Invalid parameters.");
                    }
                }

            } else if (commandParts[0].equals(CommandType.FILL_EMPTY_AREA.getValue())) {

                if (canvas == null) {
                    System.out.println("No canvas created");
                } else {

                    paramsValidator = new BucketFillParamsValidator();

                    if (paramsValidator.validateParameters(commandParts)) {

                        Point from = new Point(Integer.parseInt(commandParts[1]), Integer.parseInt(commandParts[2]));
                        String color = commandParts[3];

                        cf.addCommand(CommandType.FILL_EMPTY_AREA.getValue(), new BucketFillCommand(canvas, tf.createBucketFill(from),color) );
                        cf.executeCommand(CommandType.FILL_EMPTY_AREA.getValue());
                        canvas.drawCanvas();

                    } else {
                        System.out.println("Invalid parameters.");
                    }
                }


            } else if (commandParts[0].equals(CommandType.EXIT.getValue())) {
                System.out.println("End of the program");
                System.exit(0);
            }

        }

        readCommand.close();
    }


}
