package com.epam.nivash.spring.core;

public class ConsoleEventLogger implements Loggable {
    @Override
    public void logEvent(String msg) {
        System.out.println(msg);
    }
}
