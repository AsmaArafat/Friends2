package com.example.android.friends2.person.view;

import com.example.android.friends2.Person;

import java.util.List;

/**
 * Created by g on 05/05/2018.
 */

public interface PersonView {
    void showData(List<Person> people);

    void showError(String s);

    void showLoading();

    void hideLoading();

    void isEmpty();
}
