package javaobinnaCollections;

import java.util.Arrays;
import java.util.Iterator;

//This class doesn't implement the Iterable interface. Therefore, you cannot loop over it using a foreach.
class GenericList<T> {
    private T[] items;
    private int count;

    public GenericList(int capacity) {
        this.items = (T[]) new Object[capacity];
    }

    public void Add(T item) {
        this.items[count++] = item;
    }

    public T Get(int index) {
        return this.items[index];
    }
}

/** About this Class.
 * This class implements the Iterable interface. Therefore, you can loop over it using a foreach.
 * A second version of this class exist, which internally uses a private class to create the Iterator object.
 * In this class, we use Arrays.stream(items).iterator() to generate the iterator object.
 * Both versions will achieve same result.
 */
class GenericListIterable<T> implements Iterable<T> {
    private T[] items;
    private int counter;

    public GenericListIterable(int capacity) {
        this.items = (T[]) new Object[capacity];
    }

    public void Add(T item) {
        this.items[counter++] = item;
    }

    public T Get(int index) {
        return this.items[index];
    }

    //Below method will return an iterable object called iterator
    //The iterator is a pointer, that will be used to loop over items in a collection and return.
    //iterator.hasNext() checks if there is next item where the pointer is located. Returns true or false
    //iterator.next() gets the item in the pointer's location, and moves pointer forward.
    @Override
    public Iterator<T> iterator() {
        Iterator<T> iterator = Arrays.stream(items).iterator();
        return iterator;
    }
}


/** About this Class.
 * This class implements the Iterable interface. Therefore, you can loop over it using a foreach.
 * This class uses a private class to create the Iterator object.
 * See class above it if you want to learn how to use the Arrays.stream(items).iterator() to generate the iterator object.
 * Both versions will achieve same result.
 */
class GenericListIterableV2<T> implements Iterable<T> {
    private T[] items;
    private int counter;

    public GenericListIterableV2(int capacity) {
        this.items = (T[]) new Object[capacity];
    }

    public void Add(T item) {
        this.items[counter++] = item;
    }

    public T Get(int index) {
        return this.items[index];
    }

    //Iterator is an interface. You can create your own custom iterator class as shown here.
    //Or you can do a Arrays.stream(items).iterator();
    //The iterator object acts as a pointer that loops across your item's collection.
    //iterator.hasNext() a pointer that checks for an item in the current index location. Returns true or false
    //iterator.next() pointer gets the item located in the index location (if any), and pointer moves forward to next index location.
    @Override
    public Iterator<T> iterator() {
        //If you don't want to create your own custom iterator object,
        //then use Iterator<T> iterator = Arrays.stream(items).iterator();
        //Otherwise do the below to create your iterator object.
        Iterator<T> iterator = new IteratorObject(this);
        return iterator;
    }

    /** About the IteratorObject class.
     * This class will be used by iterator method defined in the GenericList's scope above.
     * The iterator object will know how to properly loop over the items field.
     * We define the class as private and implement the Iterator interface along with its hasNext and next methods.
     * Also, by defining the class as private, we can access members of the GenericList class such as "items" needed by the hasNext and next methods.
     * Notice the <T> in Iterator<T>. So when we instantiate GenericList<T>, whatever type we supply there
     * that type will automatically be passed to the Iterator<T>.
     */
    private class IteratorObject implements Iterator<T> {

        private GenericListIterableV2<T> list;
        private int indexPointer;

        public IteratorObject(GenericListIterableV2<T> list) {
            this.list = list;
        }

        @Override
        public boolean hasNext() {
            //remember, as you add items to GenericListIterableV2<T>, counter increments by 1 to indicate current size of the collection.
            int arrayLength = this.list.counter; //or do this.list.items.length;
            return (indexPointer < arrayLength);
        }

        @Override
        public T next() {
            //indexPointer will be set to 0 at first, and allow you to read the item in the collection (if any).
            //immediately after reading it, it increments indexPointer by 1, which is same as moving the pointer forward (or next) in order to read next item (if any exist).
            return this.list.items[indexPointer++];
        }
    }

}