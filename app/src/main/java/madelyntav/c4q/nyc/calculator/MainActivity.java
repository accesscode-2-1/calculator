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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void getButtonText(View v){
        Button button= (Button) findViewById(v.getId());

        toBeEvaluated+=button.getText();

        TextView calcScreen=(TextView) findViewById(R.id.calcScreen);

        calcScreen.setText(toBeEvaluated);

    }

    public void allClear(View v){
        toBeEvaluated="";
        TextView screen=(TextView) findViewById(R.id.calcScreen);
        screen.setText(toBeEvaluated);
    }


    public void evaluateExpression(View v){

        //TODO implement

        TextView calcScreen = (TextView) findViewById(R.id.calcScreen);
        calcScreen.setText(toBeEvaluated);
        Expressions expressions = new Expressions(calcScreen.getText().toString());

        BigDecimal result= new BigDecimal(String.valueOf(expressions.eval()));
        calcScreen.setText((result.toString()));



//        //numbers
//        final Button num0 = (Button) findViewById(R.id.number0);
//        final Button num1 = (Button) findViewById(R.id.number1);
//        final Button num2 = (Button) findViewById(R.id.number2);
//        final Button num3 = (Button) findViewById(R.id.number3);
//        final Button num4 = (Button) findViewById(R.id.number4);
//        final Button num5 = (Button) findViewById(R.id.number5);
//        final Button num6 = (Button) findViewById(R.id.number6);
//        final Button num7 = (Button) findViewById(R.id.number7);
//        final Button num8 = (Button) findViewById(R.id.number8);
//        final Button num9 = (Button) findViewById(R.id.number9);
//
//        //controls
//        final Button allClear = (Button) findViewById(R.id.ac);
//
//        //regular expressions
//        final Button add = (Button) findViewById(R.id.plus);
//        final Button multiply = (Button) findViewById(R.id.times);
//        final Button subtract = (Button) findViewById(R.id.minus);
//        final Button divide = (Button) findViewById(R.id.divide);
//        final Button decimalpoint = (Button) findViewById(R.id.decimalpoint);
//
//        //calculations
//        final Button sum = (Button) findViewById(R.id.equals);
//        final Button percentage = (Button) findViewById(R.id.button4);
//
//        //integers expression could also be made into a switch.
//        final Button negative = (Button) findViewById(R.id.negative);
//        final Button positive = (Button) findViewById(R.id.positive);
//
//
//        //scientific functions
//
//
//        //the following two could al well be made into a switch.
//        final Button radius = (Button) findViewById(R.id.radius);
//        final Button degrees = (Button) findViewById(R.id.degrees);
//
//        // -> X!
//        final Button factorial = (Button) findViewById(R.id.factorial);
//
//        /*Not sure the supposed function of this. Can be used to switch between functions in
//        scientific mode (when the calc is turned sideways). */
//        final Button inverse = (Button) findViewById(R.id.lnv);
//
//        //
//        final Button sine = (Button) findViewById(R.id.sine);
//        final Button cos = (Button) findViewById(R.id.cosine);
//        final Button tan = (Button) findViewById(R.id.tangent);
//
//
//        final Button ln = (Button) findViewById(R.id.nlog);//natural log
//
//        final Button pi = (Button) findViewById(R.id.pi);
//
//        final Button log = (Button) findViewById(R.id.log);//log10 ?
//
//        final Button e = (Button) findViewById(R.id.e);
//
//        final Button sqrt = (Button) findViewById(R.id.squareroot);
//
//        final Button ans = (Button) findViewById(R.id.answer);
//
//        final Button exp = (Button) findViewById(R.id.exponent);
//
//        final Button xy = (Button) findViewById(R.id.tothepowerof);
//
//        //calc screen.
//

    }


}
