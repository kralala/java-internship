package com.bad.code2.shapes;

import com.bad.code2.base.*;

public class Square implements Shape2D {

    private Double x;
    private Double y;
    private Double edgeSize;

    public Square(Double x, Double y, Double edgeSize) {
        this.x = x;
        this.y = y;
        this.edgeSize = edgeSize;
    }

    @Override
    public Double getX() {
        return x;
    }

    @Override
    public Double getY() {
        return y;
    }

    @Override
    public Double getPerimeter() {
        return edgeSize * edgeSize;
    }
}
