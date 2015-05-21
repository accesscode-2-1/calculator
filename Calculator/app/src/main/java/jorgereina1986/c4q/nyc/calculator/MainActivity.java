package jorgereina1986.c4q.nyc.calculator;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.math.BigDecimal;


public class MainActivity extends ActionBarActivity {

    Expression expression;
    TextView screen;
    String input;
    Button one, two, three, four, five, six, seven, eight, nine, zero, openP, closeP, point, percent, equals, ac, divide, times, minus, plus, sin, cos, tan, pi, root, delete, exp, e, asin, acos, atan, log, log10, radian, degree;
    String last = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        openP = (Button) findViewById(R.id.openParenthesis);
        closeP = (Button) findViewById(R.id.closeParenthesis);
        zero = (Button) findViewById(R.id.zeroButton);
        one = (Button) findViewById(R.id.oneButton);
        two = (Button) findViewById(R.id.twoButton);
        three = (Button) findViewById(R.id.threeButton);
        four = (Button) findViewById(R.id.fourButton);
        five = (Button) findViewById(R.id.fiveButton);
        six = (Button) findViewById(R.id.sixButton);
        seven = (Button) findViewById(R.id.sevenButton);
        eight = (Button) findViewById(R.id.eightButton);
        nine = (Button) findViewById(R.id.nineButton);
        plus = (Button) findViewById(R.id.plusButton);
        minus = (Button) findViewById(R.id.minusButton);
        times = (Button) findViewById(R.id.timesButton);
        divide = (Button) findViewById(R.id.divideButton);
        equals = (Button) findViewById(R.id.equalButton);
        point = (Button) findViewById(R.id.pointButton);
        percent = (Button) findViewById(R.id.percentButton);
        ac = (Button) findViewById(R.id.acButton);
        sin = (Button) findViewById(R.id.sinButton);
        cos = (Button) findViewById(R.id.cosinButton);
        tan = (Button) findViewById(R.id.tanButton);
        pi = (Button) findViewById(R.id.piButton);
        root = (Button) findViewById(R.id.rootButton);
        delete = (Button) findViewById(R.id.deleteButton);
        exp = (Button) findViewById(R.id.expButton);
        e = (Button) findViewById(R.id.eButton);
        asin = (Button) findViewById(R.id.asinButton);
        acos = (Button) findViewById(R.id.acosButton);
        atan = (Button) findViewById(R.id.atanButton);
        log = (Button) findViewById(R.id.logButton);
        log10 = (Button) findViewById(R.id.log10Button);
        radian = (Button) findViewById(R.id.radianButton);
        degree = (Button) findViewById(R.id.degreeButton);

        //SETTING BUTTONS

        openP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                screen = (TextView) findViewById(R.id.inputField);
                screen.append("(");


            }
        });
        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                screen = (TextView) findViewById(R.id.inputField);
                screen.append("7");

            }
        });
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                screen = (TextView) findViewById(R.id.inputField);
                screen.append("4");

            }
        });
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                screen = (TextView) findViewById(R.id.inputField);
                screen.append("1");

            }
        });
        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                screen = (TextView) findViewById(R.id.inputField);
                screen.append("0");

            }
        });
        closeP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                screen = (TextView) findViewById(R.id.inputField);
                screen.append(")");

            }
        });
        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                screen = (TextView) findViewById(R.id.inputField);
                screen.append("8");

            }
        });
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                screen = (TextView) findViewById(R.id.inputField);
                screen.append("5");

            }
        });
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                screen = (TextView) findViewById(R.id.inputField);
                screen.append("2");

            }
        });
        point.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                screen = (TextView) findViewById(R.id.inputField);
                screen.append(".");

            }
        });
        percent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                screen = (TextView) findViewById(R.id.inputField);
                screen.append("%(");

            }
        });
        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                screen = (TextView) findViewById(R.id.inputField);
                screen.append("9");

            }
        });
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                screen = (TextView) findViewById(R.id.inputField);
                screen.append("6");

            }
        });
        equals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                screen = (TextView) findViewById(R.id.inputField);
                input = screen.getText().toString();
                BigDecimal answer = null;
                try {
                    Expression expression = new Expression(input);
                    answer = expression.eval();
                    screen.setText("" + answer.toPlainString());
                } catch (Exception e) {
                    screen.setText("Wrong Format");
                }


            }
        });
        ac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                screen = (TextView) findViewById(R.id.inputField);
                screen.setText("");

            }
        });
        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                screen = (TextView) findViewById(R.id.inputField);
                String screenText = screen.getText().toString();
                if (screenText.length()>0){
                    last = screenText.substring(screenText.length()-1);}

                if (last.equals("/")){
                    screen.append("");
                }
                else {
                    screen.append("/");
                }
            }
        });
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                screen = (TextView) findViewById(R.id.inputField);
                screen.append("3");

            }
        });
        times.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                screen = (TextView) findViewById(R.id.inputField);
                String screenText = screen.getText().toString();
                if (screenText.length()>0){
                    last = screenText.substring(screenText.length()-1);}

                if (last.equals("*")){
                    screen.append("");
                }
                else {
                    screen.append("*");
                }

            }
        });
        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                screen = (TextView) findViewById(R.id.inputField);
                String screenText = screen.getText().toString();

                if (screenText.length()>0){
                    last = screenText.substring(screenText.length()-1);}

                if (last.equals("-")){
                    screen.append("");
                }
                else {
                    screen.append("-");
                }

            }
        });
        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                screen = (TextView) findViewById(R.id.inputField);
                String screenText = screen.getText().toString();
                if (screenText.length()>0){
                    last = screenText.substring(screenText.length()-1);}

                if (last.equals("+")){
                    screen.append("");
                }
                else {
                    screen.append("+");
                }

            }
        });
        sin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                screen = (TextView) findViewById(R.id.inputField);
                screen.append("SIN(");


            }
        });
        cos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                screen = (TextView) findViewById(R.id.inputField);
                screen.append("COS(");

            }
        });
        tan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                screen = (TextView) findViewById(R.id.inputField);
                screen.append("TAN(");

            }
        });
        pi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                screen = (TextView) findViewById(R.id.inputField);
                screen.append("PI");

            }
        });
        root.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                screen = (TextView) findViewById(R.id.inputField);
                screen.append("SQRT(");

            }
        });
        exp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                screen = (TextView) findViewById(R.id.inputField);
                screen.append("^");

            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                screen = (TextView) findViewById(R.id.inputField);
                try {
                    screen.setText(screen.getText().toString().substring(0, screen.getText().toString().length()-1));

                }
                catch (StringIndexOutOfBoundsException e){
                    screen.setText("");
                }
            }
        });
        e.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                screen = (TextView) findViewById(R.id.inputField);
                screen.append("e");

            }
        });
        asin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                screen = (TextView) findViewById(R.id.inputField);
                screen.append("ASIN(");

            }
        });
        acos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                screen = (TextView) findViewById(R.id.inputField);
                screen.append("ACOS(");

            }
        });
        atan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                screen = (TextView) findViewById(R.id.inputField);
                screen.append("ATAN(");

            }
        });
        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                screen = (TextView) findViewById(R.id.inputField);
                screen.append("LOG(");

            }
        });
        radian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                screen = (TextView) findViewById(R.id.inputField);
                screen.append("RAD(");

            }
        });
        degree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                screen = (TextView) findViewById(R.id.inputField);
                screen.append("DEG(");

            }
        });

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
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
