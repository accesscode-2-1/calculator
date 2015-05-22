package reinardcox.c4q.nyc.calculator;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.nfunk.jep.JEP;

import java.util.Collection;

/**
 * Created by Shadow on 5/20/2015.
 */
public class MainActivity extends AppCompatActivity {

    //Create a onCreate method
    // TextView window;



    String [] listOfthings = {"-","+","*", "/", "%"};

    Button zero, one, two, three, four, five, six, seven, eight, nine, period, equal, plus, minus,
            times, divide, clear, percentage, openPen, closePen, log1;
    String memoryBank = "";
    TextView reader;
    boolean ticker = false, tickerPeriod = false;

    public static boolean endsWithAnyOf(String s, String[] listOfStrings){
        boolean valid = false;
        for (String ending : listOfStrings){
            if (s.endsWith(ending))
                valid = true;
        }
        return valid;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Set Content View
        setContentView(R.layout.main_layout);

        reader = (TextView) findViewById(R.id.reader_id);

        zero = (Button) findViewById(R.id.zero_id);
        one = (Button) findViewById(R.id.one_id);
        two = (Button) findViewById(R.id.two_id);
        three = (Button) findViewById(R.id.three_id);
        four = (Button) findViewById(R.id.four_id);
        five = (Button) findViewById(R.id.five_id);
        six = (Button) findViewById(R.id.six_id);
        seven = (Button) findViewById(R.id.seven_id);
        eight = (Button) findViewById(R.id.eight_id);
        nine = (Button) findViewById(R.id.nine_id);

        period = (Button) findViewById(R.id.peroid_id);
        equal = (Button) findViewById(R.id.equal_id);
        plus = (Button) findViewById(R.id.plus_id);
        minus = (Button) findViewById(R.id.minus_id);
        times = (Button) findViewById(R.id.times_id);
        divide = (Button) findViewById(R.id.divide_id);
        clear = (Button) findViewById(R.id.clear_id);
        percentage = (Button) findViewById(R.id.percentage_id);
        openPen = (Button) findViewById(R.id.openPen_id);
        closePen = (Button) findViewById(R.id.closePen_id);

        log1 = (Button) findViewById(R.id.log_id);


        if (savedInstanceState == null) {
            memoryBank = "";
        } else {
            memoryBank = savedInstanceState.getString("memoryBank");
            reader.setText(memoryBank);
        }

        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check();
                memoryBank += "0";
                reader.setText(memoryBank);
            }
        });

        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check();
                memoryBank += "1";
                reader.setText(memoryBank);
            }
        });

        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check();
                memoryBank += "2";
                reader.setText(memoryBank);
            }
        });

        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check();
                memoryBank += "3";
                reader.setText(memoryBank);
            }
        });

        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check();
                memoryBank += "4";
                reader.setText(memoryBank);
            }
        });

        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check();
                memoryBank += "5";
                reader.setText(memoryBank);
            }
        });

        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check();
                memoryBank += "6";
                reader.setText(memoryBank);
            }
        });

        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check();
                memoryBank += "7";
                reader.setText(memoryBank);
            }
        });

        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check();
                memoryBank += "8";
                reader.setText(memoryBank);
            }
        });

        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check();
                memoryBank += "9";
                reader.setText(memoryBank);
            }
        });

        openPen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check();
                memoryBank += "(";
                reader.setText(memoryBank);
            }
        });

        closePen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check();
                memoryBank += ")";
                reader.setText(memoryBank);
            }
        });

        percentage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                    if (!memoryBank.endsWith("%")) {
                if (!endsWithAnyOf(memoryBank, listOfthings)){
                    check();
                    memoryBank += "%";
                    reader.setText(memoryBank);
                }
            }
        });

        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                if (!memoryBank.endsWith("/")) {
                if (!endsWithAnyOf(memoryBank, listOfthings)){
                    ticker = false;
                    memoryBank += "/";
                    reader.setText(memoryBank);
                }
            }
        });

        times.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                if (!memoryBank.endsWith("*")) {

                if (!endsWithAnyOf(memoryBank, listOfthings)){
                    ticker = false;
                    memoryBank += "*";
                    reader.setText(memoryBank);
                }
            }
        });


        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                if (!memoryBank.endsWith("-")) {

                if (!endsWithAnyOf(memoryBank, listOfthings)){
                    ticker = false;
                    memoryBank += "-";
                    reader.setText(memoryBank);
                }
            }
        });

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                if (!memoryBank.endsWith("+")) {

                if (!endsWithAnyOf(memoryBank, listOfthings)){
                    ticker = false;
                    memoryBank += "+";
                    reader.setText(memoryBank);
                }
            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                memoryBank = "";
                reader.setText(memoryBank);
            }
        });

        period.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!memoryBank.endsWith(".")) {
                    check();
                    memoryBank += ".";
                    reader.setText(memoryBank);
                }
            }
        });

        if (log1 != null) {
            log1.setOnClickListener(new View.OnClickListener() {


                @Override
                public void onClick(View v) {
                    check();
                    memoryBank += "log(";
                    reader.setText(memoryBank);
                }
            });
        }

        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                JEP myParser = new JEP();
                myParser.parseExpression(memoryBank);
                memoryBank = myParser.getValue() + "";
                reader.setText(memoryBank);

                ticker = true;

            }
        });


    }

    public void check (){
        if (ticker !=false) {
            memoryBank = "";
            reader.setText(memoryBank);
            ticker = false;
        }
    }

    @Override
    public void onSaveInstanceState(Bundle saveInstanceState) {
        super.onSaveInstanceState(saveInstanceState);
        saveInstanceState.putString("memoryBank", memoryBank);
    }
}
