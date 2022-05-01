package javaobinnaGenerics;

public class GenericTutorial8 {
    public static void main(String[] args) {
        /*
        This part of the tutorial illustrates basic Generic usage.
        The t resolves to whatever the type <> argument is.
        You will be able to call the methods of the type.
         */
        Example1();

        /*
        The t resolves to the type <T> argument specified.
        Based on OOP, you can assign a child instance to its parent type.
        So Parent p = new Child(); and only possible because of the inheritance relationship between Parent and Child.
         */
        Example2();

        /*
        Even though WildCardChild is child of WildCardParent,
        The Generic class WildcardGen<T> where T can be WildCardChild or WildCardParent is just one class in itself.
        And WildcardGen<WildCardChild> does not extend WildcardGen<WildCardParent>.
        Therefore, you cannot substitute new WildcardGen<WildCardChild>() for a WildcardGen<WildCardParent>
        in the same way we could with new WildCardChild for a  WildCardParent.
        In Example4, you will see how using Wildcards in Generics can solve this to allow for substitution.
         */
        Example3();

        Example4();
    }



    public static void Example1() {
        WildcardGen<WildcardParent> parent = new WildcardGen<>();
        parent.t.MethodParent();

        WildcardGen<WildCardChild> child = new WildcardGen<>();
        child.t.MethodChild();
        child.t.MethodParent();
    }

    public static void Example2() {
        WildcardGen<WildcardParent> parent = new WildcardGen<>();
        WildcardGen<WildCardChild> child = new WildcardGen<>();

        WildcardParent parentObj = parent.t;
        WildCardChild childObj = child.t;
        MethodExample(parentObj);
        MethodExample(childObj);
    }

    public static void Example3() {
        MethodExample3(new WildcardGen<WildCardChild>());
        MethodExample2(new WildcardGen<WildcardParent>());

        /*
        Below line of code will have compile-time error because even though WildCardChild is child of WildCardParent,
        the generic class itself "WildcardGen<WildCardChild>" is not child of WildcardGen<WildcardParent>.

        MethodExample2(new WildcardGen<WildCardChild>());
         */
    }

    private static void Example4() {
    }

    public static void MethodExample(WildcardParent parent) { }

    public static void MethodExample2(WildcardGen<WildcardParent> genObj) { }
    public static void MethodExample3(WildcardGen<WildCardChild> genObj) { }
}

class WildcardGen<T extends WildcardParent> {
    T t;

    public WildcardGen() {
        t = (T) new Object();
    }
}

class WildcardParent {
    void MethodParent() {
        System.out.println("Parent");
    }
}


class WildCardChild extends WildcardParent {
    void MethodChild() {
        System.out.println("Child");
    }
}


