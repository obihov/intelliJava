package javaobinnaGenerics;

public class GenericDefinitionRule {
}

class ClassLevelExample1 <T> {}
class ClassLevelExample2 <T extends Object> {}
class ClassLevelExample3 <T extends Number> { T args = (T) new Object(); }

class MethodLevelExample{
    /** Tutorial:

      You will get a "Cannot resolve symbol T" error if you defined a generic method in any of the below ways in Java:
        1. private static <T extends Object> void MethodD(WildcardGen<T> genObj)
        2. private static <T extends Object> void MethodD(WildcardGen<T extends Object> genObj)
        3. private static <T> void MethodD(WildcardGen<T extends Object> genObj)
        4. private static void MethodD(WildcardGen<T extends Object> genObj)
        5. private static void MethodD(WildcardGen<T> genObj)

     As a general rule, if you have a generic class definition. Then the Type argument must match the method argument specified.
     Example1:
     Given: class Generic<T>{ }
     And you have a method in another class: void Method(Generic<T> args){ }
     Then you must specify the method argument as: <T> void Method(Generic<T> args){ }
     <T> without restriction is same as <T extends Object>. You will be able to supply any type args to the method's parameter since all types inherit the Object class.

     Example2:
     Given restriction is applied: class Generic<T extends Number>{ }
     And you have a method in another class: void Method(Generic<T> args){ }
     Then you must specify the method argument as: <T extends Number> void Method(Generic<T> args){ }
     With restrictions, you will only be allowed to supply args to the method's parameter where T resolves as Number or any of Number's child classes.

     Note:
     Restrictions using extends are upper-bound, meaning you cannot go above it, only at its level or its child.
     So extends Object, can use new Object() or any type literally in Java.
     extends Number, can use new Number() and only its child classes. Cannot use new Object() as that is above the restriction bound.

      The correct ways to define a Generic method is shown below:
        1. private static <T> void MethodD(WildcardGen<T> genObj)
            - Above is only possible if the Generic class is defined as below:
            - class WildcardGen<T> { T arg; }
        2. private static <T extends WildcardParent> void MethodD(WildcardGen<T> genObj)
            - Above is only possible if the Generic class is defined as below:
            - class WildcardGen<T extends WildcardParent> { T arg; }
            - Supply only argument to the method's parameter that will resolve to WildcardParent or its child classes.
        3. private static <T extends WildCardChild> void MethodD(WildcardGen<T> genObj)
            - if the Generic class is defined as below:
            - class WildcardGen<T extends WildcardParent> { T arg; }
            - your method can still be allowed to restrict to the exact type or any of its child classes.
            - So for our method, we can restrict T to either WildcardParent or WildCardChild.
        4. private static <T extends Integer> void MethodD(WildcardGen<T> genObj)
            - Above is only possible if the Generic class is defined as below:
            - class WildcardGen<T extends Object>
            - In this situation, not only can we restrict T on the method to Integer, but we can do so with other types
            - This is because our Generic class is bound/restricted to Object, and all types inherit from Object, meaning we can use any type to restrict our method's T argument.

     Below definitions are also valid but, they have no real usage.
     public static <T> void Method0(){ } //valid definition but of no use in reality.
     public static <T> T Method1(){ T args = (T) new Object(); return args; } //valid definition but of no use in reality.
     public static <T extends Number> T Method2(){ T args = (T) new Object(); return args; } //valid definition but of no use in reality.

      Summary:
        - Generic methods can be defined inside a Generic class and a non-generic class.
        - If defined in a non-generic class, the syntax must follow: "accessModifier <T with/without restrictions> returnType MethodName(T or ReferenceType<T> args) { }".
        - If defined in a generic class, and still uses the Type argument of the class, then syntax can be simplified to: "accessModifier returnType MethodName(T or ReferenceType<T> args) { }".
        - Never use any restriction for the "T" argument type that is specified in the Method parentheses itself.

     */


}