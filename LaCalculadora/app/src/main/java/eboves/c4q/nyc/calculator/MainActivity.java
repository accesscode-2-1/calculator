package eboves.c4q.nyc.calculator;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.math.BigDecimal;
import java.util.ArrayList;


public class MainActivity extends ActionBarActivity {

    String ANS;
    private TextView input;
   // private Button butXPower;
    private Button butSum;
    private Button butSub;
    private Button butMult;
    private Button butDiv;
    private Button butClr;
    private Button butDot;
    private Button but0;
    private Button but1;
    private Button but2;
    private Button but3;
    private Button but4;
    private Button but5;
    private Button but6;
    private Button but7;
    private Button but8;
    private Button but9;
    private Button butDelete;

    //Scientific Calculator part

    private Button butSin;
    private Button butCos;
    private Button butTan;
    private Button butLog;
    private Button butLn;
    private Button butExponent;
    private Button butLeftParent;
    private Button butRightParent;
    private Button butXPower;
    private Button butPI;
    private Button butAns;

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState != null) {
            input.setText(savedInstanceState.getString("text1", ""));
        }
    }

    private Button butE;
    //private Button butRadian;
    private Button butDegree;
    //private Button butInvertido;
    private Button butRadical;
    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        input = (TextView) findViewById(R.id.textResult1);
        input.setMovementMethod(new ScrollingMovementMethod());

        but0 = (Button) findViewById(R.id.but0);
        but1 = (Button) findViewById(R.id.but1);
        but2 = (Button) findViewById(R.id.but2);
        but3 = (Button) findViewById(R.id.but3);
        but4 = (Button) findViewById(R.id.but4);
        but5 = (Button) findViewById(R.id.but5);
        but6 = (Button) findViewById(R.id.but6);
        but7 = (Button) findViewById(R.id.but7);
        but8 = (Button) findViewById(R.id.but8);
        but9 = (Button) findViewById(R.id.but9);
        butDelete = (Button) findViewById(R.id.butDelete);
        butDot = (Button) findViewById(R.id.butDot);
        butSub = (Button) findViewById(R.id.butSub);
        butDiv = (Button) findViewById(R.id.butDiv);
        butMult = (Button) findViewById(R.id.butMult);
        butSum = (Button) findViewById(R.id.butSum);
        butSin = (Button) findViewById(R.id.butSin);
        butCos = (Button) findViewById(R.id.butCos);
        butTan = (Button) findViewById(R.id.butTan);
        butLog = (Button) findViewById(R.id.butLog);
        butLn = (Button) findViewById(R.id.butLn);
        butLeftParent = (Button) findViewById(R.id.butLeftParent);
        butRightParent = (Button) findViewById(R.id.butRightParent);
        butXPower = (Button) findViewById(R.id.butXPower);
        butExponent = (Button) findViewById(R.id.butExponent);
        butE = (Button) findViewById(R.id.butE);
        butClr = (Button) findViewById(R.id.butClr);
        butPI = (Button) findViewById(R.id.butPI);
        //butRadian = (Button) findViewById(R.id.butRadian);
        butDegree = (Button) findViewById(R.id.butDegree);
        butClr = (Button) findViewById(R.id.butClr);
        butRadical = (Button) findViewById(R.id.butRadical);
        butSin = (Button) findViewById(R.id.butSin);
        //butInvertido = (Button) findViewById(R.id.butInvertido);

        result = (TextView) findViewById(R.id.textResult1);

        ButtonOnClickListener listener = new ButtonOnClickListener(result);

        ArrayList<Button> buttons = new ArrayList<Button>();
        buttons.add(but0);
        buttons.add(but1);
        buttons.add(but2);
        buttons.add(but3);
        buttons.add(but4);
        buttons.add(but5);
        buttons.add(but6);
        buttons.add(but6);
        buttons.add(but7);
        buttons.add(but8);
        buttons.add(but9);
        buttons.add(butDelete);
        buttons.add(butDot);
        buttons.add(butDiv);
        buttons.add(butSum);
        buttons.add(butSub);
        buttons.add(butMult);
        buttons.add(butClr);
        buttons.add(butSin);
        buttons.add(butCos);
        buttons.add(butTan);
        buttons.add(butLog);
        buttons.add(butLn);
        buttons.add(butXPower);
        buttons.add(butE);
        buttons.add(butPI);
        //buttons.add(butRadian);
        buttons.add(butDegree);
        buttons.add(butExponent);
        buttons.add(butRadical);
        buttons.add(butLeftParent);
        buttons.add(butRightParent);
        //buttons.add(butInvertido);

        for (Button button : buttons) {
            if (button != null) { //prevents app from crashing when put to landscape
                button.setOnClickListener(listener);
            }
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("text1", input.getText().toString());
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

    public void inv(View v) {
        butSin.setText("sin-1");
        //butSin.setText("sin");

    }

    public void solve(View v) {
        String inputString = input.getText().toString() ;
        BigDecimal resultBigDecimal = null;
        String last2 = inputString.substring(inputString.length() - 1); //gets last character of inputString
        // prevents app from crashing if last2 character is ...
        if (last2.equals("+")) {
            input.setText(inputString);
        } else if (last2.equals("-")) {
            input.setText(inputString);
        } else if (last2.equals("/")) {
            input.setText(inputString);
        } else if (last2.equals("*")) {
            input.setText(inputString);
        } else if (last2.equals(".")) {
            input.setText(inputString);
        } else if (inputString.equals(" ")) {
            input.setText(inputString);
        } else if (last2.equals("(")) {
            input.setText(inputString);
        }
        else {

            try {
                resultBigDecimal = new Expression(inputString).eval();// call eval to parse add solve
            } catch (Exception e) {
                input.setText("Nice try. I won't crash that easily.");
                return;
            }
            String resultString = resultBigDecimal.toPlainString();// converts big decimal result to plainstring
            input.setText(resultString);

            if (inputString.length() < 5) {
                input.setText(resultString + " (That was Easy)");
            } else if (inputString.length() > 10) {
                input.setText(resultString + " (Hard One)");
            }
            else {
                input.setText(resultString);
            }
        }
    }
    public void factorial(View v) {
        String inputString = input.getText().toString();
        BigDecimal resultBigDecimal = null;
        String last2 = inputString.substring(inputString.length() - 1); //gets last character of inputString
        // prevents app from crashing if last2 character is ...
        if (last2.equals("+")) {
            input.setText(inputString);
        } else if (last2.equals("-")) {
            input.setText(inputString);
        } else if (last2.equals("/")) {
            input.setText(inputString);
        } else if (last2.equals("*")) {
            input.setText(inputString);
        } else if (last2.equals(".")) {
            input.setText(inputString);
        } else if (inputString.equals(" ")) {
            input.setText(inputString);
        } else if (last2.equals("(")) {
            input.setText(inputString);
        } else {
            try {
                resultBigDecimal = new Expression(inputString).eval();// call eval to parse add solve
            } catch (Exception e) {
                input.setText("Nice try. I won't crash that easily.");
                return;
            }
            String resultString = resultBigDecimal.toPlainString();// converts big decimal result to plainstring
            input.setText(resultString);
            resultString = input.getText().toString();
            int result2 = Integer.parseInt(resultString);
            double result = 1;

            for (int i = result2; i > 1; i--) {
                result = result * i;
            }
            input.setText(result + "");
        }
    }
    public void percentage(View v) {
        String inputString = input.getText().toString();
        BigDecimal resultBigDecimal = null;
        String last2 = inputString.substring(inputString.length() - 1); //gets last character of inputString
        // prevents app from crashing if last2 character is ...
        if (last2.equals("+")) {
            input.setText(inputString);
        } else if (last2.equals("-")) {
            input.setText(inputString);
        } else if (last2.equals("/")) {
            input.setText(inputString);
        } else if (last2.equals("*")) {
            input.setText(inputString);
        } else if (last2.equals(".")) {
            input.setText(inputString);
        } else if (inputString.equals(" ")) {
            input.setText(inputString);
        } else if (last2.equals("(")) {
            input.setText(inputString);
        } else {
            try {
                resultBigDecimal = new Expression(inputString).eval();// call eval to parse add solve
            } catch (Exception e) {
                input.setText("Nice try. I won't crash that easily.");
                return;
            }
            double d = resultBigDecimal.doubleValue();
            double e = d * 0.01;
            input.setText(e + "");

        }
    }
    public void ans (View v) {
        butAns = (Button) findViewById(R.id.butAns);
        //change button text to change action of button depending on text
        if (butAns.getText().equals("ans")) {
            ANS = input.getText().toString();
            Log.d("ans", ANS);
            butAns.setText("ANS");
        }
        else {
            String inputString = input.getText().toString() + ANS;
            Log.d("inputString", inputString);
            input.setText(inputString);
            butAns.setText("ans");
        }
    }
    public void rad (View v) {
//        String inputString = input.getText().toString() ;
//        BigDecimal resultBigDecimal = null;
//        String last2 = inputString.substring(inputString.length() - 1); //gets last character of inputString
//        // prevents app from crashing if last2 character is ...
//        if (last2.equals("+")) {
//            input.setText(inputString);
//        } else if (last2.equals("-")) {
//            input.setText(inputString);
//        } else if (last2.equals("/")) {
//            input.setText(inputString);
//        } else if (last2.equals("*")) {
//            input.setText(inputString);
//        } else if (last2.equals(".")) {
//            input.setText(inputString);
//        } else if (inputString.equals(" ")) {
//            input.setText(inputString);
//        } else if (last2.equals("(")) {
//            input.setText(inputString);
//        }
//        else {
//
//            try {
//                resultBigDecimal = new Expression(inputString).eval();// call eval to parse add solve
//            } catch (Exception e) {
//                input.setText("Nice try. I won't crash that easily.");
//                return;
//            }
//            String resultString = resultBigDecimal.toPlainString();// converts big decimal result to plainstring
//            input.setText(resultString);
//
//            if (inputString.length() < 5) {
//                input.setText(resultString + " (That was Easy)");
//            } else if (inputString.length() > 10) {
//                input.setText(resultString + " (Hard One)");
//            }
//            else {
//                input.setText(resultString);
//                return;
//            }
//            double e = resultBigDecimal.doubleValue();
//            double result = (Math.toDegrees(e)*(Math.PI/180));
//            Log.d("result","" result);
            input.setText("coming soon");
        }
    }
//}



