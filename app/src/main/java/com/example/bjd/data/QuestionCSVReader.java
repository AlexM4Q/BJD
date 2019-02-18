package com.example.bjd.data;

import android.app.Activity;
import android.content.Context;
import android.util.Log;

import com.example.bjd.R;
import com.example.bjd.models.Question;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;

import lombok.val;

public final class QuestionCSVReader extends CSVReader<Question> {

    private static final String TAG = QuestionCSVReader.class.getSimpleName();

    public QuestionCSVReader(@NotNull final Context context) {
        super(context.getResources().openRawResource(R.raw.questions));
    }

    @Nullable
    @Override
    public Question readNext() {
        try {
            @Nullable val csvLine = reader.readLine();
            if (csvLine == null || csvLine.isEmpty()) {
                return null;
            }

            @NotNull val row = csvLine.split(DELIMITER);

            return new Question(
                    Integer.valueOf(row[0]),
                    Integer.valueOf(row[1]),
                    Integer.valueOf(row[2]),
                    row[3]
            );
        } catch (Throwable e) {
            Log.e(TAG, "Error while reading subject", e);
            return null;
        }
    }
}
