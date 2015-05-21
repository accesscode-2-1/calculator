package gmsyrimis.c4q.nyc.calc;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.AndroidRuntimeException;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import java.math.BigDecimal;
import java.util.List;


public class MainActivity extends Activity {

    // Standard Calc
    Button multiply;
    Button plus;
    Button minus;
    Button divide;
    Button one;
    Button two;
    Button three;
    Button four;
    Button five;
    Button six;
    Button seven;
    Button eight;
    Button nine;
    Button zero;
    Button clear;
    Button equalsBtn;
    Button bksp;
    Button rightParenthesis;
    Button leftParenthesis;
    Button decimal;
    // Sci calc
    Button factorial;
    Button sqrt;
    Button percentage;
    Button sin;
    Button cos;
    Button tan;
    Button rd;
    Button log;
    Button oneOverX;
    Button eX;
    Button xSquared;
    Button yToX;
    Button absolute;
    Button pi;
    Button e;

    TextView calculate;

    boolean lastPressed_Equals =false;
    boolean radians = true;

    static final String STATE_DISPLAY = "Calculator Display";


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);


        //show that calc is in radians mode
        getActionBar().setTitle("Tasha & George Awesome Calculator");

        calculate = (TextView) findViewById(R.id.calculate);

        if (savedInstanceState != null) {
            calculate.setText(savedInstanceState.getString(STATE_DISPLAY));
        }

        multiply = (Button) findViewById(R.id.multiply_btn);
        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (lastPressed_Equals==true||calculate.getText().toString().equals("ERROR")){
                    calculate.setText("");
                }
                calculate.append("*");
                lastPressed_Equals=false;
            }
        });
        divide =(Button) findViewById(R.id.division_btn);
        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (lastPressed_Equals==true||calculate.getText().toString().equals("ERROR")){
                    calculate.setText("");
                }
                calculate.append("/");
                lastPressed_Equals=false;
            }
        });
        plus = (Button) findViewById(R.id.plus_btn);
        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (lastPressed_Equals==true||calculate.getText().toString().equals("ERROR")){
                    calculate.setText("");
                }
                calculate.append("+");
                lastPressed_Equals=false;
            }
        });
        minus = (Button) findViewById(R.id.minus_btn);
        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (lastPressed_Equals==true||calculate.getText().toString().equals("ERROR")){
                    calculate.setText("");
                }
                calculate.append("-");
                lastPressed_Equals=false;
            }
        });
        one = (Button) findViewById(R.id.one_btn);
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (lastPressed_Equals==true||calculate.getText().toString().equals("ERROR")){
                    calculate.setText("");
                }
                calculate.append("1");
                lastPressed_Equals=false;
            }
        });
        two = (Button) findViewById(R.id.two_btn);
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (lastPressed_Equals==true||calculate.getText().toString().equals("ERROR")){
                    calculate.setText("");
                }
                calculate.append("2");
                lastPressed_Equals=false;
            }
        });
        three =  (Button) findViewById(R.id.three_btn);
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (lastPressed_Equals==true||calculate.getText().toString().equals("ERROR")){
                    calculate.setText("");
                }
                calculate.append("3");
                lastPressed_Equals=false;
            }
        });
        four= (Button) findViewById(R.id.four_btn);
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (lastPressed_Equals==true||calculate.getText().toString().equals("ERROR")){
                    calculate.setText("");
                }
                calculate.append("4");
                lastPressed_Equals=false;
            }
        });
        five = (Button) findViewById(R.id.five_btn);
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (lastPressed_Equals==true||calculate.getText().toString().equals("ERROR")){
                    calculate.setText("");
                }
                calculate.append("5");
                lastPressed_Equals=false;
            }
        });
        six=(Button) findViewById(R.id.six_btn);
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (lastPressed_Equals==true||calculate.getText().toString().equals("ERROR")){
                    calculate.setText("");
                }
                calculate.append("6");
                lastPressed_Equals=false;
            }
        });
        seven = (Button) findViewById(R.id.seven_btn);
        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (lastPressed_Equals==true||calculate.getText().toString().equals("ERROR")){
                    calculate.setText("");
                }
                calculate.append("7");
                lastPressed_Equals=false;
            }
        });
        eight = (Button) findViewById(R.id.eight_btn);
        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (lastPressed_Equals==true||calculate.getText().toString().equals("ERROR")){
                    calculate.setText("");
                }
                calculate.append("8");
                lastPressed_Equals=false;
            }
        });
        nine = (Button) findViewById(R.id.nine_btn);
        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (lastPressed_Equals==true||calculate.getText().toString().equals("ERROR")){
                    calculate.setText("");
                }
                calculate.append("9");
                lastPressed_Equals=false;
            }
        });
        zero =  (Button) findViewById(R.id.zero_btn);
        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (lastPressed_Equals==true||calculate.getText().toString().equals("ERROR")){
                    calculate.setText("");
                }
                calculate.append("0");
                lastPressed_Equals=false;
            }
        });
        clear = (Button) findViewById(R.id.clear_btn);
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (lastPressed_Equals==true||calculate.getText().toString().equals("ERROR")){
                    calculate.setText("");
                }
                calculate.setText("");
                lastPressed_Equals=false;
            }
        });
        equalsBtn = (Button) findViewById(R.id.equals_btn);
        equalsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = calculate.getText().toString();
                String input2 = "";
