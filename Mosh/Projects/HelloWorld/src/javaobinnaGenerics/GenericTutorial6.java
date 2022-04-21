package javaobinnaGenerics;

import java.util.ArrayList;
import java.util.List;

public class GenericTutorial6 {
    public static void main(String[] args) {
        UniversityStaff staff1 = new Instructor(10, "John");
        System.out.println(staff1.toString());

        GenericStaffList<Instructor> staffs = new GenericStaffList<>(2);
        staffs.add(new Instructor(10, "John"));
        staffs.add(new Instructor(20, "Peter"));
        staffs.add(new Instructor(20, "Obi"));
        staffs.add(new Instructor(20, "Max"));

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
    private int point;
    private String name;

    public UniversityStaff(int point, String name) {
        this.point = point;
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}

class Instructor extends UniversityStaff {

    private String name;

    public Instructor(int point, String name) {
        super(point, name);
    }
}
