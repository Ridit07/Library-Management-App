package com.example.test3.models;

public class Librarian {

    private String id;
    private String password;
    private String phone_number;
    private String name;

    public  Librarian(String id,String name,String password,String phone_number){
        this.id=id;
        this.name=name;
        this.password=password;
        this.phone_number=phone_number;

    }
    public Librarian(){

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
