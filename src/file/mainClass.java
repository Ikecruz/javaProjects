/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package file;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author ikedi
 */
public class mainClass {

    //Read file one and return it's content
    String fileOne() {
        String data = "";

        try {
            //Convert to file
            File myFile = new File("C:\\Users\\ikedi\\Desktop\\JavaFile\\file1.txt");
            if (myFile.exists()) {
                //Try reading with Scanner
                try (Scanner myReader = new Scanner(myFile)) {

                    //Read all line in file
                    while (myReader.hasNextLine()) {
                        //Pass the value to a variable
                        data += myReader.nextLine();
                    }
                }
            } else {
                data = "File doesn't exist";
            }
        } catch (FileNotFoundException e) {
            data = "An error occurred.";
        }

        //Return the file content
        return data;
    }

    //Read file one and return it's content
    String fileTwo() {
        String data = "";

        try {
            //Convert to file
            File myFile = new File("C:\\Users\\ikedi\\Desktop\\JavaFile\\file2.txt");
            if (myFile.exists()) {
                //Try reading with Scanner
                try (Scanner myReader = new Scanner(myFile)) {

                    //Read all line in file
                    while (myReader.hasNextLine()) {
                        //Pass the value to the data variable
                        data += myReader.nextLine();
                    }
                }
            } else {
                data = "File doesn't exist";
            }
        } catch (FileNotFoundException e) {
            data = "An error occurred.";
        }

        return data;
    }

    //Concat file one's content with file two's 
    String fileThree() throws IOException {
        //Concat file one's content with file two's 
        String fileContent = fileOne().concat(fileTwo());

        //Write into file three
        try (FileWriter write = new FileWriter("C:/Users/ikedi/Desktop/JavaFile/file3.txt")) {
            write.write(fileContent);
        }
        
        return fileContent;
    }
    
    // Create new file and pass file three's content length into it
    String fileFour() throws IOException{
        //Pass the length of file three's content into a variable
        String length = String.valueOf(fileThree().length());
        
        try {
            //Create new file
            File myFile = new File("C:/Users/ikedi/Desktop/JavaFile/file4.txt");
            
            //check if file was created
            if (myFile.createNewFile()) {

                //Write length into file
                try (FileWriter writer = new FileWriter(myFile)) {
                    writer.write(length);
                    writer.close();
                }
                
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return length;
    }

    public static void main(String[] args) throws IOException {
        mainClass one = new mainClass();

        System.out.println("File one's content:");
        System.out.println(one.fileOne());
        System.out.println("-------------------");
        System.out.println("");
        
        System.out.println("File two's content:");
        System.out.println(one.fileTwo());
        System.out.println("-------------------");
        System.out.println("");
        
        System.out.println("File three's content:");
        System.out.println(one.fileThree());
        System.out.println("-------------------");
        System.out.println("");
        
        System.out.println("Length of file three's content:");
        System.out.println(one.fileFour());
        System.out.println("-------------------");
        System.out.println("");
    }
}
