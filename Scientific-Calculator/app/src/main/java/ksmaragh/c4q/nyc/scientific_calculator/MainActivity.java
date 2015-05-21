package ksmaragh.c4q.nyc.scientific_calculator;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ToggleButton;


public class MainActivity extends Activity implements View.OnClickListener {

    TextView outputField;
    Calculator calc = new Calculator();

    private boolean isInverse = false;

    private Button button0, button1, button2,button3,button4,button5,button6,button7,
            button8,button9,buttonClear, buttonDivide,buttonMultiply,buttonSubtract,
            buttonAdd, buttonPercentage, buttonEqual,buttonDecimal, closeParens, openParens;

    private Button btnFactorial,btnRad,btnDegree,btnInverse,btnSin,btnLn,btnPI,btnCos,btnNaturalLog,btnEular,
            btnTan,btnSquareRoot,btnAnswer,btnExponentToTen,btnExponentByY;

    private Button btnSinInverse,btnLnInverse,btnCosInverse,btnInvNaturalLog,btnTanInverse,btnSquareRootInverse,
            btnAnswerInverse,btnInvYsqurX;

    private ToggleButton toggleRad;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        makeNumberButtons();
        makeOtherButtons();
        makeComplexMathButtons();
        makeComplexInverseButtons();

        //Allows horizontal scrolling on textView
        //outputField.setMovementMethod(new ScrollingMovementMethod());

