package ru.job4j.collection;

import java.util.*;

public class Departments {
    /**
     * Method takes List of departments as input, looks for missed departments positined on
     * higher levels and returns List of departments with filled higher levels.
     *
     * @param deps list of deparmtnets with missed higher levels.
     * @return list of departments with filled higher levels.
     */
    public static List<String> fillGaps(List<String> deps) {
        Set<String> tmp = new LinkedHashSet<>();
        for (String value : deps) {
            String start = "";
            boolean first = true;
            for (String el : value.split("/")) {
                start += "".equals(start) ? el : "/" + el;
                tmp.add(start);
            }
        }
        return new ArrayList<>(tmp);
    }

    /**
     * Method sorts departements in ascending order.
     * @param orgs
     */
    public static void sortAsc(List<String> orgs) {
        Collections.sort(orgs);
    }

    /**
     * Method sorts departements in descending order taking into account hierarchy of departments.
     * @param orgs
     */
    public static void sortDesc(List<String> orgs) {
        Collections.sort(orgs, new DepDescComp());
    }
}
