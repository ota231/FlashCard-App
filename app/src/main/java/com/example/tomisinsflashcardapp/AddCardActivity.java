package com.example.tomisinsflashcardapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class AddCardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_card);
        overridePendingTransition(R.anim.right_in, R.anim.left_out);

        ImageView remove_button = findViewById(R.id.remove_button_imageview);
        ImageView save_button = findViewById(R.id.save_button_imageview);
        EditText my_question = findViewById(R.id.my_question_edittext);
        EditText my_answer = findViewById(R.id.my_answer_edittext);
        EditText wrong1 = findViewById(R.id.wrong1_edittext);
        EditText wrong2 = findViewById(R.id.wrong2_edittext);

        remove_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        save_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String question = my_question.getText().toString();
                String answer = my_answer.getText().toString();
                String wrong_1 = wrong1.getText().toString();
                String wrong_2 = wrong2.getText().toString();
                Intent my_data = new Intent();
                my_data.putExtra("final_question", question);
                my_data.putExtra("final_answer", answer);
                my_data.putExtra("wrong1", wrong_1);
                my_data.putExtra("wrong2", wrong_2);
                setResult(RESULT_OK, my_data);
                finish();
            }
        });

    }
}