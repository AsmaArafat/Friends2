package com.example.android.friends2;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.facebook.stetho.Stetho;

import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity  {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Stetho.initializeWithDefaults(this);
        Fragment fragment = PeopleFragment.newInstance("http://demo7261611.mockable.io/people");
        Fragment fragment2 = PeopleFragment.newInstance("http://demo7261611.mockable.io/people2");
        getSupportFragmentManager().beginTransaction().add(R.id.fragment_people1,fragment).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.fragment_people2,fragment2).commit();



    }

    /*@Override
    public void onItemClick(View view, int position) {
        Intent open = new Intent(this, Detailed_Activity.class);
        open.putExtra("key", peopleList.get(position));
        startActivity(open);*/
    }

    //////Async task to avoid mainthread problem


