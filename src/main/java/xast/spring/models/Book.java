package xast.spring.models;

import javax.validation.constraints.*;

public class Book {
    private int id;

    @NotEmpty(message = "Name of the book shouldn't be empty!")
    @Size(min = 1, max = 100, message = "1 < size < 100")
    private String name;

    @NotEmpty(message = "Author of the book shouldn't be empty!")
    @Size(min = 1, max = 100, message = "1 < size < 100")
    private String author;

    @Min(value = 0, message = "Incorrect year!")
    private int year;

    public Book(){}

    public Book(String name, String author, int year) {
        this.name = name;
        this.author = author;
        this.year = year;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

}
