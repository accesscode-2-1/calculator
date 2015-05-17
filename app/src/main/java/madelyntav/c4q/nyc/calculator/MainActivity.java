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
    private String toBeEvaluated = "";
    private TextView calcScreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void getButtonText(View v) {
        Button button = (Button) findViewById(v.getId());

        toBeEvaluated += button.getText();

        calcScreen = (TextView) findViewById(R.id.calcScreen);

        calcScreen.setText(toBeEvaluated);

    }

    public void negButton(View v) {
        if (toBeEvaluated.charAt(0) != '-' && toBeEvaluated.charAt(0) != '+') {
            toBeEvaluated = "-" + toBeEvaluated;
        }
        if (toBeEvaluated.charAt(0) == '-') {
            toBeEvaluated = toBeEvaluated.replace(toBeEvaluated.charAt(0), '+');
        } else if (toBeEvaluated.charAt(0) == '+') {
            toBeEvaluated = toBeEvaluated.replace(toBeEvaluated.charAt(0), '-');
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
        } else if (ans != "") {
            toBeEvaluated += ans;
            calcScreen.setText(toBeEvaluated);
        }
    }




    public void evaluateExpression(View v){

        //TODO implement ANS (JOHN)(DONE)
        //TODO implement ABS (JOHN)
        //TODO Close Parens  (Madelyn)
        //TODO add cancel button
        //TODO Switch to Anti's (Madelyn)
        //TODO implement POS and NEG (Madelyn)-DONE
        //TODO fix EXP and x^Y (THINK)
        //TODO Error Message(John)
        //TODO Figure out percent(MAYBE)
        //TODO Clear Screen after answer
        //TODO fix paren

        if(toBeEvaluated.contains("(")){
            toBeEvaluated=toBeEvaluated+")";
        }
        try {
            calcScreen = (TextView) findViewById(R.id.calcScreen);
            calcScreen.setText(toBeEvaluated);
            Expressions expressions = new Expressions(calcScreen.getText().toString());
            BigDecimal result = new BigDecimal(String.valueOf(expressions.eval()));
            calcScreen.setText((result.toPlainString()));
        }catch (EmptyStackException e){
            calcScreen.setText("Err. Nothing Here, Clear Screen.");
        } catch (NullPointerException e){
            calcScreen.setText("Err. Invalid input Clear Screen.");
        } catch (RuntimeException r){
            calcScreen.setText("You broke me. :( Clear.");
        }
        ans ="";


    }


}
