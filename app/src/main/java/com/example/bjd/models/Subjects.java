package com.example.bjd.models;

import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import lombok.val;

public final class Subjects {

    private final Set<Subject> items;

    public Subjects() {
        this.items = new HashSet<>();
    }

    public void addSubject(@NotNull final Subject subject) {
        items.add(subject);
    }

    public void addQuestion(@NotNull final Question question) {
        for (@NotNull val subject : items) {
            if (subject.getId() == question.getSubjectId()) {
                subject.addQuestion(question);
                return;
            }
        }
    }

    public void addAnswer(@NotNull final Answer answer) {
        for (@NotNull val subject : items) {
            for (@NotNull val question : subject.getQuestions()) {
                if (question.getId() == answer.getQuestionId()) {
                    question.getAnswers().add(answer);
                    return;
                }
            }
        }
    }

    @NotNull
    public Collection<Question> findQuestions(@NotNull final String name) {
        @NotNull val result = new HashSet<Question>();
        for (@NotNull val subject : items) {
            subject.findQuestion(name, result);
        }

        return result;
    }

}
