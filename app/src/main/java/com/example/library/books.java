package com.example.library;

public class books {
    String id;
    String name;
    String author;
    String year;



    public books(String id, String name, String author, String year) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.year = year;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }


}

