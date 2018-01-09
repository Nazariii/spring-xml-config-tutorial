package com.epam.nivash.spring.core;

import com.epam.nivash.spring.core.event.Event;

public interface Loggable {
    void logEvent(Event msg);
}
