package javaobinnaGenerics;

/*
This tutorial focus on the creation of custom collection types for storing values.
Custom collection classes should be avoided (including custom object collection classes).
Consider using a Generic collection class instead.
Issues with a custom collection class are, you have to always create a new collection class
to store the kind of data you want. If you want to store a list of nations, you have to create
a custom collection class solely for storing a list of nations, same NationList class can't be
used for storing list of Languages etc.
 */
public class GenericTutorial1 {

    public static void main(String[] args) {
        IntegerList intCollection = new IntegerList(3);
        intCollection.add(200);
        intCollection.add(500);
        System.out.println("Value at index 0: " + intCollection.get(0));

        UserList userCollection = new UserList(4);
        userCollection.add(new User("1001", "Obinna"));
        userCollection.add(new User("1002", "Nonso"));
        System.out.println("User at index 0: " + userCollection.get(1).UserName);
    }
}

//Creating a custom list object for storing multiple integer data
class IntegerList {
    private int[] values;
    private int count;

    public IntegerList(int maximumCapacity) {
        this.values = new int[maximumCapacity];
    }

    public void add(int value) {
        if (count > values.length) {
            throw new ArrayIndexOutOfBoundsException("Cannot add new users. Capacity exceeded.");
        }
        values[count++] = value;
    }

    public int get(int index) {
        if (index < 0) {
            throw new IllegalArgumentException("The specified index should be equal or greater than 0.");
        }
        return this.values[index];
    }
}

//Creating a custom list object for storing multiple user data
class UserList {
    private User[] users;
    private int count;

    public UserList(int maximumCapacity) {
        this.users = new User[maximumCapacity];
    }

    public void add(User user) {
        if (count > users.length) {
            throw new ArrayIndexOutOfBoundsException("Cannot add new users. Capacity exceeded.");
        }
        users[count++] = user;
    }

    public User get(int index) {
        if (index < 0) {
            throw new IllegalArgumentException("The specified index should be equal or greater than 0.");
        }
        return this.users[index];
    }

}

class User {
    public String UserId;
    public String UserName;

    public User(String userId, String userName) {
        this.UserId = userId;
        this.UserName = userName;
    }

    @Override
    public String toString() {
        return this.UserName;
    }
}
