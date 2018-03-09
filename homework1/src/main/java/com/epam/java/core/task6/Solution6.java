package com.epam.java.core.task6;

public class Solution6 {

    public static void main(String[] args) {

        Notepad notepad = new Notepad();
        notepad.addRecord("Dovlatov", "Invisible book");
        notepad.addRecord("Dovlatov", "Ours");
        notepad.addRecord("Bulgakov", "Master & Margarita");
        notepad.addRecord("Nabokov", "Lolita");
        notepad.list();

        notepad.updateRecord("Pushkin", "Evgeniy Onegin", 1);
        notepad.list();

        notepad.deleteRecord(3);
        notepad.list();
    }
}
