/*
package ru.job4j.tracker;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class StartUITest {

    @Test
    public void whenCreateItemItemName() {
        Input in = new StubInput(
                new String[] {"0", "Item name", "1"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(),
                new ExitAction()
        };
        new StartUI().init(in, tracker, actions);
        Assertions.assertThat(tracker.findAll()[0].getName()).isEqualTo("Item name");
    }

    @Test
    void whenCreateItemFixPC() {
        Input in = new StubInput(
                new String[] {"0", "Fix PC", "1"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(),
                new ExitAction()
        };
        new StartUI().init(in, tracker, actions);
        Assertions.assertThat(tracker.findAll()[0].getName()).isEqualTo("Fix PC");
    }

    @Test
    public void whenEditItem() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Replaced Item"));
        String replacedName = "New item name";
        Input in = new StubInput(
                   new String[] {"0", "1", replacedName, "1"}
        );
        UserAction[] actions = {
                new EditAction(),
                new ExitAction()
        };
        new StartUI().init(in, tracker, actions);
        Assertions.assertThat(tracker.findAll()[0].getName()).isEqualTo("New item name");
    }

    @Test
    public void whenDeleteItem() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Delete Item"));
        Input in = new StubInput(
                new String[] {"0", "1", "1"}
        );
        UserAction[] actions = {
                new DeleteAction(),
                new ExitAction()
        };
        new StartUI().init(in, tracker, actions);
        Assertions.assertThat(tracker.findAll()).isEmpty();
    }
}

 */