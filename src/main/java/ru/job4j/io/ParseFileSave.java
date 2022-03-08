package ru.job4j.io;

import java.io.*;

public final class ParseFileSave {
    private final File file;

    public ParseFileSave(File file) {
        this.file = file;
    }

    public synchronized void saveContent(String content) {
        try (OutputStream o =
                     new BufferedOutputStream(new FileOutputStream(file))) {
            for (int i = 0; i < content.length(); i += 1) {
                o.write(content.charAt(i));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
