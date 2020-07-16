package edu.ahs.robotics.java;

import org.junit.Test;

import static org.junit.Assert.*;

public class PathTest {

        @Test
        public void testDuplicatesRemoved() {
            // Make some points
            Point[] rawPoints = new Point[] {new Point(0,0), new Point(3,4), new Point(3,4), new Point(5,5)};
            Path path = new Path(rawPoints);

            Point[] expectedRemoveDoubles = new Point[] {new Point(0,0), new Point(3,4), new Point(5,5)};

            //assertEquals(expectedRemoveDoubles,path.);



            // Check to make sure that you got rid of the duplicates
            // Your code here!
    }
}