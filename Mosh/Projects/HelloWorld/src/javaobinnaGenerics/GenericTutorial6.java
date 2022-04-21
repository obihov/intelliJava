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

public class GenericTutorial6 {
    public static void main(String[] args) {
        UniversityStaff staff1 = new Instructor("John");
        System.out.println(staff1.toString());

        System.out.println("==============================");
        GenericStaffList<UniversityStaff> uniStaff = new GenericStaffList<>(2);
        uniStaff.add(new UniversityStaff("Jacob"));
        uniStaff.add(new UniversityStaff("Mosh"));
        printStaffList(uniStaff);

        System.out.println("==============================");
        GenericStaffList<Instructor> instructorStaff = new GenericStaffList<>(2);
        instructorStaff.add(new Instructor("John"));
        instructorStaff.add(new Instructor("Peter"));
        //printStaffList(instructorStaff);
        //will not accept an instance of GenericStaffList<Instructor> for GenericStaffList<UniversityStaff>
        //GenericStaffList<Instructor> is not child of GenericStaffList<UniversityStaff>
        //Even though Instructor is child of UniversityStaff
        //See workaround below:
        GenericStaffList<UniversityStaff> uniStaff2 = new GenericStaffList<>(2);
        uniStaff2.add(new Instructor("John"));
        uniStaff2.add(new Instructor("Peter"));
        printStaffList(uniStaff2);
    }

    public static void printStaffList(GenericStaffList<UniversityStaff> staffs) {
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
