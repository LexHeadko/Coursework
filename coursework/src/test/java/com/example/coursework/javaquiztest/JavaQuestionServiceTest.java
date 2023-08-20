package com.example.coursework.javaquiztest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import com.example.coursework.javaquiz.JavaQuestionRepository;
import com.example.coursework.javaquiz.JavaQuestionService;
import com.example.coursework.question.Question;
import com.example.coursework.question.QuestionRepository;
import com.example.coursework.question.QuestionServiceException;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static com.example.coursework.utils.Randoms.*;

@ExtendWith(MockitoExtension.class)
public class JavaQuestionServiceTest {

    @Mock
    QuestionRepository questionRepositoryMock;

    @InjectMocks
    JavaQuestionService javaQuestionServiceMocked;

    @Test
    public void JavaQuestionServiceTest() {

        Question question1 = new Question("Java Test Question #1", "Java Test Answer #1");
        JavaQuestionService javaQuestionService = new JavaQuestionService(questionRepositoryMock);
        Collection<Question> testCollection = randomQuestionSet(randomInt(20, 30));
        when(questionRepositoryMock.getAll()).thenReturn(testCollection);
        assertEquals(testCollection, javaQuestionService.getAll());
    }

    @Test
    public void getAllTest() {
        Collection<Question> testQuestionSet = randomQuestionSet(randomInt(40, 50));
        when(questionRepositoryMock.getAll()).thenReturn(testQuestionSet);
        assertEquals(testQuestionSet, javaQuestionServiceMocked.getAll());
    }

    @Test
    public void getRandomQuestionTest() {
        JavaQuestionService javaQuestionService =
                new JavaQuestionService(
                        new JavaQuestionRepository(randomQuestionSet(randomInt(10, 20))));
        Question question = javaQuestionService.getRandomQuestion();
        assertTrue(javaQuestionService.getAll().contains(question));
    }

    @Test
    public void addQuestionQuestionArgTest() {
        JavaQuestionService testJavaQuestionService =
                new JavaQuestionService(questionRepositoryMock);
        String testProblem = randomPhrase(3, 5);
        String testAnswer = randomPhrase(5, 15);
        Question testQuestion = new Question(testProblem, testAnswer);
        when(questionRepositoryMock.add(testQuestion)).thenReturn(testQuestion);
        assertEquals(testQuestion, testJavaQuestionService.add(testQuestion));
        when(questionRepositoryMock.add(testQuestion)).thenThrow(new QuestionServiceException("question already added"));
        assertThrows(QuestionServiceException.class, () -> testJavaQuestionService.add(testQuestion));
    }

    @Test
    public void addStringStringArgsTest() {
        JavaQuestionService testJavaQuestionService = new JavaQuestionService(questionRepositoryMock);
        String testProblem = randomPhrase(3, 5);
        String testAnswer = randomPhrase(5, 15);
        Question testQuestion = new Question(testProblem, testAnswer);
        when(questionRepositoryMock.add(testQuestion)).thenReturn(testQuestion);
        assertEquals(testQuestion, testJavaQuestionService.add(testProblem, testAnswer));
        when(questionRepositoryMock.add(testQuestion)).thenThrow(new QuestionServiceException("question already added"));
        assertThrows(QuestionServiceException.class, () -> testJavaQuestionService.add(testProblem, testAnswer));
    }

    @Test
    public void removeStringArgsTest() {
        JavaQuestionService testJavaQuestionService = new JavaQuestionService(questionRepositoryMock);
        String testProblem = randomPhrase(3, 5);
        String testAnswer = randomPhrase(5, 15);
        Question testQuestion = new Question(testProblem, testAnswer);
        when(questionRepositoryMock.remove(testProblem, testAnswer)).thenReturn(testQuestion);
        assertEquals(testQuestion, testJavaQuestionService.remove(testProblem, testAnswer));
        when(questionRepositoryMock.remove(testProblem, testAnswer)).thenThrow(new QuestionServiceException("question already added"));
        assertThrows(QuestionServiceException.class, () -> testJavaQuestionService.remove(testProblem, testAnswer));
    }

    @Test
    public void removeQuestionArgTest() {
        JavaQuestionService testJavaQuestionService = new JavaQuestionService(questionRepositoryMock);
        String testProblem = randomPhrase(3, 5);
        String testAnswer = randomPhrase(5, 15);
        Question testQuestion = new Question(testProblem, testAnswer);
        when(questionRepositoryMock.remove(testQuestion)).thenReturn(testQuestion);
        assertEquals(testQuestion, testJavaQuestionService.remove(testQuestion));
        when(questionRepositoryMock.remove(testQuestion)).thenThrow(new QuestionServiceException("question already added"));
        assertThrows(QuestionServiceException.class, () -> testJavaQuestionService.remove(testQuestion));
    }

    @Test
    public void getQtyOfNumbersTest() {
        JavaQuestionService testJavaQuestionService = new JavaQuestionService(questionRepositoryMock);
        Collection<Question> testQuestionCollection = randomQuestionSet(randomInt(10, 100));
        int testSize = testQuestionCollection.size();
        when(questionRepositoryMock.getAll()).thenReturn(testQuestionCollection);
        assertEquals(testSize, testJavaQuestionService.getQtyOfNumbers());
    }


}
