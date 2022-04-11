package javaobinnaException;

/**ABOUT:
 * This tutorial shows the creation of custom "checked/compile-time" exception.
 * Like system defined checked exceptions, custom defined checked exceptions must be handled.
 * This means using both the "throws" keyword on the method where the exception will occur
 * And, using a catch block to handle the exception when that method is called.
 */
public class ExceptionTutorial3 {
    public static void main(String[] args) {

        //We must handle system defined and custom defined checked exceptions ina  catch block.
        try {
            MethodA();
        } catch (CustomCheckedException ex) {
            ex.printStackTrace();
        }
    }

    //Because CustomCheckedException is a checked/compile-time exception
    //We Must use the "throws" keyword here.
    public static void MethodA() throws CustomCheckedException {
        throw new CustomCheckedException();
    }
}

//The CustomCheckedException is a checked exception given it inherits the Exception class directly
//If it had inherited the RuntimeException class instead, then it would be an unchecked/runtime exception.
class CustomCheckedException extends Exception{
    public CustomCheckedException() {
        super("Custom-checked exception thrown.");
    }

    public CustomCheckedException(String message) {
        super(message);
    }
}