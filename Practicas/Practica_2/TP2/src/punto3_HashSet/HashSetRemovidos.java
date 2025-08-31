package punto3_HashSet;

import java.util.Collection;
import java.util.HashSet;

public class HashSetRemovidos<E> extends ForwardingSet<E> {

    private int cantidadRemovidos = 0;

    public HashSetRemovidos() {
        super(new HashSet<>());
    }

    @Override
    public boolean remove(Object o) {
        boolean rdo = super.remove(o);
        if (rdo) {
            cantidadRemovidos++;
        }
        return rdo;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        boolean rdo = false;
        for (Object o : c) {
            remove(o);
            if (remove(o)) {
                rdo = true;
                cantidadRemovidos++;
            }
        }
        return rdo;
    }

    public int getCantidadRemovidos() {
        return cantidadRemovidos;
    }

}
