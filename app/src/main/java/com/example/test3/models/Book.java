package com.example.test3.models;

public class Book {


    private String id;
    private String quantity;
    private String author;
    private String name;

    public  Book(String id,String name,String author,String quantity){
        this.id=id;
        this.name=name;
        this.author=author;
        this.quantity=quantity;

    }
    public Book(){

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
