package Controller;

import Util.URL_generator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class DeletePersonController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        URL url = URL_generator.deletePerson();
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "application/json");

        connection.setDoOutput(true);
        try(DataOutputStream out = new DataOutputStream(connection.getOutputStream())) {
            out.writeBytes("id = " + req.getParameter("id"));
            out.flush();
        }

        connection.disconnect();
    }
}
