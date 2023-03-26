package ru.job4j.search;

import java.util.LinkedList;

public class PriorityQueue {
    private LinkedList<Task> tasks = new LinkedList<>();

    public void put(Task task) {
        int index = 0;
        if (tasks.isEmpty()) {
            tasks.add(index, task);
        }
        for (Task element : tasks) {
            if (element.getPriority() > task.getPriority()) {
                tasks.add(index, task);
                break;
            }
            index++;
        }
    }

    public Task take() {
        return tasks.poll();
    }
}