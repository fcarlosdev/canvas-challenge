package com.challenge.commands;

import com.challenge.components.Canvas;
import com.challenge.tools.Tool;

public class BucketFillCommand implements Command {


    private Canvas canvas;
    private String color;
    private Tool bucketFill;

    public BucketFillCommand(Canvas canvas, Tool bucketFill, String color) {
        this.color      = color;
        this.canvas     = canvas;
        this.bucketFill = bucketFill;
    }

    @Override
    public void execute() {
        bucketFill.applyTo(canvas,color);
    }

}
