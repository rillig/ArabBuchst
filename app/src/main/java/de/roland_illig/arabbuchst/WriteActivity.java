package de.roland_illig.arabbuchst;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;
import java.util.Random;

public class WriteActivity extends Activity {

    private final List<TrainingData.WordPair> wordPairs = new TrainingData().loadWordPairs();
    private final Random rnd = new Random();
    private TrainingData.WordPair wordPair;
    private TextView given;
    private EditText answer;
    private TextView wrong;
    private TextView correct;
    private int displayMode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write);
        given = (TextView) findViewById(R.id.given);
        answer = (EditText) findViewById(R.id.answerText);
        wrong = (TextView) findViewById(R.id.wrongLabel);
        correct = (TextView) findViewById(R.id.correctLabel);
        given.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onGivenClick();
            }
        });
        answer.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                onAnswerChanged();
            }
        });
        nextWord();
    }

    public void onCheckClick(View view) {
        String reVowels = "[\u0618\u0619\u061A\u064E\u064F\u0650\u0652]";
        String arNoVowels = wordPair.ar.replaceAll(reVowels, "");
        String answerNoVowels = answer.getText().toString().replaceAll(reVowels, "");
        boolean isCorrect = arNoVowels.equals(answerNoVowels);
        if (isCorrect)
            nextWord();
        correct.setVisibility(isCorrect ? View.VISIBLE : View.INVISIBLE);
        wrong.setVisibility(isCorrect ? View.INVISIBLE : View.VISIBLE);
    }

    public void onSkipClick(View view) {
        nextWord();
    }

    private void nextWord() {
        TrainingData.WordPair prev = wordPair;
        do {
            wordPair = wordPairs.get(rnd.nextInt(wordPairs.size()));
        } while (prev == wordPair);
        displayMode = 0;
        updateGiven();
        answer.setText("");
        if (answer.requestFocus()) {
            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        }
    }

    private void onGivenClick() {
        displayMode = (displayMode + 1) % 3;
        updateGiven();
    }

    private void updateGiven() {
        given.setText(displayMode == 0
                ? wordPair.ar
                : displayMode == 1
                ? Transliterator.arabicToLatin(wordPair.ar)
                : wordPair.de);
        given.setGravity(displayMode == 1 ? Gravity.CENTER_HORIZONTAL : Gravity.NO_GRAVITY);
    }

    private void onAnswerChanged() {
        correct.setVisibility(View.INVISIBLE);
        wrong.setVisibility(View.INVISIBLE);
    }
}
