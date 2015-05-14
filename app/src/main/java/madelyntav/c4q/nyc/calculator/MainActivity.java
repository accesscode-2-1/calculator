package madelyntav.c4q.nyc.calculator;

import android.provider.ContactsContract;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //numbers
        final Button num0 = (Button) findViewById(R.id.number0);
        final Button num1 = (Button) findViewById(R.id.number1);
        final Button num2 = (Button) findViewById(R.id.number2);
        final Button num3 = (Button) findViewById(R.id.number3);
        final Button num4 = (Button) findViewById(R.id.number4);
        final Button num5 = (Button) findViewById(R.id.number5);
        final Button num6 = (Button) findViewById(R.id.number6);
        final Button num7 = (Button) findViewById(R.id.number7);
        final Button num8 = (Button) findViewById(R.id.number8);
        final Button num9 = (Button) findViewById(R.id.number9);

        //regular functions
        final Button point = (Button) findViewById(R.id.button);
        final Button allClear = (Button) findViewById(R.id.ac);
        final Button divide = (Button) findViewById(R.id.divide);
        final Button multiply = (Button) findViewById(R.id.times);
        final Button subtract = (Button) findViewById(R.id.minus);
        final Button addify = (Button) findViewById(R.id.plus);
        final Button sum = (Button) findViewById(R.id.equals);

        //scientific functions

        final Button percentage = (Button) findViewById(R.id.button4);
        final Button negative = (Button) findViewById(R.id.button3);
        final Button positive = (Button) findViewById(R.id.button2);

        //the following two could be made into a switch like the google calc.
        final Button radius = (Button) findViewById(R.id.radius);
        final Button degrees = (Button) findViewById(R.id.degrees);

        // -> X!
        final Button factorial = (Button) findViewById(R.id.factorial);

        /*Not sure the supposed function of this. If not math, can be used to switch between functions in
        scientific mode (when the calc is turned sideways.*/
        final Button inverse = (Button) findViewById(R.id.lnv);

        //
        final Button sine = (Button) findViewById(R.id.sine);
        final Button ln = (Button) findViewById(R.id.nlog);
        final Button pi = (Button) findViewById(R.id.pi);
        final Button cos = (Button) findViewById(R.id.cosine);
        final Button log = (Button) findViewById(R.id.log);
        final Button e = (Button) findViewById(R.id.e);
        final Button tan = (Button) findViewById(R.id.tangent);
        final Button sqrt = (Button) findViewById(R.id.squareroot);
        final Button ans = (Button) findViewById(R.id.answer);
        final Button exp = (Button) findViewById(R.id.exponent);
        final Button xy = (Button) findViewById(R.id.tothepowerof);

        //calc screen. (please double check. My rendering i
        final TextView text1 = (TextView) findViewById(R.id.textView);

    }
}
