package com.example.coursework.question;

import java.util.Collection;

public interface QuestionRepository {

    Question add(Question question);

    Question add(String problem, String answer);

    Question remove(Question question);

    Question remove(String problem, String answer);

    Collection<Question> getAll();
}