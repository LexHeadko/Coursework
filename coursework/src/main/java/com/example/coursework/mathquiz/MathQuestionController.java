package com.example.coursework.mathquiz;

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
public class MathQuestionController {

    private final QuestionService service;

    MathQuestionController(@Qualifier("mathQuestionService") QuestionService service) {
        this.service = service;
    }

    @GetMapping(path = "/math/")
    Set<Question> getAll() {
        return (Set<Question>) service.getAll();
    }

    @GetMapping(path = "/math/add/")
    Question add(@RequestParam(required = false, name = "problem") String problem,
                 @RequestParam(required = false, name = "answer") String answer) {
        return service.add(problem, answer);
    }

    @GetMapping(path = "/math/remove/")
    Question remove(@RequestParam(required = false, name = "problem") String problem,
                    @RequestParam(required = false, name = "answer") String answer) {
        return service.remove(problem, answer);
    }
}