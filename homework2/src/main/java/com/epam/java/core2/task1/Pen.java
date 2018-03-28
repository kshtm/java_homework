package com.epam.java.core2.task1;

public class Pen extends Stationery {

    private int price;
    private String title;
    private String manufactured;


    public Pen(int price, String title, String manufactured) {
        super(price, title, manufactured);

    }

    @Override
    public String toString() {
        return "Pen{" +
                "price=" + getPrice() +
                ", title='" + getTitle() + '\'' +
                ", manufactured='" + getManufactured() + '\'' +
                '}';
    }
}
