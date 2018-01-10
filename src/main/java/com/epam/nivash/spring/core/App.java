package com.epam.nivash.spring.core;

import com.epam.nivash.spring.core.event.Event;
import com.epam.nivash.spring.core.logger.Loggable;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    private Client client;
    private Loggable eventLogger;

    public App() {
    }

    public App(Client client, Loggable eventLogger) {
        this.client = client;
        this.eventLogger = eventLogger;
    }

    public void logEvent(String msg, ConfigurableApplicationContext context) {
        String message = msg.replaceAll(String.valueOf(client.getId()), client.getFullName());
        Event event = context.getBean(Event.class);
        event.setMsg(message);
        eventLogger.logEvent(event);
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        App app = (App) context.getBean("app");
        app.logEvent("First Log for user 1", context);
        app.logEvent("second Log for user 1", context);
        app.logEvent("third log for user 1", context);
        context.close();
    }
}
