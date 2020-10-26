package com.example.calculatorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static com.example.calculatorapp.ConvertStringToMathExpression.convert;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button b_0, b_1, b_2, b_3, b_4, b_5, b_6, b_7, b_8, b_9;
    Button b_ce, b_c, b_bs;
    Button b_add, b_subtract, b_multiply, b_divide, b_equal, b_dot, b_lunisolar;

    TextView screen;

    boolean dot_is_pressed = false;
    boolean operator_is_pressed = false;
    boolean equal_is_pressed = false;

    Button[] number_buttons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        screen = findViewById(R.id.screen);

        b_ce = (Button) findViewById(R.id.ce);
        b_ce.setOnClickListener(this);

        b_c = (Button) findViewById(R.id.c);
        b_c.setOnClickListener(this);

        b_bs = (Button) findViewById(R.id.bs);
        b_bs.setOnClickListener(this);

        b_add = (Button) findViewById(R.id.add);
        b_add.setOnClickListener(this);

        b_subtract = (Button) findViewById(R.id.subtract);
        b_subtract.setOnClickListener(this);

        b_multiply = (Button) findViewById(R.id.multiply);
        b_multiply.setOnClickListener(this);

        b_divide = (Button) findViewById(R.id.divide);
        b_divide.setOnClickListener(this);

        b_equal = (Button) findViewById(R.id.equal);
        b_equal.setOnClickListener(this);

        b_lunisolar = (Button) findViewById(R.id.lunisolar);
        b_lunisolar.setOnClickListener(this);

        b_dot = (Button) findViewById(R.id.dot);
        b_dot.setOnClickListener(this);

        b_0 = (Button) findViewById(R.id.zero);
        b_0.setOnClickListener(this);

        b_1 = (Button) findViewById(R.id.one);
        b_1.setOnClickListener(this);

        b_2 = (Button) findViewById(R.id.two);
        b_2.setOnClickListener(this);

        b_3 = (Button) findViewById(R.id.three);
        b_3.setOnClickListener(this);

        b_4 = (Button) findViewById(R.id.four);
        b_4.setOnClickListener(this);

        b_5 = (Button) findViewById(R.id.five);
        b_5.setOnClickListener(this);

        b_6 = (Button) findViewById(R.id.six);
        b_6.setOnClickListener(this);

        b_7 = (Button) findViewById(R.id.seven);
        b_7.setOnClickListener(this);

        b_8 = (Button) findViewById(R.id.eight);
        b_8.setOnClickListener(this);

        b_9 = (Button) findViewById(R.id.nine);
        b_9.setOnClickListener(this);

        b_c = (Button) findViewById(R.id.c);
        b_c.setOnClickListener(this);

        b_ce = (Button) findViewById(R.id.ce);
        b_ce.setOnClickListener(this);

        b_bs = (Button) findViewById(R.id.bs);
        b_bs.setOnClickListener(this);
        number_buttons = new Button[]{b_0, b_1, b_2, b_3, b_4, b_5, b_6, b_7, b_8, b_9};
    }

    @Override
    public void onClick(View view) {

        for (Button number_button : number_buttons) {
//        Reset the Text View if a number button is pressed after pressing equal button
            if (equal_is_pressed && view.getId() == number_button.getId()) {
                screen.setText("");
                equal_is_pressed = false;
            } else if (equal_is_pressed && !(view.getId() == number_button.getId())) {
                equal_is_pressed = false;
            } else {
                dot_is_pressed = false;
            }
//        Allow to press operator buttons after pressing number button
            operator_is_pressed = false;
        }

        switch (view.getId()) {
//            Number buttons
            case R.id.one:
                screen.setText(String.format("%s1", screen.getText()));
                break;
            case R.id.two:
                screen.setText(String.format("%s2", screen.getText()));
                break;
            case R.id.three:
                screen.setText(String.format("%s3", screen.getText()));
                break;
            case R.id.four:
                screen.setText(String.format("%s4", screen.getText()));
                break;
            case R.id.five:
                screen.setText(String.format("%s5", screen.getText()));
                break;
            case R.id.six:
                screen.setText(String.format("%s6", screen.getText()));
                break;
            case R.id.seven:
                screen.setText(String.format("%s7", screen.getText()));
                break;
            case R.id.eight:
                screen.setText(String.format("%s8", screen.getText()));
                break;
            case R.id.nine:
                screen.setText(String.format("%s9", screen.getText()));
                break;
            case R.id.zero:
                screen.setText(String.format("%s0", screen.getText()));
                break;

            case R.id.dot:
//                 Make dot button can only be pressed once
                if (!dot_is_pressed) {
                    screen.setText(String.format("%s.", screen.getText()));
                    dot_is_pressed = true;
                    break;
                }

//            Operator button handler
            case R.id.add:
                if (!operator_is_pressed) {
                    screen.setText(String.format("%s+", screen.getText()));
                    operator_is_pressed = true;
//                    dot_is_pressed = false;
                }
                break;
            case R.id.subtract:
                if (!operator_is_pressed) {
                    screen.setText(String.format("%s-", screen.getText()));
                    operator_is_pressed = true;
//                    dot_is_pressed = false;
                }
                break;
            case R.id.divide:
                if (!operator_is_pressed) {
                    screen.setText(String.format("%s/", screen.getText()));
                    operator_is_pressed = true;
//                    dot_is_pressed = false;
                }
                break;
            case R.id.multiply:
                if (!operator_is_pressed) {
                    screen.setText(String.format("%s*", screen.getText()));
                    operator_is_pressed = true;
//                    dot_is_pressed = false;
                }
                break;
            case R.id.equal:
                if (screen.getText() != "") {
                    screen.setText(formatted_result(result_from_math_expressions()));

                    equal_is_pressed = true;
                    operator_is_pressed = false;
//                    dot_is_pressed = false;
                }
                break;

            case R.id.c:
                screen.setText("");
                break;

            case R.id.bs:
                String str = screen.getText().toString();
                if (str.length() > 1) {
                    str = str.substring(0, str.length() - 1);
                    screen.setText(str);
                } else {
                    screen.setText("");
                }
                break;

            case R.id.ce:
                str = screen.getText().toString();
                if (str.length() > 1) {
                    str = str.substring(0, str.lastIndexOf("+") + 1 );
                    screen.setText(str);
                } else {
                }
                break;
        }
    }

    private String formatted_result(double result) {
        if (result == (int) result) {
            return String.valueOf((int) result);
        } else {
            return String.valueOf(result);
        }
    }

    private double result_from_math_expressions() {
        return convert((String) screen.getText());
    }
}
