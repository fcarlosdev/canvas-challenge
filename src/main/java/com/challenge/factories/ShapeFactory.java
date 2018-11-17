package com.challenge.factories;

import com.challenge.shapes.Line;
import com.challenge.components.Point;
import com.challenge.shapes.Rectangle;
import com.challenge.shapes.Shape;

public class ShapeFactory implements ShapeFactories {

    @Override
    public Shape createLine(Point from, Point till) {
        return new Line(from, till);
    }

    @Override
    public Shape createRectangle(Point from, Point till) {
        return new Rectangle(from,till);
    }
}
