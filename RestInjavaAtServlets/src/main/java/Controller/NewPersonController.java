package Controller;

import Model.Person;
import Service.PersonDAOService;
import Service.PersonDAOServiceImpl;
import com.google.gson.Gson;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

public class NewPersonController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        PersonDAOService service = new PersonDAOServiceImpl();

        String result;

        try(BufferedReader reader = new BufferedReader(new InputStreamReader(req.getInputStream()))) {
            result = reader.lines().collect(Collectors.joining(System.lineSeparator()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Person newPerson = new Gson().fromJson(result, Person.class);

        service.addNewPerson(newPerson);
    }
}
