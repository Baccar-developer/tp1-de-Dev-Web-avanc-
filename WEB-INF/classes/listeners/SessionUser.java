package listeners;

import jakarta.servlet.http.*;

import java.util.concurrent.atomic.AtomicInteger;

import jakarta.servlet.*;

import jakarta.servlet.annotation.WebListener;

public class SessionUser implements HttpSessionBindingListener {
    private String name;

    public SessionUser(String name) {
        this.name = name;
    }

    public void valueBound(HttpSessionBindingEvent e) {
        System.out.println(name + " bound to session");
    }

    public void valueUnbound(HttpSessionBindingEvent e) {
        System.out.println(name + " unbound from session");
    }
}
