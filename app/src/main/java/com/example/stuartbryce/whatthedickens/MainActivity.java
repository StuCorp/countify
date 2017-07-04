package com.example.stuartbryce.whatthedickens;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText entryBox;
    Button submitButton;
    TextView responseBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        entryBox = (EditText) findViewById(R.id.entry_box);
        submitButton = (Button) findViewById(R.id.submit_button);
        responseBox = (TextView) findViewById(R.id.response_box);
    }

    public void onSubmitButtonClicked(View button) {
        String sentence = entryBox.getText().toString();
        Log.d("Countify", sentence);

        int count = StringDoer.countString(sentence);
        String response = String.format("%d words", count);
        String summary = StringDoer.allFunctionCall(sentence);
        String fullSummary = response + " List: " + summary;
//        Answers answers = new Answers();
        responseBox.setText(fullSummary);
    }
}
