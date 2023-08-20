package com.example.coursework.javaquiz;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.coursework.question.Question;
import com.example.coursework.question.QuestionService;

import java.util.Set;

@RestController
@RequestMapping(path = "/exam/")
public class JavaQuestionController {

    private final QuestionService service;

    public JavaQuestionController(@Qualifier("javaQuestionService") QuestionService service) {
        this.service = service;
    }

    public Set<Question> getQuestionSet() {
        Set<Question> questionSet = (Set<Question>) service.getAll();
        return questionSet;
    }

    public QuestionService getJavaQuestions() {
        return service;
    }

    @GetMapping(path = "/java/add/")
    public Question add(@RequestParam(required = false, name = "problem") String problem,
                        @RequestParam(required = false, name = "answer") String answer) {
        return service.add(problem, answer);
    }

    @GetMapping(path = "/java/remove/")
    public Question remove(@RequestParam(required = false, name = "problem") String problem,
                           @RequestParam(required = false, name = "answer") String answer) {
        return service.remove(problem, answer);
    }

    @GetMapping(path = "/java/")
    public Set<Question> getAllQuestions() {
        return (Set<Question>) service.getAll();
    }

}
