package punto3_HashSet;

import java.util.Collection;
import java.util.HashSet;

public class HashSetAgregadosV2<E> extends ForwardingSet<E> {

    private int cantidadAgregados = 0;

    public HashSetAgregadosV2() {
        super(new HashSet<>());
    }

    @Override
    public boolean add(E e) {
        boolean rdo = super.add(e);
        if (rdo) {
            cantidadAgregados++;
        }
        return rdo;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        boolean rdo = false;
        for (E e : c) {
            add(e);
            if (add(e)) {
                rdo = true;
                cantidadAgregados++;
            }
        }
        return rdo;
    }

    public int getCantidadAgregados() {
        return cantidadAgregados;
    }
}
