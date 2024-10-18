package com.example.myapplication;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText etDisplay;
    private double firstNumber = 0;
    private double secondNumber = 0;
    private String operation = "";
    private boolean isNewOperation = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etDisplay = findViewById(R.id.etDisplay);

        // общие обработчики для кнопок
        View.OnClickListener numberClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button button = (Button) v;
                String buttonText = button.getText().toString();

                if (isNewOperation) {
                    etDisplay.setText(buttonText);
                    isNewOperation = false;
                } else {
                    etDisplay.append(buttonText);
                }
            }
        };

        findViewById(R.id.btn0).setOnClickListener(numberClickListener);
        findViewById(R.id.btn1).setOnClickListener(numberClickListener);
        findViewById(R.id.btn2).setOnClickListener(numberClickListener);
        findViewById(R.id.btn3).setOnClickListener(numberClickListener);
        findViewById(R.id.btn4).setOnClickListener(numberClickListener);
        findViewById(R.id.btn5).setOnClickListener(numberClickListener);
        findViewById(R.id.btn6).setOnClickListener(numberClickListener);
        findViewById(R.id.btn7).setOnClickListener(numberClickListener);
        findViewById(R.id.btn8).setOnClickListener(numberClickListener);
        findViewById(R.id.btn9).setOnClickListener(numberClickListener);

        findViewById(R.id.btnAdd).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleOperation("+");
            }
        });

        findViewById(R.id.btnSubtract).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleOperation("-");
            }
        });

        findViewById(R.id.btnMultiply).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleOperation("*");
            }
        });

        findViewById(R.id.btnDivide).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleOperation("/");
            }
        });

        findViewById(R.id.btnC).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etDisplay.setText("0");
                firstNumber = 0;
                secondNumber = 0;
                operation = "";
                isNewOperation = true;
            }
        });

        findViewById(R.id.btnEquals).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                secondNumber = Double.parseDouble(etDisplay.getText().toString());
                double result = 0;

                switch (operation) {
                    case "+":
                        result = firstNumber + secondNumber;
                        break;
                    case "-":
                        result = firstNumber - secondNumber;
                        break;
                    case "*":
                        result = firstNumber * secondNumber;
                        break;
                    case "/":
                        if (secondNumber != 0) {
                            result = firstNumber / secondNumber;
                        } else {
                            etDisplay.setText("Ошибка");
                            return;
                        }
                        break;
                }

                etDisplay.setText(String.valueOf(result));
                isNewOperation = true;
            }
        });
    }

    // Метод для установки операции и сохранения первого числа
    private void handleOperation(String op) {
        firstNumber = Double.parseDouble(etDisplay.getText().toString());
        operation = op;
        isNewOperation = true;
    }
}