package com.example.coursework.examtest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import com.example.coursework.exam.ExaminerServiceImpl;
import com.example.coursework.question.Question;
import com.example.coursework.question.QuestionService;
import com.example.coursework.question.QuestionServiceException;

import java.util.Collection;
import java.util.HashSet;

import static org.mockito.Mockito.when;
import static com.example.coursework.utils.Randoms.*;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceImplTest {


    @Mock
    QuestionService javaQuestionServiceMock;

    @Mock
    QuestionService mathQuestionServiceMock;

    @InjectMocks
    ExaminerServiceImpl examinerServiceImplMocked;

    @Test
    public void getQuestionsTest() {
        ExaminerServiceImpl examinerServiceImplMocked = new ExaminerServiceImpl(javaQuestionServiceMock, mathQuestionServiceMock);
        int amount = randomInt(3, 7);
        Collection<Question> testJavaQuestionCollection = randomQuestionSet(randomInt(amount + 1, amount * 20));
        Collection<Question> testMathQuestionCollection = randomQuestionSet(randomInt(amount + 1, amount * 20));
        when(javaQuestionServiceMock.getAll()).thenReturn(testJavaQuestionCollection);
        when(mathQuestionServiceMock.getAll()).thenReturn(testMathQuestionCollection);
        Assertions.assertThrows(QuestionServiceException.class, () -> examinerServiceImplMocked.getQuestions(
                testJavaQuestionCollection.size() + testMathQuestionCollection.size() + 1));
    }

    class GetTestQuestionAndKeepInStorage {
        private final Collection<Question> questionCollection = new HashSet<>();
        private int dummyQuestionCount = 0;

        public GetTestQuestionAndKeepInStorage() {
        }

        Question getNewDummy() {
            dummyQuestionCount++;
            Question question = new Question("Dummy Question #" + dummyQuestionCount,
                    "Dummy Answer #" + dummyQuestionCount);
            questionCollection.add(question);
            return question;
        }

        Collection<Question> getAll() {
            return questionCollection;
        }

    }

}
