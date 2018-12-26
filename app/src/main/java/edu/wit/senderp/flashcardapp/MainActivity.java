package edu.wit.senderp.flashcardapp;

import android.animation.Animator;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;


import android.view.ViewAnimationUtils;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;


import java.util.List;

import at.wirecube.additiveanimations.additive_animator.AdditiveAnimation;
import at.wirecube.additiveanimations.additive_animator.AdditiveAnimator;


public class MainActivity extends AppCompatActivity {
    FlashcardDatabase flashcardDatabase;
    List<Flashcard> allFlashcards;

    int currentCardDisplayedIndex;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        flashcardDatabase = new FlashcardDatabase(getApplicationContext());
        allFlashcards = flashcardDatabase.getAllCards();
        currentCardDisplayedIndex = allFlashcards.size();
        String initial_setup = getString(R.string.initial_setup);


        /*
        Initial create
        */
        if (allFlashcards != null && allFlashcards.size() > 0) {
            ((TextView) findViewById(R.id.flashcard_question)).setText(allFlashcards.get(0).getQuestion());
            ((TextView) findViewById(R.id.flashcard_answer)).setText(allFlashcards.get(0).getAnswer());
            findViewById(R.id.delete).setVisibility(View.VISIBLE);
            findViewById(R.id.delete_text).setVisibility(View.VISIBLE);
            findViewById(R.id.next).setVisibility(View.VISIBLE);
            findViewById(R.id.next_text).setVisibility(View.VISIBLE);
            findViewById(R.id.edit).setVisibility(View.VISIBLE);
            findViewById(R.id.edit_text).setVisibility(View.VISIBLE);

        }
        else {
            ((TextView) findViewById(R.id.flashcard_question)).setText(initial_setup);
            ((TextView) findViewById(R.id.flashcard_answer)).setText(initial_setup);
        }

        /*
        Delete Button
         */

        findViewById(R.id.delete).setOnClickListener(new View.OnClickListener() {
            String initial_setup = getString(R.string.initial_setup);
            @Override
            public void onClick(View v) {
                flashcardDatabase.deleteCard(((TextView) findViewById(R.id.flashcard_question)).getText().toString());
                allFlashcards.remove(allFlashcards.get(currentCardDisplayedIndex));
                if (currentCardDisplayedIndex >  0) {
                    currentCardDisplayedIndex--;
                }
                else {
                    currentCardDisplayedIndex++;
                }

                if (allFlashcards != null && allFlashcards.size() > 0) {
                    ((TextView) findViewById(R.id.flashcard_question)).setText(allFlashcards.get(currentCardDisplayedIndex).getQuestion());
                    ((TextView) findViewById(R.id.flashcard_answer)).setText(allFlashcards.get(currentCardDisplayedIndex).getAnswer());
                    if (allFlashcards.size() <=  1) {
                        findViewById(R.id.delete).setVisibility(View.INVISIBLE);
                        findViewById(R.id.delete_text).setVisibility(View.INVISIBLE);
                        findViewById(R.id.next).setVisibility(View.INVISIBLE);
                        findViewById(R.id.next_text).setVisibility(View.INVISIBLE);
                        findViewById(R.id.edit).setVisibility(View.INVISIBLE);
                        findViewById(R.id.edit_text).setVisibility(View.INVISIBLE);
                    }
                } else {
                    ((TextView) findViewById(R.id.flashcard_question)).setText(initial_setup);
                    ((TextView) findViewById(R.id.flashcard_answer)).setText(initial_setup);
                }

            }
        });

        /*
        Next Button
         */

