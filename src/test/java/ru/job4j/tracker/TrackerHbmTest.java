package ru.job4j.tracker;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class TrackerHbmTest {
    private HbmTracker tracker;

    @BeforeEach
    public void setup() {
        tracker = new HbmTracker();
    }

    @AfterEach
    public void cleanup() {
        var items = tracker.findAll();
        for (Item item : items) {
            tracker.delete(item.getId());
        }
        tracker.close();
    }

    @Test
    public void whenAddNewItemThenTrackerHasSameItem() throws Exception {
        try (var tracker = new HbmTracker()) {
            Item item = new Item();
            item.setName("test1");
            tracker.add(item);
            Item result = tracker.findById(item.getId());
            assertThat(result.getName()).isEqualTo(item.getName());
        }
    }

    @Test
    public void whenReplaceItemThenItemIsUpdated() {
        Item item = new Item();
        item.setName("test2");
        tracker.add(item);
        int id = item.getId();

        Item updatedItem = new Item();
        updatedItem.setName("test2-updated");
        tracker.replace(id, updatedItem);

        Item result = tracker.findById(id);
        assertThat(result.getName()).isEqualTo(updatedItem.getName());
    }

    @Test
    public void whenDeleteItemThenTrackerDoesNotHaveItem() {
        Item item = new Item();
        item.setName("test3");
        tracker.add(item);
        int id = item.getId();

        boolean isDeleted = tracker.delete(id);
        assertThat(isDeleted).isTrue();

        Item result = tracker.findById(id);
        assertThat(result).isNull();
    }

    @Test
    public void whenFindAllItemsThenReturnAllItems() {
        Item item1 = new Item();
        item1.setName("test4");
        var savedItem1 = tracker.add(item1);
        Item item2 = new Item();
        item2.setName("test5");
        var savedItem2 = tracker.add(item2);
        List<Item> items = tracker.findAll();
        assertThat(items).containsExactlyInAnyOrder(savedItem1, savedItem2);
    }

    @Test
    public void whenFindByNameThenReturnMatchingItems() {
        Item item1 = new Item();
        item1.setName("test6");
        tracker.add(item1);

        Item item2 = new Item();
        item2.setName("test7");
        tracker.add(item2);

        Item item3 = new Item();
        item3.setName("test6");
        tracker.add(item3);

        List<Item> items = tracker.findByName("test6");
        assertThat(items).containsExactlyInAnyOrder(item1, item3);
    }
}
