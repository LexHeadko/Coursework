package com.example.coursework.utils;


import com.thedeanda.lorem.LoremIpsum;
import com.example.coursework.question.Question;

import java.util.HashSet;
import java.util.Random;

public class Randoms {

    public static String randomPhrase(int origin, int bound) {
        return new LoremIpsum().getWords(origin, bound);
    }

    public static int randomInt(int origin, int bound) {
        return new Random().nextInt(origin, bound);
    }

    public static HashSet<Question> randomQuestionSet(int numberOfQuestions) {
        HashSet<Question> questionSet = new HashSet<>(numberOfQuestions);
        for (int i = 0; i < numberOfQuestions; i++) {
            questionSet.add(randomQuestion());
        }
        return questionSet;
    }

    public static HashSet<Question> dummyQuestionSet(int numberOfQuestions, String topic) {

        HashSet<Question> questionSet = new HashSet<>(numberOfQuestions);
        for (int i = 1; i <= numberOfQuestions; i++) {
            questionSet.add(new Question(topic + " Dummy Question #" + i, "Dummy Answer #" + i));
        }
        return questionSet;
    }

    public static Question randomQuestion() {
        return new Question(randomPhrase(3, 5) + "?", randomPhrase(5, 15));
    }
}