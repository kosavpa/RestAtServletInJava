package Service;

import DAO.PersonDAO;
import Model.Person;

import java.sql.SQLException;
import java.util.List;

public class PersonDAOServiceImpl implements PersonDAOService{
    @Override
    public List<Person> getAllPerson() {
        try {
            return PersonDAO.allPerson();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Person searchPersonById(String id) {
        try {
            return PersonDAO.personById(Integer.parseInt(id));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void addNewPerson(Person person) {
        try {
            PersonDAO.addNewPerson(person);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updatePersonById(Person person) {
        try {
            PersonDAO.updatePerson(person);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deletePersonById(String id) {
        try {
            PersonDAO.deletePersonById(Integer.parseInt(id));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
