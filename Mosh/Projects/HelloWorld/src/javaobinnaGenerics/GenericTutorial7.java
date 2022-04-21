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
 * Because GenericStaffList<Instructor> is not a child of GenericStaffList<UniversityStaff>
 *
 * Note:
 * As a workaround.
 * If printStaffList expected an instance of GenericStaffList<UniversityStaff>
 * And knowing that UniversityStaff is a parent of Instructor, what you can do is
 * Create one or more instances of Instructor.
 * Instructor instructor1 = new Instructor("pete")
 * Then do this:
 * GenericListStaffList<UniversityStaff> universityStaff = new GenericListStaffList<UniversityStaff>
 * universityStaff.add(new Instructor("pete"))
 * universityStaff.add(new UniversityStaff("matt"))
 * Above is possible because the add method resolves the 'T' parameter as UniversityStaff or its children.
 * Now you can:
 * printStaffList(universityStaff)
 *
 * There is a better way using WildCards. Check out next tutorial - GenericTutorial7
 */

public class GenericTutorial7 {
    public static void main(String[] args) {
        UniversityStaff staff1 = new Instructor("John");
        System.out.println(staff1.toString());

        WildCardGenericStaffList<WildCardInstructor> staffs = new WildCardGenericStaffList<>(2);
        staffs.add(new WildCardInstructor("John"));
        staffs.add(new WildCardInstructor("Peter"));
        staffs.add(new WildCardInstructor("Obi"));
        staffs.add(new WildCardInstructor("Max"));

        printStaffList(staffs);

    }

    public static void printStaffList(WildCardGenericStaffList<WildCardInstructor> staffs) {
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
