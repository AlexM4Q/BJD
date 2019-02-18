package com.example.bjd.data;

import android.content.Context;
import android.util.Log;

import com.example.bjd.R;
import com.example.bjd.models.Answer;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import lombok.val;

public final class AnswerCSVReader extends CSVReader<Answer> {

    private static final String TAG = AnswerCSVReader.class.getSimpleName();

    public AnswerCSVReader(@NotNull final Context context) {
        super(context.getResources().openRawResource(R.raw.answers));
    }

    @Nullable
    @Override
    public final Answer readNext() {
        try {
            @Nullable val csvLine = reader.readLine();
            if (csvLine == null || csvLine.isEmpty()) {
                return null;
            }

            @NotNull val row = csvLine.split(DELIMITER);

            return new Answer(
                    Integer.valueOf(row[0]),
                    Integer.valueOf(row[1]),
                    Integer.valueOf(row[2]),
                    row[3],
                    Boolean.valueOf(row[4])
            );
        } catch (Throwable e) {
            Log.e(TAG, "Error while reading subject", e);
            return null;
        }
    }
}
