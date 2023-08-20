package com.example.coursework.javaquiz;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import com.example.coursework.question.Question;
import com.example.coursework.question.QuestionRepository;
import com.example.coursework.question.QuestionService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static com.example.coursework.utils.Randoms.randomInt;

@Service
@Scope
public class JavaQuestionService implements QuestionService {

    private final QuestionRepository questionStorage;

    public JavaQuestionService(@Qualifier("javaQuestionRepository") QuestionRepository questionStorage) {
        this.questionStorage = questionStorage;
    }

    public QuestionRepository getQuestionStorage() {
        return questionStorage;
    }

    @Override
    public Question remove(Question question) {
        return questionStorage.remove(question);
    }

    @Override
    public Collection<Question> getAll() {
        Collection<Question> q = questionStorage.getAll();
        return q;
    }

    @Override
    public Question getRandomQuestion() {
        List<Question> list = new ArrayList<>((Collection) questionStorage.getAll());
        int index = randomInt(0, list.size() - 1);
        return list.get(index);
    }

    @Override
    public Question add(String problem, String answer) {
        return questionStorage.add(new Question(problem, answer));
    }

    @Override
    public Question add(Question question) {
        return questionStorage.add(question);
    }

    public Question remove(String problem,
                           String answer) {
        return questionStorage.remove(problem, answer);
    }

    public int getQtyOfNumbers() {
        if (questionStorage == null) {
            return -1;
        }
        return questionStorage.getAll().size();
    }

}