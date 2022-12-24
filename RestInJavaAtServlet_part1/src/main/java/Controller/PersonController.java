package Controller;

import Service.PersonDAOService;
import com.google.gson.Gson;

import javax.servlet.AsyncContext;
import javax.servlet.AsyncEvent;
import javax.servlet.AsyncListener;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.concurrent.ThreadPoolExecutor;


@WebServlet(urlPatterns = "/person", asyncSupported = true)
public class PersonController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        ThreadPoolExecutor executor = (ThreadPoolExecutor) req.getAttribute("executor");
        PersonDAOService service = (PersonDAOService) req.getAttribute("service");
        Gson gson = (Gson) req.getAttribute("gson");
        final String[] allPersonInJson = {""};
        AsyncContext asyncContext = req.startAsync();

        asyncContext.addListener(new AsyncListener() {
            @Override
            public void onComplete(AsyncEvent asyncEvent) throws IOException {
                HttpServletResponse response = (HttpServletResponse) asyncEvent.getAsyncContext().getResponse();
                PrintWriter writer = response.getWriter();

                response.setContentType("application/json");
                writer.println(allPersonInJson[0]);
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
                allPersonInJson[0] = gson.toJson(service.searchPersonById(req.getParameter("id")));
                asyncContext.complete();
            }
        });
    }
}