        if( btnFactorial == null){
            settingOnclickersForStanard();
        }else{
            settingOnclickersForStanard();
            settingOnclickersForComplex();
        }

    }

    protected void makeComplexMathButtons(){
        btnFactorial = (Button) findViewById(R.id.btnFactorial);
        toggleRad = (ToggleButton) findViewById(R.id.btnRad_Degree);
        btnInverse = (Button) findViewById(R.id.btnInverse);
        btnSin = (Button) findViewById(R.id.btnSin);
        btnLn = (Button) findViewById(R.id.btnLn);
        btnPI = (Button) findViewById(R.id.btnPI);
        btnCos = (Button) findViewById(R.id.btnCos);
        btnNaturalLog = (Button) findViewById(R.id.btnNaturalLog);
        btnEular = (Button) findViewById(R.id.btnEuler);
        btnTan = (Button) findViewById(R.id.btnTan);
        btnSquareRoot = (Button) findViewById(R.id.btnSquareRoot);
        btnAnswer = (Button) findViewById(R.id.btnAnswer);
        btnExponentToTen = (Button) findViewById(R.id.btnExponentToTen);
        btnExponentByY = (Button) findViewById(R.id.btnExponentByY);
    }

    protected void makeComplexInverseButtons(){
        btnSinInverse = (Button) findViewById(R.id.btnSinInverse);
        btnLnInverse = (Button) findViewById(R.id.btnLnInverse);
        btnCosInverse = (Button) findViewById(R.id.btnCosInverse);
        btnInvNaturalLog = (Button) findViewById(R.id.btnInvNaturalLog);
        btnTanInverse = (Button) findViewById(R.id.btnTanInverse);
        btnSquareRootInverse = (Button) findViewById(R.id.btnSquareRootInverse);
        btnAnswerInverse = (Button) findViewById(R.id.btnAnswerInverse);
        btnInvYsqurX = (Button) findViewById(R.id.btnInvYsqurX);

    }

    protected void makeNumberButtons(){
        button0 = (Button) findViewById(R.id.btnZero);
        button1 = (Button) findViewById(R.id.btnNumberOne);
        button2 = (Button) findViewById(R.id.btnNumberTwo);
        button3 = (Button) findViewById(R.id.btnNumberThree);
        button4 = (Button) findViewById(R.id.btnNumberFour);
        button5 = (Button) findViewById(R.id.btnNumberFive);
        button6 = (Button) findViewById(R.id.btnNumberSix);
        button7 = (Button) findViewById(R.id.btnNumberSeven);
        button8 = (Button) findViewById(R.id.btnNumberEight);
        button9 = (Button) findViewById(R.id.btnNumberNine);
    }

    protected void makeOtherButtons(){
        buttonAdd = (Button) findViewById(R.id.btnPlus);
        buttonSubtract = (Button) findViewById(R.id.btnSubtraction);
        buttonDivide = (Button) findViewById(R.id.btnDivision);
        buttonMultiply = (Button) findViewById(R.id.btnMultiplication);
        buttonDecimal = (Button) findViewById(R.id.btnDecimal);
        buttonPercentage = (Button) findViewById(R.id.btnPercentage);
        openParens = (Button) findViewById(R.id.btnLeftParentheses);
        closeParens = (Button) findViewById(R.id.btnRightParentheses);
        buttonClear = (Button) findViewById(R.id.btnAllClear);
        buttonEqual = (Button) findViewById(R.id.btnEqual);
        outputField = (TextView) findViewById(R.id.display);
    }

    protected void settingOnclickersForComplex(){
        btnFactorial.setOnClickListener(this);
        toggleRad.setOnClickListener(this);
        btnInverse.setOnClickListener(this);
        btnSin.setOnClickListener(this);
        btnLn.setOnClickListener(this);
        btnPI.setOnClickListener(this);
        btnCos.setOnClickListener(this);
        btnNaturalLog.setOnClickListener(this);
        btnEular.setOnClickListener(this);
        btnTan.setOnClickListener(this);
        btnSquareRoot.setOnClickListener(this);
        btnAnswer.setOnClickListener(this);
        btnExponentToTen.setOnClickListener(this);
        btnExponentByY.setOnClickListener(this);

        btnSinInverse.setOnClickListener(this);
        btnLnInverse.setOnClickListener(this);
        btnCosInverse.setOnClickListener(this);
        btnInvNaturalLog.setOnClickListener(this);
        btnTanInverse.setOnClickListener(this);
        btnSquareRootInverse.setOnClickListener(this);
        btnAnswerInverse.setOnClickListener(this);
        btnInvYsqurX.setOnClickListener(this);
    }

    protected void settingOnclickersForStanard(){
        button0.setOnClickListener(this);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        button7.setOnClickListener(this);
        button8.setOnClickListener(this);
        button9.setOnClickListener(this);
        buttonAdd.setOnClickListener(this);
        buttonSubtract.setOnClickListener(this);
        buttonDivide.setOnClickListener(this);
        buttonMultiply.setOnClickListener(this);
        buttonDecimal.setOnClickListener(this);
        buttonPercentage.setOnClickListener(this);
        openParens.setOnClickListener(this);
        closeParens.setOnClickListener(this);
        buttonClear.setOnClickListener(this);
        buttonEqual.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        //Casting to a button again so I can use the getText method. Might have to change how I set up the onClickListener
        Button button = (Button) view;
        String data = button.getText().toString();

        if(!(data.equals("=") || data.equals("Inv")))
            calc.addToExpression(data);
        else if(data.equals("Inv")){
                if(isInverse){
                    isInverse = false;

                    btnSin.setVisibility(View.GONE);
                    btnLn.setVisibility(View.GONE);
                    btnCos.setVisibility(View.GONE);
                    btnNaturalLog.setVisibility(View.GONE);
                    btnTan.setVisibility(View.GONE);
                    btnSquareRoot.setVisibility(View.GONE);
                    btnAnswer.setVisibility(View.GONE);
                    btnExponentByY.setVisibility(View.GONE);

                    btnSinInverse.setVisibility(View.VISIBLE);
                    btnLnInverse.setVisibility(View.VISIBLE);
                    btnCosInverse.setVisibility(View.VISIBLE);
                    btnInvNaturalLog.setVisibility(View.VISIBLE);
                    btnTanInverse.setVisibility(View.VISIBLE);
                    btnSquareRootInverse.setVisibility(View.VISIBLE);
                    btnAnswerInverse.setVisibility(View.VISIBLE);
                    btnInvYsqurX .setVisibility(View.VISIBLE);
                }
            else{
                    isInverse = true;

                    btnSinInverse.setVisibility(View.GONE);
                    btnLnInverse.setVisibility(View.GONE);
                    btnCosInverse.setVisibility(View.GONE);
                    btnInvNaturalLog.setVisibility(View.GONE);
                    btnTanInverse.setVisibility(View.GONE);
                    btnSquareRootInverse.setVisibility(View.GONE);
                    btnAnswerInverse.setVisibility(View.GONE);
                    btnInvYsqurX .setVisibility(View.GONE);


                    btnSin.setVisibility(View.VISIBLE);
                    btnLn.setVisibility(View.VISIBLE);
                    btnCos.setVisibility(View.VISIBLE);
                    btnNaturalLog.setVisibility(View.VISIBLE);
                    btnTan.setVisibility(View.VISIBLE);
                    btnSquareRoot.setVisibility(View.VISIBLE);
                    btnAnswer.setVisibility(View.VISIBLE);
                    btnExponentByY.setVisibility(View.VISIBLE);
                }
        }
        else
            calc.getResult();

        outputField.setText(calc.getCurrentDisplay());
    }

}

