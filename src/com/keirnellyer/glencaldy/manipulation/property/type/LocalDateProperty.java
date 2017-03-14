package com.keirnellyer.glencaldy.manipulation.property.type;

import com.keirnellyer.glencaldy.exception.InputException;
import com.keirnellyer.glencaldy.util.Constants;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class LocalDateProperty extends BasicProperty<LocalDate> {

    public LocalDateProperty(String askMsg) {
        super(askMsg);
    }

    public LocalDateProperty(String askMsg, boolean editable) {
        super(askMsg, editable);
    }

    @Override
    protected LocalDate parse(String input) throws InputException {
        try {
            return LocalDate.parse(input, Constants.DATE_FORMATTER);
        } catch (DateTimeParseException e) {
            throw new InputException("Error whilst parsing date.", e);
        }
    }
}
