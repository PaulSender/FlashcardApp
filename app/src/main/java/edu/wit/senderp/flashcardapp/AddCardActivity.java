package edu.wit.senderp.flashcardapp;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class AddCardActivity extends Activity {

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_card);


        String clicked = getIntent().getExtras().getString("clickedKey");
        //If the edit Button is clicked code----------------
        if (clicked.equals("clicked")) {
            Bundle bundle = this.getIntent().getExtras();
            String s1 = bundle.getString("stringKey1");
            String s2 = bundle.getString("stringKey2");
            String s3 = bundle.getString("stringKey3");
            String s4 = bundle.getString("stringKey4");

            ((EditText) findViewById(R.id.add_question)).setText(s1);
            ((EditText) findViewById(R.id.add_answer)).setText(s2);
            ((EditText) findViewById(R.id.optionOne)).setText(s3);
            ((EditText) findViewById(R.id.optionTwo)).setText(s4);
              /*
        cancel button
            */
            findViewById(R.id.cancel).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();

                }
            });
        /*
        Save button
            */
            findViewById(R.id.save).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    EditText add_wrong1 = (EditText) findViewById(R.id.optionOne);
                    EditText add_wrong2 = (EditText) findViewById(R.id.optionTwo);
                    EditText add_question = (EditText) findViewById(R.id.add_question);
                    EditText add_answer = (EditText) findViewById(R.id.add_answer);
                    String getQuestion = add_question.getText().toString();
                    String getAnswer = add_answer.getText().toString();
                    String getWrong1 = add_wrong1.getText().toString();
                    String getWtong2 = add_wrong2.getText().toString();
                    if (!getQuestion.equals("") && !getAnswer.equals("")) {
                        if((getWrong1.equals("") && !getWtong2.equals("")) || (!getWrong1.equals("") && getWtong2.equals(""))) {
                            Toast toast = Toast.makeText(getApplicationContext(), "Both options need to be filled", Toast.LENGTH_LONG);
                            toast.setGravity(Gravity.BOTTOM, 0, 200);
                            toast.show();
                        }
                        else if(getWrong1.equals("") && getWtong2.equals("")) {
                            Intent save = new Intent();
                            save.putExtra("string1", getQuestion);
                            save.putExtra("string2", getAnswer);
                            setResult(100, save);
                            finish();
                        }
                        else {
                            Intent save = new Intent();
                            save.putExtra("string1", getQuestion);
                            save.putExtra("string2", getAnswer);
                            save.putExtra("string3", getWrong1);
                            save.putExtra("string4", getWtong2);
                            setResult(100, save);
                            finish();
                        }
                    } else {
                        Toast toast = Toast.makeText(getApplicationContext(), "Both question and answer needs to be filled", Toast.LENGTH_LONG);
                        toast.setGravity(Gravity.BOTTOM, 0, 200);
                        toast.show();
                    }

                }
            });

        }
        //If add button is clicked--------------------------
        else {
             /*
        cancel button
            */
            findViewById(R.id.cancel).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();

                }
            });
        /*
        Save button
         */
            findViewById(R.id.save).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    EditText add_wrong1 = (EditText) findViewById(R.id.optionOne);
                    EditText add_wrong2 = (EditText) findViewById(R.id.optionTwo);
                    EditText add_question = (EditText) findViewById(R.id.add_question);
                    EditText add_answer = (EditText) findViewById(R.id.add_answer);
                    String getQuestion = add_question.getText().toString();
                    String getAnswer = add_answer.getText().toString();
                    String getWrong1 = add_wrong1.getText().toString();
                    String getWtong2 = add_wrong2.getText().toString();
                    if (!getQuestion.equals("") && !getAnswer.equals("")) {
                        if((getWrong1.equals("") && !getWtong2.equals("")) || (!getWrong1.equals("") && getWtong2.equals(""))) {
                            Toast toast = Toast.makeText(getApplicationContext(), "Both options need to be filled", Toast.LENGTH_LONG);
                            toast.setGravity(Gravity.BOTTOM, 0, 200);
                            toast.show();
                        }
                        else if(getWrong1.equals("") && getWtong2.equals("")) {
                            Intent save = new Intent();
                            save.putExtra("string1", getQuestion);
                            save.putExtra("string2", getAnswer);
                            setResult(100, save);
                            finish();
                        }
                        else {
                            Intent save = new Intent();
                            save.putExtra("string1", getQuestion);
                            save.putExtra("string2", getAnswer);
                            save.putExtra("string3", getWrong1);
                            save.putExtra("string4", getWtong2);
                            setResult(100, save);
                            finish();
                        }
                    } else {
                        Toast toast = Toast.makeText(getApplicationContext(), "Both question and answer needs to be filled", Toast.LENGTH_LONG);
                        toast.setGravity(Gravity.BOTTOM, 0, 200);
                        toast.show();
                    }

                }
            });
        }
    }

    }








