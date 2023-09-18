package javaobinnaCollections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/** About List interface
 * The main focus of the List interface is working with index in an ordered collection.
 * The List interface implements the Collection interface.
 * Thus, it can do everything the Collection and Iterable interface can.
 * It can add, remove, get size of the collection object (thanks to Collection interface)
 * It can use foreach or iterator object to iterate the collection object (thanks to Iterable interface)
 */
public class Collection3 {
    public static void main(String[] args) {

        //Create new collectionObject using List interface. Use methods and features inherited from parent interfaces (Collection and Iterable)
        Example1();

        //add(index, item) >> from List interface. Add an item to the collection using index.
        //Note: Collection interface doesn't support indexing. However, Collection interface has an add(item) and addAll(collection), that can add an item or an entire collection object respectively to another collection.
        Example2();

        //Collections.addAll >> from Collections class but can work for Collection and subtypes.
        Example3();

        //get(index) >> from List interface. Gets the item in the collection located at the given index.
        //Note: Collection interface doesn't have a get method.
        Example4();

        //set(index, item) >> from List interface. Update an existing item in the collection located at the given index.
        //Note: Collection interface doesn't have a set method.
        Example5();

        //remove(index) >> from List interface. Remove an existing item in the collection located at the given index.
        //Note: Collection interface doesn't support indexing so can't do this. However, Collection interface has a remove(item) and removeAll(collection) that can be used to remove an item or an entire collection in a collection object.
        Example6();

        //indexOf(item) >> from List interface. Returns first occurrence of the item in the collection as an integer value.
        Example7();

        //lastIndexOf(item) >> from List interface. Returns last occurrence of the item in the collection as an integer value.
        Example8();

        //subList(inclusiveStartIndex, exclusiveEndIndex) >> from List interface. Returns new items off a collection into another from item at start index (inclusively) up to -1 of end index (Exclusive)
        Example9();
    }

    public static void Example1() {
        List<String> collectionObject = new ArrayList<>();

        //Some methods from Collection interface:
        String name = "kiki";
        collectionObject.add(name);
        collectionObject.remove(name);
        int size = collectionObject.size();
        collectionObject.clear();
        Boolean isEmpty = collectionObject.isEmpty();
        Boolean exist = collectionObject.contains(name);
        //etc.

        //some methods from Iterable interface - spliterator, forEach, and iterator
        //we care only about iterator method which allows our collection
        //(a generic class "ArrayList<>" for example) to be iterable using
        //foreach or while-loop hasNext and next methods.
        for (String user : collectionObject) {
            System.out.println(user);
        }



    }

    public static void Example2() {
        List<String> collectionObject = new ArrayList<>();
        collectionObject.add("kiki");
        collectionObject.add("obi");
        System.out.println("Items as-is in the collection before rearranging: " + collectionObject);

        //Notice we can use index to place item anywhere in the collection.
        collectionObject.add(0, "Peter");
        System.out.println("Items as-is in the collection after rearranging: " + collectionObject);

    }

    public static void Example3() {
        //You can add multiple items to the collection object at once.
        //The List interface and its members, same as the Queue and Set interface all implement the Collection and Iterable interfaces.
        //So you can add multiple items to the collection as well.
        List<String> collectionObject = new ArrayList<>();
        Collections.addAll(collectionObject, "kiki", "obi");
    }

    public static void Example4() {
        //Unlike Collection and Iterable interfaces, List interface offers you the ability to add as well as get an item from a collection by index.
        List<String> collectionObject = new ArrayList<>();
        Collections.addAll(collectionObject, "kiki", "obi");
        String user1 = collectionObject.get(0);
        System.out.printf("User index 0: " + user1);
    }

    public static void Example5() {
        //You can also replace an item in a collection object located at a given index.
        List<String> collectionObject = new ArrayList<>();
        Collections.addAll(collectionObject, "kiki", "obi");
        System.out.println("Collection object before update: " + collectionObject);

        //Replace item located in index 0 of the collection
        collectionObject.set(0, "Peter");
        System.out.println("Collection object after update: " + collectionObject);
    }

    public static void Example6() {
        //You can also replace an item in a collection object located at a given index.
        List<String> collectionObject = new ArrayList<>();
        Collections.addAll(collectionObject, "kiki", "obi");
        System.out.println("Collection object before remove: " + collectionObject);

        //Remove item located in index 0 of the collection
        //There is also a remove(item) which doesn't takes an index. This is from the Collection interface. It also returns a boolean to indicate if item was successfully removed.
        String user0 =  collectionObject.remove(0);
        System.out.println("User Removed at index 0: " + user0);

        System.out.println("Collection object after remove: " + collectionObject);
    }

    public static void Example7() {
        List<String> collectionObject = new ArrayList<>();
        Collections.addAll(collectionObject, "kiki", "obi");

        //Can use indexOf(item) to get the index where an item first occurred in the collection.
        int index =  collectionObject.indexOf("kiki");
        System.out.println("Kiki occurred at index: " + index);

        //a negative value is returned when the item doesn't exist in the collection.
        index = collectionObject.indexOf("horse");
        System.out.println("Horse occurred at index: " + index);
    }

    public static void Example8() {
        List<String> collectionObject = new ArrayList<>();
        Collections.addAll(collectionObject, "kiki", "obi", "kiki");

        //Can use lastIndexOf(item) to get the index where an item last occurred in the collection.
        int firstIndexOccurred =  collectionObject.indexOf("kiki");
        int lastIndexOccurred =  collectionObject.lastIndexOf("kiki");
        System.out.println("First index kiki occurred: " + firstIndexOccurred);
        System.out.println("Last index kiki occurred: " + lastIndexOccurred);

        //just like indexOf method, a negative value is returned when the item doesn't exist in the collection.
        int index = collectionObject.lastIndexOf("horse");
        System.out.println("Last index Horse occurred: " + index);
    }

    public static void Example9() {
        //C# has the GetRange for getting portion of items off a collection into another collection.
        //Java's GetRange version is subList
        List<String> collectionObject = new ArrayList<>();
        Collections.addAll(collectionObject, "kiki", "obi", "kiki");

        //Using subList will always return a new list. Note the original list is never unchanged in memory.
        //To update existing items in a list collection, you can use the set method.
        int inclusiveStartPosition = 0;
        int exclusiveEndPosition = 2;
        List<String> subsetCollection = collectionObject.subList(inclusiveStartPosition, exclusiveEndPosition);
        System.out.println(subsetCollection);
    }
}
