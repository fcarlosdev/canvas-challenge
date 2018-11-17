package com.challenge.tools;

import com.challenge.components.Canvas;

public abstract class Tool {

    public abstract void applyTo(Canvas canvas, String ...params);
}
