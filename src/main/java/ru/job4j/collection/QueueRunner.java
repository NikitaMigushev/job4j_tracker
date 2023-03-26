package ru.job4j.collection;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class QueueRunner {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();
        queue.add("first");
        queue.add("second");
        queue.add("third");

        for (String string : queue) {
            System.out.println(string);
        }
        queue.remove();
        System.out.println();
        System.out.println("State of Queue after remove: ");
        for (String string : queue) {
            System.out.println(string);
        }
        System.out.println("Another Queue");
        Queue<String> anotherQueue = new LinkedList<>();
        String temp = anotherQueue.poll();
        System.out.println(temp);
        Queue<String> oneMoreQueue = new ArrayBlockingQueue<>(3);
        oneMoreQueue.offer("first");
        oneMoreQueue.offer("second");
        oneMoreQueue.offer("third");
        oneMoreQueue.offer("fourth");
        for (String string : oneMoreQueue) {
            System.out.println(string);
        }
        System.out.println(queue.peek());
    }
}
