package com.example.randomnumbergenerator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button Generate = (Button) findViewById(R.id.Generate);
        Generate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)  {

                EditText firstvalue = (EditText) findViewById(R.id.editText4);
                EditText secondvalue = (EditText) findViewById(R.id.editText5);
                EditText amountnumbers = (EditText) findViewById(R.id.aonums);
                String firstvalueString = firstvalue.getText().toString();
                String secondvalueString = secondvalue.getText().toString(); // secondValue
                String amountnumbersString = amountnumbers.getText().toString();
                TextView res = (TextView) findViewById(R.id.ResultNum);

                int num1;
                if (TextUtils.isEmpty(firstvalueString)){
                    firstvalue.setError("Error: Please input a value");
                    return;
                }
                else {
                    num1 = Integer.parseInt(firstvalue.getText().toString());
                }
                 if (num1 < 0){
                     firstvalue.setError("Error: 1st value < 0");
                     return;
                 }
                int num2;
                if (TextUtils.isEmpty(secondvalueString)){
                    secondvalue.setError("Error: Please input a value");
                    return;
                }
                else {
                    num2 = Integer.parseInt(secondvalue.getText().toString());
                }
                  if(num2 <= num1){
                        secondvalue.setError("Error: 2nd value < or = 1st value");
                        return;
                    }


                int num3;
                if (TextUtils.isEmpty(amountnumbersString)) {
                    amountnumbers.setError("Error: Please input a amount value");
                    return;
                }
                else {
                    num3 = Integer.parseInt(amountnumbers.getText().toString());
                }
                    if(num3 <= 0) {
                        amountnumbers.setError("Error: Amount of numbers < or = 0");
                        return;
                    }
                res.setText("");
                while (num3 > 0){
                    int ran = (int) (num1 + (Math.random())* num2);
                    if (ran < 0){
                        ran *= -1;
                    }
                    else if (ran > num2){
                        ran = num2;
                    }
                    num3--;
                    res.setText(res.getText().toString() + Integer.toString(ran) + " ");
                }
            }
        });
        Button Clear = (Button) findViewById(R.id.Clear);
        Clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText firstvalue = (EditText) findViewById(R.id.editText4);
                EditText secondvalue = (EditText) findViewById(R.id.editText5);
                EditText amountnumbers = (EditText) findViewById(R.id.aonums);
                TextView res = (TextView) findViewById(R.id.ResultNum);

                firstvalue.getText().clear();
                secondvalue.getText().clear();
                amountnumbers.getText().clear();
                res.setText("Result");


            }
        });
    }
}
