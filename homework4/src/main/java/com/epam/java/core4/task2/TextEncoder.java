package com.epam.java.core4.task2;

import java.io.*;
import java.nio.charset.Charset;

public class TextEncoder {

    public void encodeText(String source, String ensource) {
        File file = new File(source);
        if (!file.isFile() || !file.exists()) {
            throw new IllegalArgumentException("There is no such file");
        }
        try (FileInputStream stream = new FileInputStream(file);
             FileOutputStream writer = new FileOutputStream(ensource)) {
            byte[] bytesArray = new byte[(int)file.length()];
            stream.read(bytesArray);
            String data = new String(bytesArray, Charset.forName("UTF-8"));
            writer.write(data.getBytes(Charset.forName("UTF-16")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