        findViewById(R.id.next).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*
                Animations
                 */
                final Animation leftOutAnimation = AnimationUtils.loadAnimation(v.getContext(), R.anim.left_out);
                final Animation rightInAnim = AnimationUtils.loadAnimation(v.getContext(), R.anim.right_in);
                if (findViewById(R.id.flashcard_question).getVisibility() == View.VISIBLE) {
                    findViewById(R.id.flashcard_question).startAnimation(leftOutAnimation);
                    leftOutAnimation.setAnimationListener(new Animation.AnimationListener() {
                        @Override
                        public void onAnimationStart(Animation animation) {

                        }

                        @Override
                        public void onAnimationEnd(Animation animation) {
                            findViewById(R.id.flashcard_question).startAnimation(rightInAnim);
                            ((TextView) findViewById(R.id.flashcard_question)).setText(allFlashcards.get(currentCardDisplayedIndex).getQuestion());
                            ((TextView) findViewById(R.id.flashcard_answer)).setText(allFlashcards.get(currentCardDisplayedIndex).getAnswer());

                        }

                        @Override
                        public void onAnimationRepeat(Animation animation) {

                        }
                    });

                    currentCardDisplayedIndex++;

                    if (currentCardDisplayedIndex > allFlashcards.size() - 1) {
                        currentCardDisplayedIndex = 0;
                    }
                }
                else {
                    findViewById(R.id.flashcard_answer).startAnimation(leftOutAnimation);
                    leftOutAnimation.setAnimationListener(new Animation.AnimationListener() {
                        @Override
                        public void onAnimationStart(Animation animation) {

                        }

                        @Override
                        public void onAnimationEnd(Animation animation) {
                            findViewById(R.id.flashcard_answer).startAnimation(rightInAnim);
                            ((TextView) findViewById(R.id.flashcard_answer)).setText(allFlashcards.get(currentCardDisplayedIndex).getAnswer());
                            ((TextView) findViewById(R.id.flashcard_question)).setText(allFlashcards.get(currentCardDisplayedIndex).getQuestion());

                        }

                        @Override
                        public void onAnimationRepeat(Animation animation) {

                        }
                    });

                    currentCardDisplayedIndex++;

                    if (currentCardDisplayedIndex > allFlashcards.size() - 1) {
                        currentCardDisplayedIndex = 0;
                    }
                }


            }
        });

        /*
        Add card button
         */

        findViewById(R.id.add).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView addQ = (TextView) findViewById(R.id.flashcard_question);
                TextView addA = (TextView) findViewById(R.id.flashcard_answer);
                //Commented out for multiple choice
                //TextView addO1 = (TextView) findViewById(R.id.choice1);
                //TextView addO2 = (TextView) findViewById(R.id.choice2);
                Intent i = new Intent(MainActivity.this, AddCardActivity.class);
                Bundle bundle = new Bundle();
                String clicked = "nope";
                bundle.putString("stringKey1", addQ.getText().toString());
                bundle.putString("stringKey2", addA.getText().toString());
                //
                //bundle.putString("stringKey3", addO1.getText().toString());
                //bundle.putString("stringKey4", addO2.getText().toString());
                bundle.putString("clickedKey", clicked);


                i.putExtras(bundle);
                MainActivity.this.startActivityForResult(i, 100);
                overridePendingTransition(R.anim.right_in, R.anim.left_out);

            }
        });
        /*
        Edit button
         */
        findViewById(R.id.add_text).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView addQ = (TextView) findViewById(R.id.flashcard_question);
                TextView addA = (TextView) findViewById(R.id.flashcard_answer);
                //
                //TextView addO1 = (TextView) findViewById(R.id.choice1);
                //TextView addO2 = (TextView) findViewById(R.id.choice2);
                Intent i = new Intent(MainActivity.this, AddCardActivity.class);
                Bundle bundle = new Bundle();
                String clicked = "nope";
                bundle.putString("stringKey1", addQ.getText().toString());
                bundle.putString("stringKey1", addQ.getText().toString());
                bundle.putString("stringKey2", addA.getText().toString());
                //
                //bundle.putString("stringKey3", addO1.getText().toString());
                //bundle.putString("stringKey4", addO2.getText().toString());
                bundle.putString("clickedKey", clicked);


                i.putExtras(bundle);
                MainActivity.this.startActivityForResult(i, 100);


            }
        });
        findViewById(R.id.edit).setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {


                TextView addQ = (TextView) findViewById(R.id.flashcard_question);
                TextView addA = (TextView) findViewById(R.id.flashcard_answer);
                //
                //TextView addO1 = (TextView) findViewById(R.id.choice1);
                //TextView addO2 = (TextView) findViewById(R.id.choice2);
                Intent i = new Intent(MainActivity.this, AddCardActivity.class);
                Bundle bundle = new Bundle();
                String clicked = "clicked";
                bundle.putString("stringKey1", addQ.getText().toString());
                bundle.putString("stringKey2", addA.getText().toString());
                //
                //bundle.putString("stringKey3", addO1.getText().toString());
                //bundle.putString("stringKey4", addO2.getText().toString());
                bundle.putString("clickedKey", clicked);
                i.putExtras(bundle);

                MainActivity.this.startActivityForResult(i, 100);
                overridePendingTransition(R.anim.right_in, R.anim.left_out);
            }
        });
        findViewById(R.id.edit_text).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView addQ = (TextView) findViewById(R.id.flashcard_question);
                TextView addA = (TextView) findViewById(R.id.flashcard_answer);
                //
                //TextView addO1 = (TextView) findViewById(R.id.choice1);
                //TextView addO2 = (TextView) findViewById(R.id.choice2);
                Intent i = new Intent(MainActivity.this, AddCardActivity.class);
                Bundle bundle = new Bundle();
                String clicked = "clicked";
                bundle.putString("stringKey1", addQ.getText().toString());
                bundle.putString("stringKey2", addA.getText().toString());
                //
                //bundle.putString("stringKey3", addO1.getText().toString());
                //bundle.putString("stringKey4", addO2.getText().toString());
                bundle.putString("clickedKey", clicked);
                i.putExtras(bundle);


                MainActivity.this.startActivityForResult(i, 100);
            }
        });
    }

