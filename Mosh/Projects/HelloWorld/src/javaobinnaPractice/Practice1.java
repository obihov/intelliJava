package javaobinnaPractice;

public class Practice1 {
    public static void main(String[] args) {
        GenericPractice1<Integer> practice1 = new GenericPractice1<>(3);
        practice1.Add(10);
        practice1.Add(20);

        System.out.println("Item in index 2: " + practice1.Get(0));

    }
}

class GenericPractice1<T extends Number> {

    private final T[] items;
    private int count = 0;

    public GenericPractice1(int capacity) throws ClassCastException {
        this.items = (T[]) new Number[capacity];
    }

    public void Add(T item) {
        items[count++] = item;
        System.out.println("Item added successfully.");
    }

    public T Get(int index) {
        return items[index];
    }


}


