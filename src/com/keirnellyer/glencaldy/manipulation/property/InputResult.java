package com.keirnellyer.glencaldy.manipulation.property;

import com.keirnellyer.glencaldy.manipulation.property.type.Property;

import java.util.Map;

public class InputResult {
    private final Map<Property<?>, Object> values;

    public InputResult(Map<Property<?>, Object> values) {
        this.values = values;
    }

    public Map<Property<?>, Object> getValues() {
        return values;
    }

    public <T> T getValue(Property<T> property) {
        return (T) values.get(property);
    }
}
