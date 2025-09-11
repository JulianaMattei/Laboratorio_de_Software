package punto1_stack;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Stack {

    private java.util.ArrayList<String> items;

    public Stack() {
        items = new java.util.ArrayList();
    }

    public void push(String item) {
        items.add(item);
    }

    public String pop() {
        return items.remove(items.size() - 1);
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public Iterator<String> iterator() {
        return new StackIterator();
    }


    // Con este Iterator la pila se recorre del primer elemento insertado al último, si se
    // quiere recorrer como una pila, se debe cambiar el orden de los índices
    // public class StackIterator implements Iterator<String> {
     private  class StackIterator implements Iterator<String> {
        private int index = 0;

        @Override
        public boolean hasNext() {
            return index < items.size();
        }

        @Override
        public String next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return items.get(index++);
        }
    }
}
