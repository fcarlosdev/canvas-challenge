package com.challenge.commands;

import com.challenge.components.Canvas;
import com.challenge.shapes.Shape;

public class drawLineCommand implements Command {


    private final Shape line;
    private final Canvas canvas;

    public drawLineCommand(Canvas canvas, Shape line) {
        this.line = line;
        this.canvas = canvas;
    }

    @Override
    public void execute() {
        line.drawShapeAt(canvas);
    }
}