//                if (radians) {
//                     input2 = "RAD(" + input + ")";
//                }
//                else {
//                     input2 = "DEG(" + input + ")";
//                }
                try{
                Expression exp = new Expression(input);
                BigDecimal answer;
                answer = exp.eval();
                String anwserStr = answer.toString();
                calculate.setText(anwserStr);
                }
                catch (RuntimeException e){
                    calculate.setText("ERROR");
                }
                lastPressed_Equals=true;
            }
        });
        bksp = (Button) findViewById(R.id.backspace_btn);
        bksp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (lastPressed_Equals==true||calculate.getText().toString().equals("ERROR")){
                    calculate.setText("");
                }
                if(calculate.getText().toString().length()>0){
                String past = calculate.getText().toString();
                String now = past.substring(0,past.length()-1);
                calculate.setText(now);
                }
                lastPressed_Equals=false;
            }
        });
        rightParenthesis = (Button) findViewById(R.id.right_parenthesis_btn);
        rightParenthesis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (lastPressed_Equals==true||calculate.getText().toString().equals("ERROR")){
                    calculate.setText("");
                }
                calculate.append(")");
                lastPressed_Equals=false;
            }
        });
        leftParenthesis = (Button) findViewById(R.id.left_parenthesis_btn);
        leftParenthesis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (lastPressed_Equals==true||calculate.getText().toString().equals("ERROR")){
                    calculate.setText("");
                }
                calculate.append("(");
                lastPressed_Equals=false;
            }
        });
        decimal = (Button) findViewById(R.id.decimal_btn);
        decimal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (lastPressed_Equals==true||calculate.getText().toString().equals("ERROR")){
                    calculate.setText("");
                }
                calculate.append(".");
                lastPressed_Equals=false;
            }
        });

        // SCICALC
//        if(findViewById(R.id.factorial_btn)!=null) {
//            factorial = (Button) findViewById(R.id.factorial_btn);
//            factorial.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    if (lastPressed_Equals==true||calculate.getText().toString().equals("ERROR")){
//                        calculate.setText("");
//                    }
//                    calculate.append("!(");
//                    lastPressed_Equals=false;
//                }
//            });
//        }
        if(findViewById(R.id.sqrt_btn)!=null) {
            sqrt = (Button) findViewById(R.id.sqrt_btn);
            sqrt.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (lastPressed_Equals==true||calculate.getText().toString().equals("ERROR")){
                        calculate.setText("");
                    }
                    calculate.append("sqrt(");
                    lastPressed_Equals=false;
                }
            });
        }
//        if(findViewById(R.id.percent_btn)!=null) {
//            percentage = (Button) findViewById(R.id.percent_btn);
//            percentage.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    if (lastPressed_Equals==true||calculate.getText().toString().equals("ERROR")){
//                        calculate.setText("");
//                    }
//                    calculate.append("%");
//                    lastPressed_Equals=false;
//                }
//            });
//        }
        if(findViewById(R.id.sin_btn)!=null) {
            sin = (Button) findViewById(R.id.sin_btn);
            sin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (lastPressed_Equals==true||calculate.getText().toString().equals("ERROR")){
                        calculate.setText("");
                    }
                    calculate.append("sin(");
                    lastPressed_Equals=false;
                }
            });
        }
        if(findViewById(R.id.cos_btn)!=null) {
            cos = (Button) findViewById(R.id.cos_btn);
            cos.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (lastPressed_Equals==true||calculate.getText().toString().equals("ERROR")){
                        calculate.setText("");
                    }
                    calculate.append("cos(");
                    lastPressed_Equals=false;
                }
            });
        }
        if(findViewById(R.id.tan_btn)!=null) {
            tan = (Button) findViewById(R.id.tan_btn);
            tan.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (lastPressed_Equals==true||calculate.getText().toString().equals("ERROR")){
                        calculate.setText("");
                    }
                    calculate.append("tan(");
                    lastPressed_Equals=false;
                }
            });
        }
