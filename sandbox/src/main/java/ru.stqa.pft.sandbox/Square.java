package ru.stqa.pft.sandbox;

/**
 * Created by Анастасия Цыбулько on 26.05.2017.
 */
public class Square {
    public double l;

    public Square(double l){

        this.l = l;
    }

    public double area() {
     return this.l * this.l;
    }
}
