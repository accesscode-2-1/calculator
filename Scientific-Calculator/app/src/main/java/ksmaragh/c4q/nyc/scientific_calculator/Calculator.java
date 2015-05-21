package ksmaragh.c4q.nyc.scientific_calculator;

import com.fathzer.soft.javaluator.DoubleEvaluator;
import com.fathzer.soft.javaluator.Function;
import com.fathzer.soft.javaluator.Parameters;

import java.util.Iterator;

/**
 * Created by kadeemmaragh on 5/11/15.
 */
public class Calculator {

 // The function has one argument and its name is "sqrt"
    final Function sqrt = new Function("sqrt", 1);
    final Function factorial = new Function("!", 1);

    Parameters params;
    DoubleEvaluator evaluator;

    private double previousSum = 0;
    private double currentSum = 0;
    private String currentDisplay = "";
    private String expressionUsedForParsing ="";
    private boolean isRadians = false;


    public Calculator() {
        addFunctions();
        //Adds the functions to the evaluator
        evaluator = new DoubleEvaluator(params) {
            @Override
            protected Double evaluate(Function function, Iterator arguments, Object evaluationContext) {
                if (function == sqrt)
                    return Math.sqrt((Double) arguments.next());
                else if (function == factorial) {
                    double result = 1;
                    double num = (Double) arguments.next();
                    for (int i = 2; i <= num; i++) {
                        result = result * i;
                    }
                    return result;
                } else
                    return super.evaluate(function, arguments, evaluationContext);
            }
        };

    }

    public void addFunctions() {
        params = DoubleEvaluator.getDefaultParameters();
        params.add(sqrt);
        params.add(factorial);
    }


    public void getResult() {
        //Tries to parse the information as it is entered, if the parser can't handle it, the word error is shown on screen
        try {
            currentSum = evaluator.evaluate(fixExpression(expressionUsedForParsing));
            currentSum = convertToRadians(currentSum);
            currentDisplay = String.valueOf(currentSum);
            previousSum = currentSum;
        } catch (Exception e) {
            currentDisplay = "Error";
        }
    }

    public double convertToRadians(double sum){
        double newSum = sum;
        if(isRadians == true)
            newSum = Math.toRadians(sum);
        return newSum;
    }

    //Used to show display to user
    public String getCurrentDisplay() {
        return currentDisplay;
    }

