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

        Example5();
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
        MethodA(parentObj);
        MethodA(childObj);
    }

    public static void Example3() {
        MethodB(new WildcardGen<WildcardParent>());
        MethodC(new WildcardGen<WildCardChild>());

        /*
        Below line of code will have compile-time error because even though WildCardChild is child of WildCardParent,
        the generic class itself "WildcardGen<WildCardChild>" is not child of WildcardGen<WildcardParent>.

        MethodB(new WildcardGen<WildCardChild>());
         */
    }

    private static void Example4() {
        int number = 10;
        MethodD(number);

        String stringObj = "hello world";
        MethodD(stringObj);

        WildcardGen<WildcardParent> parentWildcardGen = new WildcardGen<>();
        MethodD(parentWildcardGen);

        WildcardGen<WildCardChild> cardChildWildcardGen = new WildcardGen<>();
        MethodD(cardChildWildcardGen);
    }

    private static void Example5(){
        /*
        Below will throw errors because the <T> in MethodE is restricted to accept only WildcardParent or its children.
        MethodE("hello world");
        MethodE(false);
         */

        WildcardGen<WildcardParent> parentWildcardGen = new WildcardGen<>();
        MethodE(parentWildcardGen);

        WildcardGen<WildCardChild> cardChildWildcardGen = new WildcardGen<>();
        MethodE(cardChildWildcardGen);
    }


    private static void MethodA(WildcardParent parent) { }
    private static void MethodB(WildcardGen<WildcardParent> genObj) { }
    private static void MethodC(WildcardGen<WildCardChild> genObj) { }
    private static <T> void MethodD(T genObj) { }   //<T> is not restricted so can take any argument type value for genObj (e.g. string, boolean, WildCardGen, WildcardParent etc.).
    private static <T extends WildcardParent> void MethodE(WildcardGen<T> genObj) { } //<T extends WildcardParent>, meaning T is restricted to allow only argument for genObj that is WildcardParent or its children

}

class WildcardGen<T extends WildcardParent> {
    T t;

    public WildcardGen() {
        t = (T) new Object();
    }
}

class WildcardParent {
    int[] items = new int[5];
    int counter;

    void MethodParent() {
        System.out.println("Parent");
    }

    void Add(int value){
        if(counter > items.length){
            System.out.println("Cannot add any more item. Maximum set to " + items.length);
        }

        items[counter++] = value;
        System.out.println("Value entered.");
    }

    int Get(int index){
        var minimumIndex = 0;
        var maximumIndex = items.length - 1;
        if(index > items.length){
            System.out.println("Specify an index between " +minimumIndex+ " and " +maximumIndex);
        }

        return items[index];
    }
}


class WildCardChild extends WildcardParent {
    void MethodChild() {
        System.out.println("Child");
    }
}


