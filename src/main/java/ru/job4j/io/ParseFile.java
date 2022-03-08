package ru.job4j.io;

import java.io.*;
import java.util.function.Predicate;

public final class ParseFile {
    private final File file;

    public ParseFile(final File file) {
        this.file = file;
    }

    public synchronized String getContent() {
      return content(character -> true);
    }

    public synchronized String getContentWithoutUnicode() {
        return content(character -> character < 0x80);
    }

    public synchronized String  content(Predicate<Character> filter) {
        String output = "";
        try (InputStream i = new BufferedInputStream(new FileInputStream(file))) {
            int data;
            while ((data = i.read()) != -1) {
                if (filter.test((char) data)) {
                    output += (char) data;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return output;
    }
}
