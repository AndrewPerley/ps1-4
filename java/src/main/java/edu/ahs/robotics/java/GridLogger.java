package edu.ahs.robotics.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class GridLogger {

        private LogWriter writer;
        private Clock clock;
        private boolean firstRow=true;
        private HashSet<String> categorySet = new HashSet<>();
        private ArrayList<String> categories = new ArrayList<>();
        private HashMap<String, String> rowData = new HashMap<>();

        public GridLogger(LogWriter writer, Clock clock) {
            this.writer = writer;
            this.clock = clock;
            clock.reset();
            categories.add("Time");

        }

        /**
         * Add a value to the logger under the category.  Categories are lazily added to the logger
         * in the order encountered.
         * @param category
         * @param value
         */
        public void add(String category, String value) {
          //builds up categories
            // if we haven't seen the category yet ad it to our list

            if (firstRow && !categorySet.contains(category)) {
                categorySet.add(category);
                categories.add(category);
            }

            rowData.put(category, value);
        }


        /**
         * Write a line of data to the log.  If this is the first call to writeLn, categories are
         * written first, followed by the line of data.  Once the data is written, the logger is reset
         * and calls to add() will add values to the next line of data.
         */
        public void writeLn() {
            if (firstRow) {
                StringBuffer categoryBuffer = new StringBuffer();
                for (int i = 0; i < categories.size(); i++) {
                    String allCategories = categories.get(i);
                    categoryBuffer.append(allCategories);
                    if (i < categories.size()-1) {
                        categoryBuffer.append(",");
                    }
                    }
                writer.writeLine(categoryBuffer.toString());
                firstRow = false;

                }
            //Update time
            rowData.put("Time", Long.toString(clock.getCurrentTimeMillis()));

            //write rowData
            StringBuffer finalBuffer = new StringBuffer();
            for (int i = 0; i < categories.size(); i++) {
                String allCategories = categories.get(i);
                String values = rowData.get(allCategories);
                if (values != null) {
                    finalBuffer.append(values);
                }
                if (i < categories.size() - 1) {
                    finalBuffer.append(",");
                }

            }
            writer.writeLine(finalBuffer.toString());

            rowData.clear();
            }


        public void stop() {}
    }


