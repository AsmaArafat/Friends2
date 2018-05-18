package com.example.android.friends2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Toast;

/**
 * Created by g on 24/03/2018.
 */

public class Detailed_Activity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Person person = (Person) getIntent().getSerializableExtra("key");

        Toast.makeText(this, person.getName() + " " +person.getAge() + " " +person.getMail(), Toast.LENGTH_SHORT).show();
    }
}
