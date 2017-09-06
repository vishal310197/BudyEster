package com.google.budyester.com.google.budyester.toolbox;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.TableLayout;

/**
 * Created by Ideapad on 06-08-2017.
 */

public class StorageManipulator extends SQLiteOpenHelper {

    public static final String Database_name = "BudyEster.db";
    public static final int Database_version = 1;
    public static final String Id = "id";
    public static final String Table_name_message = "table_message";
    public static final String Message_recievr = "reciever";
    public static final String Message_sender = "sender";
    public static final String Message_message = "message";


    public static final String table_message_create = " CREATE TABLE " + Table_name_message + " ( " + Id + " INTEGER PRIMARY KEY AUTOINCREMENT, " + Message_recievr + " VARCHAR(25), " + Message_sender + " VARCHAR(25) " ;

    public static final String Table_message_drop = " DROP TABLE IF EXISTS " + Table_name_message;

    public StorageManipulator(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(table_message_create);
    }

    public void insert(String sender,String reciever,String message)
    {
        long rowId;
        try{
            SQLiteDatabase db = getWritableDatabase(); //open db and insert sending
            ContentValues contentValues = new ContentValues();
            contentValues.put(Message_recievr,reciever);
            contentValues.put(Message_sender,sender);
            contentValues.put(Message_message,message);
            rowId = db.insert(Table_name_message,null,contentValues);
//for selct row, we use cursor
    }catch(Exception e){}}

        public Cursor get(String sender,String reciever){
        SQLiteDatabase db = getWritableDatabase();
        //Like searches pattern
        String selectQuery = " SELECT * FROM " + Table_name_message + " LIKE " + sender + " AND " + Message_recievr + " LIKE " + reciever + " ORDER BY " + Id + " ASC " ;
        return null;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
          db.execSQL(Table_message_drop);
    }
}
