package edu.wit.senderp.flashcardapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.background).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findViewById(R.id.choice1).setBackgroundColor(getResources().getColor(R.color.questionColor));
                findViewById(R.id.choice2).setBackgroundColor(getResources().getColor(R.color.questionColor));
                findViewById(R.id.choice3).setBackgroundColor(getResources().getColor(R.color.questionColor));

            }
        });



    }

    public void showAnswer(View v) {
        findViewById(R.id.flashcar_question).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findViewById(R.id.flashcard_answer).setVisibility(View.VISIBLE);
                findViewById(R.id.flashcar_question).setVisibility(View.INVISIBLE);
            }
        });
    }

    public void showQuestion(View v) {
        findViewById(R.id.flashcard_answer).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findViewById(R.id.flashcar_question).setVisibility(View.VISIBLE);
                findViewById(R.id.flashcard_answer).setVisibility(View.INVISIBLE);
            }
        });

    }

    public void wrong(View v) {
        findViewById(R.id.choice1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findViewById(R.id.choice1).setBackgroundColor(getResources().getColor(R.color.red));
                findViewById(R.id.choice3).setBackgroundColor(getResources().getColor(R.color.green));
            }
        });
        findViewById(R.id.choice2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findViewById(R.id.choice2).setBackgroundColor(getResources().getColor(R.color.red));
                findViewById(R.id.choice3).setBackgroundColor(getResources().getColor(R.color.green));
            }
        });

    }

    public void correct(View v) {
        findViewById(R.id.choice3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findViewById(R.id.choice3).setBackgroundColor(getResources().getColor(R.color.green));
            }
        });
    }
    public void hide(View v) {
        findViewById(R.id.eye_close).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findViewById(R.id.Eye).setVisibility(View.VISIBLE);
                findViewById(R.id.eye_close).setVisibility(View.INVISIBLE);
                findViewById(R.id.choice1).setVisibility(View.INVISIBLE);
                findViewById(R.id.choice2).setVisibility(View.INVISIBLE);
                findViewById(R.id.choice3).setVisibility(View.INVISIBLE);
            }
        });
    }
    public void show (View v) {
        findViewById(R.id.Eye).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findViewById(R.id.eye_close).setVisibility(View.VISIBLE);
                findViewById(R.id.Eye).setVisibility(View.INVISIBLE);
                findViewById(R.id.choice1).setVisibility(View.VISIBLE);
                findViewById(R.id.choice2).setVisibility(View.VISIBLE);
                findViewById(R.id.choice3).setVisibility(View.VISIBLE);
            }
        });
    }

}