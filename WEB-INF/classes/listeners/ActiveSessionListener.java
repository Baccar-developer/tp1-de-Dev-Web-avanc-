package listeners;

import jakarta.servlet.http.*;

import java.util.concurrent.atomic.AtomicInteger;

import jakarta.servlet.*;

import jakarta.servlet.annotation.WebListener;

@WebListener
public class ActiveSessionListener implements HttpSessionListener {
    private static final AtomicInteger active = new AtomicInteger(1);

    @Override
    public void sessionCreated(HttpSessionEvent e) {
        int n = active.incrementAndGet();
        e.getSession().getServletContext().setAttribute("activeSessions", n);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent e) {
        int n = active.decrementAndGet();
        e.getSession().getServletContext().setAttribute("activeSessions", n);
    }
}