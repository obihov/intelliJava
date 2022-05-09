package javaobinnaGenerics;

/** TUTORIAL - Generic Super and Extends for method parameter.
 * The extends or super keyword can be used to get item from the cart.
 *
 * We suggest using the super keyword for adding items.
 * The super keyword for method parameter, creates a maximum class type that is allowed for defining the <? super ...> as method parameter.
 * You cannot go higher than the restricted typed defined in the generic class.
 * So if class is defined as <T extends Product>, then <? super ...> will only accept Product or its children for '...' argument
 *
 * Also, we suggest using the extends keyword for getting items.
 * The extends keyword for method parameter does not mandate a maximum class type.
 * You can go higher or lower than the restricted type defined in the generic class.
 * So  if class is defined as <T extends Product>, then <? extends ...> will accept Object, Product or its children (i.e. Egg, Pencil) for '...' argument.
 *
 * One last thing,
 * If a generic class is defined with restriction, then you cannot plug in any type other than the restricted type and its children.
 * So if class is defined as <T extends Product>, then <? super Number>, <? super String>, <? extends Exception>, <? extends Boolean> will not work.
 */

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
        //If restricted generic class, then you can call method using type specified after super keyword or its parent (Object not accepted).
        //If non-restricted generic class, then you can call method using type specified after super keyword or its parent (Object is accepted).
        //For super - call with exact type specified after the super keyword or any of its parent.
        AddMoreItems(cart, egg1);
        AddMoreItems(cart, egg2);
        AddMoreItems(cart, pencil1);
        AddMoreItems(cart, pencil2); //if this product isn't added, then check capacity of Cart set on line8

        //Get a product from cart by its index. Method parameter uses the extends keyword.
        //For extends - call method with exact type specified after extends keyword or any of its children.
        int recentItemIndex = cart.GetTotalItemsInCart() - 1;
        Object x = GetItem(cart, recentItemIndex);
        if (x instanceof Product) {
            Product product = (Product) x;
            System.out.println("Recent item serial added: " + product.serialNumber);
        }
    }

    /** SUPER - For adding
     *
     * When Generic class is not restricted:
     * >>Given class - Cart<T>
     * >>Method definition: super can be followed by any type (i.e. String, Object, Product etc.) as shown below.
     *      AddMoreItems(Cart<? super Object> activeCart)
     *      AddMoreItems(Cart<? super Egg> activeCart)
     *      AddMoreItems(Cart<? super Product> activeCart)
     *      AddMoreItems(Cart<? super String> activeCart)
     *      AddMoreItems(Cart<? super Number> activeCart)
     * >>Calling method: You can use type defined after the super keyword or its parent. Note: you can use new Cart<Object> since generic class is not restricted.
     *      If method is AddMoreItems(Cart<? super SmallEgg> activeCart), then call
     *          AddMoreItems(new Cart<SmallEgg>())
     *          AddMoreItems(new Cart<Egg>())
     *          AddMoreItems(new Cart<Product>())
     *          AddMoreItems(new Cart<Object>())
     *      If method is AddMoreItems(Cart<? super Number> activeCart), then call
     *          AddMoreItems(new Cart<Number>())
     *          AddMoreItems(new Cart<Object>())
     *      If method is AddMoreItems(Cart<? super Object> activeCart), then call
     *          AddMoreItems(new Cart<Object>())
     * >>Summary:
     * For a non-restricted generic class <T>
     * Create method: By specifying <? super anyType>. You can use any type including Object.
     * Calling method: Supply as argument to the method the 'anyType' used after the super keyword or any of its Parent including Object. Object is allowed when it involves a non-generic class.
     *
     *
     *
     * When Generic class is restricted:
     * >>Given class - Cart<T extends Product>
     * >>Method definition: super can be followed by Product or its children as shown below
     *      AddMoreItems(Cart<? super Product> activeCart)
     *      AddMoreItems(Cart<? super Egg> activeCart)
     *      AddMoreItems(Cart<? super Pencil> activeCart)
     * >>Calling method: You can use type defined after the super keyword or its parent. Note: new Cart<Object> should not be use.
     *      If method is AddMoreItems(Cart<? super Product> activeCart), then call
     *          AddMoreItems(new Cart<Product>())
     *      If method is AddMoreItems(Cart<? super Egg> activeCart), then call
     *          AddMoreItems(new Cart<Egg>())
     *          AddMoreItems(new Cart<Product>())
     *      If method is AddMoreItems(Cart<? super Pencil> activeCart), then call
     *          AddMoreItems(new Cart<Pencil>())
     *          AddMoreItems(new Cart<Product>())
     *
     * Summary:
     * (if restricted generic class)
     * Create method :
     * Specify the exact restrictedType OR its children
     * Call method:
     * Supply at minimum the exact type mentioned after the super keyword or
     * Supply at maximum any of its parent (i.e. parents of the type mentioned after the super keyword) as argument.
     * But the parent type cannot be higher than the restrictedType used to define the generic class.
     * Object is not allowed.
     *
     * (if non-restricted generic class)
     * Create method:
     * Specify anyType (i.e. String, Number, Object, Product etc.)
     * Call method:
     * Supply at minimum exact type mentioned after the super keyword or
     * Supply at maximum any of its parent (i.e. parents of the type mentioned after the super keyword) as argument.
     * Object is allowed.
     *
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
     * Specify the exact restrictedType OR its children
     * Call method:
     * Supply the exact type mentioned in the created method, or its children (if any).
     *
     * (if non-restricted generic class)
     * Create method:
     * Specify anyType (i.e. String, Number, Object, Product etc.)
     * Call method:
     * Supply the exact type mentioned in the created method, or its children (if any)
     *
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
        int highestIndex = this.capacity - 1;

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