package punto3_HashSet;

import java.util.Arrays;
import java.util.List;

public class HashSetAgregadosTest {

    public static void main(String[] args) {

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

    }
}