//        //RAD and DEG button, toggles title bar to display
//        //calc - radians or calc - degrees
//        if(findViewById(R.id.rd_btn)!=null) {
//            rd = (Button) findViewById(R.id.rd_btn);
//            rd.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    if (lastPressed_Equals==true||calculate.getText().toString().equals("ERROR")){
//                        calculate.setText("");
//                    }
//                    if (radians) {
//                    getActionBar().setTitle("Calc - degrees");
//                    radians = false;
//                    rd.setText("RAD");
//                    }
//                    else {
//                        getActionBar().setTitle("Calc - radians");
//                        radians = true;
//                        rd.setText("DEG");
//                    }
//                    //calculate.append("Ln(");
//                    lastPressed_Equals=false;
//                }
//            });
//        }
        if(findViewById(R.id.log_btn)!=null) {
            log = (Button) findViewById(R.id.log_btn);
            log.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (lastPressed_Equals==true||calculate.getText().toString().equals("ERROR")){
                        calculate.setText("");
                    }
                    calculate.append("log(");
                    lastPressed_Equals=false;
                }
            });
        }
        if(findViewById(R.id.denominator_btn)!=null) {
            oneOverX = (Button) findViewById(R.id.denominator_btn);
            oneOverX.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (lastPressed_Equals==true||calculate.getText().toString().equals("ERROR")){
                        calculate.setText("");
                    }
                    calculate.append("1/");
                    lastPressed_Equals=false;
                }
            });
        }
        if(findViewById(R.id.ePOWx_btn)!=null) {
            eX = (Button) findViewById(R.id.ePOWx_btn);
            eX.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (lastPressed_Equals==true||calculate.getText().toString().equals("ERROR")){
                        calculate.setText("");
                    }
                    calculate.append("E^");
                    lastPressed_Equals=false;
                }
            });
        }
        if(findViewById(R.id.xsquared_btn)!=null) {
            xSquared = (Button) findViewById(R.id.xsquared_btn);
            xSquared.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (lastPressed_Equals==true||calculate.getText().toString().equals("ERROR")){
                        calculate.setText("");
                    }
                    calculate.append("^2");
                    lastPressed_Equals=false;
                }
            });
        }
        if(findViewById(R.id.absolute_btn)!=null) {
            absolute = (Button) findViewById(R.id.absolute_btn);
            absolute.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (lastPressed_Equals==true||calculate.getText().toString().equals("ERROR")){
                        calculate.setText("");
                    }
                    calculate.append("ABS(");
                    lastPressed_Equals=false;
                }
            });
        }
        if(findViewById(R.id.pi_btn)!=null) {
            pi = (Button) findViewById(R.id.pi_btn);
            pi.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (lastPressed_Equals==true||calculate.getText().toString().equals("ERROR")){
                        calculate.setText("");
                    }
                    calculate.append("PI");
                    lastPressed_Equals=false;
                }
            });
        }
        if(findViewById(R.id.e_btn)!=null) {
            e = (Button) findViewById(R.id.e_btn);
            e.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (lastPressed_Equals==true||calculate.getText().toString().equals("ERROR")){
                        calculate.setText("");
                    }
                    calculate.append("E");
                    lastPressed_Equals=false;
                }
            });
        }
        if(findViewById(R.id.YpowX_btn)!=null) {
            yToX = (Button) findViewById(R.id.YpowX_btn);
            yToX.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (lastPressed_Equals==true||calculate.getText().toString().equals("ERROR")){
                        calculate.setText("");
                    }
                    calculate.append("^");
                    lastPressed_Equals=false;
                }
            });
        }

    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        TextView tv = (TextView) findViewById(R.id.calculate);
        savedInstanceState.putString(STATE_DISPLAY, tv.getText().toString());
        super.onSaveInstanceState(savedInstanceState);
    }
}
