package edu.ahs.robotics.java;

import java.sql.SQLOutput;
import java.util.Enumeration;

public class Main {
    public static void main(String[] args){

        Point a=new Point(5,-56);
        Point b=new Point(-6,5122);
        System.out.println(a.distanceFromOrigin());

        System.out.println(a.getX());

        System.out.println(a);

        System.out. println(a.getQuadrant());
    }

}


