package javaobinnaCollections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/** About Collection interface
 * The Collection interface implements the Iterable interface.
 * This means, the Collection interface will have access to the iterator method which gives you an iterator object to allow you loop over it using foreach.
 * Also, it means that the Collection interface can add, and get item from a collection.
 */
public class Collection2 {
    public static void main(String[] args) {

        //Create a collection object
        Example1();

        //add() >> Add single item to a collection object
        Example2();

        //Collections.addAll() >> From Collections class, this helps adds multiple items to a collection object at once.
        Example3();

        //addAll() >> Add one or more collection object(s) into another collection object
        Example4();

        //size() >> determine size of collection
        Example5();

        //remove() >> remove a single item from the collection
        Example6();

        //removeAll() >> remove an entire collection object contained in another collection object
        Example7();

        //clear() >> remove all items in a collection
        Example8();

        //isEmpty() >> check if a collection is empty or not.
        Example9();

        //contains() >> check if an item exist in the collection.
        Example10();

        //containsAll() >> check if a collection exist inside another collection
        Example11();

        //toArray() >> convert a collection into an Object array
        Example12();

        //toArray(T[]) >> convert a collection into a specified type array.
        Example13();
    }


    /**
     * Learn how to use the Collection interface.
     * Create instances using classes like ArrayList, which implement the collection interface.
     * Use Collection interface methods:
     * add >> to add single item to the collection object
     * addAll from Collection interface >> copy contents of a collection into another collection object. Note new collection object will have a different memory address than the other being copied.
     * addAll from Collections class >> add multiple items to a collection object at once
     * remove >> remove an item from the collection
     * removeAll >> remove a whole collection contained in another collection
     * isEmpty >> check if collection has zero items.
     * contains >> check if an item exist in the collection.
     * containsAll >> check if a collection exist inside another collection
     * clear >> remove all items contained in the collection
     * toArray >> convert a collection into an Object array
     * toArray(T[]) >> convert a collection into a casted-type array. Specify new String[0] using zero as default to get a String array etc.
     * You can even create your own generic class that implements the collection interface just as you did with Iterable interface
     */
    public static void Example1() {
        //The Collection interface has List, Queue and Set interfaces that implements it.
        //There are several classes implementing each interface mentioned above.
        //For example, the ArrayList implements the List. PriorityQueue implements Queue interface. HashSet implements the Set interface etc.
        //ArrayList is easy and often used when working with the Collection interface.
        Collection<String > stringCollectionA = new ArrayList<>();


        //Note: Please don't stress about creating your own custom class that directly implement the Collection interface.
        //There are just too many interface methods defined in the Collection interface that implementation are required for.
        //Maybe you can create a custom class that implements either List, Queue, or Set;
        //might be easier if creating a custom Collection is something you're interested in.
    }

    public static void Example2() {
        Collection<String> collection = new ArrayList<>(2);

        //add method from Collection class helps add a single item to a collection.
        collection.add("Kim");
        collection.add("Kanye");
    }

    public static void Example3() {
        //use the Collections.addAll method to add multiple items to the collection object at once.
        Collection<String > stringCollectionA = new ArrayList<>();
        Collections.addAll(stringCollectionA, "obi", "kiki");
    }

    public static void Example4() {
        Collection<String> collectionA = new ArrayList<>(2);
        collectionA.add("Kim");
        collectionA.add("Kanye");

        //addAll method from Collection class helps add a collection to another collection.
        //can be used to add multiple collection objects into another collection.
        Collection<String> collectionB = new ArrayList<>(2);
        collectionB.addAll(collectionA);

        //Note: collectionA and collectionB are in different locations in memory, however there contents are similar.
        Boolean isSameMemory = collectionA == collectionB;
        Boolean hasSameContent = collectionA.equals(collectionB);
        System.out.println("Both collections have same memory address: " + isSameMemory);
        System.out.println("Both collections has same contents: " + hasSameContent);
    }

    public static void Example5() {
        Collection<String> collectionA = new ArrayList<>(2);
        collectionA.add("Kim");
        collectionA.add("Kanye");

        int size = collectionA.size();
        System.out.println("Size of collection: "  + size);
    }

