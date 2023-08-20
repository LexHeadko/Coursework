package com.example.coursework.exam;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import com.example.coursework.question.Question;
import com.example.coursework.question.QuestionService;
import com.example.coursework.question.QuestionServiceException;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import static com.example.coursework.utils.Randoms.randomInt;

@Service
@Scope
public class ExaminerServiceImpl implements ExaminerService {

    private final QuestionService javaQuestionService;
    private final QuestionService mathQuestionService;

    public ExaminerServiceImpl(@Qualifier("javaQuestionService") QuestionService javaQuestionService,
                               @Qualifier("mathQuestionService") QuestionService mathQuestionService) {
        this.javaQuestionService = javaQuestionService;
        this.mathQuestionService = mathQuestionService;
    }
    @Override
    public Collection<Question> getQuestions(int amount) {
        int javaQuestionsQty = javaQuestionService.getAll().size();
        int mathQuestionsQty = mathQuestionService.getAll().size();

        if (amount > javaQuestionsQty) {
            throw new QuestionServiceException("not enough Java questions");
        }

        if (amount > mathQuestionsQty) {
            throw new QuestionServiceException("not enough Math questions");
        }

        if (amount == javaQuestionsQty + mathQuestionsQty) {
            Collection<Question> q = javaQuestionService.getAll();
            q.addAll(mathQuestionService.getAll());
            return q;
        }

        Set<Question> questions = new HashSet<Question>();

        Question nextQuestion;

        int javaQuizAmount = randomInt(0, amount);

        int i = 1;
        for (; i <= javaQuizAmount; i++) {
            do {
                nextQuestion = javaQuestionService.getRandomQuestion();
                questions.add(nextQuestion);
            } while (questions.contains(nextQuestion));
            questions.add(nextQuestion);
        }

        for (; i <= amount; i++) {
            do {
                nextQuestion = mathQuestionService.getRandomQuestion();
            } while (questions.contains(nextQuestion));
            questions.add(nextQuestion);
        }

        return questions;
    }
}