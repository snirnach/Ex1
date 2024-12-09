//student name: Snir Nachmany
//ID: 322593047



import static java.lang.Character.getNumericValue;

/**
 * This class represents a simple solution for Ex1.
 * As defined here: <a href="https://docs.google.com/document/d/1AJ9wtnL1qdEs4DAKqBlO1bXCM6r6GJ_J/r/edit/edit">...</a>
 * In this assignment, we will design a number formatting converter and calculator.
 * In general, we will use Strings as numbers over basis of binary till Hexa.
 * [2-16], 10-16 are represented by A,B,..G.
 * The general representation of the numbers is as a String with the following format:
 * <number><b><base> e.g., “135bA” (i.e., “135”, as 10 is the default base), “100111b2”, “12345b6”,”012b5”, “123bG”, “EFbG”.
 * The following are NOT in the format (not a valid number):
 * “b2”, “0b1”, “123b”, “1234b11”, “3b3”, “-3b5”, “3 b4”, “GbG”, "", null,
 * You should implement the following static functions:
 */
public class Ex1 {
    /**
     * Convert the given number (num) to a decimal representation (as int).
     * It the given number is not in a valid format returns -1.
     *
     * @param num a String representing a number in basis [2,16]
     * @return
     */
//    The number2Int function converts the string num into an integer and return the value. If isNumber(num) is true,
//    it calculates the value by iterating through the numeric part (beginOfNum(num)), raising the base (endOfNum(num)) to
//    the appropriate power, multiplying by the numeric value of each character, and summing the results.
//    If num contains only digits, it directly converts it to an integer using Integer.parseInt.
    public static int number2Int(String num) {
        int ans = -1;

        if (isNumber(num)){
            ans=0;
            for (int i=0; i<beginOfNum(num).length(); i++){/*Iterates through the first part of the string, and at each index, raises the last part of the
            string to the power of the length of the string minus the index minus 1, then multiplies the result by the number at the current index.*/
                ans = (int) (ans + (Math.pow(getNumericValue(endOfNum(num)),beginOfNum(num).length()-1-i))*getNumericValue(beginOfNum(num).charAt(i)));
            }
        }
        if (num.matches("\\d+")) // change char of number to int.
            ans = Integer.parseInt(num);

        return ans;
     }

        /**
         * This static function checks if the given String (g) is in a valid "number" format.
         * @param a a String representing a number
         * @return true iff the given String is in a number format
         */
//        The isNumber function checks whether string 'a' represents a valid number in the format.
//            It splits 'a' into two parts: 'b', the main numeric sequence (using beginOfNum), and 'e', the last character (using endOfNum).
//            The function verifies that 'a' is not empty, that its format matches 'b' + "b" + 'e', and that 'e' is valid according to the goodChar helper function.
//            It also checks that all characters in b are valid and smaller than 'e'. Additionally, if a consists only of digits
//           , it is considered valid. The function returns true if all checks pass, and false otherwise.
        public static boolean isNumber(String a) {
            boolean ans = true;
            String b = beginOfNum(a);
            char e = endOfNum(a);
            if (a.isEmpty() || b.isEmpty() || !a.equals(b+"b"+e) || !goodChar(e))
                ans = false;

            for (int i =0; i<b.length() && ans;i++){
                if (!goodChar(b.charAt(i)) || b.charAt(i)>=e)
                    ans = false;
            }
                if (a.matches("\\d+"))
                    ans = true;

            return ans;
        }

        /**
         * Calculate the number representation (in basis base)
         * of the given natural number (represented as an integer).
         * If num<0 or base is not in [2,16] the function should return "" (the empty String).
         * @param num the natural number (include 0).
         * @param base the basis [2,16]
         * @return a String representing a number (in base) equals to num, or an empty String (in case of wrong input).
         */
        public static String int2Number(int num, int base) { //The function takes two numbers: one as a number in base 10 and the other
//            as the base in which the number should be represented and return a String representing a number (in base) equals to num, or an empty String (in case of wrong input).
//            I create an empty string and use a loop to perform a modulo operation
//            of the base on the number. Each time, the remainder is added at the beginning of the string, and the number is divided by
//            the base until the number equals 0. The function then returns the resulting string along with "b" and the base.
//            It handles the case where the base is 10 by leaving the number as it is, as well as the case where the number is 0, which simply results in "0" in the given base.
//            An auxiliary function is used to convert the numbers from integers to strings.
            String ans = "";
            String base1 = fixnum(base);
            if (num < 0 || 16 < base || base< 2 ){// check if the num or base not in format and return "".
            return ans;}
            if (base == 10) // if the base is 10 return num as String.
                return String.valueOf(num);
            if (num == 0){ // if num is 0 return 0b(base)
                return 0 + "b" + base1;
            }
            while (num !=0 ){ // change the num to num in base and return him.
                ans = fixnum(num % base) + ans;
              num = num/base;
            }
            return ans + "b" + base1;
        }

        /**
         * Checks if the two numbers have the same value.
         * @param n1 first number
         * @param n2 second number
         * @return true iff the two numbers have the same values.
         */
//    The `equals` function compares two strings, `n1` and `n2`, by converting them to integers using `number2Int` and checking
//    if the values are equal. It returns `true` if they match, otherwise `false`.
        public static boolean equals(String n1, String n2)
        {
            return (number2Int(n1) == number2Int(n2));
        }

        /**
         * This static function search for the array index with the largest number (in value).
         * In case there are more than one maximum - returns the first index.
         * Note: you can assume that the array is not null and is not empty, yet it may contain null or none-valid numbers (with value -1).
         * @param arr an array of numbers
         * @return the index in the array in with the largest number (in value).
         *
         */
//    The `maxIndex` function finds the index of the largest number in an array of strings by comparing each element
//    (converted to an integer using `number2Int`). It updates the index if a larger value is found and returns the index of the largest number.
        public static int maxIndex(String[] arr) {
            int ans = 0;
            for (int i=0; i< arr.length; i++){
               if (number2Int(arr[i]) > number2Int(arr[ans])) // check if current number bigger and if he bigger save the current index.
                    ans = i;
                }

            return ans;
        }

        public static String fixnum(int a){ // representing number with letters
            if (a==10)
                return "A";
            if (a==11)
                return "B";
            if (a==12)
                return "C";
            if (a==13)
                return "D";
            if (a==14)
                return "E";
            if (a==15)
                return "F";
            if (a==16)
                return "G";
            return String.valueOf(a);

        }
    //The `goodChar` function checks if a character is a valid digit (0-9)
    // or one of the characters in "ABCDEFG". It returns `true` if either condition is met, otherwise `false`.
        public static boolean goodChar(char a){
            boolean ans = false;
            String l = "ABCDEFG";
            if (getNumericValue(a) >= 0 && getNumericValue(a) < 10 )
                ans = true;
            for (int i=0; i<l.length(); i++){//It iterates through all the characters in the string and checks if the character matches any of them.
                if (l.charAt(i) == a) {
                    ans = true;
                    break;
                }
            }

            return ans;
        }

        public static String beginOfNum(String a){ //get string number and return the part before 'b'
         String ans = "";
         int i=0;
         while (i<a.length() && a.charAt(i) != 'b') {//It iterates through the string up to the character 'b' and copies that part into a string I created.
             ans = ans + a.charAt(i);
                     i++;
         }
         return ans;
        }

        public static char endOfNum(String a){ //get string number and return last char that representing the part of the base
           if (a == "")
               return ' ';
            return a.charAt(a.length() - 1);
        }


}
