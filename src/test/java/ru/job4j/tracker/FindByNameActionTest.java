package ru.job4j.tracker;

import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.*;

class FindByIdNameTest {
    @Test
    public void execute() {
        Output out = new StubOutput();
        MemTracker tracker = new MemTracker();
        tracker.add(new Item("TestItem"));
        FindByNameAction findByNameAction = new FindByNameAction(out);
        Input input = mock(Input.class);
        when(input.askInt(any(String.class))).thenReturn(5);
        when(input.askStr(any(String.class))).thenReturn("TestItem");
        findByNameAction.execute(input, tracker);
        System.out.println("check here");
        String ln = System.lineSeparator();
        assertThat(out.toString()).contains("=== Find items by name ===" + ln
                + "Item{id=1, name='TestItem'");
    }
}