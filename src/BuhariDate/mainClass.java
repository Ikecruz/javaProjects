/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BuhariDate;
import java.text.SimpleDateFormat;
import java.time.*;
/**
 *
 * @author ikedi
 */
public class mainClass {
    LocalDate now = LocalDate.now();
    
    LocalDate getDate(){
        return now;
    }
    
    LocalDate tenure(){
        return LocalDate.of(2023, Month.MAY, 29);
    }
    
    Period diff(){
        return Period.between(getDate(), tenure());
    }
    
    public static void main(String[] args) {
        mainClass mc = new mainClass();
        
        Period difference = mc.diff();
        
        System.out.println("Buhari's remaining Time in tenure:");
        System.out.println(difference.getYears() +" Years, "+ difference.getMonths()+" Months and "+difference.getDays()+" Days");
        
        
        System.out.println("Cruz...");
    }
}
