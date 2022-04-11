package javaobinnaException;

/** ABOUT:
 * Illustrate how to handle UNCHECKED exceptions.
 * Unchecked exceptions don't require the "throws" keyword.
 * The java compiler doesn't enforce checking unchecked exceptions.
 * During runtime, the JVM runtime (JRE) will throw any unhandled unchecked exception.
 * Unchecked exceptions are usually caused by bad programming practices and
 * are not advised to be handled (although we have done so here in the catch block).
 *
 * In this example, bad programming practice can be prevented using an if/else condition.
 * User can be prompted again to re-enter a valid index value.
 * Unchecked/Runtime exceptions are not caught at compile time until code is run hence its name.
 */

public class ExceptionTutorial1 {
    public static void main(String[] args) {
        try {
            //A throw IndexOutOfBoundsException occurs if input is greater than 2
            //Can use an if/else condition to prevent this exception from ever occurring.
            String fruit = GetFruit(3);
            System.out.println("Fruit: " + fruit);
        } catch (IndexOutOfBoundsException ex) {
            //will print the default exception message
            System.out.println(ex.getMessage());
        }
    }

    //Unchecked/Runtime exceptions don't require the "throws" keyword (optional)
    public static String GetFruit(int index) {
        String[] fruits = new String[]{"Apple", "Mango", "Orange"};
        return fruits[index];
    }
}


