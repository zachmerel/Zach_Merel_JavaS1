package com.company;

import com.company.interfaces.Shape;

public class Circle implements Shape {
    int radius;

    @Override
    public double perimeter() {
        return 2*Math.PI+radius;
    }

    @Override
    public double area() {
        return Math.PI*(radius*radius);
    }
}
