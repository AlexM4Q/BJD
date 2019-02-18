package com.example.bjd.models;

import com.example.bjd.models.base.NamedEntity;

import org.jetbrains.annotations.NotNull;

import java.util.HashSet;
import java.util.Set;

import lombok.Getter;

public final class Question extends NamedEntity {

    @Getter
    private final int subjectId;

    @Getter
    private final int number;

    @Getter
    private final Set<Answer> answers;

    public Question(final int id,
                    final int subjectId,
                    final int number,
                    @NotNull final String name) {
        super(id, name);
        this.subjectId = subjectId;
        this.number = number;
        this.answers = new HashSet<>();
    }

}
