package com.example.headfirst.observer.view;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.headfirst.R;

public class ActivityCustomObserver extends AppCompatActivity {

    public static Intent getIntent(Context context) {
        Intent intent = new Intent(context, ActivityCustomObserver.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_observer);
    }
}
