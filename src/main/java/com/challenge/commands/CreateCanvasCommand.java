package com.challenge.commands;

import com.challenge.components.Canvas;

public class CreateCanvasCommand implements Command {

    private Canvas canvas;

    public CreateCanvasCommand(Canvas canvas) {
        this.canvas = canvas;
    }

    @Override
    public void execute() {
        canvas.createCanvas();
    }
}
