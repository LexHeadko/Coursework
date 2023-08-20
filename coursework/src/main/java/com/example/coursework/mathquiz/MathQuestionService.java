package com.example.coursework.mathquiz;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import com.example.coursework.question.Question;
import com.example.coursework.question.QuestionRepository;
import com.example.coursework.question.QuestionService;
import com.example.coursework.question.QuestionServiceException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static com.example.coursework.utils.Randoms.randomInt;

@Service
@Scope
public class MathQuestionService implements QuestionService {

    private final QuestionRepository questionStorage;

    public MathQuestionService(@Qualifier("mathQuestionRepository") QuestionRepository questionStorage) {
        this.questionStorage = questionStorage;
    }

    @Override
    public Question remove(Question question) {
        if (questionStorage.getAll().contains(question)) {
            return questionStorage.remove(question);
        } else {
            throw new QuestionServiceException("Question missing");
        }
    }

    @Override
    public Question remove(String problem, String answer) {
        return remove(new Question(problem, answer));
    }

    @Override
    public Collection<Question> getAll() {
        return questionStorage.getAll();
    }

    @Override
    public Question getRandomQuestion() {
        List<Question> list = new ArrayList<>(questionStorage.getAll());
        int index = randomInt(0, list.size() - 1);
        return list.get(index);
    }

    @Override
    public Question add(String problem, String answer) {
        return add(new Question(problem, answer));
    }

    @Override
    public Question add(Question question) {
        if (!questionStorage.getAll().contains(question)) {
            return questionStorage.add(question);
        } else {
            throw new QuestionServiceException("Question already added");
        }
    }
}
