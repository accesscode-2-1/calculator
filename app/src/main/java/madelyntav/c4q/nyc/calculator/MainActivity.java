package madelyntav.c4q.nyc.calculator;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.math.BigDecimal;
import java.util.EmptyStackException;

public class MainActivity extends ActionBarActivity {
    private String ans ="";
    private TextView ansview;
    private String toBeEvaluated =" ";
    private String showOnScreen = " ";
    private TextView calcScreen;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calcScreen = (TextView) findViewById(R.id.calcScreen);
        ansview = (TextView) findViewById(R.id.anstxtview);

        if(savedInstanceState != null ) {
            calcScreen.setText(savedInstanceState.getString("toBeEvaluated"));
            toBeEvaluated=savedInstanceState.getString("toBeEvaluated");
        }
        calcScreen.setText(toBeEvaluated);
    }


    public void getButtonText(View v) {
        Button button = (Button) findViewById(v.getId());
        String buttonText = button.getText().toString();

        if(toBeEvaluated.equals(null)){
            showOnScreen=buttonText;
            toBeEvaluated+=showOnScreen;
        } else if (toBeEvaluated != null) {

            //changed code to replace number check. Does the same but it's cleaner
            if (Character.isDigit(toBeEvaluated.charAt(toBeEvaluated.length() - 1))) {
                    toBeEvaluated += buttonText;
                    showOnScreen = toBeEvaluated;
            } else {
                toBeEvaluated += buttonText;
                showOnScreen += buttonText;
            }
        }
        calcScreen = (TextView) findViewById(R.id.calcScreen);
        calcScreen.setText(showOnScreen.trim());
    }


    public void getOperators(View v) {

        Button button = (Button) findViewById(v.getId());
        calcScreen = (TextView) findViewById(R.id.calcScreen);
        char check = button.getText().charAt(0);


        if ((toBeEvaluated == null) || (toBeEvaluated.equals("")||toBeEvaluated.equals(" "))) {
            toBeEvaluated += "0" + button.getText().toString();
            showOnScreen =button.getText().toString();
        } else if (toBeEvaluated.charAt(toBeEvaluated.length()-1) == check){
            toBeEvaluated+="";
            showOnScreen+="";
        }
        else {
            toBeEvaluated += button.getText().toString();
            showOnScreen = button.getText().toString();
        }
        calcScreen.setText(toBeEvaluated);
    }


    public void Sohcahtoa(View v) {

        Button button = (Button) findViewById(v.getId());
        TextView calcS = (TextView) findViewById(R.id.calcScreen);

        if (showOnScreen == null) {
            toBeEvaluated = button.getText() + "(";
            calcS.setText(toBeEvaluated);
        } else if (showOnScreen.equals("")||showOnScreen.equals(" ")) {
            showOnScreen.trim();
            toBeEvaluated = button.getText() + "(";
        } else
            toBeEvaluated = button.getText() + "(" + toBeEvaluated + ")";

            showOnScreen = toBeEvaluated;

            calcS.setText(showOnScreen);
    }


    public void negButton(View v) {
        if (toBeEvaluated.charAt(0) != '-' && toBeEvaluated.charAt(0) != '+') {
            toBeEvaluated = "-" + toBeEvaluated;
        } else if (toBeEvaluated.charAt(0) == '-') {
            toBeEvaluated = toBeEvaluated.replace(toBeEvaluated.charAt(0), ' ');
            toBeEvaluated = toBeEvaluated.trim();
        }
        calcScreen.setText(toBeEvaluated);
    }


    public void allClear(View v) {
        toBeEvaluated = " ";
        showOnScreen = toBeEvaluated;
        calcScreen = (TextView) findViewById(R.id.calcScreen);
        calcScreen.setText(toBeEvaluated);
    }


    public void ans(View v) {

        if ((calcScreen.getText() != "") && ans == "") {
            Expressions expressions = new Expressions(calcScreen.getText().toString());
            BigDecimal res = new BigDecimal(String.valueOf(expressions.eval()));
            ans = ((res.toPlainString()));
            ansview.setText(ans);
        } else if (ans != "") {
            toBeEvaluated += ans;
            calcScreen.setText(toBeEvaluated);
        } else if (ans == "" && calcScreen.getText() == ""){
            calcScreen.setText("");
            ansview.setText("");
        }
    }


    public void clearans(View v){
        ans ="";
        ansview.setText(ans);
    }


    public void absolutEval(View v) {
        try {
            Expressions expressions = new Expressions(toBeEvaluated);
            BigDecimal result = new BigDecimal(String.valueOf(expressions.eval()));
            toBeEvaluated = result.toPlainString();

            if (toBeEvaluated.charAt(0) != '-' && toBeEvaluated.charAt(0) != '+') {
                toBeEvaluated = "-" + toBeEvaluated;
            } else if (toBeEvaluated.charAt(0) == '-') {
                toBeEvaluated = toBeEvaluated.replace(toBeEvaluated.charAt(0), ' ');
                toBeEvaluated = toBeEvaluated.trim();
            }
            calcScreen.setText(toBeEvaluated);

        } catch (EmptyStackException e) {
            calcScreen.setText("Err. Nothing To Calculate");
        } catch (NullPointerException e) {
            calcScreen.setText("Err. Invalid input, Clear Screen.");
        } catch (RuntimeException r) {
            calcScreen.setText("Error");
        }
    }


    private void checkParenthesis() {
        int p = 0;

        for (int i = 0; i < toBeEvaluated.length(); i++) {
            if (toBeEvaluated.charAt(i) == '(') {
                p++;
            } else if (toBeEvaluated.charAt(i) == ')') {
                p--;
            }
        }
        if (p > 0) {
            toBeEvaluated += ")";
        }
        calcScreen.setText(toBeEvaluated);
    }


    public void openAndCloseParens(View v) {
        int p = 0;
        Button button=(Button) findViewById(v.getId());
        if (toBeEvaluated == null) {
            toBeEvaluated = button.getText()+"(";
        }
        if (toBeEvaluated.equals("")||toBeEvaluated.equals(" ")) {
            toBeEvaluated =button.getText()+ "(";
        } else {
            for (int i = 0; i < toBeEvaluated.length(); i++) {
                if (toBeEvaluated.charAt(i) == '(') {
                    p++;
                } else if (toBeEvaluated.charAt(i) == ')') {
                    p--;
                }
            }
            if (p > 0) {
                toBeEvaluated += ")";

            } else {
                toBeEvaluated += "(";
            }
        }
        TextView calcS = (TextView) findViewById(R.id.calcScreen);
        calcS.setText(toBeEvaluated);
    }


    public void evaluateExpression(View v) {

        checkParenthesis();

        try {
            Button button = (Button) findViewById(v.getId());
            showOnScreen += button.getText();

            Expressions expressions = new Expressions(toBeEvaluated);
            BigDecimal result = new BigDecimal(String.valueOf(expressions.eval()));//gives result.

            showOnScreen = result.toPlainString();

//            toBeEvaluated+=showOnScreen; <--This was giving us the wrong results.

            calcScreen.setText((showOnScreen));
            if (Character.isDigit(showOnScreen.charAt(showOnScreen.length() - 1))
                    && Character.isDigit(button.getText().charAt(0))) {
                showOnScreen.equals("");
                toBeEvaluated.equals("");
                toBeEvaluated = button.getText().toString();
                calcScreen.setText(toBeEvaluated);
            }
        } catch (EmptyStackException e) {
            calcScreen.setText("Err. Nothing Here, Clear Screen.");
        } catch (NullPointerException e) {
            calcScreen.setText("Err. Null Pointer.");
        } catch (RuntimeException r) {
            calcScreen.setText("You broke me. :( Clear.");
        }
    }


    @Override
    public void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putString("toBeEvaluated", calcScreen.getText().toString());
        outState.putString("showOnScreen",showOnScreen);
    }
}