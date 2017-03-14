package com.keirnellyer.glencaldy.menu.option.stock;

import com.keirnellyer.glencaldy.item.Item;
import com.keirnellyer.glencaldy.menu.Option;
import com.keirnellyer.glencaldy.repository.StockRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SearchStockOption extends Option {

    private static final String FORMAT = "| %-5s | %-15s | %-10s | %-5s |%n";
    private static final String[] HEADER = new String[]{"ID", "Name", "Type", "Cost"};

    private final StockRepository stockRepository;

    public SearchStockOption(StockRepository stockRepository) {
        super("Search Catalogue");
        this.stockRepository = stockRepository;
    }

    @Override
    public void start(Scanner scanner) {
        System.out.println("Please enter a search term.");
        String search = scanner.next();

        List<Item> results = searchCatalogue(search);

        if (results.size() > 0) {
            System.out.printf(FORMAT, (Object[]) HEADER);

            for (Item result : results) {
                System.out.printf(FORMAT, result.getId(), result.getName(), result.getStockType(), result.getCost());
            }
        } else {
            System.out.println("No results found.");
        }
    }

    private List<Item> searchCatalogue(String term) {
        List<Item> results = new ArrayList<>();
        String lower = term.toLowerCase();

        for (Item item : stockRepository.getAll()) {
            // compare both lower case making this function case-insensitive
            if (item.getName().toLowerCase().contains(lower)) {
                results.add(item);
            }
        }

        return results;
    }
}
