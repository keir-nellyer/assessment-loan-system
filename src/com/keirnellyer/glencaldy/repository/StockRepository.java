package com.keirnellyer.glencaldy.repository;

import com.keirnellyer.glencaldy.item.Item;

import java.util.ArrayList;
import java.util.List;

public class StockRepository implements Repository<Integer, Item> {

    private final List<Item> items = new ArrayList<>();

    @Override
    public List<Item> getAll() {
        return items;
    }

    @Override
    public Item get(Integer id) {
        for (Item item : items) {
            if (item.getId() == id) {
                return item;
            }
        }

        return null;
    }

    @Override
    public void add(Item item) {
        items.add(item);
    }
}
