package com.company.generics;

import javafx.scene.shape.Shape;

public class SquareClass extends Shape implements Comparable<SquareClass> {

    @Override
    public com.sun.javafx.geom.Shape impl_configShape() {
        return null;
    }

    @Override
    public int compareTo(SquareClass o) {
        return 0;
    }
}
