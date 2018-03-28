package com.epam.java.core2.task1;

import java.util.Objects;

public class Stationery {

    private int price;
    private String title;
    private String manufactured;

    public Stationery(int price, String title, String manufactured) {
        this.price = price;
        this.title = title;
        this.manufactured = manufactured;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getManufactured() {
        return manufactured;
    }

    public void setManufactured(String manufactured) {
        this.manufactured = manufactured;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Stationery)) return false;
        Stationery that = (Stationery) o;
        return getPrice() == that.getPrice() &&
                Objects.equals(getTitle(), that.getTitle()) &&
                Objects.equals(getManufactured(), that.getManufactured());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getPrice(), getTitle(), getManufactured());
    }

    @Override
    public String toString() {
        return  "Stationery{" +
                "price=" + getPrice() +
                ", title='" + getTitle() + '\'' +
                ", manufactured='" + getManufactured() + '\'' +
                '}';
    }
}
