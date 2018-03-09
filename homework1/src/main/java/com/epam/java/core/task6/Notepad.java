package com.epam.java.core.task6;

import java.util.ArrayList;
import java.util.List;

/**
 * {@link Notepad} provides CRUD operations for collection of {@link NotepadEntry}
 */
public class Notepad {

    /**
     * Stores content of {@link Notepad}
     */
    private List<NotepadEntry> entries;

    /**
     * Creates empty {@link Notepad}
     */
    public Notepad() {
        this.entries = new ArrayList<>();
    }

    /**
     * Adds a new record into {@link Notepad}
     * @param author of a new record
     * @param text of a new record
     * @return index of a new record
     */
    public int addRecord(String author, String text) {
        NotepadEntry entry = new NotepadEntry(author, text);
        entries.add(entry);
        return entries.size() - 1;
    }

    /**
     * Deletes a record from {@link Notepad}
     * @param index of a record to delete
     */
    public void deleteRecord(int index) {
        checkIndex(index);
        entries.remove(index);
    }

    /**
     * Updates a record in {@link Notepad}
     * @param author updated author
     * @param text updated text
     * @param index of a record to update
     */
    public void updateRecord(String author, String text, int index) {
        checkIndex(index);
        NotepadEntry entry = entries.get(index);
        entry.setAuthor(author);
        entry.setText(text);
    }


    /**
     * Prints all records to stdout
     */
    public void list() {
        if (entries.isEmpty()) {
            System.out.println("Notepad is empty!");
            return;
        }
        for (int i = 0; i < entries.size(); i++) {
            System.out.printf("%d: %s", i, entries.get(i));
            System.out.println();
        }
    }

    private void checkIndex(int index) {
        if (index < 0 || index > entries.size() - 1) {
            throw new IllegalArgumentException("Illegal index");
        }
    }

}
