package com.epam.nivash.spring.core.event;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.UUID;

public class Event {

    private int id;
    private String msg;
    private LocalDate date;
    private DateTimeFormatter dateTimeFormatter;

    public Event(LocalDate date, DateTimeFormatter formatter) {
        this.date = date;
        this.dateTimeFormatter = formatter;
    }

    public void setMsg(String msg) {
        this.msg = msg;
        this.id = new Random().nextInt();
    }

    public int getId() {
        return id;
    }

    public String getMsg() {
        return msg;
    }

    public LocalDate getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", msg='" + msg + '\'' +
                ", date=" + dateTimeFormatter.format(date) +
                '}';
    }
}
