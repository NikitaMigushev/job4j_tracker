package ru.job4j.tracker;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class SqlTracker implements Store {
    private Connection cn;
    private Properties config;

    public SqlTracker() {
        this.config = new Properties();
        init();
    }

    public SqlTracker(Connection cn) {
        this.cn = cn;
    }

    private void init() {
        try (InputStream in = SqlTracker.class.getClassLoader().getResourceAsStream("app.properties")) {
                config.load(in);
                Class.forName(config.getProperty("driver_class"));
                String url = config.getProperty("url");
                String login = config.getProperty("login");
                String password = config.getProperty("password");
                cn = DriverManager.getConnection(url, login, password);
            DatabaseMetaData metaData = cn.getMetaData();
            System.out.println("Connection is successful!");
            System.out.println(metaData.getUserName());
            System.out.println(metaData.getURL());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private PreparedStatement prepareStatement(String query, Object... parameters) throws SQLException {
        PreparedStatement statement = cn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        for (int i = 0; i < parameters.length; i++) {
            statement.setObject(i + 1, parameters[i]);
        }
        return statement;
    }

    @Override
    public void close() throws SQLException {
        if (cn != null) {
            cn.close();
        }
    }

    @Override
    public Item add(Item item) {
        Item addedItem = item;
        String query = "INSERT INTO ITEMS (name, createddate) VALUES (?, ?) RETURNING id";
        int id = -1;
        try (PreparedStatement statement = prepareStatement(query, item.getName(), new Timestamp(System.currentTimeMillis()))) {
            statement.execute();
            ResultSet resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                id = resultSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        addedItem.setId(id);
        return addedItem;
    }

    @Override
    public boolean replace(int id, Item item) {
        boolean rsl = false;
        String query = "UPDATE items SET name = ? WHERE id = ?";
        try (PreparedStatement statement = prepareStatement(query, item.getName(), id)) {
            statement.execute();
            rsl = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rsl;
    }

    @Override
    public boolean delete(int id) {
        boolean rsl = false;
        String query = "DELETE FROM ITEMS WHERE id = ?";
        try (PreparedStatement statement = prepareStatement(query, id)) {
            statement.execute();
            rsl = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rsl;
    }

    @Override
    public List<Item> findAll() {
        List<Item> items = new ArrayList<>();
        String query = "SELECT * FROM ITEMS";
        try (PreparedStatement statement = prepareStatement(query)) {
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    items.add(new Item(
                            resultSet.getInt("id"),
                            resultSet.getString("name")
                    ));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return items;
    }

    @Override
    public List<Item> findByName(String key) {
        List<Item> items = new ArrayList<>();
        String query = "SELECT * FROM ITEMS WHERE name = ?";
        try (PreparedStatement statement = prepareStatement(query, key)) {
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    items.add(new Item(
                            resultSet.getInt("id"),
                            resultSet.getString("name")
                    ));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return items;
    }

    @Override
    public Item findById(int id) {
        Item item = new Item();
        String query = "SELECT * FROM ITEMS WHERE ID = ?";
        try (PreparedStatement statement = prepareStatement(query, id)) {
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                item.setId(id);
                item.setName(resultSet.getString("name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return item;
    }
}