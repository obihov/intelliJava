package javaobinnaGenerics;

/*
Generic Collections are awesome. You no longer need to create many custom collection classes for every type of data
you want to store in the collection. You can use a Generic collection to store all kinds of datatype by specifying
the argument type <T> where T can be a primitive type or reference type.
Also, you don't need to box or unbox to store/retrieve data.
Also, you are able to reuse same methods (like the add and get methods) for storing and accessing different data types.
Cleaner code, and easier to maintain than multiple custom collection classes.
 */

public class GenericTutorial3 {
    public static void main(String[] args) {
        //Using Generic argument Collection<T> where T is Integer.
        Collection<Integer> integerCollection = new Collection<Integer>(3);
        integerCollection.add(10);
        int value1 = integerCollection.get(0);
        System.out.println("Value1: " +value1);

        //Using Generic argument Collection<T> where T is String.
        Collection<String> stringCollection = new Collection<String>(3);
        stringCollection.add("Obinna");
        String name = stringCollection.get(0);
        System.out.println("Name: " +name);
    }
}

class Collection<T> {
    private T[] values;
    private int count;

    public Collection(int maximumCapacity) {
        values = (T[]) new Object[maximumCapacity]; //MUST cast back to T[] type (unboxing)
    }

    //You supply a value of type T (int, boolean, String, Nation etc.) to be stored in array of T (or T[])
    public void add(T value) {
        if (count > values.length) {
            throw new ArrayIndexOutOfBoundsException("Cannot add new users. Capacity exceeded.");
        }
        values[count++] = value;
    }

    //You supply a index value to retrieve from T[] collection, a value of type T (int, boolean, String, Nation etc.)
    public T get(int index) {
        if (index < 0) {
            throw new IllegalArgumentException("The specified index should be equal or greater than 0.");
        }
        return this.values[index];
    }
}
