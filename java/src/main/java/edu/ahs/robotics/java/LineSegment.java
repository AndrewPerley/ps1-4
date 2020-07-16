package edu.ahs.robotics.java;

public class LineSegment {
    private Point point1;
    private Point point2;
    private double length;

    public LineSegment(Point point1, Point point2) {
        this.point1 = point1;
        this.point2 = point2;
        this.length = point1.distanceToPoint(point2);
    }

    public Point[] subDivide(int subSegment) {
        double deltaX = point2.getX() - point1.getX();
        double deltaY = point2.getY() - point1.getX();

        double xStep = deltaX / subSegment;
        double yStep = deltaY / subSegment;
        Point[] subdividePoints = new Point[subSegment - 1];
        for (int i = 1; i < subSegment; i++) {
        double subdivideXpoint = point1.getX()+xStep*i;
        double subdivideYpoint = point1.getY()+yStep*i;

        Point pointSubdivided = new Point(subdivideXpoint,subdivideYpoint);
        subdividePoints[i-1]=pointSubdivided;
        }
        return subdividePoints;



    }

    public Point interpolate(double distanceFromFirstPoint) {
        double deltaX = point2.getX() - point1.getX();
        double deltaY = point2.getY() - point1.getY();

        double scaleFactor=distanceFromFirstPoint/length;

        double scaledX = deltaX*scaleFactor;
        double scaledY = deltaY*scaleFactor;

        double finalX = point1.getX() + scaledX;
        double finalY = point1.getY() + scaledY;

        Point interpolatedPoint = new Point(finalX,finalY);
        return interpolatedPoint;

    }

    public Point midPoint() {
       Point pointMid = this.interpolate(1/2*length);

        return pointMid;
    }
}
