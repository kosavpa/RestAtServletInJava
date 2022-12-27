package DAO;


import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.*;


public class DataSource {
    private static final String URL = "jdbc:mysql://localhost:3306/person";
    private static final String login = "root";
    private static final String password = "root";
    private static BasicDataSource dataSource;

    static {
        dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl(URL);
        dataSource.setUsername(login);
        dataSource.setPassword(password);

        dataSource.setMinIdle(2);
        dataSource.setMaxIdle(8);
        dataSource.setMaxTotal(14);
    }

    public static Connection getConnection(){
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
