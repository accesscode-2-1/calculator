package nyc.c4q.yuliyakaleda.calculator;

import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

import java.util.ArrayList;
import java.util.Random;


public class MainActivity extends ActionBarActivity {

    private static final String CHOSEN_THEME_ID = "chosen_theme_id";
    private static final String DISPLAY_COLOR_KEY = "colorChanges" ;
    private static final String DISPLAY_BACKGROUND_COLOR="table_background_color";
    private static final String DISPLAY_FONT="display_font";

    private static final String DISPLAY_RESULT_KEY = "displayResult";

    TextView display;

    Button bClear;
    Button bSum;
    Button bSubtraction;
    Button bDivision;
    Button bMultiplication;
    Button bDot;
    Button bOpenParen;
    Button bClosedParen;
    Button bSin;
    Button bCos;
    Button bTan;
    Button bLN;
    Button bLog;
    Button bOneDivideX;
    Button bAbs;
    Button bYToPowX;
    Button bPI;
    Button bE;
    Button bEToPowX;
    Button bXToPow2;
    Button bEqual;
    Button bPerCent;
    Button bCurious;

    Button b1;
    Button b2;
    Button b3;
    Button b4;
    Button b5;
    Button b6;
    Button b7;
    Button b8;
    Button b9;
    Button b0;


    String result = "testing";


    private int chosenTheme = 0;
    private int tableBackgroundColor = 0;
    private String fontsFamily="";

    private Switch soundSwitch;
    MediaPlayer mMediaPlayer1;
    MediaPlayer mMediaPlayer2;
    MediaPlayer mMediaPlayer3;
    MediaPlayer mMediaPlayer4;
    MediaPlayer mMediaPlayer5;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (savedInstanceState != null) {
            chosenTheme = (int) savedInstanceState.get(CHOSEN_THEME_ID);
            tableBackgroundColor = (int) savedInstanceState.get(DISPLAY_BACKGROUND_COLOR);
            fontsFamily = (String) savedInstanceState.get(DISPLAY_FONT);

            if (chosenTheme > 0) {
                setTheme(chosenTheme);
            }

        }


        setContentView(R.layout.activity_main);

//        now that the layout is specified, we can get the view items to change color
        LinearLayout relativeLayout = (LinearLayout )findViewById(R.id.main_layout);
        if (tableBackgroundColor != 0) {

            relativeLayout.setBackgroundColor(tableBackgroundColor);
        }


        display = (TextView) findViewById(R.id.enter_numbers);



        if (!fontsFamily.isEmpty()) {
            Typeface typeFace=Typeface.createFromAsset(getAssets(),fontsFamily);

            display.setTypeface(typeFace);

            if(fontsFamily.equals("fonts/dotty.ttf")){

                display.setTextSize(TypedValue.COMPLEX_UNIT_DIP,80);

            }else if (fontsFamily.equals("fonts/digital-7.ttf")){

                display.setTextSize(TypedValue.COMPLEX_UNIT_DIP,50);

            }else {
                display.setTextSize(TypedValue.COMPLEX_UNIT_DIP,40);
            }


        }

        soundSwitch = (Switch) findViewById(R.id.sound_switch);

