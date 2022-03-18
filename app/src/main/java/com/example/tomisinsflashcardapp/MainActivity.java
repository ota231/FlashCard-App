package com.example.tomisinsflashcardapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView flashcardQuestion = findViewById(R.id.flashcard_question_textview);
        TextView answer = findViewById(R.id.flashcard_answer_textview);
        TextView clinton = findViewById(R.id.clinton_textview);
        TextView bush = findViewById(R.id.bush_textview);
        ImageView openEye = findViewById(R.id.open_eye_imageview);
        ImageView closedEye = findViewById(R.id.closed_eye_imageview);
        ImageView add_button = findViewById(R.id.add_button_imageview);

        answer.setOnClickListener(view -> answer.setBackgroundColor(getResources().getColor(R.color.my_green, null)));

        clinton.setOnClickListener(view -> clinton.setBackgroundColor(getResources().getColor(R.color.my_red, null)));

        bush.setOnClickListener(view -> bush.setBackgroundColor(getResources().getColor(R.color.my_red, null)));

        openEye.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openEye.setVisibility(View.INVISIBLE);
                closedEye.setVisibility(View.VISIBLE);
                answer.setVisibility(View.VISIBLE);
                clinton.setVisibility(View.VISIBLE);
                bush.setVisibility(View.VISIBLE);
            }
        });

        closedEye.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openEye.setVisibility(View.VISIBLE);
                closedEye.setVisibility(View.INVISIBLE);
                answer.setVisibility(View.INVISIBLE);
                clinton.setVisibility(View.INVISIBLE);
                bush.setVisibility(View.INVISIBLE);
            }
        });

        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AddCardActivity.class);
                startActivityForResult(intent, 100);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode,  Intent my_data) {
        super.onActivityResult(requestCode, resultCode, my_data);
        if (requestCode == 100 && resultCode == RESULT_OK){
            String my_question = my_data.getExtras().getString("final_question");
            String my_answer = my_data.getExtras().getString("final_answer");

            TextView flashcardQuestion = findViewById(R.id.flashcard_question_textview);
            flashcardQuestion.setText(my_question);

            TextView answer = findViewById(R.id.flashcard_answer_textview);
            answer.setText(my_answer);

            TextView clinton = findViewById(R.id.clinton_textview);
            TextView bush = findViewById(R.id.bush_textview);
            clinton.setVisibility(View.INVISIBLE);
            bush.setVisibility(View.INVISIBLE);
        }
    }


}