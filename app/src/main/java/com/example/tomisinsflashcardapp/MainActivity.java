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
        TextView clinton = findViewById(R.id.clinton_textview);
        TextView bush = findViewById(R.id.bush_textview);

        flashcard_answer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                flashcard_answer.setBackgroundColor(getResources().getColor(R.color.my_green, null));
            }
        });

        clinton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clinton.setBackgroundColor(getResources().getColor(R.color.my_red, null));
            }
        });

        bush.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bush.setBackgroundColor(getResources().getColor(R.color.my_red, null));
            }
        });
    }
}