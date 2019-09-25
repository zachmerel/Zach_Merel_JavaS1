package com.company;

import com.company.interfaces.Shape;

public class Triangle implements Shape {
    int side1;
    int side2;
    int side3;
    int perimeter = side1+ side2 + side3;
    @Override
    public double perimeter() {

        return side1+side2+side3;
    }

    @Override
    public double area() {

        return Math.sqrt((perimeter)*(perimeter-side1)*(perimeter-side2)*(perimeter-side3));
    }
}
