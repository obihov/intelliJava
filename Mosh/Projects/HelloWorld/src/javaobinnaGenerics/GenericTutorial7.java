package javaobinnaGenerics;


public class GenericTutorial7 {


    public static void main(String[] args) {

    }

    /** PROBLEM AND REASON WHY A WILDCARD IS NEEDED WHEN WORKING WITH METHODS THAT USES GENERIC TYPES as ARGUMENT
    In the parameter of these methods:  ObjectEx, StringEx, AnimalEx, OR CatEx
    We had strictly specified what the expected argument type should be for each method parameter.
    Therefore,
    For ObjectEx method, we expect only new GenericItemList<Object>.
    For StringEx method, we expect only GenericItemList<String>.

    The issue with this approach is that if we cannot think of substituting any of these with a Child. So
    We cannot supply new GenericItemList<Integer> in the ObjectEx method.

    Please don't confuse this approach of defining method with approach used in defining generic methods.
    1. static <T> void ObjectEx(GenericItemList<T> item) is not same as
    2. static void ObjectEx(GenericItemList<Object> animalList)

    (1) offers flexibility and is considered as a generic-level method,
    T is determined based on the type you specify when you call the method,
    Also keep in mind that how T is defined in the generic class itself GenericItemList<T>,
    will determine what types (And their children) that you can use when calling the ObjectEx method.
    ObjectEx(new GenericItemList<String>())

    (2) is not flexible, it is simply a regular method that takes a Generic class as argument in its parameter.
    In this situation, you must specify an exact argument as already expected by the method's parameter.
    Treat this approach like when you have a method that expects int, you supply it an int value.
    ObjectEx(new GenericItemList<Object>())

    So the real question here is, what if we wanted a method that expects a GenericItemList<Monkey> as argument
    Then we would have to add a MonkeyEx method that has a parameter of type GenericItemList<Monkey> like below:
    public static void MonkeyEx(GenericItemList<Monkey> animalList) { }

    This will pollute our source code in no time. This is where Wildcard is a hero.
     1. With WildCards '<?>' we can derive flexibility in our method's parameter.
     2. We can also use it for Generics inheritance situations (see extends and super examples)
     */
    public static void ObjectEx(GenericItemList<Object> animalList) { }
    public static void StringEx(GenericItemList<String> animalList) { }
    public static void AnimalEx(GenericItemList<Animal> animalList) { }
    public static void CatEx(GenericItemList<Cat> animalList) { }

    public static void WithoutUsingWildcard(){
        ObjectEx(new GenericItemList<Object>());
        StringEx(new GenericItemList<String>());
        AnimalEx(new GenericItemList<Animal>());
        CatEx(new GenericItemList<Cat>());
    }


}

class GenericItemList<T> {

}

class Animal {

}

class Cat {

}


