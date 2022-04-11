package javaobinnaGenerics;

public class ComparableExample {
    public static void main(String[] args) {
        Student student1 = new Student(55);
        Student student2 = new Student(70);

        //Since Student class implements the Comparable<Student> interface,
        //we can compare One student to another student instance based on a given field (i.e. score).
        int outcome = student1.compareTo(student2);
        if(outcome == 0)
            System.out.println("Both students had the same score on the test.");
        if(outcome > 0)
            System.out.println("Student1 scored higher than Student2 on the test.");
        if(outcome < 0)
            System.out.println("Student2 scored higher than Student1 on the test.");
    }
}

//Please note - if you did Comparable instead of Comparable<T>
//Then the method will be compareTo(Object o) instead.
//Due to boxing/unboxing casting issues as well as performance, avoid doing just Comparable.
class Student implements Comparable<Student> {

    private int score;

    public Student(int score) {
        this.score = score;
    }

    @Override
    public int compareTo(Student otherStudent) {
        //Logic to implement version 1.
        int value = this.score - otherStudent.score;
        return value;
    }
}


