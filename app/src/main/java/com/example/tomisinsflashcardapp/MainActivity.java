package com.example.tomisinsflashcardapp;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView flashcard_question = findViewById(R.id.flashcard_question_textview);
        TextView flashcard_answer = findViewById(R.id.flashcard_answer_textview);

        flashcard_question.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                flashcard_question.setVisibility(View.INVISIBLE);
                flashcard_answer.setVisibility(View.VISIBLE);
            }
        });

    }
}