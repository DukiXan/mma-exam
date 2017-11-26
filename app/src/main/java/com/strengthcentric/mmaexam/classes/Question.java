package com.strengthcentric.mmaexam.classes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Question {
    private String text;

    private List<Answer> answers;
    private boolean isAnswered;

    public Question(String text, List<Answer> answers) {
        this.text = text;
        this.answers = answers;
        this.isAnswered = false;
    }

    public Question (String question, String... answers) {
        if (answers.length < 2) {
            return;
        }

        this.text = question;
        this.answers = new ArrayList<>();
        this.answers.add(new Answer(answers[0], true));
        this.isAnswered = false;

        for (int i = 1; i < answers.length; i++) {
            this.answers.add(new Answer(answers[i], false));
        }
    }

    public Answer getCorrectAnswer() {
        for (Answer answer : answers) {
            if (answer.isCorrect()) {
                return answer;
            }
        }

        return null;
    }

    public boolean isAnswerCorrect(String answer) {
        Answer correctAnswer = getCorrectAnswer();
        return correctAnswer == null ? false : correctAnswer.getText().equals(answer);
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<Answer> getAnswers() {
        Collections.shuffle(answers);
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    public boolean isAnswered() {
        return isAnswered;
    }

    public void setAnswered(boolean answered) {
        isAnswered = answered;
    }
}
