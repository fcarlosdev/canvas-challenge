package com.challenge.factories;

import com.challenge.components.Point;
import com.challenge.tools.BucketFill;
import com.challenge.tools.Tool;

public class TooBucketFillFactory implements ToolFactories {

    @Override
    public Tool createBucketFill(Point location) {
        return new BucketFill(location);
    }
}
