package com.company;

public class PhysicsLibrary {

    public double calculateForce(double mass, double acceleration) {
        return mass * acceleration;
    }

    public double calculateVelocity(double distance2, double distance1, double time2, double time1) {
        if (distance2 - distance1 == 0 || time2 - time1 == 0) {
            return 0;
        } else {
            return (distance2 - distance1) / (time2 - time1);
        }
    }

    public double calculateMass(double weight, double gravity) {
        if (weight == 0 || gravity == 0) {
            return 0;
        } else {
            return weight / gravity;
        }
    }

    public double calculateAcceleration(double velocity2, double velocity1, double time2, double time1) {
        if (velocity2 - velocity1 == 0 || time2 - time1 == 0) {
            return 0;
        } else {
            return (velocity2 - velocity1) / (time2 - time1);
        }
    }

    public double calculateDistance(double velocity, double time) {
        return velocity * time;
    }
}
