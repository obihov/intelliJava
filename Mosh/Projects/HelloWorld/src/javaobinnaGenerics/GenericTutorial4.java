package javaobinnaGenerics;

/*
You may restrict the Generic <T> argument to one or more constrains. A restricted Generic class no longer
requires the specification of the T argument type when instantiated. Therefore, if a Generic class is restricted
to only accept Integer values, then instead of doing new GenericClass<Integer>(), you simply do
new GenericClass(). Java automatically resolve the T argument for you. You will only be allowed to work with the
Type specified or its children. So in this case, when calling the add method, you are only allowed to pass int,
byte and short value types. The wrapper classes for byte and short (i.e. Byte and Short) are not children of the
Integer type, however, they can be implicitly converted to an integer type when assigned to an integer variable.
 */

public class GenericTutorial4 {
    public static void main(String[] args) {
        //Using Generic argument Collection<T> where T is Integer.
        RestrictedCollection restrictedCollection = new RestrictedCollection(3);
        restrictedCollection.add(10);
        int value1 = restrictedCollection.get(0);
        System.out.println("Value1: " +value1);
    }
}

//Since T extends Integer, our Collection class can only store Integer values and smaller sized numerical values like
//byte and short.
class RestrictedCollection<T extends Integer> {
    private T[] values;
    private int count;

    public RestrictedCollection(int maximumCapacity) {
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
