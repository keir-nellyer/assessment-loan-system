package com.keirnellyer.glencaldy.manipulation.stock;

import com.keirnellyer.glencaldy.item.Paper;
import com.keirnellyer.glencaldy.manipulation.property.InputResult;
import com.keirnellyer.glencaldy.manipulation.property.type.IntegerProperty;
import com.keirnellyer.glencaldy.manipulation.property.type.StringProperty;

public class PaperProperties extends ItemProperties {
    private final StringProperty subjectProperty = new StringProperty("Please enter the subject area.");
    private final IntegerProperty pagesProperty = new IntegerProperty("Please enter the amount of pages.");

    public PaperProperties() {
        super();

        addProperty(subjectProperty);
        addProperty(pagesProperty);
    }

    public StringProperty getSubjectProperty() {
        return subjectProperty;
    }

    public IntegerProperty getPagesProperty() {
        return pagesProperty;
    }

    public void updatePaper(Paper item, InputResult result) {
        super.updateItem(item, result);

        String subject = result.getValue(subjectProperty);
        Integer pages = result.getValue(pagesProperty);

        if (subject != null) item.setSubjectArea(subject);
        if (pages != null) item.setPages(pages);
    }
}
