package Controller;

import Model.Person;
import Util.URL_generator;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class UpdatePersonController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();
        Person updatePerson = new Person(
                Integer.parseInt(cookies[1].getValue()),
                req.getParameter("firstName"),
                req.getParameter("secondName"),
                Integer.parseInt(req.getParameter("age")),
                req.getParameter("city"),
                req.getParameter("company"),
                req.getParameter("language"),
                Integer.parseInt(req.getParameter("salary"))
        );

        URL url = URL_generator.updatePerson();
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        connection.setRequestMethod("POST");
        connection.setDoOutput(true);
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (HTML, like Gecko) Chrome/103.0.5060.134 Safari/537.36 OPR/89.0.4447.83");

        try(OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream())) {
            String JSONPerson = new Gson().toJson(updatePerson);
            writer.write(JSONPerson);
        }

        if (connection.getResponseCode() != 200) {
            System.err.println("!!!!!!!!!!!!!connection failed!!!!!!!!!!!!!!!");
        }

        connection.disconnect();

        req.getRequestDispatcher("mainPage.jsp").forward(req, resp);
    }
}
