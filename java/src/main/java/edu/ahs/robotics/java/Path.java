package edu.ahs.robotics.java;

import java.util.ArrayList;

public class Path {

    private ArrayList<WayPoint> wayPoints;

    /**
     * @param rawPoints Array of X,Y points.  Duplicate points are discarded
     *                  A path must have at least 2 non-identical points
     */
    public Path(Point[] rawPoints) {
        wayPoints = new ArrayList<>();
        WayPoint startingPoint = new WayPoint(rawPoints[0],0,0,0);
        for (int i = 1; i < rawPoints.length; i++) {


        }
    }

    /**
     * @return total distance of the path
     */
    public double totalDistance() {
        return 0.0;
    }


    /**
     * @return a point at the supplied distance along the path from the supplied current position
     * Note that the point will usually be interpolated between the points that originally defined the Path
     */
    public Path.WayPoint targetPoint(Point current, double distance) {
        return null;
    }


    public static class WayPoint {
        public Point point;
        private double deltaXFromPrevious;
        private double deltaYFromPrevious;
        private double distanceFromPrevious;

        private WayPoint(Point point, double deltaXFromPrevious, double deltaYFromPrevious, double distanceFromPrevious) {
            this.point = point;
            this.deltaXFromPrevious = deltaXFromPrevious;
            this.deltaYFromPrevious = deltaYFromPrevious;
            this.distanceFromPrevious = distanceFromPrevious;
        }

        /**
         * Calculates the projection of the vector Vcurrent leading from the supplied current
         * point to this WayPoint onto the vector Vpath leading from the previous point on the path
         * to this WayPoint.  If the return value is positive, it means that the WayPoint is
         * farther along the path from the current point.  If the return value is negative, it means
         * that the WayPoint is before the current point.  The magnitude of the value tells the
         * distance along the path.  The value is computed as the dot product between Vcurrent and
         * Vpath, normalized by the length of vPath
         * @param current The source point to compare to the WayPoint
         */
        private double componentAlongPath(Point current) {
            double deltaXFromCurrent = point.x - current.x;
            double deltaYFromCurrent = point.y - current.y;

            double dp = deltaXFromCurrent * deltaXFromPrevious + deltaYFromCurrent * deltaYFromPrevious;
            return dp / distanceFromPrevious;
        }
    }





}
