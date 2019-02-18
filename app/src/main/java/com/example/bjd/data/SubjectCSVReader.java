package com.example.bjd.data;

import android.app.Activity;
import android.content.Context;
import android.util.Log;

import com.example.bjd.R;
import com.example.bjd.models.Subject;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import lombok.val;

public final class SubjectCSVReader extends CSVReader<Subject> {

    private static final String TAG = SubjectCSVReader.class.getSimpleName();

    public SubjectCSVReader(@NotNull final Context context) {
        super(context.getResources().openRawResource(R.raw.subjects));
    }

    @Nullable
    @Override
    public final Subject readNext() {
        try {
            @Nullable val csvLine = reader.readLine();
            if (csvLine == null || csvLine.isEmpty()) {
                return null;
            }

            @NotNull val row = csvLine.split(DELIMITER);

            return new Subject(Integer.valueOf(row[0]), row[1]);
        } catch (Throwable e) {
            Log.e(TAG, "Error while reading subject", e);
            return null;
        }
    }

}
