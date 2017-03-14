package com.keirnellyer.glencaldy.menu.option.stock;

import com.keirnellyer.glencaldy.item.Item;
import com.keirnellyer.glencaldy.manipulation.Manipulator;
import com.keirnellyer.glencaldy.manipulation.property.PropertyManager;
import com.keirnellyer.glencaldy.manipulation.property.InputResult;
import com.keirnellyer.glencaldy.menu.Menu;
import com.keirnellyer.glencaldy.menu.Option;
import com.keirnellyer.glencaldy.repository.StockRepository;

import java.util.Scanner;

import static com.keirnellyer.glencaldy.manipulation.Manipulators.*;

public class CreateStockOption extends Option {
    private final StockRepository repository;

    public CreateStockOption(StockRepository repository) {
        super("Create Stock");
        this.repository = repository;
    }

    @Override
    public void start(Scanner scanner) {
        Menu menu = new Menu("Stock Type");

        menu.addItem(new SelectType("Book", BOOK_MANAGER, BOOK_MANIPULATOR));
        menu.addItem(new SelectType("Journal", JOURNAL_MANAGER, JOURNAL_MANIPULATOR));
        menu.addItem(new SelectType("Compact Disc", DISC_MANAGER, DISC_MANIPULATOR));
        menu.addItem(new SelectType("Video", VIDEO_MANAGER, VIDEO_MANIPULATOR));

        menu.startMenu(scanner);
    }

    public class SelectType extends Option {
        private final PropertyManager propertyManager;
        private final Manipulator<? extends Item> manipulator;

        public SelectType(String userType, PropertyManager propertyManager,
                          Manipulator<? extends Item> manipulator) {
            super(userType);
            this.propertyManager = propertyManager;
            this.manipulator = manipulator;
        }

        @Override
        public void start(Scanner scanner) {
            InputResult result = propertyManager.fetchResult(scanner, false);

            if (result != null) {
                Item item = manipulator.create(result);

                if (item != null) {
                    repository.add(item);
                    System.out.println("Stock created.");
                } else {
                    System.out.println("Something went wrong whilst creating item.");
                }
            }
        }
    }
}
