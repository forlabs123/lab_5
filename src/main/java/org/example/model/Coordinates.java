package org.example.model;

public class Coordinates {
    private float x; //Максимальное значение поля: 519
    private long y; //Значение поля должно быть больше -284

    public Coordinates(float x, long y) {
        this.x = x;
        this.y = y;
    }

    public Coordinates() {

    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public long getY() {
        return y;
    }

    public void setY(long y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Coordinates{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}