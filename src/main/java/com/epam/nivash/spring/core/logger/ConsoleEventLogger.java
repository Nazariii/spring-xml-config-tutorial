package com.epam.nivash.spring.core.logger;

import com.epam.nivash.spring.core.event.Event;

public class ConsoleEventLogger implements Loggable {
    @Override
    public void logEvent(Event msg) {
        System.out.println(msg);
    }
}
