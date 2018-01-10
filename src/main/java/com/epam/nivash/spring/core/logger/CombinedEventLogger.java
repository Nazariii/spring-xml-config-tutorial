package com.epam.nivash.spring.core.logger;

import com.epam.nivash.spring.core.event.Event;

import java.util.Set;

public class CombinedEventLogger implements Loggable {
    private Set<Loggable> loggers;

    public CombinedEventLogger(Set<Loggable> loggers) {
        this.loggers = loggers;
    }

    @Override
    public void logEvent(Event msg) {
        loggers.forEach(loggable -> loggable.logEvent(msg));
    }
}
