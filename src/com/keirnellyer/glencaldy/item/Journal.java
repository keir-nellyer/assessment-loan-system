package com.keirnellyer.glencaldy.item;

import java.time.LocalDate;
import java.util.Objects;

public class Journal extends Paper {
    private String issn;
    private int issueNumber;
    private LocalDate issueDate;

    public Journal(int id, String title, String publisher, float cost, String subjectArea, int pages, String issn, int issueNumber, LocalDate issueDate) {
        super(id, title, publisher, cost, subjectArea, pages);
        this.issn = issn;
        this.issueNumber = issueNumber;
        this.issueDate = issueDate;
    }

    public String getIssn() {
        return issn;
    }

    public void setIssn(String issn) {
        this.issn = issn;
    }

    public int getIssueNumber() {
        return issueNumber;
    }

    public void setIssueNumber(int issueNumber) {
        this.issueNumber = issueNumber;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }

    @Override
    public String getStockType() {
        return "Journal";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Journal)) return false;
        if (!super.equals(o)) return false;
        Journal journal = (Journal) o;
        return issueNumber == journal.issueNumber &&
                Objects.equals(issn, journal.issn) &&
                Objects.equals(issueDate, journal.issueDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), issn, issueNumber, issueDate);
    }

    @Override
    public String toString() {
        return "Journal{" +
                "issn='" + issn + '\'' +
                ", issueNumber=" + issueNumber +
                ", issueDate=" + issueDate +
                "} " + super.toString();
    }
}
