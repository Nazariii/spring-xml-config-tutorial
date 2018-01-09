package com.epam.nivash.spring.core;

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

    public void logEvent(String msg) {
        String message = msg.replaceAll(String.valueOf(client.getId()), client.getFullName());
        eventLogger.logEvent(message);
    }

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        App app = (App) context.getBean("app");
        app.logEvent("Log for user 1");
    }
}
