package javaobinnaAccessModifiers;

public class AccessModifier {
    //public member -
    //can be seen by every class in the current package and can also be seen by classes in external packages (provided this current package is imported in those classes)
    public int FileSize;
    public int GetFileSize(){ return this.FileSize; }

    //protected member -
    //can be seen by every class in the current package and ONLY can be seen by classes in external package that inherit/extends this current (i.e. AccessModifier for example).
    protected String FileName;
    protected String GetFileName(){ return this.FileName; }

    //default member -
    //can be seen by ONLY and ALL the classes defined inside this current package. Classes in external packages will not have access to default members defined in a class in another package.
    boolean isFormatted;
    boolean GetFormatType(){ return this.isFormatted; }

    //private member -
    //can ONLY be seen/accessed by members defined in the class. Even if other classes are in the same package (as well as external packages), they won't see private members defined in another class.
    private String passCode;
    private void SetPassCode() { this.passCode = "****"; }


    //final modifier -
    //This will create constant members.
    //If you define a class as final, that class can't be extended.
    //If you define a method as final, that method can't be overridden. An abstract method can't be final because abstract methods are designed to be overridden by its child class.
    //If you define a field as final, that field is treated as a readonly (just as we have in C# readonly keyword). Can set the value after defining field or use a constructor.
    final String Organization = "Oracle"; //readonly field set after it is defined.
    final String Owner;
    public AccessModifier(String owner) {
        Owner = owner; //readonly field set using constructor
    }

    //Static final modifier -
    //If you define a field as static final, then that field is treated as a constant (just as we have in C# const keyword). You must assign a value immediately after defining a constant field.
    //Note: you cannot use a constructor to assign value to a static final (i.e. const) field.
    private static final int SecondOwner = 387;

    //abstract - learn more below
    //abstract modifier can be defined at class and member level.
    //if defined at class level then the class can't be instantiated.
    //if defined at member level, then class must also be abstract. And children of the abstract class must provide full or partial implementation of the abstract members defined in base/super.
    //if a child class provides partial implementation of abstract method of its parent, the child class must be defined as abstract. Its own child must complete any missing implementation thereafter.
    //if a child class provides full implementation of abstract method of its parent, then there is no need to define the class as abstract, unless you want to.


}

abstract class Parent {
    //abstract member -
    //Use this to create a parent-child relationship. Based on OOP you can use this to assign a Child's instance to a parent type. (boxing)
    //You can also use this to extract/cast a Child's instance off its Parent's instance. (unboxing)
    //abstract members must be implemented in its immediate child/or subsequent child classes in the class-hierarchy (i.e. grandchild, great grand etc.).
    abstract void IsSmart();
    abstract void IsBeautiful();
}

class ChildGirl extends Parent{
    //In this class we implemented all abstract methods defined in the Parent. By doing this, we no longer are enforced to use abstract modifier on the class.
    //Please note, if you define an abstract class, you can't instantiate it. Also, an abstract class don't have to have abstract members in it.
    //If you define an abstract member then the class must be defined as an abstract class.
    @Override
    void IsSmart() {
        System.out.println("ChildGirl is smart");
    }

    @Override
    void IsBeautiful() {
        System.out.println("ChildGirl is beautiful");
    }
}

abstract class ChildBoy extends Parent {
    @Override
    void IsSmart() {
        System.out.println("ChildBoy is smart");
    }

    //you don't have to implement every abstract method defined in the parent
    //if you decide not to implement all abstract method's of the parent, you can do so later in a grandchild (that will be a class that extends this child class).
    //also, not implementing all abstract method mean you must define the child class as an abstract class as well.
}

class GrandChild extends ChildBoy {
    //This class completes the ChildBoy's partial implementation of the Parent's abstract methods.
    //notice because of this, we don't have to define the GrandChild class as abstract, unless we feel like for any of the reasons below.
    //Define class as abstract if you want to prevent class from being instantiated.
    //Define class as abstract because you intend to have abstract methods defined in the class that its child(ren) will implement later.
    //Define class as abstract because you want to implement your codes based on Abstract members (same way it is done with interfaces). Gives loose coupling across source code.
    @Override
    void IsBeautiful() {
        System.out.println("Grandchild is beautiful.");
    }
}
