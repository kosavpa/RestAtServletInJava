package DAO;

import java.sql.*;

public class DataSource {
    private static final String URL = "jdbc:mysql://localhost:3306/person";
    private static final String login = "root";
    private static final String password = "root";
    private static java.sql.Connection connection;

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            connection = DriverManager.getConnection(URL, login, password);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private DataSource() {
    }

    private static class InnerPersonDAOHolder{
        public static final DataSource personDAO = new DataSource();
    }

    public static DataSource getInstance(){
        return InnerPersonDAOHolder.personDAO;
    }

    public java.sql.Connection getConnection(){
        return connection;
    }
}
