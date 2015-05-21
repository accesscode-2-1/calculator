package nyc.c4q.sufeiiz.scientificcalculator;

import android.view.View;
import android.widget.TextView;

import java.util.Arrays;

/**
 * Created by sufeizhao on 5/5/15.
 */
public class Numbers extends MainActivity{

    // returns String of the percentage as a decimal
    public static String percentage(String num, String lastNum) {
        String converted;
        double newCurr = (Double.valueOf(num) / 100);

        if (lastNum.isEmpty()) {
            converted = String.valueOf(newCurr);
        } else {
            newCurr = Double.valueOf(lastNum) * newCurr;
            converted = String.valueOf(newCurr);
        }

        return converted;
    }

    // returns true if last input was +, -, *, /, (
    public static boolean lastInputIsOperator(String equation) {
        String[] operators = {"+", "-", "*", "/", "("};
        return Arrays.asList(operators).contains(String.valueOf(equation.charAt(equation.length() - 1)));
    }

    // returns true if last input was %
    public static boolean lastInputIsPercent(String display) {
        return display.charAt(display.length() - 1) == '%';
    }

    public static boolean lastInputIsConstant(String display) {
        return display.charAt(display.length() - 1) == 's' ||
                display.charAt(display.length() - 1) == 'π' ||
                display.charAt(display.length() - 1) == 'e';
    }

    // returns factorial answer
    static boolean negative = false;
    public static double factorial(int x) {
        if (x < 0) {
            x *= -1;
            negative = true;
        }
        if (x == 1) {
            if (negative) {
                return -1;
            } else {
                return 1;
            }
        } else if (x == 0) {
            return 1;
        } else {
            return x * factorial(x-1);
        }
    }
}