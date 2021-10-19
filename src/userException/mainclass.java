/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userException;
import java.util.Scanner;

class Zero extends Exception {

    String message;

    public Zero(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
/**
 *
 * @author ikedi
 */
public class mainclass {

    public static void main(String[] args) throws Zero {
        Scanner s = new Scanner(System.in);
        System.out.println("Welcome to RechargeMate");
        System.out.println("-----------------------");
        System.out.println("");
        System.out.println("Enter amount :");
        int amount = s.nextInt();
        try {
            if (amount <= 0) {
                throw new Zero("Invalid Amount");
            } else {
                System.out.println("Amount Deposited");
            }

        } catch (Zero mab) {
            mab.printStackTrace();
        }
    }

}
