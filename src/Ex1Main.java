//student name: Snir Nachmany
//ID: 322593047


import java.util.Scanner;

/**
 * Intro2CS, Ex1 - very basic "main template"
 * Make sure your implementation of this main performs as the Ex1Sol.jar solution implement all needed functions.
 *
 */
public class Ex1Main {
    public static void main(String[] args) { /* the function get string numbers, print if he in good format and the value, the same with another
        number. then he get number between [2,16] and print The addition and multiplication of the two numbers in the base it received,
         and the number with the highest value among the four numbers.*/
        Scanner sc = new Scanner(System.in);
        String num1 = "", num2 = "", quit = "quit";
        int base;

        while (!num1.equals(quit) && !num2.equals(quit)) {
            System.out.println();
            System.out.println("Ex1 class solution:");
            System.out.println("Enter a string as number#1 (or \"quit\" to end the program): ");// ask to insert number
            num1 = sc.next();
            if (!num1.equals("quit")) {//
                System.out.println("num1= " + num1 + " is number: " + Ex1.isNumber(num1) + " , value: " + (int) Ex1.number2Int(num1));

                if (!Ex1.isNumber(num1)) { // if num1 not in the format print error message and back to lop.
                    System.out.println("ERR: num1 is in the wrong format! (" + num1 + ")");
                    continue;
                }

                System.out.println("Enter a string as number#2 (or \"quit\" to end the program): "); // ask for another number.
                num2 = sc.next();
                if (!num2.equals("quit")) {
                    System.out.println("num1= " + num2 + " is number: " + Ex1.isNumber(num2) + " , value: " + Ex1.number2Int(num2));

                    if (!Ex1.isNumber(num2)) { // if num1 not in the format print error message and back to lop.
                        System.out.println("ERR: num1 is in the wrong format! (" + num2 + ")");
                        continue;
                    }

                    System.out.println("Enter a base for output: (a number [2,16])"); //ask to insert base.
                    base = Integer.parseInt(sc.next()); // if the base not in the format print error message and back to lop.
                    if ((base < 2) || (base > 16)) {
                        System.out.println("ERR: wrong base, should be [2,16], got (" + base + ")");
                        continue;
                    }

                    int plus = Ex1.number2Int(num1) + Ex1.number2Int(num2);
                    int multi = Ex1.number2Int(num1) * Ex1.number2Int(num2);
                    String[] arr = {num1, num2, Ex1.int2Number(plus, base), Ex1.int2Number(multi, base)};
                    System.out.println(num1 + " + " + num2 + " = " + Ex1.int2Number(plus, base));
                    System.out.println(num1 + " * " + num2 + " = " + Ex1.int2Number(multi, base));
                    System.out.println("Max number over [" + num1 + "," + num2 + "," + Ex1.int2Number(plus, base) + "," + Ex1.int2Number(multi, base) + "] is: " + arr[Ex1.maxIndex(arr)]);

                }
            }

        }
        System.out.println("quiting now...");
    }
}

