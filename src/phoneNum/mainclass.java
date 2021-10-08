/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phoneNum;

import java.util.Scanner;

/**
 *
 * @author ikedi
 */
public class mainclass {

    String phone(String number) {
        String newNumber;

        String countryCode = number.substring(0, 4);
        if (countryCode.equals("+234")) {
            String first = number.substring(4, 5);

            if ((first.equals("7")) || (first.equals("8")) || (first.equals("9"))) {
                newNumber = number;
            } else {
                newNumber = "+234" + number.substring(5);
            }

        } else {
            newNumber = "+234" + number.substring(1);
        }

        return newNumber;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        mainclass one = new mainclass();

        System.out.println("Enter Number: ");
        String number = scan.next();
        System.out.println("");

        try {
            System.out.println("Number is " + one.phone(number));
        } catch (java.util.InputMismatchException e) {
            System.out.println("Please Make Sure all Inputs are Correct");
        }
    }
}
