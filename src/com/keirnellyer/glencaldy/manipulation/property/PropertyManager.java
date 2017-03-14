package com.keirnellyer.glencaldy.manipulation.property;

import com.keirnellyer.glencaldy.manipulation.property.type.Property;

import java.util.*;

public class PropertyManager {
    private final List<Property<?>> properties = new ArrayList<>();

    public List<Property<?>> getProperties() {
        return properties;
    }

    public void addProperty(Property<?> property) {
        properties.add(property);
    }

    public InputResult fetchResult(Scanner scanner, boolean update) {
        Map<Property<?>, Object> values = new HashMap<>();

        for (Property<?> property : properties) {
            if (!update || property.isEditable()) { // don't allow edit during update if editable is false
                Object value = property.fetchValue(scanner, update);

                if (value != null) {
                    values.put(property, value);
                } else if (!update) {
                    // input aborted
                    return null;
                }
            }
        }

        return new InputResult(values);
    }
}
