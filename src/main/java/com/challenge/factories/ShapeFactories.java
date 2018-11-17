package com.challenge.factories;

import com.challenge.components.Point;
import com.challenge.shapes.Shape;

public interface ShapeFactories {

    Shape createLine(Point from, Point till);
    Shape createRectangle(Point from, Point till);

}