    //Handles adding to display and adding to parser
    public void addToExpression(String character) {

        switch (character) {

            case "0":
                currentDisplay += "0";
                expressionUsedForParsing += "0";
                break;
            case "1":
                currentDisplay += "1";
                expressionUsedForParsing += "1";
                break;
            case "2":
                currentDisplay += "2";
                expressionUsedForParsing += "2";
                break;
            case "3":
                currentDisplay += "3";
                expressionUsedForParsing += "3";
                break;
            case "4":
                currentDisplay += "4";
                expressionUsedForParsing += "4";
                break;
            case "5":
                currentDisplay += "5";
                expressionUsedForParsing += "5";
                break;
            case "6":
                currentDisplay += "6";
                expressionUsedForParsing += "6";
                break;
            case "7":
                currentDisplay += "7";
                expressionUsedForParsing += "7";
                break;
            case "8":
                currentDisplay += "8";
                expressionUsedForParsing += "8";
                break;
            case "9":
                currentDisplay += "9";
                expressionUsedForParsing += "9";
                break;
            case ".":
                currentDisplay += ".";
                expressionUsedForParsing += ".";
                break;
            case "+":
                currentDisplay += "+";
                expressionUsedForParsing += "+";
                break;
            case "-":
                currentDisplay += "-";
                expressionUsedForParsing += "-";
                break;
            case "÷":
                currentDisplay += "÷";
                expressionUsedForParsing += "/";
                break;
            case "*":
                currentDisplay += "*";
                expressionUsedForParsing += "*";
                break;
            case "(":
                currentDisplay += "(";
                expressionUsedForParsing += "(";
                break;
            case ")":
                currentDisplay += ")";
                expressionUsedForParsing += ")";
                break;
            case "%":
                currentDisplay += "%";
                expressionUsedForParsing += "%";
                break;
            case "C":
                currentDisplay = "";
                expressionUsedForParsing = "";
                currentSum = 0;
                break;

            case "x!":
                currentDisplay += "!(";
                expressionUsedForParsing += "!(";
                break;
            case "ln":
                currentDisplay += "ln(";
                expressionUsedForParsing += "ln(";
                break;
            case "log":
                currentDisplay += "log(";
                expressionUsedForParsing += "log(";
                break;
            case "√":
                currentDisplay += "√(";
                expressionUsedForParsing += "sqrt(";
                break;
            case "x^y":
                currentDisplay += "^";
                expressionUsedForParsing += "^";
                break;
            case "sin":
                currentDisplay += "sin(";
                expressionUsedForParsing += "sin(";
                break;
            case "cos":
                currentDisplay += "cos(";
                expressionUsedForParsing += "cos(";
                break;
            case "tan":
                currentDisplay += "tan(";
                expressionUsedForParsing += "tan(";
                break;
            case "EXP": //number after E adds that amount of zeros.
                currentDisplay += "E";
                expressionUsedForParsing += "E0";
                break;
            case "π":
                currentDisplay += "π";
                expressionUsedForParsing += "pi";
                break;
            case "e":
                currentDisplay += "e";
                expressionUsedForParsing += "e";
                break;
            case "Ans":
                currentDisplay += previousSum;
                expressionUsedForParsing += previousSum;
                break;
            case "e^x":
                currentDisplay += "e^";
                expressionUsedForParsing += "e^";
                break;
            case "10^x":
                currentDisplay += "10^";
                expressionUsedForParsing += "10^";
                break;
            case "x^2":
                currentDisplay += "^2";
                expressionUsedForParsing += "^2";
                break;
            case "x^(1/y)":
                currentDisplay += "^(1/";
                expressionUsedForParsing += "^(1/";
                break;
            case "sin^-1":
                currentDisplay += "arcsin(";
                expressionUsedForParsing += "asin(";
                break;
            case "cos^-1":
                currentDisplay += "arccos(";
                expressionUsedForParsing += "acos(";
                break;
            case "tan^-1":
                currentDisplay += "arctan(";
                expressionUsedForParsing += "atan(";
                break;
            case "Rnd":
                double ran = Math.random();
                currentDisplay += String.valueOf(ran);
                expressionUsedForParsing += String.valueOf(ran);
                break;
            case "Rad":
                isRadians = true;
                break;
            case "Deg":
                isRadians = false;
                break;

        }
    }

    //Handles fixing the expression before parsing. Adding parens, making sure parens can multiply with each other,
    public String fixExpression(String exp) {
        int openParens = 0;
        int closeParens = 0;
        char openP = '(';
        char closeP = ')';
        String expr = exp;

        for (int i = 0; i < exp.length(); i++) {
            if (exp.charAt(i) == openP)
                openParens++;
            else if (exp.charAt(i) == closeP)
                closeParens++;
        }

        while (openParens > 0) {
            expr += closeP;
            openParens--;
        }

        while (closeParens > 0) {
            expr = openP + expr;
            closeParens--;
        }

        expr = multiplicationForParens(expr);

        return expr;
    }


    //Used to fix multiplication between parentheses
    public String multiplicationForParens(String s) {
        String fixed = "";
        for (int position = 0; position < s.length(); position++) {
            fixed += s.charAt(position);
            if (position == s.length() - 1)
                continue;
            if (s.charAt(position) == ')' && s.charAt(position + 1) == '(')
                fixed += '*';
            if (s.charAt(position) == '(' && s.charAt(position + 1) == ')')
                fixed += '1';
        }
        return fixed;
    }


}
