package com.example.android.friends2.person.presenter;

import android.content.Context;
import android.widget.Toast;

import com.example.android.friends2.Person;
import com.example.android.friends2.person.model.NetworkManager;
import com.example.android.friends2.person.model.ParserPerson;
import com.example.android.friends2.person.model.PersonModel;
import com.example.android.friends2.person.view.PersonView;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

/**
 * Created by g on 05/05/2018.
 */

public class PeoplePresenter implements PersonAsyncTask.Contract {
    PersonModel personModel;
    PersonView personView;
    PersonAsyncTask personAsyncTask;

    public PeoplePresenter(PersonModel personModel, PersonAsyncTask personAsyncTask, PersonView personView) {
    this.personModel = personModel;
    this.personView= personView;
    this.personAsyncTask = personAsyncTask;
    this.personAsyncTask.setContract(this);

    }

    public void getPeople(String url){
        try {
            URL dataURL = new URL(url);
            personAsyncTask.execute(dataURL);

        } catch (MalformedURLException e) {
            e.printStackTrace();
            personView.showError(e.getLocalizedMessage());
        }
    }

    @Override
    public void provideData(List<Person> people) {
        if(people==null|| people.isEmpty()){
personView.isEmpty();
        }else{
            personView.showData(people);
        }
    }
}
