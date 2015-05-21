package nyc.c4q.sufeiiz.scientificcalculator;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.math.BigDecimal;


public class MainActivity extends ActionBarActivity {

    private TextView outputEq, outputAns;
    private String equation, currNum, lastAns, lastNum, display;
    private int count;
    private boolean degMode = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        outputEq = (TextView) findViewById(R.id.output_equation);
        outputAns = (TextView) findViewById(R.id.output_answer);
        if (savedInstanceState == null) {
            outputEq.setText("");
            outputAns.setText("");
            display = "";
            equation = "";
            currNum = "";
            lastNum = "";
            lastAns = "0";
            count = 0;
        } else {
            outputAns.setText(savedInstanceState.getString("lastAns"));
            outputEq.setText(savedInstanceState.getString("display"));
            display = savedInstanceState.getString("display");
            equation = savedInstanceState.getString("equation");
            currNum = savedInstanceState.getString("currNum");
            lastNum = savedInstanceState.getString("lastNum");
            lastAns = savedInstanceState.getString("lastAns");
            count = savedInstanceState.getInt("count");
        }

        final Button clr = (Button) findViewById(R.id.btn_clear);
        final Button ans = (Button) findViewById(R.id.btn_ans);
        final Button negative = (Button) findViewById(R.id.btn_int);
        final Button backspace = (Button) findViewById(R.id.btn_backspace);
        final Button open = (Button) findViewById(R.id.btn_paren_open);
        final Button close = (Button) findViewById(R.id.btn_paren_close);
        final Button add = (Button) findViewById(R.id.btn_add);
        final Button minus = (Button) findViewById(R.id.btn_sub);
        final Button multiply = (Button) findViewById(R.id.btn_mult);
        final Button divide = (Button) findViewById(R.id.btn_div);
        final Button percent = (Button) findViewById(R.id.btn_percent);
        final Button zero = (Button) findViewById(R.id.btn_0);
        final Button one = (Button) findViewById(R.id.btn_1);
        final Button two = (Button) findViewById(R.id.btn_2);
        final Button three = (Button) findViewById(R.id.btn_3);
        final Button four = (Button) findViewById(R.id.btn_4);
        final Button five = (Button) findViewById(R.id.btn_5);
        final Button six = (Button) findViewById(R.id.btn_6);
        final Button seven = (Button) findViewById(R.id.btn_7);
        final Button eight = (Button) findViewById(R.id.btn_8);
        final Button nine = (Button) findViewById(R.id.btn_9);
        final Button dot = (Button) findViewById(R.id.btn_decimal);
        final Button equal = (Button) findViewById(R.id.btn_equals);

        // Scientific buttons
        final Button factorial = (Button) findViewById(R.id.btn_factorial);
        final Button pi = (Button) findViewById(R.id.btn_pi);
        final Button e = (Button) findViewById(R.id.btn_e);
        final Button sqRoot = (Button) findViewById(R.id.btn_sq_root);
        final Button sq = (Button) findViewById(R.id.btn_sq);
        final Button sin = (Button) findViewById(R.id.btn_sin);
        final Button cos = (Button) findViewById(R.id.btn_cos);
        final Button tan = (Button) findViewById(R.id.btn_tan);
        final Button exp = (Button) findViewById(R.id.btn_exp);
        final Button ln = (Button) findViewById(R.id.btn_ln);
        final Button log = (Button) findViewById(R.id.btn_log);

