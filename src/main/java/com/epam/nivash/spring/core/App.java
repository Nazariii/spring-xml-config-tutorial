package com.epam.nivash.spring.core;

import com.epam.nivash.spring.core.event.Event;
import com.epam.nivash.spring.core.event.EventType;
import com.epam.nivash.spring.core.logger.Loggable;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

public class App {
    private Client client;
    private Loggable eventLogger;
    private Map<EventType, Loggable> loggers;

    public App() {
    }

    public App(Client client, Loggable eventLogger, Map<EventType, Loggable> loggers) {
        this.client = client;
        this.eventLogger = eventLogger;
        this.loggers = loggers;
    }

    public void logEvent(String msg, Event event, EventType type) {
        String message = msg.replaceAll(String.valueOf(client.getId()), client.getFullName());
        event.setMsg(message);
        Loggable eventLogger = loggers.get(type);
        if (eventLogger == null) {
            eventLogger = this.eventLogger;
        }
        eventLogger.logEvent(event);
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        App app = (App) context.getBean("app");
        app.logEvent("First Log for user 1", context.getBean(Event.class), EventType.ERROR);
        app.logEvent("second Log for user 1", context.getBean(Event.class), null);
        app.logEvent("third log for user 1", context.getBean(Event.class), EventType.INFO);
        app.logEvent("fourth log for user 1", context.getBean(Event.class), EventType.INFO);
        app.logEvent("fifth log for user 1", context.getBean(Event.class), EventType.ERROR);
        context.close();
    }
}
