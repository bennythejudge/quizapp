/**
 * IMPORTANT: Add your package below. Package name can be found in the project's AndroidManifest.xml file.
 * This is the package name our example uses:
 *
 * package com.example.android.justjava;
 *
 */
package com.example.android.quizapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.quizapp.R;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    int total_score     = 0;
    int right_answers   = 2;
    int quantity        = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void submitAnswers(View view) {
        int score = 0;
        final String placeOfBirth = "Anchiari";

        // question nr. 1
        // id = a1 - where was leonardo da vinci born
        String answer01 = ((EditText) findViewById(R.id.a1)).getText().toString();

        if (answer01.equalsIgnoreCase(placeOfBirth)) {
            score = score + 1;
            Log.d("main", "answer01 is right: " + answer01);
        }

        // questions nr. 2
        // final means it cannot be changed
        // 1, 2 and 4 are correct
        final CheckBox c1 = (CheckBox) findViewById(R.id.a2_1);
        if (c1.isChecked()) {
            Log.d("main", "c1 checkbox is true");
        }
        final CheckBox c2 = (CheckBox) findViewById(R.id.a2_2);
        if (c2.isChecked()) {
            Log.d("main", "c2 checkbox is true");
        }
        final CheckBox c3 = (CheckBox) findViewById(R.id.a2_3);
        if (c3.isChecked()) {
            Log.d("main", "c3 checkbox is true");
        }
        final CheckBox c4 = (CheckBox) findViewById(R.id.a2_4);
        if (c4.isChecked()) {
            Log.d("main", "c4 checkbox is true");
        }
        if ((c1.isChecked() || c2.isChecked() || c4.isChecked()) && !c3.isChecked()) {
            score = score + 1;
        }
        Log.d("main", "c1: " + c1.isChecked() + " c2: " + c2.isChecked() +
                " c3: " + c3.isChecked() + " c4: " + c4.isChecked());

        // questions nr. 3
        // Is the button now checked?
        RadioButton a3_1 = (RadioButton) findViewById(R.id.a3_1);
        RadioButton a3_2 = (RadioButton) findViewById(R.id.a3_2);
        RadioButton a3_3 = (RadioButton) findViewById(R.id.a3_3);
        RadioButton a3_4 = (RadioButton) findViewById(R.id.a3_4);

        Log.d("main", "a3_1: " + a3_1.isChecked());
        Log.d("main", "a3_2: " + a3_2.isChecked());
        Log.d("main", "a3_3: " + a3_3.isChecked());
        Log.d("main", "a3_4: " + a3_4.isChecked());

        if (a3_1.isChecked()) {
            score = score + 1;
        }

        // question nr.4
        Toast.makeText(this, "Your score is " + score,
        Toast.LENGTH_SHORT).show();
    }

    public void increment(View view) {
        if (quantity<100) {
            quantity++;
        } else {
            Toast.makeText(this, "Dude, it couldn't be more than 99!",
                    Toast.LENGTH_SHORT).show();
            return;
        }
        display(quantity);
    }

    public void decrement(View view) {
        if (quantity > 0) {
            quantity--;
        } else {
            Toast.makeText(this, "Dude, it can't be less than zero!", Toast.LENGTH_SHORT).show();
            return;
        }
        display(quantity);
    }

    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

}