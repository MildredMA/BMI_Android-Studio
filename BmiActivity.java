package com.example.bmiactivity;

public class BmiActivity { // Change here
    Double weight, height;

    public Double CalculateBMI(double wt, double ht) {
        return (wt / (ht * ht));
    }
}
