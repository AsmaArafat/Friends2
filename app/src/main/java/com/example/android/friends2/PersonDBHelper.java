package com.example.android.friends2;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by g on 30/03/2018.
 */

public  class PersonDBHelper extends SQLiteOpenHelper {
    public static String DATA_BASE_NAME = "person.db";
    public static int data_base_version = 3;
    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + PersonContract.PersonEntity.TABLE_NAME + " (" +
                    PersonContract.PersonEntity._ID + " INTEGER PRIMARY KEY," +
                    PersonContract.PersonEntity.NAME + " TEXT," +
                    PersonContract.PersonEntity.AGE + " TEXT," +
                      PersonContract.PersonEntity.HEIGHT + " TEXT)";
    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + PersonContract.PersonEntity.TABLE_NAME;

    public PersonDBHelper(Context context ) {
        super(context, DATA_BASE_NAME, null, data_base_version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);

    }
}
