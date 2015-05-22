<<<<<<< HEAD
# CalculatorAppProject

### Introduction

As the name implies, this  is a calculator meant to be run on the android platform. Made in android studio as a two-person group project it is our our submission for the unit-1 final assignment. 

### functionality

- To use the RAD nad DEG functions you must add a '(' after. No need to close them.
- If you press the +/- sign when there is an expression on the screen, this will calculate it for you and return the opposite value. 

## featured
- ans = saves current ans
- c/ans = clears current ans
- log 
- log10
- square root
- sin, cos, tan
- deg
- rad
- exponent
- e
- pi
- phi
- modulus <--works as it would on java, returning the remainded of the operation its called on. 
- ()
- abs = absolute value
- ce = clear end
- ac = all clear

###Code

There are two main layouts:

- An every day working calculator in vertical mode.
- A scientific calculator when device is horizontal extending the functionality of the regular calculator.

 There is a specified layout XML file for each mode. There is also a specialized themed XML in the drawable folder under res which draws the edges in some of the UI elements. 
 
 To calculate user input we chose to use EvalEx an expression calculator written in java.
 For reference see: https://github.com/uklimaschewski/EvalEx
 
 Our MainActivity class handles user input which we chose to handle through the use of methods called by the OnClick attributes specified for each button in the xml. 
 
 We buit specified methods when necessary while doing our best to keep our code optimized and concise. The Following is a breakdown of the methods used and the division of labor. 
 
 - onCreate: both
 - getButtonText: both
 - ce: John
 - getOperators: Madelyn
 - sohcahtoa: Madelyn
 - positiveNegativeSwitch: both
 - allClear: John
 - ans: John
 - clearAns: John
 - absButton: John
 - checkParenthesis: Madelyn
 - openCloseParens: Madelyn
 - evaluateExpression: both
 - onSaveInstanceState: Madelyn
 
 When it came to the layout, testing and error handling there was an equal division of labor from both of us. 
=======
# calculator
Submit your calculator projects here
>>>>>>> 565fe4086ff5928deb9f232fe32938e1acd9b467
