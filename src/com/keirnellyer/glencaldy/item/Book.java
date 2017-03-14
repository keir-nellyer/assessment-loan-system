package com.keirnellyer.glencaldy.item;

import java.util.Objects;

public class Book extends Paper {
    private String isbn;
    private String author;

    public Book(int id, String title, String publisher, float cost, String subjectArea, int pages, String isbn, String author) {
        super(id, title, publisher, cost, subjectArea, pages);
        this.isbn = isbn;
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String getStockType() {
        return "Book";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;
        if (!super.equals(o)) return false;
        Book book = (Book) o;
        return Objects.equals(isbn, book.isbn) &&
                Objects.equals(author, book.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), isbn, author);
    }

    @Override
    public String toString() {
        return "Book{" +
                "isbn='" + isbn + '\'' +
                ", author='" + author + '\'' +
                "} " + super.toString();
    }
}
