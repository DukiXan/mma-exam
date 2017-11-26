package com.strengthcentric.mmaexam;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.strengthcentric.mmaexam.classes.ActivityUtils;
import com.strengthcentric.mmaexam.classes.Settings;

public class HomeActivity extends AppCompatActivity {
    ActivityUtils utils;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        utils = new ActivityUtils(this);
    }

    public void startGame(View v) {
        Intent myIntent = new Intent(this, ExamActivity.class);
        this.startActivity(myIntent);
    }

    public void endGame(View v) {
        this.finish();
    }

    public void sendMail(View v) {
        utils.sendMail();
    }

    public void rate(View v) {
        utils.rate();
    }
}
