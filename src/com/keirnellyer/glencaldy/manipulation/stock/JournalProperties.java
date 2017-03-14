package com.keirnellyer.glencaldy.manipulation.stock;

import com.keirnellyer.glencaldy.item.Journal;
import com.keirnellyer.glencaldy.manipulation.property.InputResult;
import com.keirnellyer.glencaldy.manipulation.property.type.IntegerProperty;
import com.keirnellyer.glencaldy.manipulation.property.type.LocalDateProperty;
import com.keirnellyer.glencaldy.manipulation.property.type.StringProperty;

import java.time.LocalDate;

public class JournalProperties extends PaperProperties {
    private final StringProperty issnProperty = new StringProperty("Please enter the ISSN number.");
    private final IntegerProperty issueNumberProperty = new IntegerProperty("Please enter the issue number.");
    private final LocalDateProperty issueDateProperty = new LocalDateProperty("Please enter the issue date.");

    public JournalProperties() {
        super();

        addProperty(issnProperty);
        addProperty(issueNumberProperty);
        addProperty(issueDateProperty);
    }

    public StringProperty getIssnProperty() {
        return issnProperty;
    }

    public IntegerProperty getIssueNumberProperty() {
        return issueNumberProperty;
    }

    public LocalDateProperty getIssueDateProperty() {
        return issueDateProperty;
    }

    public Journal createJournal(InputResult result) {
        Integer id = result.getValue(getIdProperty());
        String title = result.getValue(getTitleProperty());
        String publisher = result.getValue(getPublisherProperty());
        Float cost = result.getValue(getCostProperty());
        String subject = result.getValue(getSubjectProperty());
        Integer pages = result.getValue(getPagesProperty());
        String issn = result.getValue(getIssnProperty());
        Integer issueNumber = result.getValue(getIssueNumberProperty());
        LocalDate issueDate = result.getValue(getIssueDateProperty());
        return new Journal(id, title, publisher, cost, subject, pages, issn, issueNumber, issueDate);
    }

    public void updateJournal(Journal journal, InputResult result) {
        super.updatePaper(journal, result);

        String issn = result.getValue(issnProperty);
        Integer issueNumber = result.getValue(issueNumberProperty);
        LocalDate issueDate = result.getValue(issueDateProperty);

        if (issn != null) journal.setIssn(issn);
        if (issueNumber != null) journal.setIssueNumber(issueNumber);
        if (issueDate != null) journal.setIssueDate(issueDate);
    }
}
