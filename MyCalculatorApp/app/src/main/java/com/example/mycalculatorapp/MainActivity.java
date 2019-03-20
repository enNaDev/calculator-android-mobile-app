package com.example.mycalculatorapp;

import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {

    Button button0, button1, button2, button3, button4, button5, button6,
            button7, button8, button9, buttonAdd, buttonSub, buttonDivision,
            buttonMul, buttonFractional, buttonC, buttonEqual, buttonDemo;

    EditText screenText;

    String currentInput = "";

    float output = 0;

    boolean startOver, addFlag, subFlag, mulFlag, divFlag, fractionalFlag = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        screenText = (EditText) findViewById(R.id.edt);
        button0 = (Button) findViewById(R.id.button0);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        button5 = (Button) findViewById(R.id.button5);
        button6 = (Button) findViewById(R.id.button6);
        button7 = (Button) findViewById(R.id.button7);
        button8 = (Button) findViewById(R.id.button8);
        button9 = (Button) findViewById(R.id.button9);
        buttonFractional = (Button) findViewById(R.id.button10);
        buttonAdd = (Button) findViewById(R.id.buttonadd);
        buttonSub = (Button) findViewById(R.id.buttonsub);
        buttonMul = (Button) findViewById(R.id.buttonmul);
        buttonDivision = (Button) findViewById(R.id.buttondiv);
        buttonEqual = (Button) findViewById(R.id.buttoneql);
        buttonC = (Button) findViewById(R.id.buttonC);
        buttonDemo = (Button) findViewById(R.id.buttondemo);

        //setting the buttons
        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkIfStartingOver();
                screenText.setText(screenText.getText() + "0");
                currentInput = currentInput + "0";
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkIfStartingOver();
                screenText.setText(screenText.getText() + "1");
                currentInput = currentInput + "1";
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkIfStartingOver();
                screenText.setText(screenText.getText() + "2");
                currentInput = currentInput + "2";
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkIfStartingOver();
                screenText.setText(screenText.getText() + "3");
                currentInput = currentInput + "3";
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkIfStartingOver();
                screenText.setText(screenText.getText() + "4");
                currentInput = currentInput + "4";
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkIfStartingOver();
                screenText.setText(screenText.getText() + "5");
                currentInput = currentInput + "5";
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkIfStartingOver();
                screenText.setText(screenText.getText() + "6");
                currentInput = currentInput + "6";
            }
        });

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkIfStartingOver();
                screenText.setText(screenText.getText() + "7");
                currentInput = currentInput + "7";
            }
        });

        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkIfStartingOver();
                screenText.setText(screenText.getText() + "8");
                currentInput = currentInput + "8";
            }
        });

        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkIfStartingOver();
                screenText.setText(screenText.getText() + "9");
                currentInput = currentInput + "9";
            }
        });

        buttonFractional.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //check for not putting fractional part twice in a number
                if (fractionalFlag) {
                    checkIfStartingOver();
                    if (currentInput.equals("")){
                        screenText.setText(screenText.getText() + "0.");
                        currentInput = "0.";
                    } else {
                        screenText.setText(screenText.getText() + ".");
                        currentInput = currentInput + ".";
                    }
                    fractionalFlag = false;
                }
            }
        });

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                functionality();
                screenText.setText(output + " + ");
                addFlag = true;
            }
        });

        buttonSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                functionality();
                screenText.setText(output + " - ");
                subFlag = true;
            }
        });

        buttonMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                functionality();
                screenText.setText(output + " * ");
                mulFlag = true;
            }
        });

        buttonDivision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                functionality();
                screenText.setText(output + " / ");
                divFlag = true;
            }
        });

        buttonEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //if the user hasn't performed any operation then the equalButton is "deactivated"
                if(!currentInput.equals("") & (addFlag || subFlag || mulFlag || divFlag)) {
                    if (addFlag) {
                        output = output + Float.parseFloat(currentInput);
                    } else if (subFlag) {
                        output = output - Float.parseFloat(currentInput);
                    } else if (mulFlag) {
                        output = output * Float.parseFloat(currentInput);
                    } else if (divFlag) {
                        output = output / Float.parseFloat(currentInput);
                    }
                    screenText.setText(output + "");
                    initialise();
                }
            }
        });

        buttonC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initialise();
                screenText.setText("");
                output = 0;
            }
        });

        buttonDemo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initialise();
                screenText.setText("Mobile App Calculator Demo");
                output = 0;
            }
        });

    }


    public void functionality() {
        if (!currentInput.equals("")) {
            //if the current input is the first input (thus output is 0), becomes the "output"
            //this prevents the inversion of the sign in subtraction
            if (output == 0) {
                output = Float.parseFloat(currentInput);
            } else {
                if (addFlag) {
                    output = output + Float.parseFloat(currentInput);
                } else if (subFlag) {
                    output = output - Float.parseFloat(currentInput);
                } else if (mulFlag) {
                    output = output * Float.parseFloat(currentInput);
                } else if (divFlag) {
                    output = output / Float.parseFloat(currentInput);
                }
            }
        }
        initialise();
        startOver = false;
    }

    public void checkIfStartingOver() {
        if (startOver){
            screenText.setText("");
            output = 0;
            startOver = false;
        }
    }

    public void initialise() {
        currentInput = "";
        addFlag = false;
        subFlag = false;
        mulFlag = false;
        divFlag = false;
        startOver = true;
        fractionalFlag = true;
    }

}