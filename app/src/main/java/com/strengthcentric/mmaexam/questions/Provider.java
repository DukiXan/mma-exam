package com.strengthcentric.mmaexam.questions;

import com.strengthcentric.mmaexam.classes.Question;

import java.util.ArrayList;
import java.util.List;

public class Provider {

    private static List<Question> allQuestions;

    private Provider() {

    }

    public static List<Question> getAllQuestions() {
        if (allQuestions != null) {
            return allQuestions;
        }

        allQuestions = new ArrayList<>();
        allQuestions.add(new Question(
                "Question 1",
                "Right Answer",
                "Wrong Answer",
                "Wrong Answer",
                "Wrong Answer"));

        allQuestions.add(new Question(
                "Question 2",
                "Right Answer",
                "Wrong Answer",
                "Wrong Answer"));

        allQuestions.add(new Question(
                "Question 3",
                "Right Answer",
                "Wrong Answer"));

        allQuestions.add(new Question(
                "Question 4",
                "Right Answer",
                "Wrong Answer",
                "Wrong Answer",
                "Wrong Answer"));

        allQuestions.add(new Question(
                "Question 5",
                "Right Answer",
                "Wrong Answer",
                "Wrong Answer",
                "Wrong Answer"));

        allQuestions.add(new Question(
                "Question 6",
                "Right Answer",
                "Wrong Answer",
                "Wrong Answer",
                "Wrong Answer"));

        allQuestions.add(new Question(
                "Question 1",
                "Right Answer",
                "Wrong Answer"));

        allQuestions.add(new Question(
                "Question 7",
                "Right Answer",
                "Wrong Answer",
                "Wrong Answer",
                "Wrong Answer"));

        allQuestions.add(new Question(
                "Question 8",
                "Right Answer",
                "Wrong Answer",
                "Wrong Answer"));

        allQuestions.add(new Question(
                "Question 9",
                "Right Answer",
                "Wrong Answer",
                "Wrong Answer",
                "Wrong Answer"));

        allQuestions.add(new Question(
                "Question 10",
                "Right Answer",
                "Wrong Answer"));

        return allQuestions;
    }
}
