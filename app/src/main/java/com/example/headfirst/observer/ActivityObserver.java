package com.example.headfirst.observer;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.headfirst.R;
import com.example.headfirst.observer.view.ActivityCustomObserver;

public class ActivityObserver extends AppCompatActivity {

    public static Intent getIntent(Context context) {
        Intent intent = new Intent(context, ActivityObserver.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DataBindingUtil.setContentView(this, R.layout.activity_observer);
    }

    public void toCustomObserver(View view) {
        startActivity(ActivityCustomObserver.getIntent(this));
    }

}
