package com.epam.nivash.spring.core.logger;

import com.epam.nivash.spring.core.event.Event;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class ConsoleEventLogger implements Loggable {
    @Override
    public void logEvent(Event msg) {
        System.out.println(msg);
    }
}
