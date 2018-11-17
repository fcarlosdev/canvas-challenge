package com.challenge.commands;

import com.challenge.components.Canvas;
import com.challenge.shapes.Shape;

public class drawRectangleCommand implements Command {


    private final Shape rectangle;
    private final Canvas canvas;

    public drawRectangleCommand(Canvas canvas, Shape rectangle) {
        this.rectangle = rectangle;
        this.canvas = canvas;
    }

    @Override
    public void execute() {
        rectangle.drawShapeAt(canvas);
    }
}
