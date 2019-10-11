package com.trilogyed.calculatorserviceactivity.models;

import javax.validation.constraints.NotEmpty;
import java.util.Objects;

public class NumberPair {

    @NotEmpty(message = "You must enter a number.")
    private double numberA;
    @NotEmpty (message = "You must enter a number.")
    private double numberB;
    private double answer;

    public NumberPair() {
    }

    public NumberPair(@NotEmpty(message = "You must enter a number.") double numberA, @NotEmpty(message = "You must enter a number.") double numberB, double answer) {
        this.numberA = numberA;
        this.numberB = numberB;
        this.answer = answer;
    }

    public double getNumberA() {
        return numberA;
    }

    public void setNumberA(double numberA) {
        this.numberA = numberA;
    }

    public double getNumberB() {
        return numberB;
    }

    public void setNumberB(double numberB) {
        this.numberB = numberB;
    }

    public double getAnswer() {
        return answer;
    }

    public void setAnswer(double answer) {
        this.answer = answer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NumberPair that = (NumberPair) o;
        return numberA == that.numberA &&
                numberB == that.numberB;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numberA, numberB);
    }

    @Override
    public String toString() {
        return "NumberPair{" +
                "numberA=" + numberA +
                ", numberB=" + numberB +
                '}';
    }
}
