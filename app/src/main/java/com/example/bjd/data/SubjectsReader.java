package com.example.bjd.data;

import android.app.Activity;
import android.content.Context;
import android.util.Log;

import com.example.bjd.models.Answer;
import com.example.bjd.models.Question;
import com.example.bjd.models.Subject;
import com.example.bjd.models.Subjects;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import lombok.val;

public final class SubjectsReader {

    private static final String TAG = SubjectsReader.class.getSimpleName();

    @Nullable
    public static Subjects read(@NotNull final Context context) {
        try {
            @NotNull val subjects = new Subjects();

            @NotNull val subjectReader = new SubjectCSVReader(context);
            @Nullable Subject readSubject;
            while ((readSubject = subjectReader.readNext()) != null) {
                subjects.addSubject(readSubject);
            }

            @NotNull val questionReader = new QuestionCSVReader(context);
            @Nullable Question readQuestion;
            while ((readQuestion = questionReader.readNext()) != null) {
                subjects.addQuestion(readQuestion);
            }

            @NotNull val answerReader = new AnswerCSVReader(context);
            @Nullable Answer readAnswer;
            while ((readAnswer = answerReader.readNext()) != null) {
                subjects.addAnswer(readAnswer);
            }

            return subjects;
        } catch (Throwable e) {
            Log.e(TAG, "Error while reading subjects", e);
            return null;
        }
    }

}
