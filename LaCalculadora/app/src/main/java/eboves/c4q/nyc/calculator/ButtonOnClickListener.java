//starts at 0, crash you click del too many times


package eboves.c4q.nyc.calculator;

import android.util.Log;
import android.view.View;
import android.widget.TextView;

/**
 * Created by elvisboves on 5/13/15.
 */
public class ButtonOnClickListener implements View.OnClickListener {

    TextView textView;

    public ButtonOnClickListener(TextView textView) {
        this.textView = textView;
    }

    public void onClick(View view){
        String input = textView.getText().toString();
        String last = "";

        if (input.length() > 0){
        last = input.substring(input.length() - 1);}
        Log.d("last",last);

        int click = view.getId();

        switch (click) {

            case R.id.but0:
                input += "0";
                break;
            case R.id.but1:
                input += "1";
                break;
            case R.id.but2:
                input += "2";
                break;
            case R.id.but3:
                input += "3";
                break;
            case R.id.but4:
                input += "4";
                break;
            case R.id.but5:
                input += "5";
                break;
            case R.id.but6:
                input += "6";
                break;
            case R.id.but7:
                input += "7";
                break;
            case R.id.but8:
                input += "8";
                break;
            case R.id.but9:
                input += "9";
                break;

            case R.id.butDot://crashes without zero look at iphone cal
                if (last.equals(".")){ //prevents dot from being clicked twice in a row
                    input += "";
                }
                else if (last.equals("+")){
                    input+="0.";
                }
                else if (last.equals("-")){
                    input+="0.";
                }
                else if (last.equals("/")){
                    input+="0.";
                }
                else if (last.equals("*")) {
                    input += "0.";
                }
                else if (input.equals(" ")) {
                    input += "0.";
                }
                else {
                    input += ".";
                }
        break;
            case R.id.butSum:
                if (last.equals("+")){
                    input+="";
                }
                else if (last.equals("-")){
                    input+="";
                }
                else if (last.equals("/")){
                    input+="";
                }
                else if (last.equals("*")) {
                    input += "";
                }
                else if (input.equals(" ")) {
                    input += "";
                }
                else {
                    input += "+";
                }break;

            case R.id.butSub:
                if (last.equals("+")){
                    input+="";
                }
                else if (last.equals("-")){
                    input+="";
                }
                else if (last.equals("/")){
                    input+="";
                }
                else if (last.equals("*")) {
                    input += "";
                }
                else {
                    input += "-";
                }break;

            case R.id.butMult:
                if (last.equals("+")){
                    input+="";
                }
                else if (last.equals("-")){
                    input+="";
                }
                else if (last.equals("/")){
                    input+="";
                }
                else if (last.equals("*")) {
                    input += "";
                }
                else if (input.equals(" ")) {
                        input += "";
                }
                else {
                    input += "*";
                }break;

            case R.id.butDiv:
                if (last.equals("+")){
                    input+="";
                }
                else if (last.equals("-")){
                    input+="";
                }
                else if (last.equals("/")){
                    input+="";
                }
                else if (last.equals("*")) {
                    input += "";
                }
                else if (input.equals(" ")) {
                        input += "";
                }
                else {
                    input += "/";
                }break;

            case R.id.butDelete:
               if (input.length() > 1 ) { // 1 not zero or crush
                    input = input.substring(0, input.length() - 1);
                }
               else {
                   input = "";
               }
                break;
            case R.id.butClr:
                    input = "";
                break;
            case R.id.butSin:
                input += "Sin(";
                //TODO
                break;
            case R.id.butCos:
                input += "Cos(";
                //TODO
                break;
            case R.id.butTan:
                input += "Tan(";
                //TODO
                break;
            case R.id.butLn:
                input += "LN(";
                //TODO
                break;
            case R.id.butLog:
                input += "Log(";
                //TODO
                break;
            case R.id.butLeftParent:
                input += "(";
                break;
            case R.id.butRightParent:
                input += ")";
                break;
            case R.id.butExponent:
                input += "^";
                //TODO
                break;
            case R.id.butPI:
                input += "π";
                //TODO
                break;
            case R.id.butPercent:
                input += "%";
                //TODO
                break;
            case R.id.butRadical:
                input += "SQRT(";
                break;
            case R.id.butE:
                input += "e";
                break;
            case R.id.butXPower:
                input += ":)";
                break;

            case R.id.butDegree:
                input += "TANRAD";
                break;
            case R.id.butAns:
                input += "Ans";

                break;
        }
        textView.setText(input);
    }
}

