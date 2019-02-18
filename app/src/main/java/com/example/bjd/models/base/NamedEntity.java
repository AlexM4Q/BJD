package com.example.bjd.models.base;

import org.jetbrains.annotations.NotNull;

import lombok.Getter;

public abstract class NamedEntity extends Entity {

    @Getter
    private final String name;

    protected NamedEntity(final int id, @NotNull final String name) {
        super(id);
        this.name = name;
    }

}
