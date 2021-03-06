/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm;

import java.util.Scanner;

/**
 *
 * @author ikedi
 */
public class ATM {

    double balance = 100000;
    int pin = 1234;
    boolean notDone = true;

    Scanner scan = new Scanner(System.in);
    
    //Format phone number
    String formatPhone(String number) {
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

    void checkBalance() {
        System.out.println("Current Account Balance: " + balance);
        System.out.println("");
    }

    void deposit() {
        System.out.println("Deposit Amount:");
        double amount = scan.nextInt();
        System.out.println("");
        
        if(amount <= 0){
            System.out.println(amount+" can't be deposited");
            System.out.println("");
            deposit();
        }

        balance += amount;
        System.out.println(amount + " Deposited");
        System.out.println("");
    }

    void rechargeMobile() {

        System.out.println("Enter Mobile Number:");
        String number = scan.next();
        System.out.println("");

        if ((number.length() < 11)) {
            System.out.println("/////////////////////////////");
            System.out.println("//  Invalid Mobile Number  //");
            System.out.println("/////////////////////////////");
            System.out.println("");
            rechargeMobile();
        }
        
        number = formatPhone(number);

        System.out.println("Enter Recharge Amount:");
        double amount = scan.nextInt();
        System.out.println("");
        
        if(amount <= 0){
            System.out.println("Recharge Amount is invalid");
            System.out.println("");
            rechargeMobile();
        } else{
            balance -= amount;
            System.out.println(amount + " Airtime recharged for "  + number);
            System.out.println("");
        }

    }

    void withdraw() {
        System.out.println("Enter Amount:");
        double amount = scan.nextInt();
        System.out.println("");

        if (amount > 0) {
            if ((balance - 1000) < amount) {
                System.out.println("///////////////////////////");
                System.out.println("//  Insufficent Balance  //");
                System.out.println("///////////////////////////");
                System.out.println("");
            } else {
                balance -= amount;
                System.out.println("***  "+ amount + " Withdrewed  ***");
                System.out.println("");
            }
        } else {
            System.out.println("/////////////////////");
            System.out.println("//  Invalid input  //");
            System.out.println("/////////////////////");
            System.out.println("");
            withdraw();
        }
    }

    void Continue() {
        System.out.println("***   Do you want to perform another Transaction?   ***");
        System.out.println("");
        System.out.print("[1] Yes");
        System.out.print("         ");
        System.out.print("[2] No");
        System.out.println("");
        int selector = scan.nextInt();
        System.out.println("");

        if (selector == 1) {
            notDone = true;
        } else if (selector == 2) {
            notDone = false;
            System.out.println("****************************************");
            System.out.println("**    Thanks for choosing CruzBank    **");
            System.out.println("****************************************");
        } else {
            System.out.println("////////////////////////////");
            System.out.println("///   Invalid Selector   ///");
            System.out.println("////////////////////////////");
            Continue();
        }
    }

    void atmMachine() {
        System.out.println("*******************************");
        System.out.println("**    Welcome To CruzBank    **");
        System.out.println("*******************************");
        
        System.out.println("**     Please enter Pin:     **");
        int pinInput = scan.nextInt();
        System.out.println("");

        if (pinInput != pin) {
            System.out.println("//////////////////////////");
            System.out.println("///    Invalid Pin     ///");
            System.out.println("//////////////////////////");
            System.out.println("");
            atmMachine();
        }
        
        System.out.println("***********************************");
        System.out.println("**       Welcome You're In       **");
        System.out.println("***********************************");
        System.out.println("***   What would you like to do?   ***");
        System.out.println("***   Input Number to select   ***");
        System.out.println("");

        while (notDone) {
            System.out.print("[1] Check Balance");
            System.out.print("         ");
            System.out.print("[2] Deposit Cash");
            System.out.println("");
            System.out.println("");
            System.out.print("[3] Withdraw Cash");
            System.out.print("         ");
            System.out.print("[4] Recharge Mobile");
            System.out.println("");
            System.out.println("");
            System.out.print("[5] Exit");
            System.out.println("");
            System.out.println("");

            int selector = scan.nextInt();
            System.out.println("");

            if (selector == 1) {
                checkBalance();
                Continue();
            } else if (selector == 2) {
                deposit();
                Continue();
            } else if (selector == 3) {
                withdraw();
                Continue();
            } else if (selector == 4) {
                rechargeMobile();
                Continue();
            } else if (selector == 5) {
                System.out.println("****************************************");
                System.out.println("**    Thanks for choosing CruzBank    **");
                System.out.println("****************************************");
                notDone = false;
            } else {
                System.out.println("//////////////////////////");
                System.out.println("//   Invalid Selector   //");
                System.out.println("//////////////////////////");
                
            }
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ATM atm = new ATM();

        //Call Function
        try {
            atm.atmMachine();
        } catch (java.util.InputMismatchException e) {
            System.out.println("///   Please Make Sure all Inputs are Correct   ///");
            System.out.println("///   You've been logged out   ///");
        }
    }

}
