package com.example.android.friends2.person.presenter;

import android.app.ProgressDialog;
import android.os.AsyncTask;

import com.example.android.friends2.CRUDPerson;
import com.example.android.friends2.PeopleAdapter;
import com.example.android.friends2.Person;
import com.example.android.friends2.PersonDBHelper;
import com.example.android.friends2.person.model.PersonModel;
import com.example.android.friends2.person.view.PersonView;

import java.io.IOException;
import java.net.URL;
import java.util.List;

/**
 * Created by g on 05/05/2018.
 */


public class PersonAsyncTask extends AsyncTask<URL, Void, List<Person>> {

    PersonModel personModel;
    Contract contract;

    public PersonAsyncTask(PersonModel personModel) {
        this.personModel = personModel;
        this.contract=contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    //////
    @Override
    protected void onPreExecute() {
        super.onPreExecute();

    }

    /////do my operation لكن محدش لسة عرف ايه اللي حصل وده اللي هيحصل في ال onpost
    @Override
    protected List<Person> doInBackground(URL... urls) {

        List<Person> result = null;
        try {
            result=  personModel.getPerson(urls[0]);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //  PersonDBHelper personDBHelper = new PersonDBHelper(getContext());

        //    CRUDPerson crudPerson = new CRUDPerson(personDBHelper);

           /* if (result != null) {
                for (int i = 0; i < result.size(); i++) {
                    crudPerson.insert(result.get(i));

                }

            }*/
        return result;
    }

    ////عشان كله يعرف انا عملت ايه

    @Override
    protected void onPostExecute(List<Person> people) {
        super.onPostExecute(people);
        //////fill my list with data cacheted


contract.provideData(people);

    }

    interface Contract {
        void provideData(List<Person> people);

    }
}


