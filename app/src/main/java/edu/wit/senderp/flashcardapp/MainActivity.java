package edu.wit.senderp.flashcardapp;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;



import android.widget.TextView;

import org.w3c.dom.Text;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*
        Add card button
         */

        findViewById(R.id.add).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView addQ = (TextView) findViewById(R.id.flashcar_question);
                TextView addA = (TextView) findViewById(R.id.flashcard_answer);
                TextView addO1 = (TextView) findViewById(R.id.choice1);
                TextView addO2 = (TextView) findViewById(R.id.choice2);
               Intent i = new Intent(MainActivity.this, AddCardActivity.class);
                Bundle bundle = new Bundle();
                String clicked = "nope";
                bundle.putString("stringKey1", addQ.getText().toString());
                bundle.putString("stringKey1", addQ.getText().toString());
                bundle.putString("stringKey2", addA.getText().toString());
                bundle.putString("stringKey3", addO1.getText().toString());
                bundle.putString("stringKey4", addO2.getText().toString());
                bundle.putString("clickedKey", clicked);


                i.putExtras(bundle);
                MainActivity.this.startActivityForResult(i, 100);

            }
        });
        /*
        Edit button
         */
        findViewById(R.id.add_text).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView addQ = (TextView) findViewById(R.id.flashcar_question);
                TextView addA = (TextView) findViewById(R.id.flashcard_answer);
                TextView addO1 = (TextView) findViewById(R.id.choice1);
                TextView addO2 = (TextView) findViewById(R.id.choice2);
                Intent i = new Intent(MainActivity.this, AddCardActivity.class);
                Bundle bundle = new Bundle();
                String clicked = "nope";
                bundle.putString("stringKey1", addQ.getText().toString());
                bundle.putString("stringKey1", addQ.getText().toString());
                bundle.putString("stringKey2", addA.getText().toString());
                bundle.putString("stringKey3", addO1.getText().toString());
                bundle.putString("stringKey4", addO2.getText().toString());
                bundle.putString("clickedKey", clicked);


                i.putExtras(bundle);
                MainActivity.this.startActivityForResult(i, 100);

            }
        });
        findViewById(R.id.edit).setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {


                TextView addQ = (TextView) findViewById(R.id.flashcar_question);
                TextView addA = (TextView) findViewById(R.id.flashcard_answer);
                TextView addO1 = (TextView) findViewById(R.id.choice1);
                TextView addO2 = (TextView) findViewById(R.id.choice2);
                Intent i = new Intent(MainActivity.this, AddCardActivity.class);
                Bundle bundle = new Bundle();
                String clicked = "clicked";
                bundle.putString("stringKey1", addQ.getText().toString());
                bundle.putString("stringKey2", addA.getText().toString());
                bundle.putString("stringKey3", addO1.getText().toString());
                bundle.putString("stringKey4", addO2.getText().toString());
                    bundle.putString("clickedKey", clicked);
                    i.putExtras(bundle);

                MainActivity.this.startActivityForResult(i, 100);
            }
        });
        findViewById(R.id.edit_text).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView addQ = (TextView) findViewById(R.id.flashcar_question);
                TextView addA = (TextView) findViewById(R.id.flashcard_answer);
                TextView addO1 = (TextView) findViewById(R.id.choice1);
                TextView addO2 = (TextView) findViewById(R.id.choice2);
                Intent i = new Intent(MainActivity.this, AddCardActivity.class);
                Bundle bundle = new Bundle();
                String clicked = "clicked";
                bundle.putString("stringKey1", addQ.getText().toString());
                bundle.putString("stringKey2", addA.getText().toString());
                bundle.putString("stringKey3", addO1.getText().toString());
                bundle.putString("stringKey4", addO2.getText().toString());
                bundle.putString("clickedKey", clicked);
                i.putExtras(bundle);


                MainActivity.this.startActivityForResult(i, 100);
            }
        });



        findViewById(R.id.background).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findViewById(R.id.choice1).setBackgroundColor(getResources().getColor(R.color.transparent));
                findViewById(R.id.choice2).setBackgroundColor(getResources().getColor(R.color.transparent));
                findViewById(R.id.choice3).setBackgroundColor(getResources().getColor(R.color.transparent));

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

    protected void onActivityResult(int requestCode, int resultCode, Intent save) {
        if (resultCode == 100) {
            if (requestCode == 100) {
                String string1 = save.getExtras().getString("string1");
                String string2 = save.getExtras().getString("string2");
                String string3 = save.getExtras().getString("string3");
                String string4 = save.getExtras().getString("string4");

                ((TextView) findViewById(R.id.flashcar_question)).setText(string1.trim());
                ((TextView) findViewById(R.id.flashcard_answer)).setText(string2.trim());
                ((TextView) findViewById(R.id.choice3)).setText(string2);
                ((TextView) findViewById(R.id.choice2)).setText(string3);
                ((TextView) findViewById(R.id.choice1)).setText(string4);
                findViewById(R.id.eye_close).setVisibility(View.VISIBLE);
                findViewById(R.id.choice3).setVisibility(View.INVISIBLE);





                Snackbar.make(findViewById(R.id.flashcar_question),
                        "Card Successfully Created",
                        Snackbar.LENGTH_SHORT)
                        .show();
            }
        }


    }

}