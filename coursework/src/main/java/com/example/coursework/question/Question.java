package com.example.coursework.question;

import java.util.Objects;

public class Question {
    private String problem;
    private String answer;

    public Question() {
    }

    public Question(String problem, String answer) {
        checkProblemAndAnswer(problem, answer);
        this.problem = problem;
        this.answer = answer;
    }

    private static void checkProblemAndAnswer(String problem, String answer) {
        if (problem.equals(answer)) {
            throw new QuestionServiceException("problem and answer are same");
        }
    }

    private void checkProblem(String problem) {
        if (answer.equals(problem)) {
            throw new QuestionServiceException("problem is same as answer");
        }
    }

    private void checkAnswer(String answer) {
        if (problem.equals(answer)) {
            throw new QuestionServiceException("answer is same as problem");
        }
    }


    public String getProblem() {
        return problem;
    }

    public void setProblem(String problem) {
        checkProblem(problem);
        this.problem = problem;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        checkAnswer(answer);
        this.answer = answer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Question question = (Question) o;
        return Objects.equals(problem, question.problem);
    }

    @Override
    public int hashCode() {
        return Objects.hash(problem, answer);
    }

    @Override
    public String toString() {
        return "Question{" +
                "problem='" + problem + '\'' +
                ", answer='" + answer + '\'' +
                '}';
    }

}
