package com.keirnellyer.glencaldy.manipulation.property.type;

import com.keirnellyer.glencaldy.exception.InputException;

public class FloatProperty extends BasicProperty<Float> {
    public FloatProperty(String askMsg) {
        super(askMsg);
    }

    public FloatProperty(String askMsg, boolean editable) {
        super(askMsg, editable);
    }

    @Override
    protected Float parse(String input) throws InputException {
        return Float.parseFloat(input);
    }
}
