package javaobinnaGenerics;

/** Using WildCards
 */

public class GenericTutorial7 {


    public static void main(String[] args) {

    }

    /** GENERICS AS ARGUMENT IN METHOD PARAMETER - PROBLEM
     *  Below examples make it possible to use generic arguments in method parameter.
     *  However, you do not have much flexibility because you are required to provide exact match expected by argument.
     *  For example, the ObjectEx method, expects argument of type GenericItemList<Object> AND that must be supplied as argument to the method's parameter.
     *  If you wanted to supply a stringList argument to the ObjectEx method, that would not be possible AND
     *  you must create another method to use a GenericItemList<String> argument type.
     *  This can blow up your code, as new methods are created to handle the expected parameter type.
     *  Using a WildCard will solve this issue.
     */
    public static void ObjectEx(GenericItemList<Object> objectList) { }
    public static void StringEx(GenericItemList<String> stringList) { }
    public static void AnimalEx(GenericItemList<Animal> animalList) { }
    public static void CatEx(GenericItemList<Cat> catList) { }
    public static void NumberExWithRestriction(GenericItemListWithRestriction<Number> numberList) { }

    public static void WildcardNotUsed(){
        ObjectEx(new GenericItemList<Object>());
        StringEx(new GenericItemList<String>());
        AnimalEx(new GenericItemList<Animal>());
        CatEx(new GenericItemList<Cat>());
        GenericTutorial7.NumberExWithRestriction(new GenericItemListWithRestriction<Number>());
        //with restriction, you are limited to bounded type defined.
        //If you wanted <Double>, then you should define another method using new GenericItemListWithRestriction<Double> as parameter
    }

    /** GENERICS AS ARGUMENT IN METHOD PARAMETER - PROBLEM
     * With a WildCard, you can make your Generic argument is flexible to accept other types.
     * Note: Using WildCard in method parameter's is restricted to the type arguments mentioned in the Generic class definition.
     * For example:
     * (1) If a generic class is defined as below
     * public class GenericItemList<T>, THEN a Generic-WildCard method like ObjectEx(GenericItemList<?> anyList) can accept a
     * - new GenericItemList<String>, new GenericItemList<Object>, new GenericItemList<Number> etc.
     * (2) If a generic class is defined with restriction as below
     * public class GenericItemList<T extends Number>, THEN a Generic-WildCard method can only accept Number and its child classes as shown below.
     * - new GenericItemList<Number>, new GenericItemList<Integer>, new GenericItemList<Float>, new GenericItemList<Double> etc.
     */
    public static void NumberExWildCard(GenericItemList<?> anyList) { }
    public static void NumberExWithRestrictionWildCard(GenericItemListWithRestriction<?> anyList) { }

    public static void WildcardIsUsed(){
        // Also, because GenericItemList class was not restricted to any specific type, we are able to use WildCard to specify argument based off of any given type as shown below.
        NumberExWildCard(new GenericItemList<Object>());
        NumberExWildCard(new GenericItemList<String>());
        NumberExWildCard(new GenericItemList<Integer>());
        NumberExWildCard(new GenericItemList<Animal>());
        NumberExWildCard(new GenericItemList<Cat>());

        // When the definition of the generic class is restricted, then we must use the restricted type or its children when supplying argument for the method's parameter.
        NumberExWithRestrictionWildCard(new GenericItemListWithRestriction<Number>());
        NumberExWithRestrictionWildCard(new GenericItemListWithRestriction<Byte>());
        NumberExWithRestrictionWildCard(new GenericItemListWithRestriction<Short>());
        NumberExWithRestrictionWildCard(new GenericItemListWithRestriction<Integer>());
        NumberExWithRestrictionWildCard(new GenericItemListWithRestriction<Long>());
        NumberExWithRestrictionWildCard(new GenericItemListWithRestriction<Float>());
        NumberExWithRestrictionWildCard(new GenericItemListWithRestriction<Double>());
    }
}

class GenericItemListWithRestriction<T extends Number> {

}

class GenericItemList<T> {

}

class Animal {

}

class Cat {

}


