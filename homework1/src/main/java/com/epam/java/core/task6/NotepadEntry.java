package com.epam.java.core.task6;

import java.util.Date;

/**
 * {@link NotepadEntry} represents a unique record in a {@link NotePad}.
 */
public class NotepadEntry {

    /**
     * Author of an entry
     */
    private String author;

    /**
     * Text content of an entry
     */
    private String text;

    /**
     * Creation timestamp
     */
    private final Date createdDate;

    /**
     * Creates a new instance of {@link NotepadEntry}
     * @param author of an entry
     * @param text content of an entry
     */
    public NotepadEntry(String author, String text) {
        this.author = author;
        this.text = text;
        this.createdDate = new Date();
    }

    @Override
    public String toString() {
        return  "author='" + author + '\'' +
                ", text='" + text + '\'' +
                ", createdDate=" + createdDate;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getCreatedDate() {
        return createdDate;
    }
}
