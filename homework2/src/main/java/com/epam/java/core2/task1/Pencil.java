package com.epam.java.core2.task1;

public class Pencil extends Stationery {

    private int price;
    private String title;
    private String manufactured;

    public Pencil(int price, String title, String manufactured) {
        super(price, title, manufactured);
    }

    @Override
    public String toString() {
        return "Pencil{" +
                "price=" + getPrice() +
                ", title='" + getTitle() + '\'' +
                ", manufactured='" + getManufactured() + '\'' +
                '}';
    }
}
