package punto1_stack;

import java.util.Iterator;

public class StackTest {

    public static void main(String[] args) {

        Stack stack = new Stack();

        stack.push("Aaa");
        stack.push("Bbb");
        stack.push("Ccc");
        stack.push("Ddd");


        // Recorre la pila una única vez, sin utilizar Iterator

        /*
        String elemento;
        while (!stack.isEmpty()) {
            elemento = stack.pop();
            System.out.println(elemento);
        }

         */

        // Recorre la pila utilizando Iterator

        Iterator<String> iterator = stack.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }


        // Cuando la clase anidada está declarada public puede crearse un objeto del tipo
        // anidado de esta forma
        // Stack.StackIterator iterator2 = stack.new StackIterator();


    }

}
