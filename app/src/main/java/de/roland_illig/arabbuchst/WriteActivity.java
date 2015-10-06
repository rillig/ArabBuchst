package de.roland_illig.arabbuchst;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;
import java.util.Random;

public class WriteActivity extends AppCompatActivity {

    private final List<TrainingData.WordPair> wordPairs = new TrainingData().loadWordPairs();
    private final Random rnd = new Random();
    private TrainingData.WordPair wordPair;
    private TextView given;
    private EditText answer;
    private TextView wrong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write);
        given = (TextView) findViewById(R.id.given);
        answer = (EditText) findViewById(R.id.answerText);
        wrong = (TextView) findViewById(R.id.wrongLabel);
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
        if (wordPair.ar.equals(answer.getText().toString())) {
            nextWord();
        } else {
            wrong.setVisibility(View.VISIBLE);
        }
    }

    public void onSkipClick(View view) {
        nextWord();
    }

    private void nextWord() {
        TrainingData.WordPair prev = wordPair;
        do {
            wordPair = wordPairs.get(rnd.nextInt(wordPairs.size()));
        } while (prev == wordPair);
        given.setText(wordPair.ar);
        answer.setText("");
        if (answer.requestFocus()) {
            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        }
    }

    private void onGivenClick() {
        if (given.getText().toString().equals(wordPair.ar)) {
            given.setText(wordPair.de);
        } else {
            given.setText(wordPair.ar);
        }
    }

    private void onAnswerChanged() {
        wrong.setVisibility(View.INVISIBLE);
    }
}
