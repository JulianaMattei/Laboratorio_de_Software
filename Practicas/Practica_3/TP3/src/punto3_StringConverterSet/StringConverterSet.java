package punto3_StringConverterSet;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class StringConverterSet extends AbstractSet {

    private ArrayList set;

    public StringConverterSet() {
        set = new ArrayList();
    }

    @Override
    public boolean add(Object e) {
        return set.add(e);
    }

    @Override
    public boolean addAll(Collection c) {
        return set.addAll(c);
    }

    @Override
    public void clear() {
        set.clear();
    }

    @Override
    public boolean contains(Object o) {
        return set.contains(o);
    }

    @Override
    public boolean containsAll(Collection c) {
        return set.containsAll(c);
    }

    @Override
    public boolean equals(Object o) {
        return set.equals(o);
    }

    @Override
    public int hashCode() {
        return set.hashCode();
    }

    @Override
    public boolean isEmpty() {
        return set.isEmpty();
    }

    @Override
    public boolean remove(Object o) {
        return set.remove(o);
    }

    @Override
    public boolean removeAll(Collection c) {
        return set.removeAll(c);
    }

    @Override
    public boolean retainAll(Collection c) {
        return set.retainAll(c);
    }

    @Override
    public int size() {
        return  set.size();
    }

    @Override
    public Iterator iterator() {
        return new IteratorStringAdapter();
    }


    private class IteratorStringAdapter implements Iterator {

        private int index = 0;

        @Override
        public boolean hasNext() {
            return index < size();
        }

        @Override
        public String next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return set.get(index++).toString();
        }
    }

}
