package com.epam.nivash.spring.core;

import com.epam.nivash.spring.core.event.Event;
import com.epam.nivash.spring.core.event.EventType;
import com.epam.nivash.spring.core.logger.Loggable;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Configuration
@ComponentScan(basePackages = "com.epam.nivash.spring.core")
@PropertySource(ignoreResourceNotFound = true, value = "classpath:client.properties")
@EnableAspectJAutoProxy
public class AppConfig {

    @Bean("eventLoggerList")
    public Set<Loggable> createEventLoggerSet(@Qualifier("consoleEventLogger") Loggable consoleEventLogger, @Qualifier("cacheFileEventLogger") Loggable cacheFileEventLogger) {
        Set<Loggable> eventLoggerSet = new HashSet<>();
        eventLoggerSet.add(consoleEventLogger);
        eventLoggerSet.add(cacheFileEventLogger);
        return eventLoggerSet;
    }

    @Bean("loggerMap")
    public Map<EventType, Loggable> createLoggerMap(@Qualifier("consoleEventLogger") Loggable consoleEventLogger, @Qualifier("combinedEventLogger") Loggable combinedEventLogger) {
        Map<EventType, Loggable> loggableMap = new HashMap<>();
        loggableMap.put(EventType.ERROR, combinedEventLogger);
        loggableMap.put(EventType.INFO, consoleEventLogger);
        return loggableMap;
    }

    @Bean("Event")
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public Event createEvent() {
        return new Event(LocalDate.now(), DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG));
    }
}
