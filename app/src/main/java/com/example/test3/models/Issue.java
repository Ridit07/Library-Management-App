package com.example.test3.models;

public class Issue {

    private String bookid;
    private String studentid;
    private String studentidname;
    private String studentcontact;

    public  Issue(String bookid,String studentid,String studentidname,String studentcontact){
        this.bookid=bookid;
        this.studentid=studentid;
        this.studentidname=studentidname;
        this.studentcontact=studentcontact;

    }
    public  Issue(){

    }

    public String getBookid() {
        return bookid;
    }

    public void setBookid(String bookid) {
        this.bookid = bookid;
    }

    public String getStudentid() {
        return studentid;
    }

    public void setStudentid(String studentid) {
        this.studentid = studentid;
    }

    public String getStudentidname() {
        return studentidname;
    }

    public void setStudentidname(String studentidname) {
        this.studentidname = studentidname;
    }

    public String getStudentcontact() {
        return studentcontact;
    }

    public void setStudentcontact(String studentcontact) {
        this.studentcontact = studentcontact;
    }
}
