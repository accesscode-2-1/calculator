package madelyntav.c4q.nyc.calculator;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.math.BigDecimal;
import java.util.EmptyStackException;


public class MainActivity extends ActionBarActivity {
    private String ans ="";//saved answer.
    private TextView ansview;//screen for the saved answer
    private String toBeEvaluated =" ";//expression
    private String showOnScreen = " ";//shown on main screen
    private TextView calcScreen;//main screen

    /*
    Madelyn, The following code comments will be verbose, but that is mainly so that you and I can understand how our code works. The final state of it should
    be more concsice with it's commentary.
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calcScreen = (TextView) findViewById(R.id.calcScreen);//connects variable name to calcscreen in layout.
        ansview = (TextView) findViewById(R.id.anstxtview);//does the same for the saved answer screen

        if(savedInstanceState != null ) {//if there is a saved instance
            calcScreen.setText(savedInstanceState.getString("toBeEvaluated"));//set the text in the main screen to be the current expression
            toBeEvaluated=savedInstanceState.getString("toBeEvaluated");//?
        }

        calcScreen.setText(toBeEvaluated);//sets the main screen text to the current contents in the expression.
    }

    public void getButtonText(View v) {
        Button button = (Button) findViewById(v.getId());//any button in our layout with this method signature name in its onCall attribute
        String buttonText = button.getText().toString();//stores the contents of that button in a string variable.

        if(toBeEvaluated.equals(null)){//if there is nothing in our toBeEvaluated var.
            showOnScreen=buttonText;//The main screen will show the contents of the button.
            toBeEvaluated+=showOnScreen;//each button pressed will be added to toBeEvaluated.
        }

        else if (toBeEvaluated != null) {//otherwise, if there is something in toBeEvaluated.

            try {
                //changed code to replace number check. Does the same but it's cleaner
                if (Character.isDigit(toBeEvaluated.charAt(0)) ||
                        Character.isDigit(toBeEvaluated.charAt(toBeEvaluated.length() - 1))) {//if the button contents are digits.
                    toBeEvaluated += buttonText;//the expression will add those numbers to the expression in the screen.
                    showOnScreen = toBeEvaluated;//What is shown on the main screen is what is saved in memory for the expression.
                    calcScreen.setText(showOnScreen);//Set that to show in the main screen
                } else {//if the button pressed is not a numerical digit.
                    toBeEvaluated += buttonText;//it will be added to whatever the current expression contains.
                    showOnScreen = toBeEvaluated;//what is show on screen is the current state of the expression. plus what button is pressed.
                }
            } catch (StringIndexOutOfBoundsException e) {//catching clearend exception.
                toBeEvaluated += buttonText;//If clearend (ce) throws an exception the expression will add the number that caused it to the mainscreen. This fixes ce crash.
                showOnScreen = toBeEvaluated;//What is shown on the main screen is what is saved in memory for the expression.
                calcScreen.setText(showOnScreen);//show that to the user
            }
        }
        calcScreen.setText(showOnScreen.trim());//In any case shown on main screen is the current state of said var. Whitespace ommited.
    }
    public void ce(View v){//backspace. (clearEnd) also ce. This method called by button ce clears the last letter currently showin on main screen.
        StringBuffer charDel = new StringBuffer(showOnScreen);//chose a buffer because it gives us the deleteCharAt method which made the code simpler.
                try {
                    charDel = charDel.deleteCharAt(charDel.length() - 1);//clears last letter of showOnScreen when method is called by button.
                    showOnScreen = String.valueOf(charDel);//saves the new state of showOnScreen
                    calcScreen.setText(showOnScreen);//prints it in the main screen
                    toBeEvaluated = showOnScreen;//saves it as the new expression
                }catch (StringIndexOutOfBoundsException e){//if there is nothing else to delete
                    calcScreen.setText(calcScreen.getText());//sets the state of the main screen to an empty state
                }
    }
    //TODO Implement m-
    //TODO Implement m+

    //TODO Madelyn: comment the following three methods as you deem necessary.
    public void getOperators(View v) {//sifts through operators and appends them to both the screen and expression var as needed.
        Button button = (Button) findViewById(v.getId());
        calcScreen = (TextView) findViewById(R.id.calcScreen);

        char checkIfOperand = button.getText().charAt(0);

        if ((toBeEvaluated == null) || (toBeEvaluated.equals("")||toBeEvaluated.equals(" "))) {
            toBeEvaluated += "0" + button.getText().toString();
            showOnScreen =button.getText().toString();
        } else if (toBeEvaluated.charAt(toBeEvaluated.length()-1) == checkIfOperand){
            toBeEvaluated+="";
            showOnScreen+="";
        }
        else {
            toBeEvaluated += button.getText().toString();
            showOnScreen = button.getText().toString();
        }
        calcScreen.setText(toBeEvaluated);
    }
    public void Sohcahtoa(View v) {//Code for parenthesis for sin cos and tan

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
    public void positiveNegativeSwitch(View v) {//calculates the current expression on the screen and outputs it's inverse (positive/negative) solution.
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

        } catch (EmptyStackException e) {//error handling just in case
            calcScreen.setText("Err. Nothing To Calculate");
        } catch (NullPointerException e) {
            calcScreen.setText("Err. Invalid input, Clear Screen.");
        } catch (RuntimeException r) {
            calcScreen.setText("Error");
        }
    }


    public void allClear(View v) {//clears whole screen. In layout as: (AC)
        toBeEvaluated = " ";
        showOnScreen = toBeEvaluated;
        calcScreen = (TextView) findViewById(R.id.calcScreen);
        calcScreen.setText(toBeEvaluated);
    }


    public void ans(View v) {//Saves current state of the expressions' answer to a variable one can reuse

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

    public void clearans(View v){//deletes saved ans variable
        ans ="";
        ansview.setText(ans);
    }

    public void absbutton(View v) {//returns absolute value of expressions' answer. (it's positive value)
            Expressions expressions = new Expressions(toBeEvaluated);
            BigDecimal result = new BigDecimal(String.valueOf(expressions.eval()));
            toBeEvaluated = result.toPlainString();
             if (toBeEvaluated.charAt(0) == '-') {
                toBeEvaluated = toBeEvaluated.replace(toBeEvaluated.charAt(0), ' ');
                toBeEvaluated = toBeEvaluated.trim();
            }
            calcScreen.setText(toBeEvaluated);
    }

//TODO Madeline: Can you explain the following method?

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
//TODO this one as well?
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


    public void evaluateExpression(View v) {//equals sign calls on this to calculate and give the final solution to the expression.

        checkParenthesis();

        try {
            Button button = (Button) findViewById(v.getId());
            showOnScreen += button.getText();

            Expressions expressions = new Expressions(toBeEvaluated);
            BigDecimal result = new BigDecimal(String.valueOf(expressions.eval()));//gives result.

            showOnScreen = result.toPlainString();

            calcScreen.setText((showOnScreen));//shows it on screen
            toBeEvaluated = showOnScreen;//saves it as current expression.

        } catch (EmptyStackException e) {
            calcScreen.setText("Err. Nothing Here, Clear Screen.");
        } catch (NullPointerException e) {
            calcScreen.setText("Err. Null Pointer.");
        } catch (RuntimeException r) {
            calcScreen.setText("You broke me. :( Clear.");
        }
    }


    @Override
    public void onSaveInstanceState(Bundle outState){//saves current state of screen in case of device flip.
        super.onSaveInstanceState(outState);
        outState.putString("toBeEvaluated", calcScreen.getText().toString());
        outState.putString("showOnScreen",showOnScreen);
    }
}