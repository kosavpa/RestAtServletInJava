package DAO;

import Model.Person;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class PersonDAO {

    public static List<Person> allPerson() {
        Connection connection = null;
        List<Person> personList = new LinkedList<>();
        try {
            connection = DataSource.getConnection();
            ResultSet resultSet = connection.createStatement().executeQuery("select * from Persons");
            while (resultSet.next()) {
                //create person list
                Person person = new Person();
                person.setId(resultSet.getInt(1));
                person.setFirstName(resultSet.getString(2));
                person.setSecondName(resultSet.getString(3));
                person.setAge(resultSet.getInt(4));
                person.setCity(resultSet.getString(5));
                person.setCompany(resultSet.getString(6));
                person.setLanguage(resultSet.getString(7));
                person.setSalary(resultSet.getInt(8));

                personList.add(person);
            }

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if(connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return personList;
    }

    public static Person personById(int id) {
        Connection connection = null;
        Person person = new Person();
        try {
            connection = DataSource.getConnection();
            ResultSet resultSet = connection.createStatement().executeQuery("select * from Persons where id = " + id);
            while (resultSet.next()) {
                //create person
                person.setId(resultSet.getInt(1));
                person.setFirstName(resultSet.getString(2));
                person.setSecondName(resultSet.getString(3));
                person.setAge(resultSet.getInt(4));
                person.setCity(resultSet.getString(5));
                person.setCompany(resultSet.getString(6));
                person.setLanguage(resultSet.getString(7));
                person.setSalary(resultSet.getInt(8));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if(connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return person;
    }

    public static void deletePersonById(int id) {
        Connection connection = null;
        try {
            connection = DataSource.getConnection();
            connection.createStatement().executeUpdate("delete from Persons where id =" + id);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if(connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void updatePerson(Person person) {
        Connection connection = null;
        try {
            connection = DataSource.getConnection();
            connection.createStatement().executeUpdate(
                    "update Persons set " +
                            "FirstName = " + "\'" + person.getFirstName() + "\', " +
                            "SecondName = " + "\'" + person.getSecondName() + "\', " +
                            "Age = " + person.getAge() + ", " +
                            "City = " + "\'" + person.getCity() + "\', " +
                            "Company = " + "\'" + person.getCompany() + "\', " +
                            "Language = " + "\'" + person.getLanguage() + "\', " +
                            "Salary = " + person.getSalary() +
                            " where id = " + person.getId()
            );
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if(connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void addNewPerson(Person person) {
        Connection connection = null;
        try {
            connection = DataSource.getConnection();
            connection.createStatement().executeUpdate("insert into Persons" +
                    "(FirstName, SecondName, Age, City, Company, Language, Salary) " +
                    "values ("
                    + "'" + person.getFirstName() + "', "
                    + "'" + person.getSecondName() + "', "
                    + person.getAge() + ", "
                    + "'" + person.getCity() + "', "
                    + "'" + person.getCompany() + "', "
                    + "'" + person.getLanguage() + "', "
                    + person.getSalary() + ")"
            );
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if(connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
