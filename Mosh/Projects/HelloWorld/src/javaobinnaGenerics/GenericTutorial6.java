package javaobinnaGenerics;


/**
 * Generics inheritance example.
 *
 *
 * So UniversityStaff is Parent and Instructor is child.
 * UniversityStaff staff = new Instructor() is possible through OOP.
 * However,
 * GenericStaffList<Instructor> is not a child of GenericStaffList<UniversityStaff>
 * For this reason, you cannot do
 * GenericStaffList<UniversityStaff> staff = new GenericStaffList<Instructor>()
 * And you cannot substitute a parameter expecting an instance of GenericStaffList<UniversityStaff>
 * with an instance of GenericStaffList<Instructor> for the same reason stated above.
 *
 * See printStaffList method. If this method expected an instance of GenericStaffList<UniversityStaff>
 * You cannot supply an instance of GenericStaffList<Instructor>.
 * Because GenericStaffList<Instructor> is not child of GenericStaffList<UniversityStaff>
 *
 * If printStaffList method expected an instance of UniversityStaff,
 * then you can supply an instance of Instructor.
 * And you can also assign an instance of Instructor to a variable of type UniversityStaff
 */

public class GenericTutorial6 {
    public static void main(String[] args) {
        UniversityStaff staff1 = new Instructor("John");
        System.out.println(staff1.toString());

        GenericStaffList<Instructor> staffs = new GenericStaffList<>(2);
        staffs.add(new Instructor("John"));
        staffs.add(new Instructor("Peter"));
        staffs.add(new Instructor("Obi"));
        staffs.add(new Instructor("Max"));

        /*for (int i = 0; i < staffs.getLength(); i++) {
            System.out.println("Staff: " + staffs.get(i));
        }*/

        printStaffList(staffs);

    }

    public static void printStaffList(GenericStaffList<Instructor> staffs) {
        for (int i = 0; i < staffs.getLength(); i++) {
            System.out.println("Staff: " + staffs.get(i));
        }
    }

}

class GenericStaffList<T extends UniversityStaff> {
    private T[] staffs;
    private int counter = 0;

    public GenericStaffList(int capacity) {
        this.staffs = (T[]) new UniversityStaff[capacity];
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


class UniversityStaff {
    private String name;

    public UniversityStaff(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}

class Instructor extends UniversityStaff {

    private String name;

    public Instructor(String name) {
        super(name);
    }
}
