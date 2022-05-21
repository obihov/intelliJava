package javaobinnaGenerics;

public class GenericTutorial8 {
    public static void main(String[] args) {

        //Define products
        Product egg1 = new Egg("a001", 20);
        Product egg2 = new SmallEgg("a002", 8);
        Product pencil1 = new Pencil("a003", 12);
        Product pencil2 = new Pencil("a004", 2);

        //Define Cart that will be used for holding products.
        Cart<Product> cart = new Cart<>(3);

        //Add products to the cart. Method parameter uses the super keyword.
        AddMoreItems(cart, egg1);
        AddMoreItems(cart, egg2);
        AddMoreItems(cart, pencil1);
        AddMoreItems(cart, pencil2); //if this product isn't added, then check capacity of Cart set on line8

        //Get a product from cart by its index. Method parameter uses the extends keyword.
        int recentItemIndex = cart.GetTotalItemsInCart() - 1;
        Object x = GetItem(cart, recentItemIndex);
        if (x instanceof Product) {
            Product product = (Product) x;
            System.out.println("Recent item serial added: " + product.serialNumber);
        }
    }

    /** SUPER - For adding
     *
     * Summary:
     * (if restricted generic class)
     * Create method :
     *      Append after super keyword, the restrictedType (OR its children) that was used to define the generic class.
     * Call method:
     *      Supply at minimum the exact type that was used to create the method.
     *      Supply at maximum the parent or at most the restrictedType that was used to define the generic class.
     *      Example1:
     *          Given class Gen<T>, java translates the non-restricted class as class Gen<T extends Object> where Object is the restrictedType.
     *          Given method created: DoSomething(Gen<?> x) or DoSomething(Gen<? super Object> x) or DoSomething(Gen<? super SmallEgg> x) where SmallEgg < Egg < Product
     *          Calling the method - DoSomething(Gen<? super SmallEgg> x):
     *              at minimum (scenario1) >> DoSomething(new Gen<SmallEgg>()).
     *              at maximum (scenario1) >> DoSomething(new Gen<Egg/Product/Object>()). Cannot exceed the restrictedType (i.e. Object) used to define the class.
     *          Calling the method - DoSomething(Gen<? super Object> x):
     *              at minimum (scenario2) >> DoSomething(new Gen<Object>()).
     *              at maximum (scenario2) >> DoSomething(new Gen<Object>()). Cannot exceed the restrictedType used to define the class.
     *      Example2:
     *          Given class Gen<T extends Product>, where Product is the restrictedType.
     *          Given method created: DoSomething(Gen<? super SmallEgg> x) where SmallEgg < Egg < Product
     *          Calling the method - DoSomething(Gen<? super SmallEgg> x):
     *              at minimum (scenario1) >> DoSomething(new Gen<SmallEgg>()).
     *              at maximum (scenario1) >> DoSomething(new Gen<Egg/Product>()). Cannot exceed the restrictedType (i.e. Product) used to define the class.
     *
     *
     * (if non-restricted generic class)
     * Create method:
     *      Append after super keyword, any type.
     * Call method:
     *      Supply at minimum exact type that was used to create the method.
     *      Supply at maximum the parents of type used when creating the method, or at most the Object type which is interpreted as the restrictedType by Java.
     *      Example1:
     *          Given class Gen<T>, java translates the non-restricted class as class Gen<T extends Object> where Object is the restrictedType.
     *          Given method created: DoSomething(Gen<?> x) or DoSomething(Gen<? extends Integer> x) or DoSomething(Gen<? extends SmallEgg> x)
     *          Calling the method - DoSomething(Gen<?> x):
     *              at minimum (scenario1) >> DoSomething(new Gen<anyType>()).
     *              at maximum (scenario1) >> DoSomething(new Gen<Parent for anyType/Object>()). Cannot exceed the implied restrictedType (i.e. Object) used to define the class.
     *          Calling the method - DoSomething(Gen<? super Integer> x):
     *              at minimum (scenario2) >> DoSomething(new Gen<Integer>()).
     *              at maximum (scenario2) >> DoSomething(new Gen<Parent of Integer/Object>()). Cannot exceed the implied restrictedType (i.e. Object) used to define the class.
     *          Calling the method - DoSomething(Gen<? super SmallEgg> x):
     *              at minimum (scenario3) >> DoSomething(new Gen<SmallEgg>()).
     *              at maximum (scenario3) >> DoSomething(new Gen<Parents of SmallEgg/Object>()). Cannot exceed the implied restrictedType (i.e. Object) used to define the class.
     *
     *
     * Note (using super for both restricted and non-restricted class):
     *      You may explicitly specify a restrictedType when you create the generic class.
     *      If no restrictedType is specified, then Java implies Object as the restrictedType for the generic class.
     *      For creating: The type to use must either be the restrictedType/implied-restrictedType or its children.
     *      For Calling:
     *          minimum type > must be at least the type used for creating the method
     *          maximum type > must be any of the parent for type used in creating the method or at most the restrictedType/implied-restrictedType used to create the generic class.
     *
     *
     * Note (Similarity between extends and super keyword):
     *      For creating (almost similar):
     *          Super, requires using either the restrictedType/implied-restricted/children.
     *          Extends, requires using either the Object/restrictedType/implied-restricted/children.
     *      For calling (vary):
     *          Super aims upward, i.e. at minimum use same type that was specified when creating method. Or go higher by using any of its parent up to at most the restrictedType/implied-restrictedType at maximum.
     *          Extend aims downward, i.e. at maximum use same type that was specified when creating method. Or go lower by using any of its children (and that includes any of the children of the restrictedType/implied-restrictedType).
     * @param activeCart
     * @param product
     */
    static void AddMoreItems(Cart<? super Product> activeCart, Product product) {
        boolean isAdded = activeCart.AddItemToCart(product);
        if(isAdded)
            System.out.println("New item was added. Serial number: " +product.serialNumber);
        else
            System.out.println("Unable to add product. Serial number: " +product.serialNumber);
    }

