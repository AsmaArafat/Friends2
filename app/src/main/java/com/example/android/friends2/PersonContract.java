package com.example.android.friends2;

import android.provider.BaseColumns;

/**
 * Created by g on 30/03/2018.
 */

public class PersonContract  {
    private PersonContract(){

    }

    public class PersonEntity implements BaseColumns{
        public static final String TABLE_NAME = "people";
        public static final String NAME = "name";
        public static final String AGE = "AGE";
        public static final String HEIGHT = "height";
    }
}
