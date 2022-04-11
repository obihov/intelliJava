package javaobinnaGenerics;

/** TUTORIAL
 * You can have a generic method inside a non-generic class.
 */
public class NonGenericClass {
    public static void main(String[] args) {
        int maximumValue1 = Util.MaximumVersion1(10, 20);
        System.out.println(maximumValue1);

        int maximumValue2 = Util.MaximumVersion2(10, 20);
        System.out.println(maximumValue2);

        Persons maximumValue3 = Util.MaximumVersion2(new Persons(50), new Persons(70));
        System.out.println("Persons: " +maximumValue3);
    }
}

/**
 * It's considered a code convention to define only static members inside Utility classes.
 */
class Util {

    //This version doesn't use a generic argument, but notice its limited to only integer values.
    public static int MaximumVersion1(int first, int second) {
        return (first > second) ? first : second;
    }

    //This version use a generic argument for more flexibility. It adds a constraint that will
    //allow T objects that implements the comparable interface to call the compareTo method for comparison operation.
    public static <T extends Comparable<T>> T MaximumVersion2(T first, T second) {
        return (first.compareTo(second) > 0) ? first : second;
    }

    //Prints an instance of user or its children.
    public static void printUser(User user) {
        System.out.println(user);
    }
}



