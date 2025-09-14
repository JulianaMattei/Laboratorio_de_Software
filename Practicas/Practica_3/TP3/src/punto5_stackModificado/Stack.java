package punto5_stackModificado;

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
        return new Iterator() {
            private int index = 0;

            /* De esta forma inicializamos los valores de la clase anónima
            private int index;

            {
                index = 0;
            }
            */

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
        };
    }
}
