package com.example.coursework.question;

import java.util.Collection;

public interface QuestionService {

    Question add(String problem, String answer);

    Question add(Question question);

    Question remove(Question question);

    Question remove(String problem, String answer);

    Collection<Question> getAll();

    Question getRandomQuestion();

}