package com.epam.java.core2.task1;

public class Notebook extends Stationery {

    private int price;
    private String title;
    private String manufactured;

    public Notebook(int price, String title, String manufactured) {
        super(price, title, manufactured);
    }

    @Override
    public String toString() {
        return "Notebook{" +
                "price=" + getPrice() +
                ", title='" + getTitle() + '\'' +
                ", manufactured='" + getManufactured() + '\'' +
                '}';
    }
}
