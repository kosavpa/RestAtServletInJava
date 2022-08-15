package Controller;

import Model.Person;
import Util.URL_generator;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class UpdatePersonGetController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        URL url = URL_generator.person(req.getParameter("id"));
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        connection.setRequestMethod("GET");

        try (BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
            Gson gson = new Gson();
            String inputLine;
            StringBuilder content = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }

            Person person = gson.fromJson(content.toString(), Person.class);
            req.setAttribute("id", person.getId());
            req.setAttribute("firstName", person.getFirstName());
            req.setAttribute("secondName", person.getSecondName());
            req.setAttribute("age", person.getAge());
            req.setAttribute("city", person.getCity());
            req.setAttribute("company", person.getCompany());
            req.setAttribute("language", person.getLanguage());
            req.setAttribute("salary", person.getSalary());

            req.getRequestDispatcher("updatePerson.jsp").forward(req, resp);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        connection.disconnect();
    }
}
