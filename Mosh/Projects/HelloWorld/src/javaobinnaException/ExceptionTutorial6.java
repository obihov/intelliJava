package javaobinnaException;

import java.io.IOException;
import java.util.zip.DataFormatException;

/**ABOUT:
 * This tutorial will use the "|" symbol to combine multiple exceptions in a single catch block
 * Especially useful if your requirements want different exceptions to be handled the same way.
 */
public class ExceptionTutorial6 {

    public static void main(String[] args) {
        try {
            MethodA();
        } catch (IOException | DataFormatException e) {
            e.printStackTrace();
        }
    }

    public static void MethodA() throws IOException, DataFormatException{
        //not implemented yet
    }
}
