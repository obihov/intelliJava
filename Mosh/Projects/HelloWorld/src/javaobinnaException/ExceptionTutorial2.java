package javaobinnaException;

import java.io.FileNotFoundException;

/** ABOUT:
 Illustrate how to handle CHECKED exceptions.
 Checked exceptions requires the "throws" keyword on method where they occur.
 Checked exceptions is a-compile time exception.
 Your code will not compile if the "throws" keyword isn't used and
 if the exception isn't handled in a catch block.
 Unlike unchecked exceptions, checked exceptions are not due to bad programming practice.

 In this example, the FileNotFoundException is a-checked exception.
 We have used the "throws" keyword on the method where this exception likely to happen.
 We have also handled the exception in a catch block.
 Not doing any of this will prevent your code from compiling (let alone running).
 */

public class ExceptionTutorial2 {
    public static void main(String[] args) {
        try {
            String fileName = GetFile();
            System.out.println("Fruit: " + fileName);
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
    }

    //FileNotFoundException is a checked exception and a "throws" keyword is required on this method.
    public static String GetFile() throws FileNotFoundException {
        throw new FileNotFoundException("File not found.");
    }
}


