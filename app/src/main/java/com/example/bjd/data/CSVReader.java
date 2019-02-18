package com.example.bjd.data;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public abstract class CSVReader<T> implements AutoCloseable {

    @NotNull
    protected static final String DELIMITER = ";";

    @NotNull
    protected final BufferedReader reader;

    protected CSVReader(@NotNull final InputStream is) {
        this.reader = new BufferedReader(new InputStreamReader(is));

        try {
            reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void close() throws Exception {
        reader.close();
    }

    @Nullable
    public abstract T readNext();

}