package com.epam.java.core4.task3;

public class Main {

    public static void main(String[] args) {

        Actor alexandrPankratov = new Actor("Alexandr Pankratov-Black", 68);
        Actor bradPitt = new Actor("Brad Pitt", 54);
        alexandrPankratov.addFilm("Курьер");
        alexandrPankratov.addFilm("Ширли-мырли");
        bradPitt.addFilm("Meet Joe Black");
        bradPitt.addFilm("Babel");
        bradPitt.addFilm("The Curious Case of Benjamin Button");

        ActorsDB actorsDB = new ActorsDB("Actors.txt");
        actorsDB.addActor(alexandrPankratov);
        actorsDB.addActor(bradPitt);
        actorsDB.saveDB();
        ActorsDB actors2 = new ActorsDB("Actors.txt");
        actors2.openDB();
        actors2.getActors().forEach(actor -> System.out.println(actor.toString()));


    }
}
