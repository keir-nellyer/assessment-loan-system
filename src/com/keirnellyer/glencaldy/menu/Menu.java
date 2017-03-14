package com.keirnellyer.glencaldy.menu;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Menu {
    private final String title;

    private char charIndex = 'a';
    private final Map<String, Option> items = new LinkedHashMap<>(); // linked hashmap preserves insertion order

    public Menu(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public Map<String, Option> getItems() {
        return items;
    }

    public void addItem(Option item) {
        addItem(String.valueOf(charIndex++), item);
    }

    public void addItem(String selector, Option item) {
        items.put(selector, item);
    }

    public void startMenu(Scanner scanner) {
        displayMenu();

        Option option = fetchMenuOption(scanner);

        if (option != null) {
            System.out.println();
            option.start(scanner);
            System.out.println();
        }
    }

    private Option fetchMenuOption(Scanner scanner) {
        Option option;

        do {
            System.out.println("Please enter a menu option.");
            String userOption = scanner.next();
            option = items.get(userOption);

            if (option == null) {
                System.out.println("Invalid menu option, please try again.");
            }
        } while (option == null);

        return option;
    }

    private void displayMenu() {
        System.out.println(String.format("*** %s ***", title));

        for (Map.Entry<String, Option> entry : items.entrySet()) {
            System.out.println(String.format("%s) %s", entry.getKey(), entry.getValue().getDisplayName()));
        }

        System.out.println();
    }

    @Override
    public String toString() {
        return "Menu{" +
                "title='" + title + '\'' +
                ", items=" + items +
                '}';
    }
}
