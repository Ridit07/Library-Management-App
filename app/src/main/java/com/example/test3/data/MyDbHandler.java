package com.example.test3.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.test3.models.Book;
import com.example.test3.models.Issue;
import com.example.test3.models.Librarian;
import com.example.test3.params.Params;

import java.util.ArrayList;
import java.util.List;

public class MyDbHandler extends SQLiteOpenHelper {

    public MyDbHandler( Context context){
        super(context, Params.DB_NAME, null , Params.DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
String create="CREATE TABLE "+ Params.TABLE_NAME +"(" +Params.LIB_ID +" TEXT PRIMARY KEY, "+Params.LIB_PASSWORD
        +" TEXT, "+ Params.LIB_NAME+ " TEXT, "+Params.LIB_PHONE+" TEXT "+" )";
Log.d("ridit","hogya");
db.execSQL(create);

        String create2="CREATE TABLE "+ Params.TABLE_NAME2 +"(" +Params.BOOK_ID +" TEXT PRIMARY KEY, "+Params.BOOK_NAME
                +" TEXT, "+ Params.BOOK_AUTHOR+ " TEXT, "+Params.BOOK_QUANTITY+" TEXT "+" )";
        Log.d("riditGREAT","hogya2TABLE");
        db.execSQL(create2);

        String create3="CREATE TABLE "+ Params.TABLE_NAME3 +"(" +Params.ISSUEBOOK_ID +" TEXT PRIMARY KEY, "+Params.ISSUESTUDENTID
                +" TEXT, "+ Params.ISSUESTUDENTNAME+ " TEXT, "+Params.ISSUECONTACT+" TEXT "+" )";
        Log.d("riditGREAT","hogya3TABLE");
        db.execSQL(create3);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
    }


    public  Boolean checkusernamepass(String username,String password){
        SQLiteDatabase MyDB=this.getWritableDatabase();
        Cursor cursor=MyDB.rawQuery("SELECT * FROM "+ Params.TABLE_NAME+" where "+Params.LIB_ID+" = ? "+
                " and "+Params.LIB_PASSWORD+" = ?",new String[]{username,password});
        if(cursor.getCount()>0){
            return true;
        }
        else {
            return false;
        }
    }



    //librarian

    //adding values default
    public void addlibrarian(Librarian librarian){
SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(Params.LIB_ID,librarian.getId());
        values.put(Params.LIB_PASSWORD,librarian.getPassword());
        values.put(Params.LIB_NAME,librarian.getName());
        values.put(Params.LIB_PHONE,librarian.getPhone_number() );
        db.insert(Params.TABLE_NAME,null,values);
        Log.d("ridit","hogyapart2");
        db.close();
    }

    //adding values by user
    public Boolean insertdata(String id, String password, String name, String contact){
        SQLiteDatabase MyDB= this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(Params.LIB_ID,id);
        contentValues.put(Params.LIB_NAME,name);
        contentValues.put(Params.LIB_PASSWORD,password);
        contentValues.put(Params.LIB_PHONE,contact);
     long result=   MyDB.insert(Params.TABLE_NAME,null,contentValues);
        if(result==-1){
            return false;
        }
        else{
            return true;
        }
    }

    //view all contacts
    public List<Librarian> getAllContacts() {
        List<Librarian> librarianslist = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        String select = "SELECT * FROM " + Params.TABLE_NAME;
        Cursor cursor = db.rawQuery(select, null);
        if(cursor.moveToFirst()){
            do{
                Librarian librarian = new Librarian();
                librarian.setId(cursor.getString(0));
                librarian.setName(cursor.getString(1));
                librarian.setPassword(cursor.getString(2));
                librarian.setPhone_number(cursor.getString(3));
                librarianslist.add(librarian);
            }while(cursor.moveToNext());
        }
        return librarianslist;

    }

    //delete contacts
    public void deleteContactById(String id){
// in the below line of code we have created an object of  writable.
        SQLiteDatabase db = this.getWritableDatabase();
//the code written in the below line will actually  delete the contact from the database
        db.delete(Params.TABLE_NAME, Params.LIB_ID +"=?", new String[]{String.valueOf(id)});
//after deleting the contact we wil close the database.
        db.close();
    }







//book

    public Boolean insertBook(String id1, String name12, String auther1, String quantity1){
        SQLiteDatabase MyDB2= this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(Params.BOOK_ID,id1);
        contentValues.put(Params.BOOK_NAME,name12);
        contentValues.put(Params.BOOK_AUTHOR,auther1);
        contentValues.put(Params.BOOK_QUANTITY,quantity1);
        long result=   MyDB2.insert(Params.TABLE_NAME2,null,contentValues);
        if(result==-1){
            return false;
        }
        else{
            return true;
        }
    }

    public void addbook(Book book){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(Params.BOOK_ID,book.getId());
        values.put(Params.BOOK_NAME,book.getName());
        values.put(Params.BOOK_AUTHOR,book.getAuthor());
        values.put(Params.BOOK_QUANTITY,book.getQuantity() );
        db.insert(Params.TABLE_NAME2,null,values);
        Log.d("ridit","hogyapart2");
        db.close();
    }


    public List<Book> getallbooks() {

        List<Book> bookList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        String select = "SELECT * FROM " + Params.TABLE_NAME2;
        Cursor cursor = db.rawQuery(select, null);
        if(cursor.moveToFirst()){
            do{
                Book book = new Book();
                book.setId(cursor.getString(0));
                book.setName(cursor.getString(1));
                book.setAuthor(cursor.getString(2));
                book.setQuantity(cursor.getString(3));
                bookList.add(book);
            }while(cursor.moveToNext());
        }
        return bookList;

    }

    public void deleteBookById(String id){
// in the below line of code we have created an object of  writable.
        SQLiteDatabase db = this.getWritableDatabase();
//the code written in the below line will actually  delete the contact from the database
        db.delete(Params.TABLE_NAME2, Params.BOOK_ID +"=?", new String[]{String.valueOf(id)});
//after deleting the contact we wil close the database.
        db.close();
    }







//issue book

    public Boolean checkbookid(String bookid){
        SQLiteDatabase MyDB=this.getWritableDatabase();
        Cursor cursor=MyDB.rawQuery("SELECT * FROM "+ Params.TABLE_NAME2+" where "+Params.BOOK_ID+" = ? "
                ,new String[]{bookid});
        if(cursor.getCount()>0){
            return true;
        }
        else {
            return false;
        }

    }


    public Boolean insertdata2(String id, String sname, String sid, String scontact){
        SQLiteDatabase MyDB= this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(Params.ISSUEBOOK_ID,id);
        contentValues.put(Params.ISSUESTUDENTNAME,sname);
        contentValues.put(Params.ISSUESTUDENTID,sid);
        contentValues.put(Params.ISSUECONTACT,scontact);
        long result=   MyDB.insert(Params.TABLE_NAME3,null,contentValues);
        if(result==-1){
            return false;
        }
        else{
            return true;
        }
    }




    public List<Issue> getallissuebooks() {

        List<Issue> issuebookList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        String select = "SELECT * FROM " + Params.TABLE_NAME3;
        Cursor cursor = db.rawQuery(select, null);
        if(cursor.moveToFirst()){
            do{
                Issue issue = new Issue();
                issue.setBookid(cursor.getString(0));
                issue.setStudentidname(cursor.getString(1));
                issue.setStudentidname(cursor.getString(2));
                issue.setStudentcontact(cursor.getString(3));
                issuebookList.add(issue);
            }while(cursor.moveToNext());
        }
        return issuebookList;

    }

    public void deleteissueBookById(String id){
// in the below line of code we have created an object of  writable.
        SQLiteDatabase db = this.getWritableDatabase();
//the code written in the below line will actually  delete the contact from the database
        db.delete(Params.TABLE_NAME3, Params.ISSUEBOOK_ID +"=?", new String[]{String.valueOf(id)});
//after deleting the contact we wil close the database.
        db.close();
    }


}




