package com.epam.nivash.spring.core.logger;

import com.epam.nivash.spring.core.event.Event;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Collections;

public class FileEventLogger implements Loggable {

    private String fileName;

    public FileEventLogger(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void logEvent(Event msg) {
        try {
            Files.write(Paths.get(fileName), Collections.singletonList(msg.toString()), StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void init() {
        System.out.println("FileEventLogger init method worked");
        if (!Files.exists(Paths.get(fileName))) {
            try {
                Files.createFile(Paths.get(fileName));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
