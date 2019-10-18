package com.trilogyed.U1M4SummativeMerelZach.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.validation.constraints.NotEmpty;
import java.util.Objects;

public class Definition {

    @NotEmpty(message = "You must enter a word")
    private String word;
    private String definition;


    public Definition() {
    }

    public Definition(@NotEmpty(message = "You must enter a word") String word, String definition) {
        this.word = word;
        this.definition = definition;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Definition that = (Definition) o;
        return Objects.equals(word, that.word) &&
                Objects.equals(definition, that.definition);
    }

    @Override
    public int hashCode() {
        return Objects.hash(word, definition);
    }

    @Override
    public String toString() {
        return "Definition{" +
                "word='" + word + '\'' +
                ", definition='" + definition + '\'' +
                '}';
    }
}
