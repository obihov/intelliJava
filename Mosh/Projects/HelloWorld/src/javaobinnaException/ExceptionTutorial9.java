package javaobinnaException;

/**ABOUT:
 * This tutorial is about working with a general purpose exception that is caused by a specific exception.
 * use the init approach or
 * use the exception constructor overload approach, which accepts a throwable type.
 */
public class ExceptionTutorial9 {


    public static void main(String[] args) {
        //Scenario 1 - We handle a general exception - one which we don't have clear knowledge what caused it.
        try {
            Example1();
        } catch (GeneralException e) {
            System.out.println("Error: " + e.getMessage());
        }

        //Scenario 2 - We handle a specific exception - one which we are absolutely sure caused the exception.
        try {
            Example2();
        } catch (SpecificException e) {
            System.out.println("Error: " + e.getMessage());
        }

        //Scenario 3 - We relate a General exception as being caused by a specific exception using the init method.
        try {
            //Two approaches, you can just be direct or unbox and then throw. Either works.
            //Direct approach - this will throw a Throwable type (parent of all exception and error classes)
            //throw new GeneralException().initCause(new SpecificException());

            //Unbox and throw approach - this can be used to throw the exact exception type you desire.
            GeneralException causedException = (GeneralException) new GeneralException().initCause(new SpecificException());
            throw causedException;

        } catch (Throwable e) {
            //if unboxed as a GeneralException, then you can use either a
            //Throwable, Exception, or GeneralException type as the argument of the catch block.
            System.out.println("Error Caused by: " + e.getCause());
            e.printStackTrace();
        }

        //Scenario 4 - Same as scenario 3 but showcases a simplified or improved code implementation.
        try {
            //You must define a constructor overloaded method in the GeneralException class
            //that takes a Throwable as an argument.
            throw new GeneralException(new SpecificException());
        } catch (GeneralException e) {
            System.out.println("Error Caused by: " + e.getCause());
            e.printStackTrace();
        }
    }

    public static void Example1() throws GeneralException {
        //In this example we will simply throw a general exception.
        //Here we really don't have a clear idea what the exact exception is, so we generalize it.
        throw new GeneralException();

    }

    public static void Example2() throws SpecificException {
        //In this example we will throw a specific exception.
        //Here we are well aware of what specific kind of exception we expect.
        throw new SpecificException();
    }
}

class GeneralException extends Exception{
    public GeneralException() {
        super("A general exception has occurred.");
    }

    public GeneralException(String message) {
        super(message);
    }

    public GeneralException(Throwable cause) {
        super(cause);
    }
}

class SpecificException extends Exception {
    public SpecificException() {
        super("A specific exception has occurred.");
    }

    public SpecificException(String message) {
        super(message);
    }
}
