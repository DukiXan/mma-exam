package com.strengthcentric.mmaexam.classes;

import java.util.List;

public class Round {
    private int numberOfQuestions;
    private int score;
    private List<Question> questions;
    private int currentQuestion;

    public Round(List<Question> questions) {
        this.questions = questions;
        this.numberOfQuestions = questions.size();
        this.score = 0;
        this.currentQuestion = -1;
    }

    public int getCurrentQuestion() {
        return currentQuestion;
    }

    public void setCurrentQuestion(int currentQuestion) {
        this.currentQuestion = currentQuestion;
    }

    public int getNumberOfQuestions() {
        return numberOfQuestions;
    }

    public void setNumberOfQuestions(int numberOfQuestions) {
        this.numberOfQuestions = numberOfQuestions;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }
}
