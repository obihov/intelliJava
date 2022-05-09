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
        Product eggLarge = new Egg("a001", 20);
        Product eggSmall = new Egg("a002", 8);
        Product pencilFullPack = new Pencil("a003", 12);
        Product pencilKidPack = new Pencil("a004", 2);

        //Define Cart that will be used for holding products.
        Cart<Product> cart = new Cart<>(3);

        //Add products to the cart. Adding item to a collection or array type Generic class, use the super restriction. See AddMoreItems method for info.
        AddMoreItems(cart, eggLarge);
        AddMoreItems(cart, eggSmall);
        AddMoreItems(cart, pencilFullPack);
        AddMoreItems(cart, pencilKidPack); //if this product isn't added, then check capacity of Cart set on line8

        //Get and Print serial number of last product added to cart. In a collection or array Generic class, use the extends/super keyword to get item.
        int recentItemIndex = cart.GetTotalItemsInCart() - 1;
        Object x = GetItem(cart, recentItemIndex);
        if (x instanceof Product) {
            Product product = (Product) x;
            System.out.println("Recent item serial added: " + product.serialNumber);
        }
    }

    /** SUPER - For adding
     * The super keyword for method parameter, creates a maximum class type that is allowed for defining the <? super ...> as method parameter.
     * You cannot go higher than the restricted typed defined in the generic class.
     * So if class is defined as <T extends Product>, then <? super ...> will only accept Product or its children for '...' argument
     *
     * Note (When generic class is defined with restriction):
     * - if your class is defined as <T extends Product>, then Java explicitly restricts the class as <T extends Product>.
     * - Meaning you can use Product or its children in defining the super keyword.
     * - So you can have <? super String>, <? super Product>, or <? super Egg> etc.
     * - Please note, you cannot use anything higher than Product, for example you cannot have <? super Object> since Object is higher than Product.
     *
     * Note (When generic class has no restriction):
     * - if your class is defined as <T>, then Java automatically restrict the class as <T extends Object>.
     * - Meaning you can use Object or its children in defining the super keyword.
     * - So you can have <? super Object>, <? super String>, <? super Product>, <? super Egg> etc.
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
     * The extends keyword for method parameter does not mandate a maximum class type.
     * You can go higher or lower than the restricted type defined in the generic class.
     * So  if class is defined as <T extends Product>, then <? extends ...> will accept Object, Product or its children (i.e. Egg, Pencil) for '...' argument.
     *
     * Note (When generic class is defined with restriction):
     * - if your class is defined as <T extends Product>, then Java bounds your generic class to Product.
     * - Unlike super, with extends, you can go higher (Product's parent) or lower (Product's children).
     * - So you can have Cart<? extends Object/Product/Egg/Pencil> specified as the method's parameter when using extends based on a restricted generic class.
     * - If you did Cart<? extends Object>, then the GetItemFromCart method will return T as Product, because generic class is restricted to Product. It doesn't return higher than Product.
     * - Also, if you did Cart<? extends Product/Egg/Pencil>, then the GetItemFromCart method will return T as either Product/Egg/Pencil respectively.
     *
     * Note (When generic class has no restriction):
     * - if your class is defined as <T>, then Java automatically restrict the class as <T extends Object>,
     * - This mean the GetItemFromCart method will return a type based on what was specified in <? extends ...>
     * - If you specified <? extends String>, then the GetItemFromCart method will return T as String.
     * - If you specified <? extends Number>, then the GetItemFromCart method will return T as Number. etc
     *
     * @param cart
     * @param index
     * @return
     */
    static Object GetItem(Cart<? extends Object> cart, int index) {
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
            isAdded = true;
            items[counter++] = item;
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