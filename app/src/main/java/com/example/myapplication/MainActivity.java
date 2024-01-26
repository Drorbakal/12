package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import com.example.myapplication.R;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView result;
    float num1 = 0.0F;
    float num2 = 0.0F;
    Float start_num = 0.0F;
    char ch;

    String newres;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        result = findViewById(R.id.textView);
    }

    public void funcButton(View view) {
        Button button = (Button) view;
        String buttonText = button.getText().toString();
        if ("AC".equals(buttonText)) {
            result.setText("0");
            num1 = 0.0F;
            num2 = 0.0F;
        }
        else if ("+/-".equals(buttonText)) {
            String currentText = result.getText().toString();
            if (!"0".equals(currentText)) {
                if (currentText.contains("-")) {
                    // If the currentText already has a minus sign, remove it
                    currentText = currentText.replace("-", "");
                }
                else {
                    // If the currentText doesn't have a minus sign, add one at the beginning
                    currentText = "-" + currentText;
                }
                // Set the modified text back to the TextView
                result.setText(currentText);
            }
        }
        else if ("+".equals(buttonText)) {
            if (result != null) {
                try {
                    if (num1 == 0.0) {
                        num1 = Float.parseFloat((String) result.getText());
                        result.setText("0");
                    }
                    else {
                        num2 += Float.parseFloat((String) result.getText());
                        result.setText(String.valueOf(getAnswer(num1,num2,'+')));
                        num1 = Float.parseFloat((String) result.getText());
                        num2 = 0.0F;
                    }
                    ch = '+';
                }
                catch (NumberFormatException e) {
                    result.setText("ERROR");
                }
            }
        }
        else if ("-".equals(buttonText)) {
            if (result != null) {
                try {
                    if (num1 == 0.0) {
                        num1 = Float.parseFloat((String) result.getText());
                        result.setText("0");
                    }
                    else {
                        num2 += Float.parseFloat((String) result.getText());
                        result.setText(String.valueOf(getAnswer(num1,num2,'-')));
                        num1 = Float.parseFloat((String) result.getText());
                        num2 = 0.0F;
                    }
                    ch = '-';
                }
                catch (NumberFormatException e) {
                    result.setText("ERROR");
                }
            }
        }
        else if ("X".equals(buttonText)) {
            if (result != null) {
                try {
                    if (num1 == 0.0) {
                        num1 = Float.parseFloat((String) result.getText());
                        result.setText("0");
                    }
                    else {
                        num2 += Float.parseFloat((String) result.getText());
                        result.setText(String.valueOf(getAnswer(num1,num2,'X')));
                        num1 = Float.parseFloat((String) result.getText());
                        num2 = 0.0F;
                    }
                    ch = 'X';
                }
                catch (NumberFormatException e) {
                    result.setText("ERROR");
                }
            }
        }
        else if ("/".equals(buttonText)) {
            if (result != null) {
                try {
                    if (num1 == 0.0) {
                        num1 = Float.parseFloat((String) result.getText());
                        result.setText("0");
                    }
                    else {
                        num2 += Float.parseFloat((String) result.getText());
                        if(num2 == 0){
                            result.setText("ERROR");
                        }
                        else {
                            result.setText(String.valueOf(getAnswer(num1, num2, '/')));
                            num1 = Float.parseFloat((String) result.getText());
                            num2 = 0.0F;
                        }
                    }
                    ch = '/';
                }
                catch (NumberFormatException e) {
                    result.setText("ERROR");
                }
            }
        }
        else if ("%".equals(buttonText)) {
            if (result != null) {
                try {
                    if (num1 == 0.0) {
                        num1 = Float.parseFloat((String) result.getText());
                        num1 = num1 / 100;
                        result.setText(String.valueOf(num1));
                    } else {
                        num2 = Float.parseFloat((String) result.getText())/100;
                        result.setText(String.valueOf(num2));
                    }
                }
                catch (NumberFormatException e) {
                    result.setText("ERROR");
                }
            }
        }
        else if ("=".equals(buttonText)) {
            if (result != null) {
                try {
                    if (num1 == 0.0) {
                        num1 = Float.parseFloat((String) result.getText());
                        result.setText("0");
                    } else {
                        num2 = Float.parseFloat((String) result.getText());
                        if (ch == '+') {
                            result.setText(String.valueOf(getAnswer(num1, num2, '+')));
                            num1 = Float.parseFloat((String) result.getText());
                        } else if (ch == '-') {
                            result.setText(String.valueOf(getAnswer(num1, num2, '-')));
                            num1 = Float.parseFloat((String) result.getText());
                        }
                        else if (ch == 'X') {
                            result.setText(String.valueOf(getAnswer(num1, num2, 'X')));
                            num1 = Float.parseFloat((String) result.getText());
                        }
                        else if (ch == '/') {
                            if (num2 == 0.0F){
                                result.setText("ERROR");
                            }
                            else {
                                result.setText(String.valueOf(getAnswer(num1, num2, '/')));
                                num1 = Float.parseFloat((String) result.getText());
                            }
                        }
                    }
                }
                catch (NumberFormatException e) {
                    result.setText("ERROR");
                }
            }
            num2 = 0.0F;
            ch = 'F';
            start_num = num1;
            num1 = 0.0F;
        }
        else {// Get the current text from the TextView
            String currentText = result.getText().toString();
            if ("0".equals(currentText)) {
                result.setText(buttonText); // If it is "0", replace it with the button text
            }
            else if (result.getText().equals(String.valueOf(num1))) {
                result.setText(""); // Clear the text
                result.setText(buttonText); // Set the new text
            }
            else {
                result.setText(currentText + buttonText); // Otherwise, append the button text
            }
        }
    }

    public float getAnswer(float num1, float num2, char ch) {
        float result = 0.0F;
        if (ch == '+') {
            result = num1 + num2;
        }
        else if (ch == '-') {
            result = num1 - num2;
        }
        else if (ch == 'X') {
            result = num1 * num2;
        }
        else if (ch == '/') {
            result = num1 / num2;
        }
        else if (ch == '%') {
            result = result;
        }
        return result;
    }
}


