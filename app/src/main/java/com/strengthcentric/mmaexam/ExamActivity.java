package com.strengthcentric.mmaexam;

import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.strengthcentric.mmaexam.classes.Answer;
import com.strengthcentric.mmaexam.classes.Generator;
import com.strengthcentric.mmaexam.classes.Question;
import com.strengthcentric.mmaexam.classes.Round;
import com.strengthcentric.mmaexam.classes.Settings;

public class ExamActivity extends AppCompatActivity {
    Round round;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam);
        round = new Round(Generator.generateQuestions(Settings.QUESTIONS_PER_ROUND));
        createTextViews();
    }

    private void createTextViews() {
        ((LinearLayout)findViewById(R.id.linearLayout)).removeAllViewsInLayout();

        if (round.getNumberOfQuestions() <= round.getCurrentQuestion() + 1) {
            finishRound();
            return;
        }

        updateQuestionCounter();
        showNextQuestion();
    }

    private void finishRound() {
        Intent myIntent = new Intent(this, ShowScoreActivity.class);
        myIntent.putExtra("score", round.getScore());
        this.startActivity(myIntent);
        finish();
    }

    private void showNextQuestion() {
        Question tempQuestion = round.getQuestions().get(round.getCurrentQuestion());
        ((TextView)findViewById(R.id.questionText)).setText(tempQuestion.getText());

        for (Answer answer : tempQuestion.getAnswers()) {
            addAnswer(answer.getText());
        }
    }

    private void updateQuestionCounter() {
        round.setCurrentQuestion(round.getCurrentQuestion() + 1);
        TextView questionCounter = (TextView)findViewById(R.id.questionCounter);
        questionCounter.setText((round.getCurrentQuestion() + 1) + " / " + round.getNumberOfQuestions());
    }

    private void addAnswer(String text) {
        TextView tempTextView = new TextView(this);

        tempTextView.setOnClickListener(listener);
        tempTextView.setTextSize(20);
        tempTextView.setText(text);
        tempTextView.setGravity(Gravity.CENTER);
        tempTextView.setPadding(25, 25, 25, 25);

        LinearLayout linearLayout = (LinearLayout)findViewById(R.id.linearLayout);
        linearLayout.addView(tempTextView);
    }

    View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Question current = round.getQuestions().get(round.getCurrentQuestion());
            if (!current.isAnswered()) {
                current.setAnswered(true);
                TextView tv = (TextView) v;

                if (current.isAnswerCorrect(tv.getText().toString())) {
                    tv.setTextColor(Color.BLUE);
                    round.setScore(round.getScore() + 1);
                } else {
                    tv.setTextColor(Color.RED);
                }

                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    public void run() {
                        createTextViews();
                    }
                }, 500);
            }
        }
    };
}
