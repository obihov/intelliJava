package javaobinnaGenerics;

import java.util.Scanner;

/**
 * Tutorial illustrates how to work with different Generic type parameters
 * This can be applied both on class level and method level as well.
 * Note, not providing restrictions will make Java treat your types as Objects.
 */
public class GenericTutorial5 {
    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        ClassLevelWithRestriction ex1 = new ClassLevelWithRestriction();
        boolean isFruit = ex1.Method("Apple", 50);
        System.out.println("Is a fruit: " + isFruit);

        ClassLevelNoRestriction ex2 = new ClassLevelNoRestriction();
        String treeName = (String) ex2.Method("Mango", "Tree");
        System.out.println("Tree Name: " + treeName);

        MethodLevel ex3 = new MethodLevel();
        boolean isCountry = ex3.WithRestriction("England", 3000000);
        System.out.println("Is a country: " + isCountry);

        var religion = (String) ex3.NoRestriction("Religion", "Christian");
        System.out.println("Religion: " + religion);
        System.out.println("You entered: " + input.nextLine());
    }
}

//Class has T, K, V generic arguments with restrictions.
class ClassLevelWithRestriction<T extends Boolean, K extends String, V extends Number> {
    public T Method(K key, V value) {
        System.out.println("<" + key +","+ value +">");
        return (T) Boolean.valueOf(true);
    }

    //Boolean.valueOf("true") and Boolean.valueOf(Boolean.parseValue("true")) will also work.
}

//Class has T, K, V generic arguments without any restrictions.
//Since no restrictions, java sees each (T, K and V) as Object types.
class ClassLevelNoRestriction<T, K, V> {
    public T Method(K key, V value) {
        System.out.println("<" + key +","+ value +">");
        return (T) (key + " " + value);
    }
}

class MethodLevel {

    //T, K and V are different generic types
    //There are no restrictions on what type can be set for either T, K or V.
    //Since no restrictions, java sees each (T, K and V) as Object types.
    public <T, K, V> T NoRestriction(K key, V value) {
        System.out.println("<" + key +","+ value +">");
        return (T) (value);
    }

    //T, K and V are different generic types
    //Restrictions are set for T, K and V.
    //T must accept only Boolean objects and its children.
    //K must accept only String objects and its children.
    //V must accept only Number objects and its children (i.e. int, double etc)
    public <T extends Boolean, K extends String, V extends Number> T WithRestriction(K key, V value) {
        System.out.println("<" + key +","+ value +">");
        return (T) Boolean.valueOf(true);
    }
}
