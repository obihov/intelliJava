package javaobinnaGenerics;

public class ComparableExample2 {
    public static void main(String[] args) {
        Persons persons1 = new Persons(55);
        Persons persons2 = new Persons(70);

        //Since Person class implements the Comparable<Person> interface,
        //we can compare One Person to another Person instance based on a given field (i.e. age).
        int outcome = persons1.compareTo(persons2);
        switch (outcome) {
            case 0:
                System.out.println("Both Persons are age mates.");
                break;
            case 1:
                System.out.println("Person1 is older than Person2.");
                break;
            case -1:
                System.out.println("Person2 is older than Person1.");
                break;
            default:
                throw new IllegalArgumentException("Invalid argument specified. Cannot compare.");
        }
    }
}

//Please note - if you did Comparable instead of Comparable<T>
//Then the method will be compareTo(Object o) instead.
//Due to boxing/unboxing casting issues as well as performance, avoid doing just Comparable.
class Persons implements Comparable<Persons> {

    private int age;

    public Persons(int age) {
        this.age = age;
    }

    @Override
    public int compareTo(Persons otherPersons) {
        //Logic to implement version 2.
        if(this.age > otherPersons.age)
            return 1;
        if(this.age < otherPersons.age)
            return -1;

        return 0;
    }

    @Override
    public String toString() {
        return String.valueOf(this.age);
    }
}




