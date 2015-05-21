package nyc.c4q.hyunj0.js_calc;

import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;
import java.util.Stack;

//Sarah will be the back-end gal with Joshelyn as her sidekick!!

public class Calculator extends ActionBarActivity {

    private
    //Basic calculator
    Button  point,
            zero, one, two, three, four, five, six, seven, eight, nine,
            add, subtract, multiply, divide,
            equals,
            clear,

    //Scientific calculator
            openParen, closeParen,
            pi, e,
            percentage,
            factorial,
            sqrt, exp, expTen,
            ln, log,
            sine, cosine, tangent,
            ans,
            delete;

    private ToggleButton inverse, radToDeg;
    private TextView preview;
    private String expression, answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        point = (Button) findViewById(R.id.point);
        zero = (Button) findViewById(R.id.zero);
        one = (Button) findViewById(R.id.one);
        two = (Button) findViewById(R.id.two);
        three = (Button) findViewById(R.id.three);
        four = (Button) findViewById(R.id.four);
        five = (Button) findViewById(R.id.five);
        six = (Button) findViewById(R.id.six);
        seven = (Button) findViewById(R.id.seven);
        eight = (Button) findViewById(R.id.eight);
        nine = (Button) findViewById(R.id.nine);
        add = (Button) findViewById(R.id.add);
        subtract = (Button) findViewById(R.id.subtract);
        multiply = (Button) findViewById(R.id.multiply);
        divide = (Button) findViewById(R.id.divide);
        equals = (Button) findViewById(R.id.equals);
        clear = (Button) findViewById(R.id.clear);
        openParen = (Button) findViewById(R.id.openParen);
        closeParen = (Button) findViewById(R.id.closeParen);
        pi = (Button) findViewById(R.id.pi);
        e = (Button) findViewById(R.id.e);
        percentage = (Button) findViewById(R.id.percentage);
        factorial = (Button) findViewById(R.id.factorial);
        sqrt = (Button) findViewById(R.id.sqrt);
        exp = (Button) findViewById(R.id.exp);
        expTen = (Button) findViewById(R.id.expTen);
        ln = (Button) findViewById(R.id.ln);
        log = (Button) findViewById(R.id.log);
        sine = (Button) findViewById(R.id.sine);
        cosine = (Button) findViewById(R.id.cosine);
        tangent = (Button) findViewById(R.id.tangent);
        ans = (Button) findViewById(R.id.ans);
        delete = (Button) findViewById(R.id.delete);
        inverse = (ToggleButton) findViewById(R.id.inverse);
        radToDeg = (ToggleButton) findViewById(R.id.rad_to_deg);
        preview = (TextView) findViewById(R.id.preview);

