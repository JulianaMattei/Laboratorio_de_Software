package punto3_HashSet;

import java.util.Arrays;
import java.util.List;

public class HashSetTest {

    public static void main(String[] args) {

        System.out.println("Testeo de la clase HashSetAgregados");
        HashSetAgregados<String> set = new HashSetAgregados<>();

        // Test add()
        set.add("A");
        set.add("B");
        set.add("A");

        System.out.println(set);
        System.out.println(set.getCantidadAgregados());

        // Test addAll()
        List<String> all = Arrays.asList("C", "D", "A");
        set.addAll(all);

        System.out.println(set);
        System.out.println(set.getCantidadAgregados());


        System.out.println("Testeo de la clase HashSetAgregadosV2");
        HashSetAgregadosV2<String> set2 = new HashSetAgregadosV2<>();

        // Test add()
        set2.add("A");
        set2.add("B");
        set2.add("A");

        System.out.println(set2);
        System.out.println(set2.getCantidadAgregados());

        // Test addAll()
        List<String> all2 = Arrays.asList("C", "D", "A");
        set2.addAll(all2);

        System.out.println(set2);
        System.out.println(set2.getCantidadAgregados());


        System.out.println("Testeo de la clase HashSetRemovidos");
        HashSetRemovidos<String> set3 = new HashSetRemovidos<>();

        List<String> elementos = Arrays.asList("A", "B", "C", "D", "E");
        set3.addAll(elementos);

        System.out.println(set3);

        set3.remove("B");
        System.out.println(set3);
        System.out.println(set3.getCantidadRemovidos());

        List<String> elementos2 = Arrays.asList("C", "D");
        set3.removeAll(elementos2);

        System.out.println(set3);
        System.out.println(set3.getCantidadRemovidos());

    }
}
