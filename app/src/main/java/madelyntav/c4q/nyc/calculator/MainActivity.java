package madelyntav.c4q.nyc.calculator;

import android.provider.ContactsContract;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.math.BigDecimal;
import java.util.EmptyStackException;


public class MainActivity extends ActionBarActivity {
    private String ans = "";
    private String toBeEvaluated="";
    private String showOnScreen=" ";
    private TextView calcScreen;
    private TextView ansview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calcScreen = (TextView) findViewById(R.id.calcScreen);
        ansview = (TextView) findViewById(R.id.anstxtview);
        calcScreen.getText();


    }

    public void getButtonText(View v) {
        Button button = (Button) findViewById(v.getId());

        String buttonText = button.getText().toString();

            if (showOnScreen != null) {
                if (showOnScreen.charAt(showOnScreen.length()-1) == '=') {
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
                        toBeEvaluated = buttonText;
                        showOnScreen=buttonText;
                    }

                }
                else{toBeEvaluated += buttonText.toString();}
            }



        calcScreen = (TextView) findViewById(R.id.calcScreen);

        calcScreen.setText(toBeEvaluated);

        }

    public void getOperators(View v){

        Button button=(Button) findViewById(v.getId());

        calcScreen=(TextView) findViewById(R.id.calcScreen);

        if((toBeEvaluated ==null) || (toBeEvaluated =="")) {

            toBeEvaluated+="0"+button.getText().toString();
            showOnScreen+=toBeEvaluated;

        }
        else
            toBeEvaluated += button.getText().toString();


            showOnScreen=button.getText().toString();

            calcScreen.setText(showOnScreen);
    }

    public void Sohcahtoa(View v) {

        Button button = (Button) findViewById(v.getId());
        TextView calcS=(TextView) findViewById(R.id.calcScreen);

        if (calcScreen == null) {

            toBeEvaluated = button.getText() + "(";

            calcS.setText(toBeEvaluated);

        } else if (calcScreen.getText()==""){
            toBeEvaluated = button.getText() + "(";

        }

        else

            toBeEvaluated = button.getText() + "(" + toBeEvaluated + ")";

        calcS.setText(toBeEvaluated);

    }

    public void negButton(View v) {
        if (toBeEvaluated.charAt(0) != '-' && toBeEvaluated.charAt(0) != '+') {
            toBeEvaluated = "-" + toBeEvaluated;
        }
        else if (toBeEvaluated.charAt(0) == '-') {
            toBeEvaluated = toBeEvaluated.replace(toBeEvaluated.charAt(0), ' ');
            toBeEvaluated=toBeEvaluated.trim();

        }
        calcScreen.setText(toBeEvaluated);
    }

    public void allClear(View v) {
        toBeEvaluated = "";
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

    public void absolutEval(View v){
        try {
            calcScreen = (TextView) findViewById(R.id.calcScreen);
            toBeEvaluated=calcScreen.getText().toString();
            Expressions expressions = new Expressions(toBeEvaluated);
            BigDecimal result = new BigDecimal(String.valueOf(expressions.eval()));
            toBeEvaluated=result.toPlainString();

            if (toBeEvaluated.charAt(0) != '-' && toBeEvaluated.charAt(0) != '+') {
                toBeEvaluated = "-" + toBeEvaluated;
            }
            else if (toBeEvaluated.charAt(0) == '-') {
                toBeEvaluated = toBeEvaluated.replace(toBeEvaluated.charAt(0), ' ');
                toBeEvaluated=toBeEvaluated.trim();

            }

            calcScreen.setText(toBeEvaluated);


        }catch (EmptyStackException e){
            calcScreen.setText("Err. Nothing Here, Clear Screen.");
        } catch (NullPointerException e){
            calcScreen.setText("Err. Invalid input, Clear Screen.");
        } catch (RuntimeException r){
            calcScreen.setText("You broke me. :( Clear.");
        }
        ans ="";


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
        if (toBeEvaluated == null) {
            toBeEvaluated = "(";
        }
        if (toBeEvaluated == "") {
            toBeEvaluated = "(";
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
        TextView calcS=(TextView) findViewById(R.id.calcScreen);
        calcS.setText(toBeEvaluated);
    }



    public void evaluateExpression(View v){


        //TODO Switch to Anti's (Madelyn)

        //TODO Clear Screen after answer

        //TODO Figure out percent(MAYBE)

        //TODO Save Screen if turned

        //TODO Add Textview that shows ans





        try {

            checkParenthesis();

            //calcScreen = (TextView) findViewById(R.id.calcScreen);
           // toBeEvaluated=calcScreen.getText().toString();
            Button button=(Button) findViewById(v.getId());

//            toBeEvaluated+=button.getText();
            showOnScreen+=button.getText();
            toBeEvaluated.toString();

            Expressions expressions = new Expressions(toBeEvaluated);
            BigDecimal result = new BigDecimal(String.valueOf(expressions.eval()));

            toBeEvaluated=result.toPlainString();

            calcScreen.setText((toBeEvaluated));
        }catch (EmptyStackException e){
            calcScreen.setText("Err. Nothing Here, Clear Screen.");
        } catch (NullPointerException e){
            calcScreen.setText("Err. Invalid input, Clear Screen.");
        } catch (RuntimeException r){
            calcScreen.setText("You broke me. :( Clear.");
        }
        ans ="";
        ansview.setText(ans);







    }


}
