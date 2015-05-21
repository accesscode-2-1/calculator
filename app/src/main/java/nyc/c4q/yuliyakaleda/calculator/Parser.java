package nyc.c4q.yuliyakaleda.calculator;

import com.fathzer.soft.javaluator.DoubleEvaluator;

import java.text.DecimalFormat;

/**
 * Created by Yuliya Kaleda on 5/12/15.
 */
public class Parser {

        public static String parse(String s) {
            if (s.contains("/0")) {
                return "Error";
            }

            //when the user presses "=" button without any input
            else if (s.equalsIgnoreCase("")) {
              return "";
            }

            try {
                // Create a new evaluator
                DoubleEvaluator evaluator = new DoubleEvaluator();
                // Evaluate an expression
                Double result = evaluator.evaluate(s);
                //remove .0 from numbers
                DecimalFormat format = new DecimalFormat();
                String finalResult = "" + format.format(result);

                // Output the result
                return finalResult;
            }
            catch (IllegalArgumentException e) {
                return "Invalid input";
            }
        }
    }