        // Numbers OnClickListener
        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (display.isEmpty()) ;
                else if (Numbers.lastInputIsConstant(display)) {
                    equation += "*";
                    display += "×";
                }
                currNum += "0";
                equation += "0";
                display += "0";
                outputEq.setText(display);
            }
        });
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (display.isEmpty()) ;
                else if (Numbers.lastInputIsConstant(display)) {
                    equation += "*";
                    display += "×";
                }
                currNum += "1";
                equation += "1";
                display += "1";
                outputEq.setText(display);
            }
        });
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (display.isEmpty()) ;
                else if (Numbers.lastInputIsConstant(display)) {
                    equation += "*";
                    display += "×";
                }
                currNum += "2";
                equation += "2";
                display += "2";
                outputEq.setText(display);
            }
        });
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (display.isEmpty()) ;
                else if (Numbers.lastInputIsConstant(display)) {
                    equation += "*";
                    display += "×";
                }
                currNum += "3";
                equation += "3";
                display += "3";
                outputEq.setText(display);
            }
        });
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (display.isEmpty()) ;
                else if (Numbers.lastInputIsConstant(display)) {
                    equation += "*";
                    display += "×";
                }
                currNum += "4";
                equation += "4";
                display += "4";
                outputEq.setText(display);
            }
        });
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (display.isEmpty()) ;
                else if (Numbers.lastInputIsConstant(display)) {
                    equation += "*";
                    display += "×";
                }
                currNum += "5";
                equation += "5";
                display += "5";
                outputEq.setText(display);
            }
        });
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (display.isEmpty()) ;
                else if (Numbers.lastInputIsConstant(display)) {
                    equation += "*";
                    display += "×";
                }
                currNum += "6";
                equation += "6";
                display += "6";
                outputEq.setText(display);
            }
        });
        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (display.isEmpty()) ;
                else if (Numbers.lastInputIsConstant(display)) {
                    equation += "*";
                    display += "×";
                }
                currNum += "7";
                equation += "7";
                display += "7";
                outputEq.setText(display);
            }
        });
        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (display.isEmpty()) ;
                else if (Numbers.lastInputIsConstant(display)) {
                    equation += "*";
                    display += "×";
                }
                currNum += "8";
                equation += "8";
                display += "8";
                outputEq.setText(display);
            }
        });
        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (display.isEmpty()) ;
                else if (Numbers.lastInputIsConstant(display)) {
                    equation += "*";
                    display += "×";
                }
                currNum += "9";
                equation += "9";
                display += "9";
                outputEq.setText(display);
            }
        });

        // if number already contains ".", ignore
        // if user omits 0 before ".", include 0
        dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currNum.contains(".")) ;
                else if (currNum.equals("")) {
                    currNum += "0.";
                    equation += "0.";
                    display += "0.";
                } else {
                    equation += ".";
                    currNum += ".";
                    display += ".";
                }
                outputEq.setText(display);
            }
        });

        // clear everything
        clr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                equation = "";
                currNum = "";
                lastAns = "";
                lastNum = "";
                display = "";
                outputAns.setText("");
                outputEq.setText(display);
            }
        });

        // TODO fix backspace for sincostan once that's implemented
        // if equation is empty, do nothing
        // else if the last input was %, convert to decimal to find length of converted num
        // else delete last char in currNum, equation, and display
        backspace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (equation.isEmpty()) ;
                else if (display.charAt(display.length() - 1) == '%') {
                    display = display.substring(0, display.length() - 1); // removes "%"

                    // find length of converted decimal and remove from equation; add back current num
                    String converted = Numbers.percentage(currNum, lastNum);
                    equation = equation.substring(0, equation.length() - converted.length());
                    equation += currNum;
                } else if (display.charAt(display.length() - 1) == '!') {
                    display = display.substring(0, display.length() - 1); // removes "!"

                    String converted = String.valueOf(Numbers.factorial(Integer.valueOf(currNum)));
                    equation = equation.substring(0, equation.length() - converted.length());
                    equation += currNum;
                } else if (display.charAt(display.length() - 1) == 'e' ||
                        display.charAt(display.length() - 1) == 'π') {
                    equation = equation.substring(0, equation.length() - 13);
                    currNum = "";
                    display = display.substring(0, display.length() - 1);
                } else if (display.charAt(display.length() - 1) == 's') {
                    equation = equation.substring(0, equation.length() - currNum.length());
                    currNum = "";
                    display = display.substring(0, display.length() - 3);
                } else {
                    if (currNum.length() > 0)
                        currNum = currNum.substring(0, currNum.length() - 1);
                    if (equation.length() > 0)
                        equation = equation.substring(0, equation.length() - 1);
                    if (display.length() > 0)
                        display = display.substring(0, display.length() - 1);
                }
                outputEq.setText(display);
            }
        });

        // if equation is empty and current is not empty, add current to equation
        // else if only equation is empty, ignore (needed so there's no out of range error)
        // else if last input was operator or (, replace
        // else just add operator
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (equation.isEmpty() && !lastAns.isEmpty()) {
                    lastNum = lastAns;
                    equation = lastAns + "+";
                    display = lastAns + "+";
                } else if (equation.isEmpty()) ;
                else if (Numbers.lastInputIsOperator(equation)) {
                    equation = equation.substring(0, equation.length() - 1) + "+";
                    display = display.substring(0, display.length() - 1) + "+";
                } else {
                    equation += "+";
                    lastNum = currNum;
                    currNum = "";
                    display += "+";
                }
                outputEq.setText(display);
            }
        });
        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (equation.isEmpty() && !lastAns.isEmpty()) {
                    lastNum = lastAns;
                    equation = lastAns + "-";
                    display = lastAns + "-";
                } else if (equation.isEmpty()) ;
                else if (Numbers.lastInputIsOperator(equation)) {
                    equation = equation.substring(0, equation.length() - 1) + "-";
                    display = display.substring(0, display.length() - 1) + "-";
                } else {
                    equation += "-";
                    lastNum = currNum;
                    currNum = "";
                    display += "-";
                }
                outputEq.setText(display);
            }
        });
        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (equation.isEmpty() && !lastAns.isEmpty()) {
                    lastNum = lastAns;
                    equation = lastAns + "*";
                    display = lastAns + "×";
                } else if (equation.isEmpty()) ;
                else if (Numbers.lastInputIsOperator(equation)) {
                    equation = equation.substring(0, equation.length() - 1) + "*";
                    display = display.substring(0, display.length() - 1) + "×";
                } else {
                    equation += "*";
                    lastNum = currNum;
                    currNum = "";
                    display += "×";
                }
                outputEq.setText(display);
            }
        });
        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (equation.isEmpty() && !lastAns.isEmpty()) {
                    lastNum = lastAns;
                    equation = lastAns + "/";
                    display = lastAns + "÷";
                } else if (equation.isEmpty()) ;
                else if (Numbers.lastInputIsOperator(equation)) {
                    equation = equation.substring(0, equation.length() - 1) + "/";
                    display = display.substring(0, display.length() - 1) + "÷";
                } else {
                    equation += "/";
                    lastNum = currNum;
                    currNum = "";
                    display += "÷";
                }
                outputEq.setText(display);
            }
        });

        // if equation is empty, ignore
        // else if last input was operator or ( or %, ignore
        // else convert percentage to number
        percent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (equation.isEmpty()) ;
                else if (Numbers.lastInputIsOperator(equation) ||
                        Numbers.lastInputIsPercent(equation)) ;
                else {
                    equation = equation.substring(0, equation.length() - currNum.length());
                    String converted = Numbers.percentage(currNum, lastNum);

                    equation += converted;
                    display += "%";
                    outputEq.setText(display);
                }
            }
        });

        // if equation is empty, add - accordingly
        // else if last input was %, find length of converted number and add - accordingly
        // else if last input was e or pi, find length of converted number and add - accordingly
        // else if last input was ans, find length of converted number and add - accordingly
        // else add - accordingly
        negative.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (equation.isEmpty()) {
                    if (currNum.contains("-"))
                        currNum = currNum.substring(1);
                    else
                        currNum = "-" + currNum;
                    equation += currNum;
                    display += currNum;
                } else if (Numbers.lastInputIsPercent(display)) {
                    String converted = Numbers.percentage(currNum, lastNum);
                    display = display.substring(0, display.length() - currNum.length() - 1);
                    equation = equation.substring(0, equation.length() - converted.length());
                    if (currNum.contains("-")) {
                        currNum = currNum.substring(1);
                        display += currNum + "%";
                        equation += converted.substring(1);
                    } else {
                        currNum = "-" + currNum;
                        display += currNum + "%";
                        equation += "-" + converted;
                    }
                } else if (display.charAt(display.length() - 1) == 'e' ||
                        display.charAt(display.length() - 1) == 'π') {
                    char constant = display.charAt(display.length() - 1);
                    if (currNum.contains("-")) {
                        currNum = currNum.substring(1);
                        equation = equation.substring(0, equation.length() - 14) + currNum;
                        display = display.substring(0, display.length() - 2) + constant;
                    } else {
                        currNum = "-" + currNum;
                        equation = equation.substring(0, equation.length() - 13) + "-" + currNum;
                        display = display.substring(0, display.length() - 1) + "-" + constant;
                    }
                } else if (display.charAt(display.length() - 1) == 's') {
                    if (currNum.equals("0")) {
                        display = display.substring(0, display.length() - 3) + "-" + "Ans";
                    } else if (currNum.contains("-")) {
                        currNum = currNum.substring(1);
                        equation = equation.substring(0, equation.length() - currNum.length() - 1) + currNum;
                        display = display.substring(0, display.length() - 4) + "Ans";
                    } else {
                        currNum = "-" + currNum;
                        equation = equation.substring(0, equation.length() - currNum.length() + 1) + currNum;
                        display = display.substring(0, display.length() - 3) + "-" + "Ans";
                    }
                } else if (display.charAt(display.length() - 1) == '^') {
                    if (currNum.contains("-")) {
                        currNum = currNum.substring(1);
                        display = display.substring(0, display.length() - currNum.length() - 1) + currNum;
                        equation = equation.substring(0, equation.length() - currNum.length() - 1) + currNum;
                    } else {
                        currNum = "-" + currNum;
                        display = display.substring(0, display.length() - currNum.length() + 1) + currNum;
                        equation = equation.substring(0, equation.length() - currNum.length() + 1) + currNum;
                    }
                } else {
                    if (currNum.contains("-")) {
                        equation = equation.substring(0, equation.length() - currNum.length());
                        display = display.substring(0, display.length() - currNum.length());
                        currNum = currNum.substring(1);
                    } else {
                        equation = equation.substring(0, equation.length() - currNum.length());
                        display = display.substring(0, display.length() - currNum.length());
                        currNum = "-" + currNum;
                    }
                    equation += currNum;
                    display += currNum;
                }
                outputEq.setText(display);
            }
        });

        // increase count for every opened parentheses
        // if equation if empty, open parentheses
        // else if last input was a number or last input was ), add multiply before open
        // else just open
        open.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (equation.isEmpty()) {
                    equation += "(";
                    display += "(";
                } else if (Character.isDigit(equation.charAt(equation.length() - 1)) ||
                        equation.charAt(equation.length() - 1) == ')' ||
                        Numbers.lastInputIsConstant(display)) {
                    equation += "*(";
                    display += "×(";
                } else {
                    display += "(";
                    equation += "(";
                }
                count++;
                outputEq.setText(display);
            }
        });

        // decrease count for every closed parentheses
        // if equation if empty or count is less than zero or last input was operator, ignore
        // else just close
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (equation.isEmpty() || count <= 0 ||
                        Numbers.lastInputIsOperator(equation)) ;
                else {
                    equation += ")";
                    display += ")";
                    count--;
                    outputEq.setText(display);
                }
            }
        });

        // save last answer (whenever = is clicked)
        ans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lastNum = currNum;
                currNum = lastAns;
                if (lastAns.isEmpty()) ;
                else if (display.isEmpty()) {
                    equation += lastAns;
                    display += "Ans";
                } else if (Numbers.lastInputIsConstant(display) ||
                        Character.isDigit(display.charAt(display.length() - 1))) {
                    equation += "*" + lastAns;
                    display += "×Ans";
                } else {
                    equation += lastAns;
                    display += "Ans";
                }
                outputEq.setText(display);
            }
        });

        // if parentheses were not closed properly, close them
        // else if last input was operator, display error message
        // else parse equation for answer
        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (count > 0) {
                    for (; count > 0; count--) {
                        equation += ")";
                    }
                }
                if (equation.equals(""))
                    outputEq.setText("");
                else {
                    try {
                        BigDecimal answer = new Expression(equation).eval();

                        lastAns = String.valueOf(answer.doubleValue());

                        // returns long if answer is a whole number, otherwise return double
                        if (lastAns.substring(lastAns.length() - 2).equals(".0"))
                            lastAns = String.valueOf(answer.longValue());
                    } catch (Exception e) {
                        equation = "";
                        currNum = "";
                        lastNum = "";
                        display = "";
                        outputEq.setText("Error");
                    }

                    lastNum = "";
                    currNum = "";
                    equation = "";
                    display = "";
                    outputAns.setText(lastAns);
                }
            }
        });

        // Scientific calculator
        if (log != null) {

            // Toggle radians/degrees
            ToggleButton toggle = (ToggleButton) findViewById(R.id.btn_rad);
            toggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked) {
                        Toast.makeText(MainActivity.this, "Radians mode on", Toast.LENGTH_SHORT).show();
                        degMode = false;
                    } else {
                        Toast.makeText(MainActivity.this, "Degrees mode on", Toast.LENGTH_SHORT).show();
                        degMode = true;
                    }
                }
            });

            // if equation if empty, ignore
            // else last operator was an operator, ignore
            // else try factorial calculation, catch error
            factorial.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (equation.isEmpty()) ;
                    else if (Numbers.lastInputIsOperator(equation)) ;
                    else {
                        try {
                            equation = equation.substring(0, equation.length() - currNum.length());
                            currNum = String.valueOf(Numbers.factorial(Integer.valueOf(currNum)));
                            equation += currNum;
                            display += "!";
                            outputEq.setText(display);
                        } catch (Exception e) {
                            equation = "";
                            currNum = "";
                            lastNum = "";
                            display = "";
                            outputEq.setText("Error");
                        }
                    }
                }
            });
            pi.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    currNum = String.valueOf(3.14159265359);
                    if (display.isEmpty()) {
                        equation += currNum;
                        display += "π";
                    } else if (Numbers.lastInputIsConstant(display) ||
                            Character.isDigit(display.charAt(display.length() - 1)) ||
                            display.charAt(display.length() - 1) == ')') {
                        equation += "*" + currNum;
                        display += "×π";
                    } else {
                        equation += currNum;
                        display += "π";
                    }
                    outputEq.setText(display);
                }
            });
            e.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    currNum = String.valueOf(2.71828182846);
                    if (display.isEmpty()) {
                        equation += currNum;
                        display += "e";
                    } else if (Numbers.lastInputIsConstant(display) ||
                            Character.isDigit(display.charAt(display.length() - 1)) ||
                            display.charAt(display.length() - 1) == ')') {
                        equation += "*" + currNum;
                        display += "×e";
                    } else {
                        equation += currNum;
                        display += "e";
                    }
                    outputEq.setText(display);
                }
            });

            sin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (degMode) {
                        if (equation.isEmpty()) {
                            equation += "SIN(";
                            display += "sin(";
                        } else if (Character.isDigit(equation.charAt(equation.length() - 1)) ||
                                equation.charAt(equation.length() - 1) == ')' ||
                                Numbers.lastInputIsConstant(display)) {
                            equation += "*SIN(";
                            display += "×sin(";
                        } else {
                            equation += "SIN(";
                            display += "sin(";
                        }
                    } else {
                        if (equation.isEmpty()) {
                            equation += "RAD(SIN(";
                            display += "sin(";
                        } else if (Character.isDigit(equation.charAt(equation.length() - 1)) ||
                                equation.charAt(equation.length() - 1) == ')' ||
                                Numbers.lastInputIsConstant(display)) {
                            equation += "*RAD(SIN(";
                            display += "×sin(";
                        } else {
                            equation += "RAD(SIN(";
                            display += "sin(";
                        }
                        count++;
                    }
                    count++;
                    outputEq.setText(display);
                }
            });
            cos.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (degMode) {
                        if (equation.isEmpty()) {
                            equation += "COS(";
                            display += "cos(";
                        } else if (Character.isDigit(equation.charAt(equation.length() - 1)) ||
                                equation.charAt(equation.length() - 1) == ')' ||
                                Numbers.lastInputIsConstant(display)) {
                            equation += "*COS(";
                            display += "×cos(";
                        } else {
                            equation += "COS(";
                            display += "cos(";
                        }
                    } else {
                        if (equation.isEmpty()) {
                            equation += "RAD(COS(";
                            display += "cos(";
                        } else if (Character.isDigit(equation.charAt(equation.length() - 1)) ||
                                equation.charAt(equation.length() - 1) == ')' ||
                                Numbers.lastInputIsConstant(display)) {
                            equation += "*RAD(COS(";
                            display += "×cos(";
                        } else {
                            equation += "RAD(COS(";
                            display += "cos(";
                        }
                        count++;
                    }
                    count++;
                    outputEq.setText(display);
                }
            });
            tan.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (degMode) {
                        if (equation.isEmpty()) {
                            equation += "TAN(";
                            display += "tan(";
                        } else if (Character.isDigit(equation.charAt(equation.length() - 1)) ||
                                equation.charAt(equation.length() - 1) == ')' ||
                                Numbers.lastInputIsConstant(display)) {
                            equation += "*TAN(";
                            display += "×tan(";
                        } else {
                            equation += "TAN(";
                            display += "tan(";
                        }
                    } else {
                        if (equation.isEmpty()) {
                            equation += "RAD(TAN(";
                            display += "tan(";
                        } else if (Character.isDigit(equation.charAt(equation.length() - 1)) ||
                                equation.charAt(equation.length() - 1) == ')' ||
                                Numbers.lastInputIsConstant(display)) {
                            equation += "*RAD(TAN(";
                            display += "×tan(";
                        } else {
                            equation += "RAD(TAN(";
                            display += "tan(";
                        }
                        count++;
                    }
                    count++;
                    outputEq.setText(display);
                }
            });
            ln.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (equation.isEmpty()) {
                        equation += "LOG(";
                        display += "ln(";
                    } else if (Character.isDigit(equation.charAt(equation.length() - 1)) ||
                            equation.charAt(equation.length() - 1) == ')' ||
                            Numbers.lastInputIsConstant(display)) {
                        equation += "*LOG(";
                        display += "×ln(";
                    } else {
                        equation += "LOG(";
                        display += "ln(";
                    }
                    count++;
                    outputEq.setText(display);
                }
            });
            log.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (equation.isEmpty()) {
                        equation += "LOG10(";
                        display += "log(";
                    } else if (Character.isDigit(equation.charAt(equation.length() - 1)) ||
                            equation.charAt(equation.length() - 1) == ')' ||
                            Numbers.lastInputIsConstant(display)) {
                        equation += "*LOG10(";
                        display += "×log(";
                    } else {
                        equation += "LOG10(";
                        display += "log(";
                    }
                    count++;
                    outputEq.setText(display);
                }
            });
            sqRoot.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (equation.isEmpty()) {
                        equation += "SQRT(";
                        display += "√(";
                    } else if (Character.isDigit(equation.charAt(equation.length() - 1)) ||
                            equation.charAt(equation.length() - 1) == ')' ||
                            Numbers.lastInputIsConstant(display)) {
                        equation += "*SQRT(";
                        display += "×√(";
                    } else {
                        equation += "SQRT(";
                        display += "√(";
                    }
                    count++;
                    outputEq.setText(display);
                }
            });

            exp.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (display.isEmpty()) ;
                    else if (Character.isDigit(display.charAt(display.length() - 1))) {
                        equation = equation.substring(0, display.length() - currNum.length()) + "(" + currNum;
                        lastNum = currNum;
                        currNum = "E";
                        equation += "*(10^";
                        display += "E";
                    }
                }
            });

            sq.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (equation.isEmpty() ||
                            equation.charAt(equation.length() - 1) == '(') ;
                    else {
                        lastNum = currNum;
                        currNum = "";
                        equation += "^";
                        display += "^";
                    }
                    outputEq.setText(display);
                }
            });
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("currNum", currNum);
        outState.putString("equation", equation);
        outState.putString("lastAns", lastAns);
        outState.putString("display", display);
        outState.putString("lastNum", lastNum);
        outState.putInt("count", count);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}