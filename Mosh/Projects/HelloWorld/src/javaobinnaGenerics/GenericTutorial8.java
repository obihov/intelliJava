package javaobinnaGenerics;

public class GenericTutorial8 {
    public static void main(String[] args) {
        Product egg = new Egg("a001", 20);
        Product pencil = new Pencil("a002", 1);

        Cart<Product> cart = new Cart<>(3);
        cart.AddItemToCart(egg);
        cart.AddItemToCart(pencil);
        cart.PrintItemsInCart();

        System.out.println();
        System.out.println("Generic Wildcard using Super to Add item. Using extend to get item as Object.");
        AddMoreItems(cart);
        int recentItemIndex = cart.GetTotalItemsInCart() - 1;
        Object x = GetItem(cart, recentItemIndex);
        if (x instanceof Product) {
            Product product = (Product) x;
            System.out.println("Recent item serial added: " + product.serialNumber);
        }
    }

    static void AddMoreItems(Cart<? super Product> activeCart) {
        activeCart.AddItemToCart(new Egg("a003", 5));
        System.out.println("New item was added.");
    }

    static Object GetItem(Cart<? super Product> cart, int index) {
        Object x = cart.GetItemFromCart(index);
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

    void AddItemToCart(T item) {
        if (counter > this.capacity) {
            System.out.println("Total items in cart: " + this.capacity);
        }
        items[counter++] = item;
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