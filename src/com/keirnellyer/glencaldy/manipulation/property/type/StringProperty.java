package com.keirnellyer.glencaldy.manipulation.property.type;

import com.keirnellyer.glencaldy.exception.InputException;

public class StringProperty extends BasicProperty<String> {
    public StringProperty(String askMsg) {
        super(askMsg);
    }

    public StringProperty(String askMsg, boolean editable) {
        super(askMsg, editable);
    }

    @Override
    protected String parse(String input) throws InputException {
        return input;
    }
}
