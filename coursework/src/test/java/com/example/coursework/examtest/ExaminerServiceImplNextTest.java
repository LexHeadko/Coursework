package com.example.coursework.examtest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import com.example.coursework.exam.ExaminerServiceImplNext;
import com.example.coursework.javaquiz.JavaQuestionRepository;
import com.example.coursework.javaquiz.JavaQuestionService;
import com.example.coursework.mathquiz.MathQuestionRepository;
import com.example.coursework.mathquiz.MathQuestionService;
import com.example.coursework.question.Question;

import java.util.Collection;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static com.example.coursework.utils.Randoms.*;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceImplNextTest {

    @Test
    public void qetQuestionsTest() {
        int amount = randomInt(1, 10);
        int javaQty = randomInt(10 * amount, 20 * amount);
        int mathQty = randomInt(10 * amount, 20 * amount);

        Collection<Question> javaQuestionSet = randomQuestionSet(javaQty);
        Collection<Question> mathQuestionSet = randomQuestionSet(mathQty);

        ExaminerServiceImplNext testExaminerServiceImplNext =
                new ExaminerServiceImplNext(
                        new JavaQuestionService(new JavaQuestionRepository(javaQuestionSet)),
                        new MathQuestionService(new MathQuestionRepository(mathQuestionSet)));

        Collection<Question> allQuestions = new HashSet<>();
        allQuestions.addAll(javaQuestionSet);
        allQuestions.addAll(mathQuestionSet);

        Collection<Question> testCollection = testExaminerServiceImplNext.getQuestions(amount);
        assertEquals(amount, testCollection.size());
        assertTrue(allQuestions.containsAll(testCollection));
    }
}