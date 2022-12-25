package Controller;

import Model.Person;
import Util.URL_generator;
import com.google.gson.Gson;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class NewPersonController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Person newPerson = new Person(
                req.getParameter("firstName"),
                req.getParameter("secondName"),
                Integer.parseInt(req.getParameter("age")),
                req.getParameter("city"),
                req.getParameter("company"),
                req.getParameter("language"),
                Integer.parseInt(req.getParameter("salary"))
        );

        URL url = URL_generator.newPerson();
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        Gson gson = new Gson();

        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setDoOutput(true);

        try(OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream())){
            String JSONPerson = gson.toJson(newPerson);
            writer.write(JSONPerson);
            writer.flush();
        }

        connection.disconnect();
    }
}