        //set the switch to on
        soundSwitch.setChecked(false);
        //attach a listener to check for changes in state
        soundSwitch.setOnCheckedChangeListener(new OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView,
                                         boolean isChecked) {

                if(isChecked){

                    mMediaPlayer1.setVolume(1,1);
                    mMediaPlayer2.setVolume(1,1);
                    mMediaPlayer3.setVolume(1,1);
                    mMediaPlayer4.setVolume(1,1);
                    mMediaPlayer5.setVolume(1,1);

                }else{

                    mMediaPlayer1.setVolume(0,0);
                    mMediaPlayer2.setVolume(0,0);
                    mMediaPlayer3.setVolume(0,0);
                    mMediaPlayer4.setVolume(0,0);
                    mMediaPlayer5.setVolume(0,0);
                }

            }
        });


        ArrayList<Button> buttons = new ArrayList<Button>();
        b1 = (Button) findViewById(R.id.button_1);
        b2 = (Button) findViewById(R.id.button_2);
        b3 = (Button) findViewById(R.id.button_3);
        b4 = (Button) findViewById(R.id.button_4);
        b5 = (Button) findViewById(R.id.button_5);
        b6 = (Button) findViewById(R.id.button_6);
        b7 = (Button) findViewById(R.id.button_7);
        b8 = (Button) findViewById(R.id.button_8);
        b9 = (Button) findViewById(R.id.button_9);
        b0 = (Button) findViewById(R.id.button_0);
        bDot = (Button) findViewById(R.id.button_dot);
        bSum = (Button) findViewById(R.id.sum);
        bSubtraction = (Button) findViewById(R.id.subtraction);
        bDivision = (Button) findViewById(R.id.division);
        bMultiplication = (Button) findViewById(R.id.multiplication);
        bOpenParen = (Button) findViewById(R.id.open_parenthesis);
        bClosedParen = (Button) findViewById(R.id.closed_parenthesis);
        bClear = (Button) findViewById(R.id.AC);
        bSin = (Button) findViewById(R.id.sin);
        bCos = (Button) findViewById(R.id.cos);
        bTan = (Button) findViewById(R.id.tan);
        bLN = (Button) findViewById(R.id.b_ln);
        bLog = (Button) findViewById(R.id.button_log);
        bOneDivideX = (Button) findViewById(R.id.button_1_divide_x);
        bAbs = (Button) findViewById(R.id.button_abs);
        bYToPowX = (Button) findViewById(R.id.button_y_pow_x);
        bPI = (Button) findViewById(R.id.button_PI);
        bE = (Button) findViewById(R.id.button_E);
        bEToPowX = (Button) findViewById(R.id.button_e_pow_x);
        bXToPow2 = (Button) findViewById(R.id.button_x_pow_2);
        bEqual = (Button) findViewById(R.id.b_equal);
        bPerCent = (Button) findViewById(R.id.button_per_cent);
        bCurious = (Button) findViewById(R.id.button_happy);


        buttons.add(b1);
        buttons.add(b2);
        buttons.add(b3);
        buttons.add(b4);
        buttons.add(b5);
        buttons.add(b6);
        buttons.add(b7);
        buttons.add(b8);
        buttons.add(b9);
        buttons.add(b0);
        buttons.add(bDot);
        buttons.add(bSum);
        buttons.add(bSubtraction);
        buttons.add(bDivision);
        buttons.add(bMultiplication);
        buttons.add(bOpenParen);
        buttons.add(bClosedParen);
        buttons.add(bEqual);




        for (Button b : buttons) {
            b.setBackgroundResource(R.drawable.test);
        }

        mMediaPlayer1 = MediaPlayer.create(getApplicationContext(), R.raw.clicksound);
        mMediaPlayer2 = MediaPlayer.create(getApplicationContext(), R.raw.clicksound);
        mMediaPlayer3 = MediaPlayer.create(getApplicationContext(), R.raw.clicksound2);
        mMediaPlayer4 = MediaPlayer.create(getApplicationContext(), R.raw.robotblip);
        mMediaPlayer5 = MediaPlayer.create(getApplicationContext(), R.raw.ringingsound);


        for (Button btn : buttons) {
            btn.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                    mMediaPlayer1.start();

                    switch (view.getId()) {
                        case R.id.button_1:
                            display.append(b1.getText());
                            break;
                        case R.id.button_2:
                            display.append(b2.getText());
                            break;
                        case R.id.button_3:
                            display.append(b3.getText());
                            break;
                        case R.id.button_4:
                            display.append(b4.getText());
                            break;
                        case R.id.button_5:
                            display.append(b5.getText());
                            break;
                        case R.id.button_6:
                            display.append(b6.getText());
                            break;
                        case R.id.button_7:
                            display.append(b7.getText());
                            break;
                        case R.id.button_8:
                            display.append(b8.getText());
                            break;
                        case R.id.button_9:
                            display.append(b9.getText());
                            break;
                        case R.id.button_0:
                            display.append(b0.getText());
                            break;
                        case R.id.button_dot:
                            display.append(bDot.getText());
                            break;
                        case R.id.sum:
                            display.append(bSum.getText());
                            break;
                        case R.id.subtraction:
                            display.append(bSubtraction.getText());
                            break;
                        case R.id.division:
                            display.append(bDivision.getText());
                            break;
                        case R.id.multiplication:
                            display.append(bMultiplication.getText());
                            break;
                        case R.id.open_parenthesis:
                            display.append(bOpenParen.getText());
                            break;
                        case R.id.closed_parenthesis:
                            display.append(bClosedParen.getText());
                            break;
                    }
                }
            });
        }



        bClear.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                display.setText("");
                mMediaPlayer3.start();
            }
        });

        if (bSin != null) {
            bSin.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                    display.append("sin");
                    mMediaPlayer2.start();
                }
            });
        }

        if (bCos != null) {
            bCos.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                    display.append("cos");
                    mMediaPlayer2.start();
                }
            });
        }

        if (bTan != null) {
            bTan.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                    display.append("tan");
                    mMediaPlayer2.start();
                }
            });
        }

        if (bLN != null) {
            bLN.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                    display.append("ln");
                    mMediaPlayer2.start();
                }
            });
        }

        if (bLog != null) {
            bLog.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                    display.append("log");
                    mMediaPlayer2.start();
                }
            });
        }

        if (bOneDivideX != null) {
            bOneDivideX.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                    display.append("1/");
                    mMediaPlayer2.start();
                }
            });
        }

        if (bAbs != null) {
            bAbs.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                    display.append("|");
                    mMediaPlayer2.start();
                }
            });
        }

        if (bYToPowX != null) {
            bYToPowX.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                    display.append("^");
                    mMediaPlayer2.start();
                }
            });
        }

        if (bPI != null) {
            bPI.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                    display.append("pi");
                    mMediaPlayer2.start();
                }
            });
        }

        if (bE != null) {
            bE.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                    display.append("E");
                    mMediaPlayer2.start();
                }
            });
        }

        if (bEToPowX != null) {
            bEToPowX.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                    display.append("e^");
                    mMediaPlayer2.start();
                }
            });
        }

        if (bXToPow2 != null) {
            bXToPow2.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                    display.append("^2");
                    mMediaPlayer2.start();
                }
            });
        }

        if (bPerCent != null) {
            bPerCent.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                    display.append(bPerCent.getText());
                    mMediaPlayer2.start();
                }
            });
        }

        bEqual.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String input = display.getText().toString();
                result = Parser.parse(input);
                display.setText(result);
                mMediaPlayer4.start();
            }
        });

        if (bCurious != null) {
            bCurious.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    // create layout for a toast
                    LayoutInflater inflater = getLayoutInflater();

                    View toastLayout = inflater.inflate(R.layout.toast_layout,
                            (ViewGroup) findViewById(R.id.id_toast_layout));

                    //generate a random joke
                    int jokeID = getRandomJoke();

                    // set an image
                    ImageView image = (ImageView) toastLayout.findViewById(R.id.image);
                    image.setImageResource(jokeID);

                    // display a toast
                    Toast toast = new Toast(getApplicationContext());
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.setDuration(Toast.LENGTH_LONG);
                    toast.setView(toastLayout);
                    toast.show();

                    mMediaPlayer5.start();
                }
            });
        }

        if (savedInstanceState != null) {
            String displayResult = savedInstanceState.getString(DISPLAY_RESULT_KEY);
            display.setText(displayResult);
            //getUserSelectionStyle(currentScreenColor);
        }
    }




    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt(CHOSEN_THEME_ID, chosenTheme);
        outState.putInt(DISPLAY_BACKGROUND_COLOR, tableBackgroundColor);
        outState.putString(DISPLAY_FONT, fontsFamily);
        outState.putString(DISPLAY_RESULT_KEY, display.getText().toString());

    }

    @Override
    public boolean onMenuOpened(int featureId, Menu menu) {
        return super.onMenuOpened(featureId, menu);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;

    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        LinearLayout relativeLayout = (LinearLayout )findViewById(R.id.main_layout);

        switch (item.getItemId()) {

            case R.id.action_change_theme_dark:


                if (chosenTheme != R.style.AppThemeDark) {
                    chosenTheme = R.style.AppThemeDark;
                    recreate();
                }

                break;

            case R.id.action_change_theme_light:

                if(chosenTheme != R.style.AppThemeLight) {
                    chosenTheme = R.style.AppThemeLight;
                    recreate();

                }

                break;

            case R.id.action_change_background_red:

                tableBackgroundColor = getResources().getColor(R.color.red);
                break;

            case R.id.action_change_background_green:

                tableBackgroundColor = getResources().getColor(R.color.green);
                break;

            case R.id.action_change_background_blue:

                tableBackgroundColor = getResources().getColor(R.color.blue);
                break;

            case R.id.action_change_background_yellow:

                tableBackgroundColor = getResources().getColor(R.color.yellow);
                break;

            case R.id.action_font_change:

                Typeface typeFace=Typeface.createFromAsset(getAssets(),"fonts/digital-7.ttf");
                display.setTypeface(typeFace);
                fontsFamily = "fonts/digital-7.ttf";
                display.setTextSize(TypedValue.COMPLEX_UNIT_DIP,50);

                break;

            case R.id.action_font_change2:

                Typeface typeFace2=Typeface.createFromAsset(getAssets(),"fonts/dotty.ttf");
                display.setTypeface(typeFace2);
                fontsFamily ="fonts/dotty.ttf";
                display.setTextSize(TypedValue.COMPLEX_UNIT_DIP,80);

                break;

            case R.id.action_font_change3:

                display.setTypeface(Typeface.SANS_SERIF);
                fontsFamily ="";
                display.setTextSize(TypedValue.COMPLEX_UNIT_DIP,40);


                break;


            case R.id.action_change_reset:

                if (chosenTheme != R.style.AppThemeDark) {
                    chosenTheme = R.style.AppThemeDark;
                    tableBackgroundColor =0;
                    fontsFamily="";
                    recreate();
                }


            default:
                break;
        }

        if (tableBackgroundColor != 0) {

            relativeLayout.setBackgroundColor(tableBackgroundColor);
        }

        Toast.makeText(MainActivity.this, item.getTitle(), Toast.LENGTH_SHORT).show();

        return super.onOptionsItemSelected(item);
    }

    //method to randomly show a joke through toast
    public Integer getRandomJoke() {
        ArrayList<Integer> jokes = new ArrayList<Integer>();
        jokes.add(R.drawable.joke1);
        jokes.add(R.drawable.joke2);
        jokes.add(R.drawable.joke3);
        jokes.add(R.drawable.joke4);
        jokes.add(R.drawable.joke6);
        jokes.add(R.drawable.joke7);
        jokes.add(R.drawable.joke8);
        jokes.add(R.drawable.joke9);
        jokes.add(R.drawable.joke0);

        Random ran = new Random();
        int Idx = ran.nextInt(8);
        return jokes.get(Idx);
    }


}

