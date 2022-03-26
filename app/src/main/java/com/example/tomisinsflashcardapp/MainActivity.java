package com.example.tomisinsflashcardapp;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        flashcardDatabase = new FlashcardDatabase(getApplicationContext());
        allFlashcards = flashcardDatabase.getAllCards();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

<<<<<<< Updated upstream
        TextView flashcard_question = findViewById(R.id.flashcard_question_textview);
        TextView flashcard_answer = findViewById(R.id.flashcard_answer_textview);
        TextView clinton = findViewById(R.id.clinton_textview);
        TextView bush = findViewById(R.id.bush_textview);
        ImageView open_eye = findViewById(R.id.openeye_imageview);
        ImageView closed_eye = findViewById(R.id.closedeye_imageview);

        flashcard_answer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                flashcard_answer.setBackgroundColor(getResources().getColor(R.color.my_green, null));
=======
        TextView question = findViewById(R.id.flashcard_question_textview);
        TextView answer = findViewById(R.id.flashcard_answer_textview);
        TextView wrongAnswer1 = findViewById(R.id.wrong_answer1_textview);
        TextView wrongAnswer2 = findViewById(R.id.wrong_answer2_textview);

        if (allFlashcards != null && allFlashcards.size() > 0){
            question.setText(allFlashcards.get(0).getQuestion());
            answer.setText(allFlashcards.get(0).getAnswer());
            wrongAnswer1.setText(allFlashcards.get(0).getWrongAnswer1());
            wrongAnswer2.setText(allFlashcards.get(0).getWrongAnswer2());
            question.setVisibility(View.VISIBLE);
            answer.setVisibility(View.VISIBLE);
            wrongAnswer1.setVisibility(View.VISIBLE);
            wrongAnswer2.setVisibility(View.VISIBLE);
        }

        ImageView openEye = findViewById(R.id.open_eye_imageview);
        ImageView closedEye = findViewById(R.id.closed_eye_imageview);
        ImageView add_button = findViewById(R.id.add_button_imageview);
        ImageView next_button = findViewById(R.id.next_imageview);
        ImageView delete_button = findViewById(R.id.delete_imageview);
        TextView emptyState = findViewById(R.id.nocards_textview);

        answer.setOnClickListener(view -> answer.setBackgroundColor(getResources().getColor(R.color.my_green, null)));
        wrongAnswer1.setOnClickListener(view -> wrongAnswer1.setBackgroundColor(getResources().getColor(R.color.my_red, null)));
        wrongAnswer2.setOnClickListener(view -> wrongAnswer2.setBackgroundColor(getResources().getColor(R.color.my_red, null)));

        openEye.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openEye.setVisibility(View.INVISIBLE);
                closedEye.setVisibility(View.VISIBLE);
                answer.setVisibility(View.VISIBLE);
                wrongAnswer1.setVisibility(View.VISIBLE);
                wrongAnswer2.setVisibility(View.VISIBLE);
>>>>>>> Stashed changes
            }
        });

        clinton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
<<<<<<< Updated upstream
                clinton.setBackgroundColor(getResources().getColor(R.color.my_red, null));
=======
                openEye.setVisibility(View.VISIBLE);
                closedEye.setVisibility(View.INVISIBLE);
                answer.setVisibility(View.INVISIBLE);
                wrongAnswer1.setVisibility(View.INVISIBLE);
                wrongAnswer2.setVisibility(View.INVISIBLE);
>>>>>>> Stashed changes
            }
        });

        bush.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bush.setBackgroundColor(getResources().getColor(R.color.my_red, null));
            }
        });

        next_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (allFlashcards.size() == 0)
                    return;
                currentCardDisplayedIndex++;
                if(currentCardDisplayedIndex >= allFlashcards.size()) {
                    Snackbar.make(question,
                            "You've reached the end of the cards, going back to start.",
                            Snackbar.LENGTH_SHORT)
                            .show();
                    currentCardDisplayedIndex = 0;
                }

                allFlashcards = flashcardDatabase.getAllCards();
                Flashcard flashcard = allFlashcards.get(currentCardDisplayedIndex);

                question.setText(flashcard.getQuestion());
                answer.setText(flashcard.getAnswer());
                wrongAnswer1.setText(flashcard.getWrongAnswer1());
                wrongAnswer2.setText(flashcard.getWrongAnswer2());
            }
        });

        delete_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                flashcardDatabase.deleteCard(question.getText().toString());
                allFlashcards = flashcardDatabase.getAllCards();
                currentCardDisplayedIndex--;
            }
        });

        if(allFlashcards.size() == 0){
            emptyState.setVisibility(View.VISIBLE);
            question.setVisibility(View.INVISIBLE);
            answer.setVisibility(View.INVISIBLE);
            wrongAnswer1.setVisibility(View.INVISIBLE);
            wrongAnswer2.setVisibility(View.INVISIBLE);
        }
    }
<<<<<<< Updated upstream
=======

    @Override
    protected void onActivityResult(int requestCode, int resultCode,  Intent my_data) {
        super.onActivityResult(requestCode, resultCode, my_data);
        if (requestCode == 100 && resultCode == RESULT_OK){
            String my_question = my_data.getExtras().getString("final_question");
            String my_answer = my_data.getExtras().getString("final_answer");
            String wrong1 = my_data.getExtras().getString("wrong1");
            String wrong2 = my_data.getExtras().getString("wrong2");

            TextView flashcardQuestion = findViewById(R.id.flashcard_question_textview);
            flashcardQuestion.setText(my_question);

            TextView answer = findViewById(R.id.flashcard_answer_textview);
            answer.setText(my_answer);

            TextView wrongAnswer1 = findViewById(R.id.wrong_answer1_textview);
            wrongAnswer1.setText(wrong1);

            TextView wrongAnswer2 = findViewById(R.id.wrong_answer2_textview);
            wrongAnswer2.setText(wrong2);

            flashcardDatabase.insertCard(new Flashcard(my_question, my_answer, wrong1, wrong2));
            allFlashcards = flashcardDatabase.getAllCards();
        }
    }

    FlashcardDatabase flashcardDatabase;
    List<Flashcard> allFlashcards;
    int currentCardDisplayedIndex = 0;

>>>>>>> Stashed changes
}