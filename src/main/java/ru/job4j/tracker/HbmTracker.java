package ru.job4j.tracker;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

import java.util.List;

public class HbmTracker implements Store, AutoCloseable {
    private final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
            .configure().build();
    private final SessionFactory sf = new MetadataSources(registry)
            .buildMetadata().buildSessionFactory();

    @Override
    public Item add(Item item) {
        try (Session session = sf.openSession()) {
            session.beginTransaction();
            session.save(item);
            session.getTransaction().commit();
        }
        return item;
    }

    @Override
    public boolean replace(int id, Item item) {
        boolean result = false;
        try (Session session = sf.openSession()) {
            session.beginTransaction();
            Item existingItem = session.get(Item.class, id);
            if (existingItem != null) {
                existingItem.setName(item.getName());
                session.update(existingItem);
                session.getTransaction().commit();
                result = true;
            }
        }
        return result;
    }

    @Override
    public boolean delete(int id) {
        boolean result = false;
        try (Session session = sf.openSession()) {
            session.beginTransaction();
            Item item = session.get(Item.class, id);
            if (item != null) {
                session.delete(item);
                session.getTransaction().commit();
                result = true;
            }
        }
        return result;
    }

    @Override
    public List<Item> findAll() {
        try (Session session = sf.openSession()) {
            return session.createQuery("FROM Item", Item.class).list();
        }
    }

    @Override
    public List<Item> findByName(String key) {
        try (Session session = sf.openSession()) {
            Query<Item> query = session.createQuery("FROM Item WHERE name LIKE :key", Item.class);
            query.setParameter("key", "%" + key + "%");
            return query.list();
        }

    }

    @Override
    public Item findById(int id) {
        try (Session session = sf.openSession()) {
            return session.get(Item.class, id);
        }
    }

    @Override
    public void close() {
        StandardServiceRegistryBuilder.destroy(registry);
    }
}
