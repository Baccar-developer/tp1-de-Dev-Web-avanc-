package listeners;

import jakarta.servlet.http.*;
import jakarta.servlet.ServletRequestListener;
import jakarta.servlet.ServletRequestEvent;
import jakarta.servlet.annotation.WebListener;
import java.io.*;

public class RequestListener implements ServletRequestListener {
    public void requestInitialized(ServletRequestEvent e) {
        System.out.println("Request initialized: " + ((HttpServletRequest) e.getServletRequest()).getRequestURI());
    }

    public void requestDestroyed(ServletRequestEvent e) {
        System.out.println("Request destroyed");
    }
}