package com.example.android.friends2.person.model;

import com.example.android.friends2.Person;

import java.io.IOException;
import java.net.URL;
import java.util.List;

/**
 * Created by g on 05/05/2018.
 */

public class PersonModel extends NetworkManager {

    public List<Person> getPerson(URL url) throws IOException {
        return ParserPerson.readPeopleArray(loadData(url));
    }
}
