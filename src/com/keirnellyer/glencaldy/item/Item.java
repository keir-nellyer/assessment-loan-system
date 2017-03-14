package com.keirnellyer.glencaldy.item;

import java.util.Objects;

public abstract class Item {
    private final int id;
    private String name;
    private String publisher;
    private float cost;

    public Item(int id, String name, String publisher, float cost) {
        this.id = id;
        this.name = name;
        this.publisher = publisher;
        this.cost = cost;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public String getStockType() {
        return "Item";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Item)) return false;
        Item item = (Item) o;
        return id == item.id &&
                Float.compare(item.cost, cost) == 0 &&
                Objects.equals(name, item.name) &&
                Objects.equals(publisher, item.publisher);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, publisher, cost);
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", publisher='" + publisher + '\'' +
                ", cost=" + cost +
                '}';
    }
}
