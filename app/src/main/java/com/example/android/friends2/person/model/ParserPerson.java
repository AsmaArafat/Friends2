package com.example.android.friends2.person.model;

import android.util.JsonReader;

import com.example.android.friends2.Person;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by g on 05/05/2018.
 */

public class ParserPerson {
    //////parcable return list of users
    public static List<Person> readPeopleArray (JsonReader reader) throws IOException {
        List<Person> person = new ArrayList<Person>();
        reader.beginArray();
        while (reader.hasNext()){
            person.add(readPerson(reader));
        }
        reader.endArray();
        return person;
    }
    /////for only one person for each
    public static Person readPerson (JsonReader reader) throws IOException{
        Person person = new Person();
        reader.beginObject();
        while (reader.hasNext()){
            String name = reader.nextName();
            if(name.equals("name")){
                person.setName(reader.nextString());
            }
            else if (name.equals("age")){
                person.setAge(reader.nextInt());
            }else if (name.equals("height")){
                person.setMail(reader.nextString());
            }

        }
        reader.endObject();
        return person;
    }
}
