package com.epam.nivash.spring.core.logger;

import com.epam.nivash.spring.core.event.Event;
import org.springframework.beans.factory.annotation.Value;

import javax.annotation.PreDestroy;
import java.util.ArrayList;
import java.util.List;

public class CacheFileEventLogger extends FileEventLogger {

    private int cashSize;
    private List<Event> cache = new ArrayList<>();

    public CacheFileEventLogger(String filename, @Value("2") Integer cashSize) {
        super(filename);
        this.cashSize = cashSize;
    }

    @Override
    public void logEvent(Event msg) {
        cache.add(msg);
        if (cache.size() == cashSize) {
            writeEventsFromCache();
            cache.clear();
        }
    }

    public void writeEventsFromCache() {
        System.out.println("writeEventsFromCache run");
//        cache.forEach(System.out::println);
        cache.forEach(super::logEvent);
    }

    @PreDestroy
    private void destroy() {
        System.out.println("destroy method run");
        if (!cache.isEmpty()) {
            writeEventsFromCache();
            cache.clear();
        }
    }
}
