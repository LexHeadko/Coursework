package com.example.coursework.mathquiztest;

import org.junit.jupiter.api.Test;
import com.example.coursework.mathquiz.MathQuestionRepository;
import com.example.coursework.question.Question;
import com.example.coursework.question.QuestionServiceException;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;
import static com.example.coursework.utils.Randoms.*;


public class MathQuestionRepositoryTest {

    @Test
    public void addQuestionArgTest() {
        Collection<Question> testQuestionCollection = randomQuestionSet(randomInt(10, 50));
        MathQuestionRepository testMathQuestionRepository = new MathQuestionRepository(testQuestionCollection);
        Question testQuestion;
        do {
            testQuestion = randomQuestion();
        } while (testQuestionCollection.contains(testQuestion));
        assertFalse(testMathQuestionRepository.getAll().contains(testQuestion));
        assertEquals(testQuestion, testMathQuestionRepository.add(testQuestion));
        Question finalTestQuestion = testQuestion;
        assertThrows(QuestionServiceException.class, () -> testMathQuestionRepository.add(finalTestQuestion));

    }

    private Question getQuestion(String problem, String answer) {
        return new Question(problem, answer);
    }

    @Test
    public void addStringArgsTest() {
        Collection<Question> testQuestionCollection = randomQuestionSet(randomInt(10, 50));
        MathQuestionRepository MathQuestionRepository = new MathQuestionRepository(testQuestionCollection);
        String testProblem;
        String testAnswer;
        Question testQuiz;
        do {
            testProblem = randomPhrase(3, 5);
            testAnswer = randomPhrase(5, 15);
            testQuiz = getQuestion(testProblem, testAnswer);
        }
        while (testQuestionCollection.contains(testQuiz));
        assertFalse(MathQuestionRepository.getAll().contains(testQuiz));
        assertEquals(testQuiz, MathQuestionRepository.add(testProblem, testAnswer));
        Question finalTestQuestion = testQuiz;
        String finalTestAnswer = testAnswer;
        String finalTestProblem = testProblem;
        assertThrows(QuestionServiceException.class, () -> MathQuestionRepository.add(finalTestProblem, finalTestAnswer));
    }

    @Test
    public void removeQuestionArgTest() {
        Collection<Question> testQuestionCollection = randomQuestionSet(randomInt(10, 50));
        MathQuestionRepository testMathQuestionRepository = new MathQuestionRepository(testQuestionCollection);
        Question testQuiz;

        testQuiz = testQuestionCollection.iterator().next();

        assertEquals(testQuiz, testMathQuestionRepository.remove(testQuiz));
        assertThrows(QuestionServiceException.class, () -> testMathQuestionRepository.remove(testQuiz));

    }

    @Test

    public void removeStringArgsTest() {
        Collection<Question> testQuestionCollection = randomQuestionSet(randomInt(10, 50));
        MathQuestionRepository testMathQuestionRepository = new MathQuestionRepository(testQuestionCollection);
        Question testQuiz;

        testQuiz = testQuestionCollection.iterator().next();
        String testProblem = testQuiz.getProblem();
        String testAnswer = testQuiz.getAnswer();

        assertEquals(testQuiz, testMathQuestionRepository.remove(testProblem, testAnswer));
        assertThrows(QuestionServiceException.class, () -> testMathQuestionRepository.remove(testProblem, testAnswer));
    }

    @Test
    public void getAllTest() {
        Collection<Question> testQuestionCollection = randomQuestionSet(randomInt(10, 50));
        MathQuestionRepository testMathQuestionRepository = new MathQuestionRepository(testQuestionCollection);
        assertEquals(testQuestionCollection, testMathQuestionRepository.getAll());
    }

}
