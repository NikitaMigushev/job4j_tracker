package ru.job4j.queue;

import java.util.Deque;
import java.util.Iterator;

public class ReconstructPhrase {
    private final Deque<Character> descendingElements;
    private final Deque<Character> evenElements;

    public ReconstructPhrase(Deque<Character> descendingElements, Deque<Character> evenElements) {
        this.descendingElements = descendingElements;
        this.evenElements = evenElements;
    }

    private String getEvenElements() {
        StringBuilder stringBuilder = new StringBuilder();
        Iterator<Character> iterator = evenElements.iterator();
        for (int i = 1; i <= evenElements.size(); i++) {
            if (i % 2 == 0) {
                stringBuilder.append(iterator.next());
            }
            iterator.next();
        }
        return stringBuilder.toString();
    }

    private String getDescendingElements() {
        return "";
    }

    public String getReconstructPhrase() {
        return getEvenElements() + getDescendingElements();
    }
}
