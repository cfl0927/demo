package com.jpa.exp3.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @description：
 * @author: chenfl
 * @Date: 2019/11/17 18:55
 */
@Entity
public class Book {
    @Id
    private String bookid;
    private String bookname;
    private Double price;
    private String author;
    private String press;

    @Id
    @Column(name = "bookid")
    public String getBookid() {
        return bookid;
    }

    public void setBookid(String bookid) {
        this.bookid = bookid;
    }

    @Basic
    @Column(name = "bookname")
    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    @Basic
    @Column(name = "price")
    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Basic
    @Column(name = "author")
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Basic
    @Column(name = "press")
    public String getPress() {
        return press;
    }

    public void setPress(String press) {
        this.press = press;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        if (bookid != null ? !bookid.equals(book.bookid) : book.bookid != null) return false;
        if (bookname != null ? !bookname.equals(book.bookname) : book.bookname != null) return false;
        if (price != null ? !price.equals(book.price) : book.price != null) return false;
        if (author != null ? !author.equals(book.author) : book.author != null) return false;
        if (press != null ? !press.equals(book.press) : book.press != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = bookid != null ? bookid.hashCode() : 0;
        result = 31 * result + (bookname != null ? bookname.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (author != null ? author.hashCode() : 0);
        result = 31 * result + (press != null ? press.hashCode() : 0);
        return result;
    }
}
