package javaobinnaException;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.zip.DataFormatException;

/**ABOUT:
 * This tutorial is about handling multiple exceptions.
 * Multiple catch blocks can be used to handle a mix of exceptions
 * This includes (checked and unchecked, as well as parent-child related exceptions - as shown in this tutorial).
 * However, keep in mind that the order of the catch block matters
 * when dealing with parent-child related exceptions.
 */
public class ExceptionTutorial5 {
    public static void main(String[] args) {
        try {
            MethodA(0);
        } catch (FileNotFoundException e) {
            //Although we have included it here, but you don't need to handle the FileNotFoundException because
            //its parent type (i.e. IOException can help do so at runtime.)
            //Also, if you must handle a child exception, then do so before handling its parent otherwise your code will not compile.
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        } catch (DataFormatException e) {
            e.printStackTrace();
        }
    }


    /**
     * Multiple exceptions are thrown on this method.
     * Notice: FileNotFoundException is a child of IOException.
     * Both IOException and DataFormatException are checked exceptions because they extend the Exception class.
     * We are mandated to handle all checked exceptions in a catch block (that includes both IOException and DataFormatException)
     * ArithmeticException is an unchecked exception. Notice we didn't include it among the "throws" definition on the method.
     * We are not mandated to handle unchecked exceptions in catch blocks.
     * */
    public static void MethodA(int value) throws FileNotFoundException, IOException, DataFormatException{
        switch (value) {
            case 0:
                throw new FileNotFoundException("file not found.");
            case 1:
                throw new IOException("Input-Out type of exception occurred.");
            case 2:
                throw new DataFormatException("invalid data provided.");
            case 3:
                throw new ArithmeticException("Cannot divide by zero");
        }
    }
}
