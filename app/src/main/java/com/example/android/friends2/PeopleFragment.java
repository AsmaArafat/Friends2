package com.example.android.friends2;


import android.app.Dialog;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.friends2.person.model.PersonModel;
import com.example.android.friends2.person.presenter.PeoplePresenter;
import com.example.android.friends2.person.presenter.PersonAsyncTask;
import com.example.android.friends2.person.view.PersonView;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PeopleFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PeopleFragment extends Fragment implements PersonView {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    RecyclerView recyclerView;
    PeopleAdapter adapter;
    //make it to be public for all methods to get index of the current item
    List<Person> peopleList = new ArrayList<>();
    PeoplePresenter peoplePresenter;
    private static final String URL_ARG = "peopleurl";
    private String peopleUrl;
    private ProgressDialog progressDialog;

    public PeopleFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment PeopleFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PeopleFragment newInstance(String peopleurl) {
        PeopleFragment fragment = new PeopleFragment();
        Bundle args = new Bundle();
        args.putString(URL_ARG, peopleurl);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            peopleUrl = getArguments().getString(URL_ARG);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_people, container, false);
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //List<Person> people = new ArrayList<>();
        recyclerView = view.findViewById(R.id.recycler_view);
        // set up the RecyclerView
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        PersonModel personModel = new PersonModel();
        PersonAsyncTask personAsyncTask = new PersonAsyncTask(personModel);
        progressDialog = new ProgressDialog(getContext());
        progressDialog.setTitle("Loading...");
        peoplePresenter = new PeoplePresenter(personModel, personAsyncTask, this);
        peoplePresenter.getPeople(peopleUrl);

    }


    @Override
    public void showData(List<Person> people) {

        peopleList = people;
        adapter = new PeopleAdapter(getContext(), peopleList);
        //adapter.setClickListener(MainActivity.this);
        recyclerView.setAdapter(adapter);
        //Toast.makeText(MainActivity.this, "" + people.size(), Toast.LENGTH_SHORT).show();
        progressDialog.dismiss();

    }

    @Override
    public void showError(String s) {


    }

    @Override
    public void showLoading() {

        if (progressDialog != null)
            progressDialog.show();
    }

    @Override
    public void hideLoading() {
        if (progressDialog != null)
            progressDialog.dismiss();
    }

    @Override
    public void isEmpty() {

    }
}
