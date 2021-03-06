package com.example.bjd.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.bjd.R;
import com.example.bjd.data.SubjectsReader;
import com.example.bjd.models.Subjects;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import lombok.val;

public final class MainActivity extends AppCompatActivity {

    private EditText searchQuery;
    private LinearLayout searchResult;

    private Subjects subjects;

    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setBackgroundDrawable(null);
        setContentView(R.layout.activity_main);

        subjects = SubjectsReader.read(this);
        searchQuery = findViewById(R.id.searchQuery);
        searchResult = findViewById(R.id.searchResult);

        searchQuery.setOnEditorActionListener((v, actionId, event) -> {
            search();
            return true;
        });

        findViewById(R.id.searchAction).setOnClickListener(v -> search());
    }

    private void search() {
        @NotNull val inflater = LayoutInflater.from(this);
        @NotNull val query = searchQuery.getText().toString();

        if (query.equalsIgnoreCase("Антон")) {
            searchQuery.setText("Мудрости пропогандон");
        }

        if (query.length() > 3) {
            searchResult.removeAllViews();

            @NotNull val questions = subjects.findQuestions(query);

            for (@NotNull val question : questions) {
                @NotNull val layout = (TextView) inflater.inflate(R.layout.item_search_result, null, false);

                @NotNull val builder = new StringBuilder(question.getName());
                for (@NotNull val answer : question.getAnswers()) {
                    builder.append("\n ");
                    builder.append(answer.isRight());
                    builder.append(' ');
                    builder.append(answer.getName());
                }

                builder.append("\n\n");

                layout.setText(builder.toString());
                searchResult.addView(layout);
            }
        }
    }

}
