package com.example.android.friends2;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by g on 30/03/2018.
 */

public class CRUDPerson {
    private PersonDBHelper personDBHelper;

    public CRUDPerson(PersonDBHelper personDBHelper) {

        this.personDBHelper = personDBHelper;
    }


    public void insert(Person person) {
        SQLiteDatabase db = personDBHelper.getWritableDatabase();
        // Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(PersonContract.PersonEntity.NAME, person.getName());
        values.put(PersonContract.PersonEntity.AGE, person.getAge());
        values.put(PersonContract.PersonEntity.HEIGHT, person.getMail());
        //Insert the new row, returning the primary key value of the new row
        db.insert(PersonContract.PersonEntity.TABLE_NAME, null, values);
    }

    public List<Person> read() {

        SQLiteDatabase db = personDBHelper.getReadableDatabase();
        String[] projection = {
                BaseColumns._ID,
                PersonContract.PersonEntity.NAME,
                PersonContract.PersonEntity.AGE,
                PersonContract.PersonEntity.HEIGHT,

        };
        // How you want the results sorted in the resulting Cursor
        String sortOrder =
                PersonContract.PersonEntity.NAME + " DESC";

        Cursor cursor = db.query(
                PersonContract.PersonEntity.TABLE_NAME,   // The table to query
                projection,             // The array of columns to return (pass null to get all)
                null,              // The columns for the WHERE clause
                null,          // The values for the WHERE clause
                null,                   // don't group the rows
                null,                   // don't filter by row groups
                sortOrder               // The sort order
        );
        List<Person> people = new ArrayList<>();
        while (cursor.moveToNext()) {

            int nameIndex = cursor.getColumnIndexOrThrow(PersonContract.PersonEntity.NAME);
            String name = cursor.getString(nameIndex);
            int ageIndex = cursor.getColumnIndexOrThrow(PersonContract.PersonEntity.AGE);
            int age = cursor.getInt(ageIndex);
            int hightIndex = cursor.getColumnIndexOrThrow(PersonContract.PersonEntity.HEIGHT);
            String hieght = cursor.getString(hightIndex);
            Person person = new Person(name, age, "");
            people.add(person);
        }
        cursor.close();
        return people;
    }

}
