package ru.stqa.pft.sandbox;

import com.sun.org.apache.xpath.internal.SourceTree;

public class MyF {
    public static void main(String[] args) {

        Point point1 = new Point(-5, 10);
        Point point2 = new Point(15, -16);

        System.out.println(point1.getDistance(point2));
    }



    public static void hello(String somebody) {
        System.out.println("hello " + somebody + "!");
    }

    public static double area(Square s) {
        return s.l * s.l;
    }


    }
