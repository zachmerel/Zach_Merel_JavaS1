package com.company;

import com.company.interfaces.Shape;

public class Square implements Shape {
    int side;

    @Override
    public double perimeter() {
        return side*4;
    }

    @Override
    public double area() {
        return side*side;
    }
}
