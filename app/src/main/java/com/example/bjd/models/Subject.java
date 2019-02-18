package com.example.bjd.models;

import com.example.bjd.models.base.NamedEntity;

import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import lombok.Getter;
import lombok.val;

public final class Subject extends NamedEntity {

    @Getter
    private final Set<Question> questions;

    public Subject(final int id, @NotNull final String name) {
        super(id, name);

        this.questions = new HashSet<>();
    }

    public void addQuestion(@NotNull final Question question) {
        questions.add(question);
    }

    public void findQuestion(@NotNull final String name, @NotNull final Collection<Question> result) {
        for (@NotNull val question : questions) {
            if (question.getName().contains(name)) {
                result.add(question);
            }
        }
    }

}
