package com.epam.java.core2.task5;

public enum Course {

    MATHEMATICS(true),
    CHEMISTRY(true),
    PHYSICS(true),
    HISTORY(false),
    PHILOSOPHY(false);

    private boolean doubleMark;

    Course(boolean doubleMark) {
        this.doubleMark = doubleMark;
    }

    public boolean isDoubleMark() {
        return doubleMark;
    }

    public void setDoubleMark(boolean doubleMark) {
        this.doubleMark = doubleMark;
    }
}
