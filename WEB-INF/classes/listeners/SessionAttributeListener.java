package listeners;

import jakarta.servlet.http.*;

import java.util.concurrent.atomic.AtomicInteger;

import jakarta.servlet.*;

import jakarta.servlet.annotation.WebListener;

public class SessionAttributeListener implements HttpSessionAttributeListener {
    public void attributeAdded(HttpSessionBindingEvent e) {
        System.out.println("ajouté: " + e.getName() + "=" + e.getValue());
    }

    public void attributeReplaced(HttpSessionBindingEvent e) {
        System.out.println("modifié: " + e.getName());
    }

    public void attributeRemoved(HttpSessionBindingEvent e) {
        System.out.println("supprimé: " + e.getName());
    }
}