package javaobinnaGenerics;


/**
 * Generics inheritance example.
 * Generics Wildcard to facilitate switching of Generic<T> where T can be anything. Or
 * Generics Wildcard to facilitate switching of Generic<T extends Type> where T can be Type or its Children.
 * See method: printStaffList(WildCardGenericStaffList<?> staffs)
 * Note:
 * WildCardGenericStaffList<?> must adhere to the WildCardGenericStaffList class definition (see below).
 * WildCardGenericStaffList<T extends WildCardUniversityStaff>
 * Meaning, '?' says T can be WildCardUniversityStaff or its children - WildCardInstructor.
 * Therefore:
 * printStaffList(new WildCardGenericStaffList<WildCardUniversityStaff>(2)) or
 * printStaffList(new WildCardGenericStaffList<WildCardInstructor>(2))
 *
 * Without Wildcards '?' you will be restricted with whatever the expected parameter type of the printStaffList method is.
 * See GenericTutorial6 to understand such drawbacks to this restriction when not using wildcards.
 */

public class GenericTutorial7 {
    public static void main(String[] args) {
        UniversityStaff staff1 = new Instructor("John");
        System.out.println(staff1.toString());

        System.out.println("==============================");
        WildCardGenericStaffList<WildCardInstructor> instructorStaff = new WildCardGenericStaffList<>(2);
        instructorStaff.add(new WildCardInstructor("John"));
        instructorStaff.add(new WildCardInstructor("Peter"));
        printStaffList(instructorStaff);

        System.out.println("==============================");
        //Using wildcard '?' in the printStaffList method, I am able to supply either an instance of
        //WildCardGenericStaffList<WildCardInstructor> or
        //WildCardGenericStaffList<WildCardUniversityStaff>
        //for WildCardGenericStaffList<?>
        //Note: ? must be match definition of class: WildCardGenericStaffList<T extends WildCardUniversityStaff>
        //Meaning you cannot use Person, House for '?' but only instances of WildCardUniversityStaff and its child classes.
        WildCardGenericStaffList<WildCardUniversityStaff> universityStaff = new WildCardGenericStaffList<>(2);
        universityStaff.add(new WildCardUniversityStaff("Jacob"));
        universityStaff.add(new WildCardInstructor("Mosh"));
        printStaffList(universityStaff);
    }

    public static void printStaffList(WildCardGenericStaffList<?> staffs) {
        for (int i = 0; i < staffs.getLength(); i++) {
            System.out.println("Staff: " + staffs.get(i));
        }
    }

}

class WildCardGenericStaffList<T extends WildCardUniversityStaff> {
    private T[] staffs;
    private int counter = 0;

    public WildCardGenericStaffList(int capacity) {
        this.staffs = (T[]) new WildCardUniversityStaff[capacity];
    }

    public void add(T staff) {
        if(counter < staffs.length)
            staffs[counter++] = staff;
        else
            System.out.println("Error: Unable to add " +staff.toString()+ ". Maximum entry reached.");
    }

    public T get(int index) {
        return staffs[index];
    }

    public int getLength() {
        return this.staffs.length;
    }
}


class WildCardUniversityStaff {
    private String name;

    public WildCardUniversityStaff(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}

class WildCardInstructor extends WildCardUniversityStaff {

    private String name;

    public WildCardInstructor(String name) {
        super(name);
    }
}
