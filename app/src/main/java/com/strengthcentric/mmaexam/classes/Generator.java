package com.strengthcentric.mmaexam.classes;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import static com.strengthcentric.mmaexam.questions.Provider.getAllQuestions;

public class Generator {
    public static List<Question> generateQuestions(int n) {
        List<Question> result = new ArrayList<>();

        if (n > getAllQuestions().size()) {
            return result;
        }

        Set<Integer> alreadyIn = new HashSet<>();
        Random rand = new Random();
        int tempRand = 0;

        while(result.size() < n) {
            tempRand = rand.nextInt(getAllQuestions().size());
            if (alreadyIn.contains(tempRand)) {
                continue;
            }

            alreadyIn.add(tempRand);
            result.add(getAllQuestions().get(tempRand));
        }

        for (Question q : result) {
            q.setAnswered(false);
        }

        return result;
    }
}
