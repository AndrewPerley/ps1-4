package edu.ahs.robotics.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class GridLoggerTest {

    @Test
    public void writeLn() {
        TestWriter writer = new TestWriter();
        TestClock clock = new TestClock();
        GridLogger gridLogger = new GridLogger(writer , clock);
        gridLogger.add("RobotX", "2.4");
        gridLogger.add("RobotY", "3.2");
        clock.setCurrentTimeMillis(0);
        gridLogger.writeLn();
        gridLogger.add("RobotX", "3.8");
        gridLogger.add("RobotY", "4.8");
        clock.setCurrentTimeMillis(1);
        gridLogger.writeLn();
        gridLogger.add("RobotX", "3.2");
        gridLogger.add("unWanted", "3.9");
        clock.setCurrentTimeMillis(2);
        gridLogger.writeLn();
        List lines = writer.getLines();

        assertEquals("Time,RobotX,RobotY" , lines.get(0));
        assertEquals("0,2.4,3.2" , lines.get(1));
        assertEquals("1,3.8,4.8" , lines.get(2));
        assertEquals("2,3.2," , lines.get(3));
    }


    private class TestWriter implements LogWriter {

        List<String> lines = new ArrayList<>();

        @Override
        public void writeLine(String line) {
            lines.add(line);
        }

        public List<String> getLines() {
            return lines;
        }
    }

    private class TestClock implements Clock {

        long currentTimeMillis;
        boolean resetCalled = false;

        public long getCurrentTimeMillis(){
            return currentTimeMillis;
        }
        public void setCurrentTimeMillis(long time){
            currentTimeMillis = time;
        }
        @Override
        public void reset(){
            resetCalled = true;
        }



    }


}