    /** EXTENDS - For getting
     *
     * Summary:
     * (if restricted generic class)
     * Create method :
     *      Append after extends keyword, the Object type, the restrictedType (OR its children) that was used to define the generic class
     * Call method:
     *      Supply the exact type or its children that was used to create the method.
     *
     * (if non-restricted generic class)
     * Create method:
     *      Freely append any type after the extends keyword.
     * Call method:
     *      Supply the exact type or its children that was used to create the method.
     *
     *
     * Note (Similarity between extends and super keyword):
     *      For creating (almost similar):
     *          Super, requires using either the restrictedType/implied-restricted/children.
     *          Extends, requires using either the Object/restrictedType/implied-restricted/children.
     *      For calling (vary):
     *          Super aims upward, i.e. at minimum use same type that was specified when creating method. Or go higher by using any of its parent up to at most the restrictedType/implied-restrictedType at maximum.
     *          Extend aims downward, i.e. at maximum use same type that was specified when creating method. Or go lower by using any of its children (and that includes any of the children of the restrictedType/implied-restrictedType).
     * @param cart
     * @param index
     * @return
     */
    static Object GetItem(Cart<? extends Product> cart, int index) {
        var x = cart.GetItemFromCart(index);
        return x;
    }

}

class Cart<T extends Product> {
    private T[] items = null;
    private int counter = 0;
    private int capacity = 0;

    Cart(int capacity) {
        this.capacity = capacity;
        this.items = (T[]) new Product[capacity];
        //If Cart<T> is defined this way, then this.items = (T[]) new Object[capacity];
        //But since Cart<T extends Product> is defined, then this.items = (T[]) new Product[capacity];
    }

    boolean AddItemToCart(T item) {
        boolean isAdded = false;

        if (counter < this.capacity) {
            items[counter++] = item;
            isAdded = true;
        }
        return isAdded;
    }

    T GetItemFromCart(int index) {
        return items[index];
    }

    int GetTotalItemsInCart() {
        return items.length;
    }

    void PrintItemsInCart() {
        for (var i : items) {
            if(i == null) break;
            System.out.println("Item serial number: " + i.serialNumber);
        }
    }
}

class Product {
    String serialNumber;
    int weight;

    Product(String serialNumber, int weight) {
        this.serialNumber = serialNumber;
        this.weight = weight;
    }
}

class Egg extends Product {
    Egg(String serialNumber, int weight) {
        super(serialNumber, weight);
    }
}

class Pencil extends Product {
    Pencil(String serialNumber, int weight) {
        super(serialNumber, weight);
    }
}

class SmallEgg extends Egg {
    SmallEgg(String serialNumber, int weight) {
        super(serialNumber, weight);
    }
}