/*
    Reset background - Commented out Version 5.

        findViewById(R.id.background).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findViewById(R.id.choice1).setBackgroundColor(getResources().getColor(R.color.transparent));
                findViewById(R.id.choice2).setBackgroundColor(getResources().getColor(R.color.transparent));
                findViewById(R.id.choice3).setBackgroundColor(getResources().getColor(R.color.transparent));

            }
        });


    }
    */
/*
    showAnswer, Question to invs
 */
        public void showAnswer (View v){
            findViewById(R.id.flashcard_question).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    View answerSideView = findViewById(R.id.flashcard_answer);
                    //get center for the clipping circle
                 /*    int cx = answerSideView.getWidth() / 2;
                    int cy = answerSideView.getHeight() / 2;

                    //get final radius for the clipping circle
                    float finalRadius = (float) Math.hypot(cx, cy);

                    // create the animator for this view (the start radius is zero)
                    Animator anim = ViewAnimationUtils.createCircularReveal(answerSideView, cx, cy, 0f, finalRadius);


                    //hide the question and show the answer to prepare for playing the animaiton!
                    findViewById(R.id.flashcard_question).setVisibility(View.INVISIBLE);
                    answerSideView.setVisibility(View.VISIBLE);

                    anim.setDuration(1000);
                    anim.start();

                    */
                 //findViewById(R.id.reveal_icon).setVisibility(View.VISIBLE);
                 Animation fadeOut = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_out);
                // findViewById(R.id.reveal_icon).startAnimation(fadeOut);
                }
            });
        }
/*
    show Question , Answer to invs
 */
        public void showQuestion (View v){
            findViewById(R.id.flashcard_answer).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    findViewById(R.id.flashcard_question).setVisibility(View.VISIBLE);
                    findViewById(R.id.flashcard_answer).setVisibility(View.INVISIBLE);
                }
            });

        }


/* Wrong, show, hide, correct funtionality commented out Version 5.
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
    */

        protected void onActivityResult ( int requestCode, int resultCode, Intent save){
            if (resultCode == 100) {
                if (requestCode == 100) {
                    String string1 = save.getExtras().getString("string1");
                    String string2 = save.getExtras().getString("string2");
                    //
                    //String string3 = save.getExtras().getString("string3");
                    //String string4 = save.getExtras().getString("string4");

                    ((TextView) findViewById(R.id.flashcard_question)).setText(string1.trim());
                    ((TextView) findViewById(R.id.flashcard_answer)).setText(string2.trim());
                    if (allFlashcards.size() >=  1) {
                        findViewById(R.id.delete).setVisibility(View.VISIBLE);
                        findViewById(R.id.delete_text).setVisibility(View.VISIBLE);
                        findViewById(R.id.next).setVisibility(View.VISIBLE);
                        findViewById(R.id.next_text).setVisibility(View.VISIBLE);
                        findViewById(R.id.edit).setVisibility(View.VISIBLE);
                        findViewById(R.id.edit_text).setVisibility(View.VISIBLE);
                    }
                    //
                /*
                ((TextView) findViewById(R.id.choice3)).setText(string2);
                ((TextView) findViewById(R.id.choice2)).setText(string3);
                ((TextView) findViewById(R.id.choice1)).setText(string4);
                findViewById(R.id.eye_close).setVisibility(View.VISIBLE);
                findViewById(R.id.choice3).setVisibility(View.INVISIBLE);
                */


                    Snackbar.make(findViewById(R.id.flashcard_question),
                            "Card Successfully Created",
                            Snackbar.LENGTH_SHORT)
                            .show();

                    flashcardDatabase.insertCard(new Flashcard(string1, string2));

                    allFlashcards = flashcardDatabase.getAllCards();
                    //currentCardDisplayedIndex++;
                }
            }


        }

}