package ru.stqa.pft.sandbox;

import com.sun.org.apache.xpath.internal.SourceTree;

public class MyF {
    public static void main(String[] args) {
        hello("world");

        double len = 5;
        System.out.println("Площадь квадрата со стороной " + len + "=" + area(len));

        double a = 6;
        double b = 7;
        System.out.println("Площадь прямоугольника со сторонами " + a + "и" + b + "=" + area(a,b));

    }


    public static void hello(String somebody) {
        System.out.println("hello " + somebody + "!");
    }

    public static double area(double l) {
        return l * l;
    }

    public static double area(double a, double b){

        return a*b;
    }
}