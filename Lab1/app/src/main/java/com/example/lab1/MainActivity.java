package com.example.lab1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // текстовое поле для вывода результата
    TextView resultField;

    // поле для ввода числа
    EditText numberField;

    // операнд операции
    Double operand = null;

    // последняя операция
    String lastOperation = "=";

    // кнопка, которая очищает поля
    Button clearButton;

    private boolean flag = true;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        resultField = findViewById(R.id.resultField);
        numberField = findViewById(R.id.numberField);
        clearButton = findViewById(R.id.clear);

        clearButton.setOnClickListener(v -> {
            numberField.setText("");
            resultField.setText("");
            operand = null;
        });
    }

    public void onNumberClick(View view) {
        Button button = (Button) view;
        numberField.append(button.getText());

        if(lastOperation.equals("=") && operand!=null){
            operand = null;
        }
    }

    public void onOperationClick(View view){

        Button button = (Button)view;
        String op = button.getText().toString();
        String number = numberField.getText().toString();

        // если введенно что-нибудь
        if(number.length()>0){
            number = number.replace(',', '.');
            try{
                performOperation(Double.valueOf(number), op);
            }catch (NumberFormatException ex){
                numberField.setText("");
            }
        }
        lastOperation = op;
    }

    @SuppressLint("SetTextI18n")
    private void performOperation(Double number, String operation){

        // если операнд ранее не был установлен (при вводе самой первой операции)
        if(operand == null){
            operand = number;
        }
        else{
            if(lastOperation.equals("=")){
                lastOperation = operation;
            }
            switch(lastOperation){
                case "=":
                    operand =number;
                    break;
                case "/":
                    if(number==0){
                        flag = false;
                    }
                    else{
                        operand /=number;
                    }
                    break;
                case "*":
                    operand *=number;
                    break;
                case "+":
                    operand +=number;
                    break;
                case "-":
                    operand -=number;
                    break;
            }
        }
        if (flag) {
            resultField.setText(operand.toString().replace('.', ','));
        } else {
            resultField.setText("Неверный формат");
            flag = true;
        }
        numberField.setText("");
    }
}
