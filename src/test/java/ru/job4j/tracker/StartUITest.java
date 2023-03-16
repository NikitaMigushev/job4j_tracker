
package ru.job4j.tracker;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class StartUITest {

    @Test
    public void whenCreateItemItemName() {
        Output output = new ConsoleOutput();
        Input in = new StubInput(
                new String[] {"0", "Item name", "1"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(output),
                new ExitAction(output)
        };
        new StartUI(output).init(in, tracker, actions);
        Assertions.assertThat(tracker.findAll()[0].getName()).isEqualTo("Item name");
    }

    @Test
    void whenCreateItemFixPC() {
        Output output = new ConsoleOutput();
        Input in = new StubInput(
                new String[] {"0", "Fix PC", "1"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(output),
                new ExitAction(output)
        };
        new StartUI(output).init(in, tracker, actions);
        Assertions.assertThat(tracker.findAll()[0].getName()).isEqualTo("Fix PC");
    }

    @Test
    public void whenEditItem() {
        Output output = new ConsoleOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Replaced Item"));
        String replacedName = "New item name";
        Input in = new StubInput(
                   new String[] {"0", "1", replacedName, "1"}
        );
        UserAction[] actions = {
                new EditAction(output),
                new ExitAction(output)
        };
        new StartUI(output).init(in, tracker, actions);
        Assertions.assertThat(tracker.findAll()[0].getName()).isEqualTo("New item name");
    }

    @Test
    public void whenDeleteItem() {
        Output output = new ConsoleOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Delete Item"));
        Input in = new StubInput(
                new String[] {"0", "1", "1"}
        );
        UserAction[] actions = {
                new DeleteAction(output),
                new ExitAction(output)
        };
        new StartUI(output).init(in, tracker, actions);
        Assertions.assertThat(tracker.findAll()).isEmpty();
    }
}
