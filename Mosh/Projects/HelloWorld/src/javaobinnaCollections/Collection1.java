package javaobinnaCollections;

import java.util.Iterator;

/** TUTORIAL - Iterable interface
 * When a class implements the Iterable interface, we will be able to iterate the collection that is
 * contained inside that class (without changing the internal implementation of the class.
 */
public class Collection1 {
    public static void main(String[] args) {
        Example1(); //prints nothing
        System.out.println();

        Example2();
        System.out.println();

        Example3();
        System.out.println();

        Example4();
    }

    private static void Example1() {
        GenericList<String> names = new GenericList<>(3);
        //for(var name : names)
        /*
        cannot use foreach because the GenericList doesn't implement the Iterable interface.
        As workaround, expose the array "items" field in the GenericList class as public
        Since array already implements the Iterable interface, you should be able to use a foreach.
        So can do for(var name : names.items)
        However, because you exposed the "items" field to public, you have violated the encapsulation (Data hiding) principle.
        See Example2 method for a preferred solution.
         */
    }

    private static void Example2() {
        GenericListIterable<String> names = new GenericListIterable<>(3);

        /** WARNING
         Unlike a foreach, when using iterator instead, if you forget to supply values to the array,
         then Java will throw error. So in this example we must provide items for our generic list instance.
         See below.
         */
        names.Add("obi");
        names.Add("kiki");
        names.Add("zaa");

        /** About the ITERATOR Object approach
         * The iterator object does what the foreach actually do.
         * In fact, the foreach is just a wrapper of the iterator approach.
         * Consider the foreach a simpler approach but both do the same thing.
         * Knowing either or both is good.
         * However, you cannot use either on a class that doesn't implement the Iterator<T> interface
         * Also that class must provide overridden implementation for the method iterator(),
         * which returns an iterator object of type " Iterator<T> ".
         * Using this object, we can call the hasNext and next method to
         * check, read, and move pointer forward across the collection.
         */
        Iterator<String> iterator = names.iterator();
        while (iterator.hasNext()) {
            var name = iterator.next();
            System.out.printf(name + "\n");
        }
    }

    /** About this method.
     * This example is only slightly different from Example4 but similar in every regard.
     * The GenericListIterableV2 class used in Example4, has a private class internally that helps create our iterator object needed for looping through our collection contained in the class.
     * While the GenericListIterable class used in this example, use Arrays.stream(items).iterator() to create the iterator object.
     */
    private static void Example3() {
        GenericListIterable<String> names = new GenericListIterable<>(3);

        /** NOTE
         * Unlike the iterator approach shown in Example2, if no data was supplied before executing
         * the foreach block, java won't throw any error. Instead, java will print null.
         * But both foreach and iterator approach achieve the same result.
         */
        names.Add("obi");
        names.Add("kiki");
        names.Add("zaa");

        /** About the FOREACH approach
         * The foreach and iterator object approach (shown in example2 above) accomplish the same thing.
         * The foreach uses an iterator internally. Therefore, the foreach is just a wrapper or a simpler
         * approach than the iterator approach.
         * Just note that neither approach if the class its based on doesn't implement the Iterator<T>
         * interface and provides implementation for the iterator() method that returns an Iterator<T> object.
         */
        for (var name : names) {
            System.out.println(name);
        }
    }

    /** About this method.
     * This example is only slightly different from Example3 but similar in every regard.
     * The GenericListIterableV2 class used in this example, has a private class internally that helps create our iterator object needed for looping through our collection contained in the class.
     * While the GenericListIterable class used in Example3, use Arrays.stream(items).iterator() to create the iterator object.
     */
    private static void Example4() {
        GenericListIterableV2<String> names = new GenericListIterableV2<>(3);

        /** NOTE
         * Unlike the iterator approach shown in Example2, if no data was supplied before executing
         * the foreach block, java won't throw any error. Instead, java will print null.
         * But both foreach and iterator approach achieve the same result.
         */
        names.Add("mark");
        names.Add("henry");
        names.Add("paul");

        /** About the FOREACH approach
         * The foreach and iterator object approach (shown in example2 above) accomplish the same thing.
         * The foreach uses an iterator internally. Therefore, the foreach is just a wrapper or a simpler
         * approach than the iterator approach.
         * Just note that neither approach if the class its based on doesn't implement the Iterator<T>
         * interface and provides implementation for the iterator() method that returns an Iterator<T> object.
         */
        for (var name : names) {
            System.out.println(name);
        }
    }
}


