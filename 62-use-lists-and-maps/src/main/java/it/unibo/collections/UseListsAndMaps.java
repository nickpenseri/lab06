package it.unibo.collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Example class using {@link List} and {@link Map}.
 *
 */
public final class UseListsAndMaps {

    private final static int FROM = 1000;
    private final static int TO = 2000;
    private final static int ELEMENTS = 100000;
    private final static int READINGS = 1000;
    private final static long AFRICA_POP = 1110635000L;
    private final static long AMERICAS_POP = 972005000L;
    private final static long ANTARCTICA_POP = 0L;
    private final static long ASIA_POP = 4298723000L;
    private final static long EUROPE_POP = 742452000L;
    private final static long OCEANIA_POP = 38304000L;

    private UseListsAndMaps() {
    }

    /**
     * @param s
     *            unused
     */
    public static void main(final String... s) {
        /*
         * 1) Create a new ArrayList<Integer>, and populate it with the numbers
         * from 1000 (included) to 2000 (excluded).
         */
        List<Integer> integerArrayList= new ArrayList<>();
        for (int i = FROM; i < TO; i++) {
            integerArrayList.add(i);
        }
        /*
         * 2) Create a new LinkedList<Integer> and, in a single line of code
         * without using any looping construct (for, while), populate it with
         * the same contents of the list of point 1.
         */
        List<Integer> integerLinkedList = new LinkedList<>(integerArrayList);
        /*
         * 3) Using "set" and "get" and "size" methods, swap the first and last
         * element of the first list. You can not use any "magic number".
         * (Suggestion: use a temporary variable)
         */
        int temp = integerArrayList.get(0);
        integerArrayList.set(0, integerArrayList.get(integerArrayList.size() - 1));
        integerArrayList.set(integerArrayList.size() - 1, temp);
        /*
         * 4) Using a single for-each, print the contents of the arraylist.
         */
        for (var element : integerArrayList) {
            System.out.println(element);
        }
        /*
         * 5) Measure the performance of inserting new elements in the head of
         * the collection: measure the time required to add 100.000 elements as
         * first element of the collection for both ArrayList and LinkedList,
         * using the previous lists. In order to measure times, use as example
         * TestPerformance.java.
         */
        long time = System.nanoTime();
        for (int i = 0; i < ELEMENTS; i++) {
            integerArrayList.add(0, i);
        }
        time = System.nanoTime() - time;
        var millis = TimeUnit.NANOSECONDS.toMillis(time);
        System.out.println("Time to insert 100000 elements in ArrayList: " + millis + "(ms)");

        time = System.nanoTime();
        for (int i = 0; i < ELEMENTS; i++) {
            integerLinkedList.add(0, i);
        }
        time = System.nanoTime() - time;
        millis = TimeUnit.NANOSECONDS.toMillis(time);
        System.out.println("Time to insert 100000 elements in LinkedList: " + millis + "(ms)");
        /*
         * 6) Measure the performance of reading 1000 times an element whose
         * position is in the middle of the collection for both ArrayList and
         * LinkedList, using the collections of point 5. In order to measure
         * times, use as example TestPerformance.java.
         */
        time = System.nanoTime();
        for (int i = 1; i <= READINGS; i++) {
            integerArrayList.get(integerArrayList.size()/2);
        }
        time = System.nanoTime() - time;
        millis = TimeUnit.NANOSECONDS.toMillis(time);
        System.out.println("Time to read 1000 elements in ArrayList: " + millis + "(ms)");

        time = System.nanoTime();
        for (int i = 1; i <= READINGS; i++) {
            integerLinkedList.get(integerArrayList.size()/2);
        }
        time = System.nanoTime() - time;
        millis = TimeUnit.NANOSECONDS.toMillis(time);
        System.out.println("Time to read 1000 elements in LinkedList: " + millis + "(ms)");
        /*
         * 7) Build a new Map that associates to each continent's name its
         * population:
         *
         * Africa -> 1,110,635,000
         *
         * Americas -> 972,005,000
         *
         * Antarctica -> 0
         *
         * Asia -> 4,298,723,000
         *
         * Europe -> 742,452,000
         *
         * Oceania -> 38,304,000
         */
        Map<String, Long> map = new HashMap<>();
        map.put("Africa", AFRICA_POP);
        map.put("Americas", AMERICAS_POP);
        map.put("Antarctica", ANTARCTICA_POP);
        map.put("Asia", ASIA_POP);
        map.put("Europe", EUROPE_POP);
        map.put("Oceania", OCEANIA_POP);
        /*
         * 8) Compute the population of the world
         */
        long totalPeople = 0;
        for (var element : map.values()) {
            totalPeople += element;
        }
        System.out.println("Population of the world: " + totalPeople);
        
    }
}
