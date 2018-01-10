package com.epam.nivash.spring.core.logger;

import com.epam.nivash.spring.core.event.Event;

import java.util.ArrayList;
import java.util.List;

public class CacheFileEventLogger extends FileEventLogger {

    private int cashSize;
    private List<Event> cache = new ArrayList<>();

    public CacheFileEventLogger(String filename, Integer cashSize) {
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
//        cache.forEach(System.out::println);
        cache.forEach(super::logEvent);
    }

    private void destroy() {
        System.out.println("destroy method run");
        if (!cache.isEmpty()) {
            writeEventsFromCache();
            cache.clear();
        }
    }
}
