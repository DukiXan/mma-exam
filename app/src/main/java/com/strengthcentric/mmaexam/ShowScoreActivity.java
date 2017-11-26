package com.strengthcentric.mmaexam;

import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.strengthcentric.mmaexam.classes.ActivityUtils;
import com.strengthcentric.mmaexam.classes.Settings;

import de.hdodenhof.circleimageview.CircleImageView;

public class ShowScoreActivity extends AppCompatActivity {
    ActivityUtils utils;
    int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_score);

        utils = new ActivityUtils(this);

        score = getIntent().getExtras().getInt("score");
        int result = Math.round(((float)score / Settings.QUESTIONS_PER_ROUND) * 100);

        TextView showScoreNumber = (TextView)findViewById(R.id.score);
        TextView showScoreMessage = (TextView)findViewById(R.id.score_message);
        CircleImageView image = (CircleImageView)findViewById(R.id.score_image);

        showScoreNumber.setText(score + " / " + Settings.QUESTIONS_PER_ROUND);

        if (result <= 50) {
            showScoreMessage.setText(Settings.MSG_0);
            image.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.z0));
        } else if (result <= 60) {
            showScoreMessage.setText(Settings.MSG_1);
            image.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.z1));
        } else if (result <= 70) {
            showScoreMessage.setText(Settings.MSG_2);
            image.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.z2));
        } else if (result <= 80) {
            showScoreMessage.setText(Settings.MSG_3);
            image.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.z3));
        } else if (result <= 90){
            showScoreMessage.setText(Settings.MSG_4);
            image.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.z4));
        } else {
            showScoreMessage.setText(Settings.MSG_5);
            image.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.z5));
        }
    }

    public void launchRound(View v) {
        Intent myIntent = new Intent(this, ExamActivity.class);
        this.startActivity(myIntent);
        this.finish();
    }

    public void shareTwitter(View v) {
        utils.shareResult(score, Settings.PACKAGE_TWITTER);
    }

    public void shareFacebook(View v) {
        utils.shareResult(score, Settings.PACKAGE_FACEBOOK);
    }

    public void rate(View v) {
        utils.rate();
    }
}
