package javaobinnaPractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

public class CollectionPractice {
    public static void main(String[] args) {

        GenericStudentList<Student> students = new GenericStudentList<>(2);
        students.Add(new UnderGradStudent(1001, "obi"));
        students.Add(new UnderGradStudent(1002, "kiki"));
        for (var student : students) {
            System.out.println(student);
        }
    }
}

/** About the GenericStudentList
 * Think of this class as a custom version of ArrayList<T> in Java or List<T> as we have in C#.
 * T is type argument and is-a type of Student.
 * We cannot use Student here since Student is abstract. Must use only subtypes of Student.
 * So, GenericStudentList<GraduateStudent> or GenericStudentList<UnderGradStudent>
 * @param <T extends Student>
 */
class GenericStudentList <T extends Student> implements Iterable<T> {
    private T[] students;
    private int counter;

    public GenericStudentList(int capacity) {
        this.students = (T[]) new Student[capacity];
    }

    public void Add(T student) {
        this.students[counter++] = student;
    }

    public T Get(int index) {
        return this.students[index];
    }

    @Override
    public Iterator<T> iterator() {
        return Arrays.stream(students).iterator();
    }
}

/** About Student class
 * Our generic class will restrict type arguments based off this class
 * So any type argument supplied must be a subtype of Student.
 */
abstract class Student {
    private int bannerId;
    private String studentName;

    public Student(int bannerId, String studentName) {
        this.bannerId = bannerId;
        this.studentName = studentName;
    }

    @Override
    public String toString() {
        return bannerId + "@" + studentName;
    }
    public String printDetails() {
        return bannerId + "@" + studentName;
    }
}

class GraduateStudent extends Student {
    public GraduateStudent(int bannerId, String studentName) {
        super(bannerId, studentName);
    }

    @Override
    public String toString() {
        return super.printDetails();
    }
}

class UnderGradStudent extends Student {
    public UnderGradStudent(int bannerId, String studentName) {
        super(bannerId, studentName);
    }

    @Override
    public String toString() {
        return super.printDetails();
    }
}
