package com.keirnellyer.glencaldy.manipulation.stock;

import com.keirnellyer.glencaldy.item.Book;
import com.keirnellyer.glencaldy.manipulation.property.InputResult;
import com.keirnellyer.glencaldy.manipulation.property.type.StringProperty;

public class BookProperties extends PaperProperties {
    private final StringProperty isbnProperty = new StringProperty("Please enter the ISBN number.");
    private final StringProperty authorProperty = new StringProperty("Please enter the author.");

    public BookProperties() {
        super();

        addProperty(isbnProperty);
        addProperty(authorProperty);
    }

    public StringProperty getIsbnProperty() {
        return isbnProperty;
    }

    public StringProperty getAuthorProperty() {
        return authorProperty;
    }

    public Book createBook(InputResult result) {
        Integer id = result.getValue(getIdProperty());
        String title = result.getValue(getTitleProperty());
        String publisher = result.getValue(getPublisherProperty());
        Float cost = result.getValue(getCostProperty());
        String subject = result.getValue(getSubjectProperty());
        Integer pages = result.getValue(getPagesProperty());
        String isbn = result.getValue(getIsbnProperty());
        String author = result.getValue(getAuthorProperty());
        return new Book(id, title, publisher, cost, subject, pages, isbn, author);
    }

    public void updateBook(Book book, InputResult result) {
        super.updatePaper(book, result);

        String isbn = result.getValue(isbnProperty);
        String author = result.getValue(authorProperty);

        if (isbn != null) book.setIsbn(isbn);
        if (author != null) book.setAuthor(author);
    }
}
