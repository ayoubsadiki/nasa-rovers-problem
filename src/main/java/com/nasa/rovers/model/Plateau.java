package com.nasa.rovers.model;

public class Plateau {

    private int upper;
    private int right;

    public Plateau(int upper, int right) {
        this.upper = upper;
        this.right = right;
    }

    public int getUpper() {
        return upper;
    }

    public void setUpper(int upper) {
        this.upper = upper;
    }

    public int getRight() {
        return right;
    }

    public void setRight(int right) {
        this.right = right;
    }
}
