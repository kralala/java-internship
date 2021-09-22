package com.bad.code2.shapes;

import com.bad.code2.base.*;

public class Qube implements Shape3D {

    private Double x;
    private Double y;
    private Double z;
    private Double edgeSize;

    public Qube(Double x, Double y, Double z, Double edgeSize) {
        this.x = x;
        this.y = y;
        this.z = z;
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
    public Double getZ() {
        return z;
    }

    @Override
    public Double getVolume() {
        return Math.pow(edgeSize, 3);
    }
}
