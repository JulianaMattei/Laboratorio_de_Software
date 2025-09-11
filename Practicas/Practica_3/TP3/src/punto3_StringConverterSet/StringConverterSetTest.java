package punto3_StringConverterSet;

import java.util.Iterator;

public class StringConverterSetTest {

    public static void main(String[] args) {

        StringConverterSet strConverterSet = new StringConverterSet();
        strConverterSet.add(10);
        strConverterSet.add(20);
        strConverterSet.add(30);

        Iterator iterator = strConverterSet.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        for (Object string : strConverterSet) {
            System.out.println(string);
        }
    }

}
