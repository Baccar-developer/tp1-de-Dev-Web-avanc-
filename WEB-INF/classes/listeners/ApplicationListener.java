package listeners;

import jakarta.servlet.http.*;

import java.util.concurrent.atomic.AtomicInteger;

import jakarta.servlet.*;

import jakarta.servlet.annotation.WebListener;

@WebListener
public class ApplicationListener implements ServletContextListener {
    public void contextInitialized(ServletContextEvent e) {
        e.getServletContext().setAttribute("appName", "ING1 Web Application");
        System.out.println("Application started");
    }

    public void contextDestroyed(ServletContextEvent e) {
        System.out.println("Application stopped");
    }
}