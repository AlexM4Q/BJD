package com.example.bjd.models;

import com.example.bjd.models.base.NamedEntity;

import org.jetbrains.annotations.NotNull;

import lombok.Getter;

public final class Answer extends NamedEntity {

    @Getter
    private final int questionId;

    @Getter
    private final int number;

    @Getter
    private final boolean isRight;

    public Answer(final int id,
                  final int questionId,
                  final int number,
                  @NotNull final String name,
                  final boolean isRight) {
        super(id, name);
        this.questionId = questionId;
        this.number = number;
        this.isRight = isRight;
    }

}
