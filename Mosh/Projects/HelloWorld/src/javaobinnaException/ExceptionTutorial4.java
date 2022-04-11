package javaobinnaException;

/**ABOUT:
 * This tutorial shows the creation of custom "unchecked/runtime" exception.
 * Like system defined runtime exceptions, custom defined runtime exceptions are not required to be handled.
 * This means using either the "throws" keyword on the method where the exception will occur
 * Or, using a catch block to handle the exception when that method is called is optional.
 * However, such exceptions demand attention because they do occur due to bad programming practices.
 */
public class ExceptionTutorial4 {
    public static void main(String[] args) {
        //Notice we didn't have to handle this method call inside a try/catch block
        //Because internally, it's an unchecked/runtime exception.
        MethodA();
    }

    //Notice we didn't use the "throws" keyword,
    //and that's because CustomRuntimeException is an unchecked/runtime exception
    public static void MethodA() {
        throw new CustomRuntimeException();
    }
}

//Runtime exceptions do not require the use of "throws" keyword,
//and also doesn't require the exception to be handled by the caller.
class CustomRuntimeException extends RuntimeException {
    public CustomRuntimeException() {
        super("Custom-runtime exception occurred.");
    }

    public CustomRuntimeException(String message) {
        super(message);
    }
}
