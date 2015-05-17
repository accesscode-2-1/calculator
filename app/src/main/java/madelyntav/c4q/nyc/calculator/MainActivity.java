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


public class MainActivity extends ActionBarActivity {

    private String toBeEvaluated="";
    private TextView calcScreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void getButtonText(View v){
        Button button= (Button) findViewById(v.getId());

        toBeEvaluated+=button.getText();

        calcScreen=(TextView) findViewById(R.id.calcScreen);

        calcScreen.setText(toBeEvaluated);

    }

    public void negButton(View v){
       if(toBeEvaluated!=null) {
        if(toBeEvaluated.charAt(1)=='+'){
            toBeEvaluated.replace('+','-');
        }else
            toBeEvaluated = "(-" + toBeEvaluated + ")";

        }else{ toBeEvaluated="-";}

        calcScreen.setText(toBeEvaluated);
    }


    public void posButton(View v){

        if(toBeEvaluated!=null) {
            if(toBeEvaluated.charAt(1)=='-'){
                toBeEvaluated.replace('-','+');
            }else
                toBeEvaluated = "(+" + toBeEvaluated + ")";

        }else{ toBeEvaluated="+";}

        calcScreen.setText(toBeEvaluated);

    }

    public void allClear(View v){
        toBeEvaluated="";
        calcScreen=(TextView) findViewById(R.id.calcScreen);
        calcScreen.setText(toBeEvaluated);
    }



    public void evaluateExpression(View v){

        //TODO implement ANS (JOHN)
        //TODO implement ABS (JOHN)
        //TODO Close Parens  (Madelyn)
        //TODO Switch to Anti's (Madelyn)
        //TODO implement POS and NEG (Madelyn)
        //TODO fix EXP and x^Y (THINK)
        //TODO Error Message(John)
        //TODO Figure out percent
        //TODO Clear Screen after answer
        //TODO fix paren

        if(toBeEvaluated.contains("(")){
            toBeEvaluated=toBeEvaluated+")";
        }

        calcScreen = (TextView) findViewById(R.id.calcScreen);
        calcScreen.setText(toBeEvaluated);
        Expressions expressions = new Expressions(calcScreen.getText().toString());

        BigDecimal result= new BigDecimal(String.valueOf(expressions.eval()));
        calcScreen.setText((result.toPlainString()));


    }


}
