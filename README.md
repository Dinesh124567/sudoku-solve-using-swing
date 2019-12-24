# sudoku-solve-using-swing
Using swing gui based Java application to solve sudoku.
The code is to solve sudoku with 9*9 grids.
It mainly checks two situations in the sudoku

a) sudoku with only one solution.
   i.e, Searching for only ONE POSSIBLE numbered boxes in the 9*9 gird.

b) sudoku with no solution.
   i.e checks if there is NO POSSIBILITIES in the grid with the box is empty.

c) sudoku with more than one solution.
   i.e this is based on BACKTRACK ALGORITHM, and checks if it is terminated to NO SOLUTION situation.


Before solving this it first check if the sudoku is valid or not.
As it conforms a valid sudoku, the code then initialise the values in sudoku with only one possible in a box( if there any).
The checking all one possibles is repeated untill all these are solved.
If any boxes are remained after this , then it goes searching the solution with a set of numbers from all the possibilities, if the solution is not found then the numbers that are set are changed again to find the solution, this process goes on until the solution of sudoku is found, if there develops array indexoutofbounds exception then this means there is no solution for the sudoku and the status shows -"no solution".
So , this algorithm is by far the best and ultimate algorithm to solve sudoku.


# Usage

To get this thing work and to use it, just execute and run the "Eventing.java" file, and then the swing window (frame ) is displayed with two buttons below it and contains a text field for the status of sudoku, and there you go!