    public static void Example6() {
        Collection<String> collectionA = new ArrayList<>(2);
        collectionA.add("Kim");
        collectionA.add("Kanye");

        int countBefore = collectionA.size();

        collectionA.remove("Kim");
        int countAfter = collectionA.size();

        System.out.println("Count before removing: "  + countBefore);
        System.out.println("Count after removing: "  + countAfter);
    }

    public static void Example7() {
        Collection<String> coupleA = new ArrayList<>(2);
        coupleA.add("Kim");
        coupleA.add("Kanye");

        Collection<String> coupleB = new ArrayList<>(2);
        coupleB.add("Beyonce");
        coupleB.add("JayZ");

        //individual Collection objects can be combined into another collection.
        //the addAll method from the Collection class allows you make copies of a collection into another collection.
        //Feel free to make copies of different collection objects into a single collection like done below.
        Collection<String> couples = new ArrayList<>(2);
        couples.addAll(coupleA);
        couples.addAll(coupleB);

        int sizeBefore = couples.size();
        System.out.println("Total Number of couples before removing a couple: " + sizeBefore);

        //remove method removes a specific item from the collection.
        //But removeAll will remove a collection inside another.
        couples.removeAll(coupleA);

        int sizeAfter = couples.size();
        System.out.println("Total Number of couples after removing a couple: " + sizeAfter);
    }

    public static void Example8() {
        Collection<String> collection = new ArrayList<>(2);
        collection.add("Kim");
        collection.add("Kanye");

        int sizeBefore = collection.size();
        System.out.println("Collection size before clearing all items: " + sizeBefore);

        collection.clear();

        int sizeAfter = collection.size();
        System.out.println("Collection size after clearing all items: " + sizeAfter);
    }

    public static void Example9() {
        Collection<String> collection = new ArrayList<>(2);
        collection.add("Kim");
        collection.add("Kanye");

        Boolean isEmpty = collection.isEmpty();
        System.out.println("Is collection empty BEFORE clearing items: " + isEmpty);

        collection.clear();

        isEmpty = collection.isEmpty();
        System.out.println("Is collection empty AFTER clearing items: " + isEmpty);
    }

    public static void Example10() {
        Collection<String> collection = new ArrayList<>(2);
        collection.add("Kim");
        collection.add("Kanye");

        Boolean itemExist = collection.contains("Kim");
        System.out.println("Has item: " + itemExist);
    }

    public static void Example11() {
        Collection<String> collection = new ArrayList<>(2);
        collection.add("Kim");
        collection.add("Kanye");

        //make a copy and use to test the containsAll method
        Collection<String> collectionCopy = new ArrayList<>(2);
        collectionCopy.addAll(collection);

        //contains method check for a single item,
        //while containsAll (just like any of the other methods suffixed with All)
        //checks for an existing collection inside another collection
        Boolean collectionExist = collection.containsAll(collectionCopy);
        System.out.println("Has collection: " + collectionExist);
    }

    public static void Example12() {
        Collection<String> collection = new ArrayList<>(2);
        collection.add("Kim");
        collection.add("Kanye");

        //This version of the toArray converts the collection to an object array.
        Object[] names = collection.toArray();

        //Casting is required. This can be problematic when you don't know what to expect.
        //An overloaded version of the toArray method that takes a type argument can solve this problem. See example12.
        String wife = (String) names[0];
        String husband = (String) names[1];

        System.out.println(wife + " & " + husband);
    }

    public static void Example13() {
        Collection<String> collection = new ArrayList<>(2);
        collection.add("Kim");
        collection.add("Kanye");

        //This version of the toArray converts the collection to an object array.
        String[] names = collection.toArray(new String[0]);

        //Because we used the overloaded version of the toArray method (see above),
        //we are able to get items from the collection without needing to cast.
        //To understand the advantage of this example, look at previous example (example11).
        String wife = names[0];
        String husband = names[1];

        System.out.println(wife + " & " + husband);
    }
}
