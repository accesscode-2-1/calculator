## scientific-calculator
https://github.com/accesscode-2-1/unit-1/blob/master/project/requirements.md

## Code Structure

**Back-End**
> Using [Udo klimaschewski's EvalEx](https://github.com/uklimaschewski/EvalEx) repo on Java Expression parsing, the calculator is able to take in a String equation and evaluate the mathematical answer returned in BigDecimal. For operations that EvalEx does not handle, we wrote our own methods in Numbers.java. MainActivity.java contains all Button Listener instructions, separated in half by basic calculator buttons on top and scientific calculator functions below. We decided to use only Buttons and Textviews to limit the possibility of invalid user input. We kept two separate variables for the equation to be parsed and the display equation the user sees, as the string format for parsing is not always user friendly. 

**Layout**
> The calculator's UI is comprised of a series of nested linear (weighted) and relative layouts, TextViews, and Buttons. To deal with several separate elements, we chose to keep the UI as "open" as possible—buttons and display are borderless with little embellishment, color palette very minimal. Visual attributes of the buttons are assigned/managed using one style. Button's onclick appearance was also customized to provide greater visual feedback on touch.

> Our layout utilizes two TextViews: one to display result and another to track the current equation. TextViews are limited to one line in order to avoid breaking the layout with long results or equations.

> When confronted with interface/user experience issues, we found that implementing a HorizontalScrollView enabled us to display equations exceeding layout boundaries, while the ToggleButton widget helped circumvent the issue of a crowded interface/inefficient use of space. Layout code was mainly handled by Jae with input, debugging, and modifications contributed by Sufei.

**Challenges**
* Inaccuracies with sin/cos implementation. We researched the Taylor Series but it proved too complex, opted for a simpler approach.
* Keeping track of several factors simultaneously, elegantly handling special cases, reconfiguring logic.
* Making up for library deficiencies.
* Maintaining consistency and utility in UI across devices.
* Constant debugging!

**Issues**
* +/- button implements incorrectly for certain inputs (^, Ans).
* Backspace

**Improvements**
* Given more time, we would have loved to complete the Wolfram Alpha API and graphing bonuses.
* Would have loved to explore Material design and animations.
* Re-evaluate logic that needs to be continuously readjusted.
* Clean up MainActivity.
