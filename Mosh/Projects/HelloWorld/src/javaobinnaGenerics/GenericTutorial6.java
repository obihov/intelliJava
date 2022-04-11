package javaobinnaGenerics;

import java.util.ArrayList;
import java.util.List;

public class GenericTutorial6 {
    public static void main(String[] args) {
        User user = new Instructor("1001", "Obinna");
        Util.printUser(user);

        //With type restriction, we are able to use object of type User and its children (i.e. Instructor)
        MyGenericList users = new MyGenericList<User>();
        users.add(new User("Student.","Obi"));
        users.add(new Instructor("Prof.", "Wolf"));
        System.out.println(users.get(0));

        //But keep in mind that type restriction isn't same as inheritance
        //i.e. MyGenericList<User> does not extend the MyGenericList<Instructor> class.
        //In fact, we don't have a MyGenericList<User> nor a MyGenericList<Instructor> class defined in our code.
        //What we do have is a MyGenericList<T> class WHERE T extends User as a restriction.

        //Below, we can only assign a "new MyGenericList<User>()" object to a MyGenericList<User> variable (i.e. users1)
        MyGenericList<User> users1 = new MyGenericList<User>();

        //Likewise, we can only assign a "new MyGenericList<Instructor>()" object to a MyGenericList<Instructor> variable (i.e. users2)
        MyGenericList<Instructor> users2 = new MyGenericList<Instructor>();

        //We cannot assign a "new MyGenericList<Instructor>()" object to a MyGenericList<User> variable or vice versa
        //Simply because we did not define our class in either format
        //"MyGenericList<Instructor> extends MyGenericList<User>" OR
        //"MyGenericList<User> extends MyGenericList<Instructor>"
    }

}

class Instructor extends User {
    public Instructor(String userId, String userName) {
        super(userId, userName);
    }
}

class MyGenericList<T> {

    List<T> list = new ArrayList<T>();

    public void add(T tObj) {
        list.add(tObj);
    }

    public void remove(T tObj) {
        list.remove(tObj);
    }

    public void remove(int index) {
        list.remove(index);
    }

    public T get(int index) {
        return list.get(index);
    }
}
