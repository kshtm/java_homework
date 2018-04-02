package com.epam.java.core2.task6;

@Description(value = "Author Semkov Vitalii")
public class Submarine {

    private SubmarineEngine engine;

    public Submarine() {
        this.engine = new SubmarineEngine();
    }

    public void start() {
        System.out.println("Starting submarine");
        engine.start();
    }

    public void stop() {
        System.out.println("Stop engine");
        engine.stop();
    }

    class SubmarineEngine {
        void start() {
            System.out.println("Frrrrrrr...");
        }

        void stop() {
            System.out.println("Vzhh...");
        }
    }
}

