package Service;

import Model.Person;

import java.util.List;

public interface PersonDAOService {
    List<Person> getAllPerson();
    Person searchPersonById(String id);
    void addNewPerson(Person person);
    void updatePersonById(Person person);
    void deletePersonById(String id);
}
