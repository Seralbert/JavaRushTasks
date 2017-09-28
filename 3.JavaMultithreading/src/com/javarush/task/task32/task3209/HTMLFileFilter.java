package com.javarush.task.task32.task3209;

import javax.swing.filechooser.FileFilter;
import java.io.File;

/**
 * Created by USER-PC on 10.09.2017.
 */
public class HTMLFileFilter  extends FileFilter {

    @Override
    public boolean accept(File f) {
        //boolean s = f.isDirectory() | f.getName().toLowerCase().matches("html$| htm$");

        return f.isDirectory() | f.getName().toLowerCase().endsWith(".html")|f.getName().toLowerCase().endsWith(".htm");
    }

    @Override
    public String getDescription() {
        return "HTML и HTM файлы";
    }
}
