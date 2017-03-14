package com.keirnellyer.glencaldy.manipulation.property.type;

import com.keirnellyer.glencaldy.exception.InputException;
import com.keirnellyer.glencaldy.item.Item;
import com.keirnellyer.glencaldy.repository.StockRepository;

public class ItemProperty extends BasicProperty<Item> {
    private final StockRepository stockRepository;

    public ItemProperty(String askMsg, StockRepository stockRepository) {
        super(askMsg);
        this.stockRepository = stockRepository;
    }

    public ItemProperty(String askMsg, boolean editable, StockRepository stockRepository) {
        super(askMsg, editable);
        this.stockRepository = stockRepository;
    }

    @Override
    protected Item parse(String input) throws InputException {
        int itemId;

        try {
            itemId = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new InputException("Not a valid item id.");
        }

        Item item = stockRepository.get(itemId);

        if (item == null) {
            throw new InputException("Item not found.");
        }

        return item;
    }
}
