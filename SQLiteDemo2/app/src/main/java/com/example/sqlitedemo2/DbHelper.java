package com.example.sqlitedemo2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DbHelper extends SQLiteOpenHelper {
    public DbHelper(@Nullable Context context) {
        super(context, "myDB2", null, 1);

    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE Department("+
                "id integer primary key,"+
                "name varchar(100),"+
                "location varchar(100)"+
                ")");
        db.execSQL("CREATE TABLE Employee("+
                "id integer primary key,"+
                "name varchar(100),"+
                "address varchar(100),"+
                "deptId integer not null "+
                "constraint deptId references Department(id)"+
                "ON DELETE CASCADE ON UPDATE CASCADE"+
                ")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Employee");
        db.execSQL("DROP TABLE IF EXISTS Department");
        onCreate(db);
    }

    @Override
    public void onConfigure(SQLiteDatabase db) {
        db.setForeignKeyConstraintsEnabled(true);
        super.onConfigure(db);
    }
    public int insertDepartment(Department department){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("id",department.getId());
        values.put("name",department.getName());
        values.put("location",department.getLocation());

        int res = (int)db.insert("Department",null,values);
        db.close();
        return  res;
    }
    public ArrayList<Department> getAllDepartment(){
        ArrayList<Department> list = new ArrayList<>();
        String sql = "SELECT * FROM Department";
        SQLiteDatabase db = getReadableDatabase();

        Cursor cursor = db.rawQuery(sql,null);
        if(cursor!=null){
            cursor.moveToFirst();
            while(!cursor.isAfterLast()){
                // them mot author lay tu csdl vao list
                list.add(new Department(cursor.getInt(0)
                        ,cursor.getString(1)
                        ,cursor.getString(2)
                        ));
                cursor.moveToNext();
            }
            cursor.close();
            db.close();
        }
        return  list;
    }
    public Department getIdDepartment(int id){
        Department department = null;
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM Department WHERE id=?",new String[]{id+""});
        if(cursor!=null){
            cursor.moveToFirst();
            department = new Department(cursor.getInt(0)
                    ,cursor.getString(1)
                    ,cursor.getString(2));
        }
        cursor.close();
        db.close();
        return department;
    }
    public boolean updateDepartment(int id ,String name , String location){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues content = new ContentValues();
        content.put("name",name);
        content.put("location",location);
        long result =db.update("Department",content,"id=?",new String[]{String.valueOf(id)});
        if(result == -1){
            return  false;
        }else{
            return  true;
        }
    }
    public void deleteDepartment(int id){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete("Department", "id= ?", new String[] { String.valueOf(id) });
        db.close();
    }
    public int insertEmployee(Employee employee){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("id",employee.getId());
        values.put("name",employee.getName());
        values.put("address",employee.getAddress());
        values.put("deptId",employee.getDeptId());

        int res = (int)db.insert("Employee",null,values);
        db.close();
        return  res;
    }
    public ArrayList<Employee> getAllEmployees(){
        ArrayList<Employee> list = new ArrayList<>();
        String sql = "SELECT * FROM Employee";
        SQLiteDatabase db = getReadableDatabase();

        Cursor cursor = db.rawQuery(sql,null);
        if(cursor!=null){
            cursor.moveToFirst();
            while(!cursor.isAfterLast()){
                // them mot author lay tu csdl vao list
                list.add(new Employee(cursor.getInt(0)
                        ,cursor.getString(1)
                        ,cursor.getString(2)
                        ,cursor.getInt(3)
                ));
                cursor.moveToNext();
            }
            cursor.close();
            db.close();
        }
        return  list;
    }
}
