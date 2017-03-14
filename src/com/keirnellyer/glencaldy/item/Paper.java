package com.keirnellyer.glencaldy.item;

import java.util.Objects;

public abstract class Paper extends Item {
    private String subjectArea;
    private int pages;

    public Paper(int id, String title, String publisher, float cost, String subjectArea, int pages) {
        super(id, title, publisher, cost);
        this.subjectArea = subjectArea;
        this.pages = pages;
    }

    public String getSubjectArea() {
        return subjectArea;
    }

    public void setSubjectArea(String subjectArea) {
        this.subjectArea = subjectArea;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    @Override
    public String getStockType() {
        return "Paper-based";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Paper)) return false;
        if (!super.equals(o)) return false;
        Paper paper = (Paper) o;
        return pages == paper.pages &&
                Objects.equals(subjectArea, paper.subjectArea);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), subjectArea, pages);
    }

    @Override
    public String toString() {
        return "Paper{" +
                "subjectArea='" + subjectArea + '\'' +
                ", pages=" + pages +
                "} " + super.toString();
    }
}
