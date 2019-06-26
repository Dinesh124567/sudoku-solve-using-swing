# sudoku-solve-using-swing
Using swing gui based Java application to solve sudoku.
The code is to solve sudoku with 9*9 grids.
It mainly checks two situations in the sudoku

a) sudoku with only one solution.
   i.e, Searching for only ONE POSSIBLE numbered boxes in the 9*9 gird.

b) sudoku with no solution.
   i.e checks if there is NO POSSIBILITIES in the grid with the box is empty.

c) sudoku with more than one solution.
   i.e this is purely based on all RANDOM POSSIBILITIES, and checks if it is terminated to NO SOLUTION.


Before solving this it first check if the sudoku is valid or not.
As it conforms a valid sudoku, the code then initialise the values in sudoku with only one possible in a box( if there any).
The checking all one possibles is repeated untill all these are solved.
If any boxes are remained after this , then it purely goes searching the solution with RANDOM numbers from the possibilities.
So , this algorithm might takes a little more time to solve with more than one solution.


To get this thing work and to use it, just execute and run the "Evening.java" file, and then the swing window (frame ) is displayed with two buttons below it, and there you go!
