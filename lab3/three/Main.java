package three;

import java.util.ArrayList;

interface MyCollection<E> {
    boolean add(E element);

    boolean remove(E element);

    boolean contains(E element);

    int size();

    boolean isEmpty();

    void clear();
}

class MyImplementation<E> implements MyCollection<E> {
    private ArrayList<E> elements;

    public MyImplementation() {
        this.elements = new ArrayList<>();
    }
    
    @Override
    public boolean add(E element) {
        return elements.add(element);
    }

    @Override
    public boolean remove(E element) {
        return elements.remove(element);
    }

    @Override
    public boolean contains(E element) {
        return elements.contains(element);
    }

    @Override
    public int size() {
        return elements.size();
    }

    @Override
    public boolean isEmpty() {
        return elements.isEmpty();
    }

    @Override
    public void clear() {
        elements.clear();
    }
}

public class Main {
    public static void main(String[] args) {
        MyCollection<Integer> collection = new MyImplementation<>();

        collection.add(10);
        collection.add(20);
        collection.add(30);
        // contains {10 20 30}
        System.out.println("Size of collection: " + collection.size()); // 3

        System.out.println("Contains 20? " + collection.contains(20)); // t
        System.out.println("Contains 40? " + collection.contains(40)); // f

        collection.remove(20);
        System.out.println("Contains 20 after removal? " + collection.contains(20)); // f

        System.out.println("Size of collection after removal: " + collection.size()); // 2

        System.out.println("Is collection empty? " + collection.isEmpty());

        collection.clear();
        System.out.println("Size of collection after clearing: " + collection.size()); // 0
        System.out.println("Is collection empty after clearing? " + collection.isEmpty()); // t
    }
}