package com.trilogyed.U1M4SummativeMerelZach.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.validation.constraints.NotEmpty;
import java.util.Objects;

public class Answer {

    @NotEmpty(message = "You must enter a question.")
    private String question;

    private String answer;


    public Answer() {
    }


    public Answer(String answer) {
        this.answer = answer;

    }

    public Answer(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }


    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Answer that = (Answer) o;
        return Objects.equals(question, that.question) &&
                Objects.equals(answer, that.answer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(question, answer);
    }

    @Override
    public String toString() {
        return "Answer{" +
                "question='" + question + '\'' +
//                question + '\'' +
                ", answer='" + answer + '\'' +
                '}';
    }
}
