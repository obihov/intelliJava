package javaobinnaGenerics;

/*
An object list offers us more flexibility for storing data regardless of its type.
However, it does introduce some of its own disadvantages.
One, it affects performance with its constant boxing and unboxing it does internally.
Also, there's a high chance to introduce a typecast exception when retrieving (unboxing) data from the object collection.
Consider using the instanceof keyword in a conditional statement to achieve a safe typecasting approach.
 */

public class GenericTutorial2 {
    public static void main(String[] args) {
        ObjectList objectCollection = new ObjectList(2); //can store any type.

        //Storing - boxing
        objectCollection.add("Obinna"); //The string "Obinna" is boxed to the object array internally
        objectCollection.add(20); //The integer value 20, is boxed to the object array internally

        //Retrieving - unboxing
        String person = (String) objectCollection.get(0); //Error will occur if you didn't use String to unbox first item.
        int age = (int) objectCollection.get(1); //Error will occur if you didn't use int to unbox first item.
        System.out.println("Person: " +person);
        System.out.println("Age: " +age);

        //Safe approach to unbox from object
        if (objectCollection.get(0) instanceof String) {
            String safeUnboxing = (String) objectCollection.get(0);
            System.out.println(safeUnboxing);
        }
        if (objectCollection.get(1) instanceof Integer) {
            int safeUnboxing = (int) objectCollection.get(1);
            System.out.println(safeUnboxing);
        }

    }

}

class ObjectList {
    private Object[] values;
    private int count;

    public ObjectList(int maximumCapacity) {
        this.values = new Object[maximumCapacity];
    }

    public void add(Object value) {
        if (count > values.length) {
            throw new ArrayIndexOutOfBoundsException("Cannot add new users. Capacity exceeded.");
        }
        values[count++] = value;
    }

    public Object get(int index) {
        if (index < 0) {
            throw new IllegalArgumentException("The specified index should be equal or greater than 0.");
        }
        return this.values[index];
    }
}
