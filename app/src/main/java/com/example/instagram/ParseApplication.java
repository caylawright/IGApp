package com.example.instagram;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseObject;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseUser;
public class ParseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        //Register your parse models
        ParseObject.registerSubclass(Post.class);

        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("6pLUvLbccOseJKfCgTeOQNbGJdWXMhzqYZxoLzPV")
                .clientKey("dpKYkuqb7YHcXNn7fIivUqaqYvO7W9R3I4exdTcB")
                .server("https://parseapi-cayla.herokuapp.com/parse")
                .build()
        );
    }
}

