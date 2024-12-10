**Ex1 Main Program**
This program demonstrates operations on numbers represented as strings in different bases (from base 2 to base 16). It validates the input, converts it to integers,
performs calculations (addition and multiplication), and outputs the results in a user-defined base. Additionally, it identifies the maximum value among the input numbers
and the results.

**Example (running Ex1Main.java):**
Ex1 class solution:
Enter a string as number#1 (or "quit" to end the program): 
1
num1= 1 is number: true , value: 1
Enter a string as number#2 (or "quit" to end the program): 
0
num2= 0 is number: true , value: 0
Enter a base for output: (a number [2,16] 
10
1 + 0 = 1
1 * 0 = 0
Max number over [1,0,1,0] is: 1


Ex1 class solution:
Enter a string as number#1 (or "quit" to end the program): 
1DbG
num1= 1DbG is number: true , value: 29
Enter a string as number#2 (or "quit" to end the program): 
AAbB
num2= AAbB is number: true , value: 120
Enter a base for output: (a number [2,16] 
2
1DbG + AAbB = 10010101b2
1DbG * AAbB = 110110011000b2
Max number over [1DbG,AAbB,10010101b2,110110011000b2] is: 110110011000b2

Ex1 class solution:
Enter a string as number#1 (or "quit" to end the program): 
1b
num1= 1b is number: false , value: -1
ERR: num1 is in the wrong format! (1b)


Ex1 class solution:
Enter a string as number#1 (or "quit" to end the program): 
quit
quitting now...


**Dependencies**
the program usage in number of function from **Ex1.java**: 
**number2Int** function converts the string num into an integer and return the value. If isNumber(num) is true,
it calculates the value by iterating through the numeric part (beginOfNum(num)), raising the base (endOfNum(num)) to
the appropriate power, multiplying by the numeric value of each character, and summing the results.
If num contains only digits, it directly converts it to an integer using Integer.parseInt.

**isNumber** function checks whether string 'a' represents a valid number in the format.
It splits 'a' into two parts: 'b', the main numeric sequence (using beginOfNum), and 'e', the last character (using endOfNum).
The function verifies that 'a' is not empty, that its format matches 'b' + "b" + 'e', and that 'e' is valid according to the goodChar helper function.
It also checks that all characters in b are valid and smaller than 'e'. Additionally, if a consists only of digits, 
it is considered valid. The function returns true if all checks pass, and false otherwise.

**int2Number** function takes two numbers: one as a number in base 10 and the otheras the base in which the number should be represented 
and return a String representing a number (in base) equals to num, or an empty String (in case of wrong input).
I create an empty string and use a loop to perform a modulo operation
of the base on the number. Each time, the remainder is added at the beginning of the string, and the number is divided by
the base until the number equals 0. The function then returns the resulting string along with "b" and the base.
It handles the case where the base is 10 by leaving the number as it is, as well as the case where the number is 0, which simply results in "0" in the given base.
An auxiliary function is used to convert the numbers from integers to strings.

**equals** function compares two strings, `n1` and `n2`, by converting them to integers using `number2Int` and checking
if the values are equal. It returns `true` if they match, otherwise `false`.

**maxIndex** function finds the index of the largest number in an array of strings by comparing each element
(converted to an integer using `number2Int`). It updates the index if a larger value is found and returns the index of the largest number.

**fixnum** function representing number with letters

**goodChar** function checks if a character is a valid digit (0-9) or one of the characters in "ABCDEFG". It returns `true` if either condition is met, otherwise `false`.

**beginOfNum** get string number and return the part before 'b'

**endOfNum** get string number and return last char that representing the part of the base

