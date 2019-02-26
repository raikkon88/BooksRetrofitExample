package com.mspifarre.books.model;

import java.util.Date;

public class Book {

    private String isbn;
    private String name;
    private Date publishedAt;

    public Book(){

    }


    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(Date publishedAt) {
        this.publishedAt = publishedAt;
    }


    @Override
    public String toString() {
        return isbn + " : " + name + " : " + publishedAt.toString();
    }
}
