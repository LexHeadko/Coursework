package com.example.coursework.exam;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.coursework.question.Question;

import java.util.Set;

@RestController
@RequestMapping(path = "/exam/")
public class ExamController {

    private final ExaminerService examinerService;

    public ExamController(@Qualifier("examinerServiceImplNext") ExaminerService examinerService) {
        this.examinerService = examinerService;
    }

    @GetMapping(path = "/get/{amount}")
    Set<Question> getQuestions(@PathVariable int amount) {
        return (Set<Question>) examinerService.getQuestions(amount);
    }
}