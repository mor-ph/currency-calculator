package com.example.currency_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button calc, clear;
    EditText price, currency, amount;
    TextView fullresult;

    private void initializeView() {
        calc = findViewById(R.id.calc);
        clear = findViewById(R.id.clear);
        price = findViewById(R.id.price);
        currency = findViewById(R.id.currency);
        amount = findViewById(R.id.amount);
        fullresult = findViewById(R.id.fullresult);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeView();
        calc.setOnClickListener(this);
        clear.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.calc:
                fullresult.setText(calculate());
                break;
            case R.id.clear:
                clearFields();
                break;
        }
    }

    private String calculate() {
        String finalRes = "";
        if(price.getText().toString().length() != 0 && amount.getText().toString().length() != 0 && currency.getText().toString().length() != 0)
            double priced = Double.valueOf(price.getText().toString());
            double amountd = Double.valueOf(amount.getText().toString());
            String crnc = currency.getText().toString();
            double res = priced * amountd;
            finalRes = amountd + " лв. = " + res + " " + currency.getText().toString();
        }
        else
            finalRes = "Има празни полета.";
        return finalRes;
    }

    private void clearFields(){
        price.setText("");
        amount.setText("");
        currency.setText("");
        fullresult.setText("");
    }
}