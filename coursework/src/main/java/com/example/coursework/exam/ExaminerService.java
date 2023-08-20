package com.example.coursework.exam;


import com.example.coursework.question.Question;

import java.util.Collection;

public interface ExaminerService {
    Collection<Question> getQuestions(int amount);
}
