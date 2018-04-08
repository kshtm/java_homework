package com.epam.java.core4.task1;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class JavaCodeReader {

    private static final Set<String> KEYWORDS = new HashSet<>();
    static {
        KEYWORDS.add("package");
        KEYWORDS.add("import");
        KEYWORDS.add("public");
        KEYWORDS.add("protected");
        KEYWORDS.add("private");
        KEYWORDS.add("abstract");
        KEYWORDS.add("final");
        KEYWORDS.add("void");
        KEYWORDS.add("class");
        KEYWORDS.add("interface");
        KEYWORDS.add("static");
        KEYWORDS.add("int");
        KEYWORDS.add("long");
        KEYWORDS.add("double");
        KEYWORDS.add("float");
        KEYWORDS.add("byte");
        KEYWORDS.add("short");
        KEYWORDS.add("char");
        KEYWORDS.add("boolean");
        KEYWORDS.add("if");
        KEYWORDS.add("else");
        KEYWORDS.add("for");
        KEYWORDS.add("while");
        KEYWORDS.add("return");
        KEYWORDS.add("try");
        KEYWORDS.add("catch");
        KEYWORDS.add("finally");
    }
    private String filePath;

    public JavaCodeReader(String filePath) {
        this.filePath = filePath;
    }

    public Map<String, Integer> countKeywords() {
        File file = new File(filePath);
        if (!file.isFile() || !file.exists()) {
            throw new IllegalArgumentException("There is no such file");
        }
        try (FileInputStream stream = new FileInputStream(file)) {
            byte[] bytesArray = new byte[(int)file.length()];
            stream.read(bytesArray);
            return readData(new String(bytesArray));
        } catch (IOException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    private Map<String,Integer> readData(String text) {
        String[] words = text.split("\\s+");
        Map<String, Integer> result = new HashMap<>();
        for (String word : words) {
            if (KEYWORDS.contains(word)) {
                if (result.containsKey(word)) {
                    int i = result.get(word);
                    result.put(word, ++i);
                } else {
                    result.put(word, 1);
                }
            }
        }
        return result;
    }
}
