package madelyntav.c4q.nyc.calculator;

import android.content.res.Configuration;
import android.provider.ContactsContract;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.math.BigDecimal;
import java.util.EmptyStackException;


public class MainActivity extends ActionBarActivity {
    private String ans ="";
    private String toBeEvaluated =" ";
    private String showOnScreen = " ";
    private TextView calcScreen;
    private TextView ansview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        calcScreen = (TextView) findViewById(R.id.calcScreen);

        if( savedInstanceState != null ) {
            Toast.makeText(this, savedInstanceState.getString("toBeEvaluated"), Toast.LENGTH_LONG).show();

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
        }
        if (toBeEvaluated != null) {
            if (toBeEvaluated.charAt(toBeEvaluated.length() - 1) == '=') {
                if (buttonText.equals("1") ||
                        buttonText.equals("2") ||
                        buttonText.equals("3") ||
                        buttonText.equals("4") ||
                        buttonText.equals("5") ||
                        buttonText.equals("6") ||
                        buttonText.equals("7") ||
                        buttonText.equals("8") ||
                        buttonText.equals("9") ||
                        buttonText.equals("0")) {
                    toBeEvaluated += buttonText;
                    showOnScreen = buttonText;
//                    showOnScreen.trim();
//                    toBeEvaluated.trim();
                }

            } else {
                toBeEvaluated += buttonText;
                showOnScreen+=buttonText;
            }
        }

        calcScreen = (TextView) findViewById(R.id.calcScreen);


        calcScreen.setText(showOnScreen.trim());

    }

    public void getOperators(View v) {

        Button button = (Button) findViewById(v.getId());

        calcScreen = (TextView) findViewById(R.id.calcScreen);

        char check=button.getText().charAt(0);


        if ((toBeEvaluated == null) || (toBeEvaluated.equals("")||toBeEvaluated.equals(" "))) {


            toBeEvaluated += "0" + button.getText().toString();
            showOnScreen =button.getText().toString();

        } else

        if (toBeEvaluated.charAt(toBeEvaluated.length()-1)==check){
            toBeEvaluated+="";
            showOnScreen+="";

        }

        else {

            toBeEvaluated += button.getText().toString();


            showOnScreen = button.getText().toString();
        }

        calcScreen.setText(showOnScreen);
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
        }
    }

    public void absolutEval(View v) {
        try {
            //calcScreen = (TextView) findViewById(R.id.calcScreen);
            //toBeEvaluated = calcScreen.getText().toString();


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
        ans = "";


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

        //TODO Edge Cases(JOHN)
        //TODO fix layout

        checkParenthesis();

        try {



            Button button = (Button) findViewById(v.getId());

            showOnScreen += button.getText();
            //toBeEvaluated+=button.getText();
            //toBeEvaluated.toString();

            Expressions expressions = new Expressions(toBeEvaluated);
            BigDecimal result = new BigDecimal(String.valueOf(expressions.eval()));

            showOnScreen = result.toPlainString();

            toBeEvaluated+=showOnScreen;

            calcScreen.setText((showOnScreen));

//            ans=showOnScreen;
//            ansview=(TextView) findViewById(R.id.anstxtview);
//            ansview.setText(ans.trim());

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

