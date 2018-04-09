package com.epam.java.core4.task3;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ActorsDB {

    private List<Actor> actors;
    private String filePath;

    public ActorsDB(String filePath) {
        this.filePath = filePath;
        this.actors = new ArrayList<>();
    }

    public List<Actor> getActors() {
        return actors;
    }

    public void openDB() {
        File file = new File(filePath);
        if (!file.exists()) {
            actors = new ArrayList<>();
        }
        try (FileInputStream fileInput = new FileInputStream(new File(filePath));
        ObjectInputStream objectInput = new ObjectInputStream(fileInput)) {
            actors = (List<Actor>)objectInput.readObject();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void addActor(Actor actor) {
        actors.add(actor);
    }

    public void removeActor(Actor actor) {
        actors.remove(actor);
    }

    public void saveDB() {
        try (FileOutputStream fileStream = new FileOutputStream(new File(filePath));
             ObjectOutputStream objectStream = new ObjectOutputStream(fileStream)) {
            objectStream.writeObject(actors);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}