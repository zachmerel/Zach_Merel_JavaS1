package com.trilogyed.U1M4SummativeMerelZach.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Objects;

public class Quote {

    private String quote;
    private String author;


    public Quote() {
    }

    public Quote(String quote, String author, int quoteNumber) {
        this.quote = quote;
        this.author = author;

    }

    public Quote(String quote, String author) {
        this.quote = quote;
        this.author = author;
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Quote quote1 = (Quote) o;
        return Objects.equals(quote, quote1.quote) &&
                Objects.equals(author, quote1.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(quote, author);
    }

    @Override
    public String toString() {
        return "Quote{" +
                "quote='" + quote + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
