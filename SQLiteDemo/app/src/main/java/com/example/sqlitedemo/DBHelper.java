package com.example.sqlitedemo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(@Nullable Context context) {
        super(context, "myDB", null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE Authors(" +
                "id integer primary key," +
                "name text," +
                "address text," +
                "email text"+
                ")");
        db.execSQL("CREATE TABLE Books(" +
                "id integer primary key," +
                "title text," +
                "id_author integer not null " +
                "constraint id_author references Authors(id)"+
                "ON DELETE CASCADE ON UPDATE CASCADE"+
                ")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Books");
        db.execSQL("DROP TABLE IF EXISTS Authors");
        onCreate(db);
    }

    @Override
    public void onConfigure(SQLiteDatabase db) {
        db.setForeignKeyConstraintsEnabled(true);
        super.onConfigure(db);
    }

    //them xoa sua cap nhat
    //THEM mot Author tra ve so Author da them
    public int insertAuthors(Author author){
        // khai bao doi tuong SQLiteDatabase , ContentValues
        SQLiteDatabase db = getWritableDatabase();
        ContentValues content = new ContentValues();
        // put mot Authors vao content
        content.put("id",author.getIdAuthor()+"");
        content.put("name",author.getName());
        content.put("address",author.getAddress());
        content.put("email",author.getEmail());
        // thuc hien cau lenh insert va truyen vao mot content
        int res = (int) db.insert("Authors",null,content);
        // dong database
        db.close();
        return res;
        }
    // SELECT
    public ArrayList<Author> getAllAuthor(){
        ArrayList<Author> list = new ArrayList<>();
        String sql = "select * from Authors";
        // doc du lieu tu database
        SQLiteDatabase db = getReadableDatabase();
        // thuc hien cau lenh
        Cursor cursor = db.rawQuery(sql,null);
        if(cursor != null){
            // di chuyen con tro ve dau
            cursor.moveToFirst();
            while(!cursor.isAfterLast()){
                // them mot author lay tu csdl vao list
                list.add(new Author(cursor.getInt(0)
                        ,cursor.getString(1)
                        ,cursor.getString(2)
                        ,cursor.getString(3)));
                cursor.moveToNext();
            }
            cursor.close();
            db.close();
        }
        return  list;
    }
    //SELECT co dieu kien
    public Author getIdAuthor(int id){
        Author author = null;
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM Authors WHERE id=?",new String[]{id+""});
        if(cursor!=null){
            cursor.moveToFirst();
             author = new Author(cursor.getInt(0)
                    ,cursor.getString(1)
                    ,cursor.getString(2)
                    ,cursor.getString(3));
        }
        cursor.close();
        db.close();
        return author;
    }
    //UPDATE
    public boolean updateAuthor(int id , String name,String address,String email){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues content = new ContentValues();
        // put mot Authors vao content
        content.put("name",name);
        content.put("address",address);
        content.put("email",email);
        long result = db.update("Authors",content,"id=?",new String[]{String.valueOf(id)});
        if(result == -1){
            return  false;
        }else{
            return  true;
        }
    }
    // DELETE
    public void deleteAuthors(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete("Authors", "id= ?", new String[] { String.valueOf(id) });
        db.close();
    }
    // Them - xoa - sua - truy van book
    public int insertBooks(Book book){
        // khai bao doi tuong SQLiteDatabase , ContentValues
        SQLiteDatabase db = getWritableDatabase();
        ContentValues content = new ContentValues();
        // put mot Authors vao content
        content.put("id",book.getId()+"");
        content.put("title",book.getTitle());
        content.put("id_author",book.getId_author()+"");
        // thuc hien cau lenh insert va truyen vao mot content
        int res = (int) db.insert("Books",null,content);
        // dong database
        db.close();
        return res;
    }
    public ArrayList<Book> getAllBook(){
        ArrayList<Book> list = new ArrayList<>();
        String sql = "select * from Books";
        // doc du lieu tu database
        SQLiteDatabase db = getReadableDatabase();
        // thuc hien cau lenh
        Cursor cursor = db.rawQuery(sql,null);
        if(cursor != null){
            // di chuyen con tro ve dau
            cursor.moveToFirst();
            while(!cursor.isAfterLast()){
                // them mot author lay tu csdl vao list
                list.add(new Book(cursor.getInt(0)
                        ,cursor.getString(1)
                        ,cursor.getInt(2)
                        ));
                cursor.moveToNext();
            }
            cursor.close();
            db.close();
        }
        return  list;
    }
    // Truy Van
    public Book getIdBook(int id){
        Book book = null;
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM Books WHERE id=?",new String[]{id+""});
        if(cursor!=null){
            cursor.moveToFirst();
            book = new Book(cursor.getInt(0)
                    ,cursor.getString(1)
                    ,cursor.getInt(2)
                    );
        }
        cursor.close();
        db.close();
        return book;
    }
    //UPDATE
    public boolean updateBook(int id , String title,int id_author){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues content = new ContentValues();
        // put mot Authors vao content
        content.put("title",title);
        content.put("id_author",id_author);
        long result = db.update("Books",content,"id=?",new String[]{String.valueOf(id)});
        if(result == -1){
            return  false;
        }else{
            return  true;
        }
    }
    // DELETE
    public void deleteBooks(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete("Books", "id= ?", new String[] { String.valueOf(id) });
        db.close();
    }
    // Truy Van
    public ArrayList<Book> getAllBookofAuthor(int id){
        ArrayList<Book> list = new ArrayList<>();
        String sql = "select Books.id,Books.title,Books.id_author from Books"+
                "\nINNER JOIN Authors ON Books.id_author = Authors.id"+
                "\nWHERE Authors.id =?";
        // doc du lieu tu database
        SQLiteDatabase db = getReadableDatabase();
        // thuc hien cau lenh
        Cursor cursor = db.rawQuery(sql, new String[] { String.valueOf(id) });
        if(cursor != null){
            // di chuyen con tro ve dau
            cursor.moveToFirst();
            while(!cursor.isAfterLast()){
                // them mot author lay tu csdl vao list
                list.add(new Book(cursor.getInt(0)
                        ,cursor.getString(1)
                        ,cursor.getInt(2)
                ));
                cursor.moveToNext();
            }
            cursor.close();
            db.close();
        }
        return  list;
    }
}
