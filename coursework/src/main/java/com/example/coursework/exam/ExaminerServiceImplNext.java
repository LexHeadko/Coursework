package com.example.coursework.exam;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import com.example.coursework.question.Question;
import com.example.coursework.question.QuestionService;
import com.example.coursework.question.QuestionServiceException;

import java.util.*;

import static com.example.coursework.utils.Randoms.randomInt;

@Service
@Scope
public class ExaminerServiceImplNext implements ExaminerService {

    private final Collection<Question> questionCollection = new HashSet<>();

    public ExaminerServiceImplNext(@Qualifier("javaQuestionService") QuestionService javaQuestionService,
                                   @Qualifier("mathQuestionService") QuestionService mathQuestionService) {
        questionCollection.addAll(javaQuestionService.getAll());
        questionCollection.addAll(mathQuestionService.getAll());
    }

    @Override
    public Set<Question> getQuestions(int amount) {

        int questionsQty = questionCollection.size();

        if (amount > questionsQty) {
            throw new QuestionServiceException("not enough questions");
        }

        Set<Question> questions = new HashSet<Question>();

        Question nextQuestion = new Question();

        for (int i = 1; i <= amount; i++) {
            do {
                nextQuestion = getRandomQuestion();
            } while (questions.contains(nextQuestion));
            questions.add(nextQuestion);
        }
        return questions;
    }

    private Question getRandomQuestion() {
        List<Question> list = new ArrayList<>(questionCollection);
        int index = randomInt(0, list.size() - 1);
        return list.get(index);
    }
}