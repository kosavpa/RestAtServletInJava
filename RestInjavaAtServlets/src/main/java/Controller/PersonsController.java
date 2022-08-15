package Controller;

import Service.PersonDAOService;
import Service.PersonDAOServiceImpl;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;

public class PersonsController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        PersonDAOService service = new PersonDAOServiceImpl();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        String allPersonInJson = gson.toJson(service.getAllPerson());

        resp.setContentType("application/json");
        PrintWriter writer = resp.getWriter();
        try {
            writer.write(allPersonInJson);
            writer.flush();
        } finally {
            writer.close();
        }
    }
}
