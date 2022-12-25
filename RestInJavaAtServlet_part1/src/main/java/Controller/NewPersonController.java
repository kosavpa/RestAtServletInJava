package Controller;


import Model.Person;
import Service.PersonDAOService;
import com.google.gson.Gson;

import javax.servlet.AsyncContext;
import javax.servlet.AsyncEvent;
import javax.servlet.AsyncListener;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.stream.Collectors;


@WebServlet(urlPatterns = "/new", asyncSupported = true)
public class NewPersonController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        ThreadPoolExecutor executor = (ThreadPoolExecutor) req.getServletContext().getAttribute("executor");
        PersonDAOService service = (PersonDAOService) req.getServletContext().getAttribute("service");
        Gson gson = (Gson) req.getServletContext().getAttribute("gson");
        AsyncContext asyncContext = req.startAsync();

        asyncContext.addListener(new AsyncListener() {
            @Override
            public void onComplete(AsyncEvent asyncEvent) throws IOException {
                PrintWriter writer = asyncEvent.getAsyncContext().getResponse().getWriter();
                writer.println(HttpServletResponse.SC_OK);
                writer.flush();
                writer.close();
            }
            @Override
            public void onTimeout(AsyncEvent asyncEvent) throws IOException {
            }
            @Override
            public void onError(AsyncEvent asyncEvent) throws IOException {
            }
            @Override
            public void onStartAsync(AsyncEvent asyncEvent) throws IOException {
            }
        });

        executor.execute(new Runnable() {
            @Override
            public void run() {
                String result = "";
                try (BufferedReader reader = new BufferedReader(new InputStreamReader(req.getInputStream()))) {
                    result = reader.lines().collect(Collectors.joining(System.lineSeparator()));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Person newPerson = gson.fromJson(result, Person.class);
                service.addNewPerson(newPerson);
                asyncContext.complete();
            }
        });
    }
}
