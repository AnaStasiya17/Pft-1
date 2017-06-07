package ru.stqa.pft.sandbox;

public class Point {
    double x;
    double y;

    public Point (double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getDistance(Point boss) {
        return Math.sqrt((Math.pow(boss.x - this.x, 2)) +( Math.pow(boss.y - this.y, 2)));

    }
}