package com.example.t00236394.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.text.DecimalFormat;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {


    private Button plus;
    private Button minus;
    private Button divide;
    private Button times;
    private Button clear;
    private Button decimal;
    private Button equals;
    private Button negative;
    private TextView input;


    public void addNumber(View view) {
        input.append(((Button)view).getText().toString());
    }

    DecimalFormat df= new DecimalFormat("#.####");

    public String calculate(String str){
        String firstString = "";
        String secondString = "";
        String thirdString ="";
        String returnString= str;
        double firstNumber;
        double secondNumber;
        float second;
        double result;
        if(str.contains("*")){
            firstString = str.substring(0,str.indexOf("*"));
            if(firstString.length() > 0 ) {
                firstNumber = Double.parseDouble(firstString);
                Log.v("Code","firstnumber is "+firstNumber);
                secondString= str.substring(str.indexOf("*")+1, str.length());
                Log.v("Code","SecondStrign is" + secondString);
                if(secondString.length()>0){
                    secondNumber = Double.parseDouble(secondString);
                    Log.v("Code","secondnumber is "+secondNumber);
                    result=(firstNumber*secondNumber);
                    returnString=df.format(result);
                }
                else if(secondString.indexOf("-")==0){
                    thirdString= secondString.substring(1,secondString.length());
                    secondNumber= -(Double.parseDouble(thirdString));
                    result=(firstNumber*secondNumber);
                    Log.v("result", "result is" +result);
                    returnString=df.format(result);

                }
            }
        }

        if(str.contains("/")){
            firstString = str.substring(0,str.indexOf("/"));
            if(firstString.length() > 0 ) {
                firstNumber = Double.parseDouble(firstString);
                secondString= str.substring(str.indexOf("/")+1, str.length());
                Log.v("Code","SecondStrign is" + secondString);
                if(secondString.length() > 0&& secondString.indexOf("-")!=0){
                    secondNumber = Double.parseDouble(secondString);
                    result=(firstNumber/secondNumber);
                    returnString=df.format(result);
                }
                //I can do a negative/negative and postive/positive
                //and a negative/postive. I can't do a positive/negative.
                //An exception is triggered with the equals button every time it is done//

                else if(secondString.indexOf("-")==0){
                    secondNumber= Double.parseDouble(secondString);
                    Log.v("secondNumber","the secondnumber is " +secondNumber);
                    result=firstNumber/secondNumber;
                    Log.v("result", "result is " +result);
                    returnString=df.format(result);
                    Log.v("string3", "string is " +returnString);
                }
            }
        }


        if(str.contains("+")){
            firstString = str.substring(0,str.indexOf("+"));
            if(firstString.length() > 0 ) {
                firstNumber = Double.parseDouble(firstString);
                Log.v("Code","firstnumber is "+firstNumber);
                secondString= str.substring(str.indexOf("+")+1, str.length());
                Log.v("Code","SecondStrign is" + secondString);
                if(secondString.length() > 0){
                    secondNumber = Double.parseDouble(secondString);
                    result=(firstNumber+secondNumber);
                    returnString=df.format(result);
                }
                else if(secondString.indexOf("-")==0){
                    thirdString= secondString.substring(0,secondString.length());
                    secondNumber= (Double.parseDouble(thirdString));
                    result=(firstNumber+secondNumber);
                    Log.v("result", "result is" +result);
                    returnString=df.format(result);
                }
            }
        }

        if(str.contains("-")){
            firstString = str.substring(0,str.indexOf("-"));
            if(firstString.length() > 0 ) {
                firstNumber = Double.parseDouble(firstString);
                Log.v("Code","firstnumber is "+firstNumber);
                secondString= str.substring(str.indexOf("-")+1, str.length());
                Log.v("Code","SecondStrign is" + secondString);
                if(secondString.length()>0){
                    secondNumber = Double.parseDouble(secondString);
                    result=(firstNumber-secondNumber);
                    returnString=df.format(result);
                }
                else if(secondString.indexOf("-")==0){

                    thirdString= secondString.substring(0,secondString.length());
                    secondNumber= -(Double.parseDouble(thirdString));
                    result=(firstNumber-secondNumber);
                    Log.v("result", "result is" +result);
                    returnString=df.format(result);


                }
            }
        }






        return returnString;
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        plus = (Button) findViewById(R.id.plus);
        minus = (Button) findViewById(R.id.minus);
        divide = (Button) findViewById(R.id.divide);
        times = (Button) findViewById(R.id.times);
        clear = (Button) findViewById(R.id.clear);
        decimal = (Button) findViewById(R.id.dot);
        equals = (Button) findViewById(R.id.equals);
        negative = (Button) findViewById(R.id.negation);
        input = (TextView) findViewById(R.id.textView);


        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText("");
            }
        });

        decimal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    input.setText(input.getText().toString() + ".");

            }
        });

        negative.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    input.setText(input.getText().toString() + "-");

            }
        });

        plus.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                try {
                    input.setText(calculate(input.getText().toString())+"+");
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "Can't do operation", Toast.LENGTH_SHORT).show();
                }
            }
        });

        minus.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                try {
                    input.setText(calculate(input.getText().toString())+"-");
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "Can't do operation", Toast.LENGTH_SHORT).show();
                }

            }



        });

        times.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                try {
                    input.setText(calculate(input.getText().toString())+"*");
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "Can't do operation", Toast.LENGTH_SHORT).show();
                }

            }
        });

        divide.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                try {
                    input.setText(calculate(input.getText().toString())+"/");
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "Can't do operation", Toast.LENGTH_SHORT).show();
                }

            }
        });


        equals.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                try {
                    input.setText(calculate(input.getText().toString()));
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "Can't do operation", Toast.LENGTH_SHORT).show();
                }
            }
        });










    }


























    }

