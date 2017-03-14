package com.keirnellyer.glencaldy.manipulation.property.type;

import com.keirnellyer.glencaldy.exception.InputException;

public class IntegerProperty extends BasicProperty<Integer> {
    public IntegerProperty(String askMsg) {
        super(askMsg);
    }

    public IntegerProperty(String askMsg, boolean editable) {
        super(askMsg, editable);
    }

    @Override
    protected Integer parse(String input) throws InputException {
        return Integer.parseInt(input);
    }
}
