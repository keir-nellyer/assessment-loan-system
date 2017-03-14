package com.keirnellyer.glencaldy.manipulation.property.type;

import com.keirnellyer.glencaldy.exception.InputException;
import com.keirnellyer.glencaldy.util.InputUtil;

import java.util.Scanner;

public abstract class Property<T> {
    private boolean editable = true;

    public Property() {}

    public boolean isEditable() {
        return editable;
    }

    protected void setEditable(boolean editable) {
        this.editable = editable;
    }

    public final T fetchValue(Scanner scanner, boolean allowSkip) {
        T value = null;

        do {
            ask();

            String input = scanner.next();

            if (shouldEdit(allowSkip, input)) {
                try {
                    value = parse(input);

                    if (value == null) {
                        System.out.println("Something went wrong there, please try again.");
                    }
                } catch (InputException e) {
                    System.out.println("Input error occurred: " + e.getMessage());
                    System.out.println("Please try again.");
                }
            } else {
                return null;
            }
        } while (value == null);

        return value;
    }

    private boolean shouldEdit(boolean allowSkip, String input) {
        return allowSkip ? !InputUtil.checkSkip(input) : !InputUtil.checkAbort(input);
    }

    protected abstract void ask();
    protected abstract T parse(String input) throws InputException;
}
