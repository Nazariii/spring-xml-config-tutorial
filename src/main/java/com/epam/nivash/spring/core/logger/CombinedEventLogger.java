package com.epam.nivash.spring.core.logger;

import com.epam.nivash.spring.core.event.Event;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Set;

@Component
public class CombinedEventLogger implements Loggable {

    @Resource(name = "eventLoggerList")
    private Set<Loggable> loggers;

    @Override
    public void logEvent(Event msg) {
        loggers.forEach(loggable -> loggable.logEvent(msg));
    }
}
