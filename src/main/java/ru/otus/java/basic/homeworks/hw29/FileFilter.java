package ru.otus.java.basic.homeworks.hw29;

import java.io.File;
import java.io.FilenameFilter;

public class FileFilter implements FilenameFilter {
    public boolean accept(File dir, String name) {
        return name.endsWith(".txt");
    }
}