        point.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                expression = preview.getText().toString();
                if (expression.isEmpty()) {
                    preview.append("0.");
                } else if (!(Character.isDigit(expression.charAt(expression.length() - 1)))) {
                    if (expression.charAt(expression.length() - 1) != '.')
                        preview.append("0.");
                } else {
                    preview.append(".");
                }
            }
        });
        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                preview.append("0");
            }
        });
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                preview.append("1");
            }
        });
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                preview.append("2");
            }
        });
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                preview.append("3");
            }
        });
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                preview.append("4");
            }
        });
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                preview.append("5");
            }
        });
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                preview.append("6");
            }
        });
        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                preview.append("7");
            }
        });
        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                preview.append("8");
            }
        });
        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                preview.append("9");
            }
        });
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                expression = preview.getText().toString();
                if (!expression.isEmpty())
                    preview.append("+");
            }
        });
        subtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                expression = preview.getText().toString();
                if (!expression.isEmpty())
                    preview.append("-");
            }
        });
        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                expression = preview.getText().toString();
                if (!expression.isEmpty())
                    preview.append("*");
            }
        });
        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                expression = preview.getText().toString();
                if (!expression.isEmpty())
                    preview.append("/");
            }
        });

        equals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                expression = preview.getText().toString();
                if (expression.isEmpty()) {
                    preview.setText("Syntax Error");
                    return;
                } else if (expression.endsWith("+") || expression.endsWith("-") || expression.endsWith("*") || expression.endsWith("/")) {
                    preview.setText("Syntax Error");
                    return;
                }

                if (expression.contains("π"))
                    expression = expression.replace("π", "PI");
                if (expression.contains("%"))
                    expression = expression.replace("%", "/100");
                if (expression.contains("√"))
                    expression = expression.replace("√", "SQRT");
                if (expression.contains("ANS"))
                    expression = expression.replace("ANS", answer);
                if (expression.contains("∞")) {
                    preview.setText(answer);
                    return;
                } else if (expression.contains("-∞")) {
                    preview.setText(answer);
                    return;
                }

                try {
                    if (isParenMatch(expression)) {
                        Expression calculate = new Expression(expression);
                        answer = calculate.eval().toPlainString();
                        if (answer.length() > preview.length())
                            answer = calculate.eval().toString();
                        preview.setText(answer);
                    } else {
                        preview.setText("Syntax Error");
                    }
                } catch (ArithmeticException e) {
                    if (!expression.contains("-") || expression.contains("-0")) {
                        answer = "∞";
                        preview.setText(answer);
                    } else if (expression.contains("-")) {
                        answer = "-∞";
                        preview.setText(answer);
                    }
                }

            }
        });
        if (clear != null) {
            clear.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    preview.setText("");
                }
            });
        }
        if (openParen != null) {
            openParen.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    preview.append("(");
                }
            });
        }
        if (closeParen != null) {
            closeParen.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    preview.append(")");
                }
            });
        }
        if (pi != null) {
            pi.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (!preview.getText().toString().endsWith("π"))
                        preview.append("π");
                }
            });
        }
        if (e != null) {
            e.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (!preview.getText().toString().endsWith("e"))
                        preview.append("e");
                }
            });
        }
        if (percentage != null) {
            percentage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    preview.append("%");
                }
            });
        }

        if (factorial != null) {
            factorial.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    preview.append("fac(");
                }
            });
        }
        if (sqrt != null) {
            sqrt.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (inverse.isChecked())
                        preview.append("^2");
                    else
                        preview.append("√(");
                }
            });
        }
        if (exp != null) {
            exp.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (inverse.isChecked())
                        preview.append("^(1/");
                    else
                        preview.append("^");
                }
            });
        }
        if (expTen != null) {
            expTen.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    preview.append("*10^(");
                }
            });
        }
        if (ln != null) {
            ln.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (inverse.isChecked())
                        preview.append("e^");
                    else
                        preview.append("ln(");
                }
            });
        }
        if (log != null) {
            log.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (inverse.isChecked())
                        preview.append("10^");
                    else
                        preview.append("log(");
                }
            });
        }
        if (sine != null) {
            sine.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (inverse.isChecked()) {
                        if (radToDeg.isChecked())
                            preview.append("asin(");
                        else
                            preview.append("asin(deg(");
                    } else {
                        if (radToDeg.isChecked())
                            preview.append("sin(");
                        else
                            preview.append("sin(deg(");
                    }
                }
            });
        }
        if (cosine != null) {
            cosine.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (inverse.isChecked()) {
                        if (radToDeg.isChecked())
                            preview.append("acos(");
                        else
                            preview.append("acos(deg(");
                    } else {
                        if (radToDeg.isChecked())
                            preview.append("cos(");
                        else
                            preview.append("cos(deg(");
                    }
                }
            });
        }
        if (tangent != null) {
            tangent.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (inverse.isChecked()) {
                        if (radToDeg.isChecked())
                            preview.append("atan(");
                        else
                            preview.append("atan(deg(");
                    } else {
                        if (radToDeg.isChecked())
                            preview.append("tan(");
                        else
                            preview.append("tan(deg(");
                    }
                }
            });
        }
        if (ans != null) {
            ans.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    preview.append("ANS");
                }
            });
        }
        if (delete != null) {
            delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    expression = preview.getText().toString();
                    if (!expression.isEmpty())
                        preview.setText(expression.substring(0, expression.length() - 1));
                }
            });
        }
        if (inverse != null) {
            inverse.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast toast;
                    if (inverse.isChecked()) {
                        toast = Toast.makeText(getApplicationContext(), "Inverse Mode On for \nsin, cos, tan, ln, log, √, ^", Toast.LENGTH_LONG);
                        toast.setGravity(Gravity.CENTER_HORIZONTAL, 0, 0);
                        toast.show();
                    }
                    else {
                        toast = Toast.makeText(getApplicationContext(), "Inverse Mode Off for \nsin, cos, tan, ln, log, √, ^", Toast.LENGTH_LONG);
                        toast.setGravity(Gravity.CENTER_HORIZONTAL, 0, 0);
                        toast.show();
                    }
                }
            });
        }
    }
    public boolean isParenMatch (String expression) {
        Stack<Character> stack = new Stack<Character>();
        char paren;
        for (int i = 0; i < expression.length(); i++) {
            paren = expression.charAt(i);
            if (paren == '(')
                stack.push(paren);
            else if (paren == ')')
                if (stack.empty())
                    return false;
                else if (stack.peek() == '(')
                    stack.pop();
        }
        return stack.empty();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        final TextView savedPreview = (TextView) findViewById(R.id.preview);
        outState.putString("savedPreview", savedPreview.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        final TextView preview = (TextView) findViewById(R.id.preview);
        preview.setText(savedInstanceState.getString("savedPreview"));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_basic_calc, menu);
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
