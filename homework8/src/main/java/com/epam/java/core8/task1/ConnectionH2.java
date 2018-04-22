package com.epam.java.core8.task1;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionH2 {


    public static void main(String[] args) throws ClassNotFoundException {
        Class.forName("org.h2.Driver");
        try (Connection conn = DriverManager.getConnection("jdbc:h2:./H2/test",
                "admin", "admin");) {
            Statement st = conn.createStatement();
            createTable(st);
            insertIntoTable(st);
            readData(st);
            updateNames(st);
            readData(st);
            deleteTable(st);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void deleteTable(Statement st) throws SQLException {
        st.execute("DROP TABLE IF EXISTS TEST");
    }

    private static void readData(Statement st) throws SQLException {
        ResultSet getNames = st.executeQuery("SELECT * FROM TEST ORDER BY ID");

        while (getNames.next()) {
            System.out.println(getNames.getString("NAME"));
        }
    }

    private static void updateNames(Statement st) throws SQLException {
        updateUser(st, 1, "Fedor");
        updateUser(st, 6, "Petr");
    }

    private static void createTable(Statement st) throws SQLException {
        st.execute("CREATE TABLE IF NOT EXISTS TEST(ID INT PRIMARY KEY, NAME VARCHAR(255))");
    }
    private static void insertIntoTable(Statement st) throws SQLException {
        insertUser(st, 1,"Ivan");
        insertUser(st, 2,"Egor");
        insertUser(st, 3,"Fekla");
        insertUser(st, 4,"John");
        insertUser(st, 5,"Gerald");
        insertUser(st, 6,"Ivan");
    }
    private static void insertUser(Statement st, int id, String name) throws SQLException {
        st.execute(String.format("INSERT INTO TEST VALUES('%d', '%s')", id, name));
    }
    private static void updateUser(Statement st, int id, String name) throws SQLException {
        st.execute(String.format("UPDATE TEST SET NAME='%s' WHERE ID='%d'", name, id));
    }
}

