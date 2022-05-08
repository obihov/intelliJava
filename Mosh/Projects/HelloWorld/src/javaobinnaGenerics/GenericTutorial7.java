package javaobinnaGenerics;

/** Using WildCards
 */

public class GenericTutorial7 {


    public static void main(String[] args) {

    }

    /** GENERICS AS ARGUMENT IN METHOD PARAMETER - PROBLEM
     *  Based on SOLID'S Liskov-substitution principle, we should be able to substitute a type with its child type.
     *  So if Child extends Parent, then we can assign an instance of child to the type Parent.
     *  Parent parent = new Child();
     *  The same can be expected when Parent is used as a parameter in a method. We should be able to provide an instance of either Parent or Child as argument to the method as well.
     *  void DoSomething(Parent parent)
     *  DoSomething(new Parent()) or DoSomething(new Child())
     *
     *  But, things are different when using Generic classes.
     *  Now if you have a Generic class as GenericExample<T extends Parent>.
     *  You should know that the type argument specified inside the <> angle brackets, is restriction/bound statement.
     *  It doesn't mean that GenericExample extends from another class. Instead, it means GenericExample would only expect T arguments that is Parent or any of its child types.
     *  So, you cannot do
     *  - GenericExample<Parent> gen = new GenericExample<Child>()
     *  - void DoSomething(GenericExample<Parent> gen) => DoSomething(new GenericExample<Child>())
     *
     *  But you can do
     *  - GenericExample<Parent> gen = new GenericExample<Parent>(); or
     *  - GenericExample<Child> gen = new GenericExample<Child>()
     *  - void DoSomething(GenericExample<Parent> gen) => DoSomething(new GenericExample<Parent>())
     *  - void DoSomething(GenericExample<Child> gen) => DoSomething(new GenericExample<Child>())
     *  - <T> void DoSomething(GenericExample<T> gen) => DoSomething<Parent>(new GenericExample<Parent>()) or DoSomething<Child>(new GenericExample<Child>())
     *
     *
     *  In this tutorial, we have created the below two generic classes for practice.
     *  class GenericItemList<T> { }
     *  class GenericItemListWithRestriction<T extends Number> { }
     *
     *  One of classes has a restriction and the other doesn't.
     *  Specifying restrictions on generic classes will determine what Type we must use to instantiate the generic class.
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
     * WildCards helps you achieve a Liskov-like solution when using Generic classes.
     * */
    public static void WildCardExample1(GenericItemList<?> anyList) { }
    public static void WildCardExample2(GenericItemListWithRestriction<?> anyList) { }

    public static void WildcardIsUsed(){
        // When there is no restriction, you may use any type argument (string, object, etc.) for the generic class as shown below.
        WildCardExample1(new GenericItemList<Object>());
        WildCardExample1(new GenericItemList<String>());
        WildCardExample1(new GenericItemList<Integer>());
        WildCardExample1(new GenericItemList<Animal>());
        WildCardExample1(new GenericItemList<Cat>());

        // When restriction is used to create the Generic class, then the WildCard is restricted to the type bound and any of its child types.
        // GenericClass<T extends Number>, thus only Number and its child classes are allowed.
        WildCardExample2(new GenericItemListWithRestriction<Number>());
        WildCardExample2(new GenericItemListWithRestriction<Byte>());
        WildCardExample2(new GenericItemListWithRestriction<Short>());
        WildCardExample2(new GenericItemListWithRestriction<Integer>());
        WildCardExample2(new GenericItemListWithRestriction<Long>());
        WildCardExample2(new GenericItemListWithRestriction<Float>());
        WildCardExample2(new GenericItemListWithRestriction<Double>());
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


