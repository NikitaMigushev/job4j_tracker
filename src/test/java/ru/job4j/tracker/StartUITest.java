
package ru.job4j.tracker;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class StartUITest {

    @Test
    public void whenCreateItemItemName() {
        Output output = new ConsoleOutput();
        Input in = new StubInput(
                new String[]{"0", "Item name", "1"}
        );
        MemTracker tracker = new MemTracker();
        UserAction[] actions = {
                new CreateAction(output),
                new ExitAction(output)
        };
        new StartUI(output).init(in, tracker, actions);
        Assertions.assertThat(tracker.findAll().get(0).getName()).isEqualTo("Item name");
    }

    @Test
    void whenCreateItemFixPC() {
        Output output = new ConsoleOutput();
        Input in = new StubInput(
                new String[]{"0", "Fix PC", "1"}
        );
        MemTracker tracker = new MemTracker();
        UserAction[] actions = {
                new CreateAction(output),
                new ExitAction(output)
        };
        new StartUI(output).init(in, tracker, actions);
        Assertions.assertThat(tracker.findAll().get(0).getName()).isEqualTo("Fix PC");
    }

    @Test
    public void whenEditItem() {
        Output output = new ConsoleOutput();
        MemTracker tracker = new MemTracker();
        Item item = tracker.add(new Item("Replaced Item"));
        String replacedName = "New item name";
        Input in = new StubInput(
                new String[]{"0", String.valueOf(item.getId()), replacedName, "1"}
        );
        UserAction[] actions = {
                new EditAction(output),
                new ExitAction(output)
        };
        new StartUI(output).init(in, tracker, actions);
        Assertions.assertThat(tracker.findAll().get(0).getName()).isEqualTo("New item name");
    }

    @Test
    public void whenDeleteItem() {
        Output output = new ConsoleOutput();
        MemTracker tracker = new MemTracker();
        Item item = tracker.add(new Item("Delete Item"));
        Input in = new StubInput(
                new String[]{"0", String.valueOf(item.getId()), "1"}
        );
        UserAction[] actions = {
                new DeleteAction(output),
                new ExitAction(output)
        };
        new StartUI(output).init(in, tracker, actions);
        Assertions.assertThat(tracker.findAll()).isEmpty();
    }

    @Test
    public void whenReplaceItemTestOutputIsSuccessfully() {
        Output out = new StubOutput();
        MemTracker tracker = new MemTracker();
        Item one = tracker.add(new Item("test1"));
        String replaceName = "New Test Name";
        Input in = new StubInput(
                new String[]{"0", String.valueOf(one.getId()), replaceName, "1"}
        );
        UserAction[] actions = new UserAction[]{
                new EditAction(out),
                new ExitAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        Assertions.assertThat(out.toString()).isEqualTo(
                "Menu:" + ln
                        + "0. Edit Item" + ln
                        + "1. Exit" + ln
                        + "=== Edit Item ===" + ln
                        + "Заявка изменена успешно." + ln
                        + "Menu:" + ln
                        + "0. Edit Item" + ln
                        + "1. Exit" + ln
                        + "=== Have a nice day! ===" + ln
        );
    }

    @Test
    public void whenFindAllAction() {
        Output out = new StubOutput();
        MemTracker tracker = new MemTracker();
        Item itemOne = tracker.add(new Item("Test1"));
        Input in = new StubInput(
                new String[]{"0", "1"}
        );
        UserAction[] actions = new UserAction[]{
                new FindAllAction(out),
                new ExitAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        Assertions.assertThat(out.toString()).isEqualTo(
                "Menu:" + ln
                        + "0. Find all Items" + ln
                        + "1. Exit" + ln
                        + "=== Show all items ===" + ln
                        + itemOne + ln
                        + "Menu:" + ln
                        + "0. Find all Items" + ln
                        + "1. Exit" + ln
                        + "=== Have a nice day! ===" + ln
        );
    }

    @Test
    public void whenFindByIdAction() {
        Output out = new StubOutput();
        MemTracker tracker = new MemTracker();
        Item itemOne = tracker.add(new Item("test5"));
        Input in = new StubInput(
                new String[]{"0", String.valueOf(itemOne.getId()), "1"}
        );
        UserAction[] actions = new UserAction[]{
                new FindByIdAction(out),
                new ExitAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        Assertions.assertThat(out.toString()).isEqualTo(
                "Menu:" + ln
                        + "0. Find by Id" + ln
                        + "1. Exit" + ln
                        + "=== Find item by id ===" + ln
                        + itemOne + ln
                        + "Menu:" + ln
                        + "0. Find by Id" + ln
                        + "1. Exit" + ln
                        + "=== Have a nice day! ===" + ln
        );
    }

    @Test
    public void whenFindByNameAction() {
        Output out = new StubOutput();
        MemTracker tracker = new MemTracker();
        Item itemOne = tracker.add(new Item("test5"));
        Input in = new StubInput(
                new String[]{"0", String.valueOf(itemOne.getName()), "1"}
        );
        UserAction[] actions = new UserAction[]{
                new FindByNameAction(out),
                new ExitAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        Assertions.assertThat(out.toString()).isEqualTo(
                "Menu:" + ln
                        + "0. Find by Name" + ln
                        + "1. Exit" + ln
                        + "=== Find items by name ===" + ln
                        + itemOne + ln
                        + "Menu:" + ln
                        + "0. Find by Name" + ln
                        + "1. Exit" + ln
                        + "=== Have a nice day! ===" + ln
        );
    }

    @Test
    public void whenInvalidExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"7", "0"}
        );
        MemTracker tracker = new MemTracker();
        UserAction[] actions = new UserAction[]{
                new ExitAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        Assertions.assertThat(out.toString()).isEqualTo(
                "Menu:" + ln
                + "0. Exit" + ln
                + "Wrong input, you can select: 0 .. 0" + ln
                + "Menu:" + ln
                + "0. Exit" + ln
                + "=== Have a nice day! ===" + ln
        );
    }
}
