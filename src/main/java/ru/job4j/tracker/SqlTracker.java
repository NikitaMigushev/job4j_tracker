package ru.job4j.tracker;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.time.LocalDateTime;
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
        try (InputStream in = new FileInputStream("db/liquibase.properties")) {
                config.load(in);
                Class.forName(config.getProperty("driver-class-name"));
                String url = config.getProperty("url");
                String login = config.getProperty("username");
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

    private Item retrieveItem(ResultSet resultSet) throws SQLException {
        Item showItem = new Item(
                resultSet.getInt("id"),
                resultSet.getString("name"));
        showItem.setCreated(resultSet.getTimestamp("created").toLocalDateTime());
        return showItem;
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
        String query = "INSERT INTO ITEMS (name, created) VALUES (?, ?)";
        int id = -1;
        try (PreparedStatement statement = prepareStatement(query, item.getName(), new java.sql.Timestamp(System.currentTimeMillis()))) {
            statement.executeUpdate();
            ResultSet generatedKeys = statement.getGeneratedKeys();
            ResultSet result = null;
            if (generatedKeys.next()) {
                id = generatedKeys.getInt(1);
                String selectQuery = "SELECT id, name, created FROM items where id = ?";
                try (PreparedStatement selectStatement = prepareStatement(selectQuery, id)) {
                    result = selectStatement.executeQuery();
                    if (result != null && result.next()) {
                        id = result.getInt("id");
                        LocalDateTime created = result.getTimestamp("created").toLocalDateTime();
                        addedItem.setId(id);
                        addedItem.setCreated(created);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
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
                    items.add(retrieveItem(resultSet));
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
                    items.add(retrieveItem(resultSet));
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
                item = retrieveItem(resultSet);
            } else {
                item = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return item;
    }
}