package com.example.bjd.models.base;

import java.io.Serializable;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class Entity implements Serializable {

    @Getter
    private final int id;

}
