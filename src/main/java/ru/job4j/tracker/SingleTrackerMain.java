package ru.job4j.tracker;

public class SingleTrackerMain {
    public static void main(String[] args) {
        SingleTracker singleTracker = SingleTracker.getInstance();
        singleTracker.add(new Item("Test1"));
        singleTracker.add(new Item("Test2"));
        System.out.println(singleTracker.findAll());
        System.out.println(singleTracker.findAll());
        SingleTracker anotherSingleTracker = SingleTracker.getInstance();
        anotherSingleTracker.add(new Item("Test3"));
    }
}
