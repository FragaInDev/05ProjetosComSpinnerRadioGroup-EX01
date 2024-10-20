/*
 *@author: Bruno Fraga
 */

// MainActivity.java
package com.fraga.ex01_05projetoscomspinnerradiogroups;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    // Bruno Fraga - RA: 1110482112016

    private RadioGroup radioGroupFaces;
    private Spinner spinnerDiceCount;
    private TextView resultText1, resultText2, resultText3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroupFaces = findViewById(R.id.radioGroupFaces);
        spinnerDiceCount = findViewById(R.id.spinnerDiceCount);
        Button buttonRoll = findViewById(R.id.buttonRoll);
        resultText1 = findViewById(R.id.resultText1);
        resultText2 = findViewById(R.id.resultText2);
        resultText3 = findViewById(R.id.resultText3);

        buttonRoll.setOnClickListener(v -> rollDice());
    }

    private void rollDice() {
        int selectedFaceId = radioGroupFaces.getCheckedRadioButtonId();
        RadioButton selectedRadioButton = findViewById(selectedFaceId);
        if (selectedRadioButton == null) {
            Toast.makeText(this, "Por favor, escolha o tipo de dado", Toast.LENGTH_SHORT).show();
            return;
        }

        int numberOfFaces = Integer.parseInt(selectedRadioButton.getText().toString().substring(1));
        int diceCount = Integer.parseInt(spinnerDiceCount.getSelectedItem().toString());

        Random random = new Random();

        switch (diceCount) {
            case 1:
                resultText1.setText(String.valueOf(random.nextInt(numberOfFaces) + 1));
                resultText2.setVisibility(View.GONE);
                resultText3.setVisibility(View.GONE);
                break;
            case 2:
                resultText1.setText(String.valueOf(random.nextInt(numberOfFaces) + 1));
                resultText2.setText(String.valueOf(random.nextInt(numberOfFaces) + 1));
                resultText1.setVisibility(View.VISIBLE);
                resultText2.setVisibility(View.VISIBLE);
                resultText3.setVisibility(View.GONE);
                break;
            case 3:
                resultText1.setText(String.valueOf(random.nextInt(numberOfFaces) + 1));
                resultText2.setText(String.valueOf(random.nextInt(numberOfFaces) + 1));
                resultText3.setText(String.valueOf(random.nextInt(numberOfFaces) + 1));
                resultText1.setVisibility(View.VISIBLE);
                resultText2.setVisibility(View.VISIBLE);
                resultText3.setVisibility(View.VISIBLE);
                break;
        }
    }
}
