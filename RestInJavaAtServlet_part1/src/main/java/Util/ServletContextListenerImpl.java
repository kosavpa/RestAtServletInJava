package Util;


import Service.PersonDAOService;
import Service.PersonDAOServiceImpl;
import com.google.gson.GsonBuilder;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;


@WebListener
public class ServletContextListenerImpl implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(4, 16, 1, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(16));
        PersonDAOService service = new PersonDAOServiceImpl();
        sce.getServletContext().setAttribute("executor", executor);
        sce.getServletContext().setAttribute("service", service);
        sce.getServletContext().setAttribute("gson", new GsonBuilder().setPrettyPrinting().create());
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        ThreadPoolExecutor executor = (ThreadPoolExecutor) sce.getServletContext().getAttribute("executor");
        executor.shutdown();
    }
}
