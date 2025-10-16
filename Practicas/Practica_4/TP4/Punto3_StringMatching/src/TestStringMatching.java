import java.util.SortedSet;

public class TestStringMatching {

    public static void main(String[] args) {

        GrammaDictionary dictionary = new GrammaDictionary(2);

        dictionary.addWord("glucosa");
        dictionary.addWord("glucoso");
        dictionary.addWord("glucano");
        dictionary.addWord("globo");
        dictionary.addWord("glutamato");
        dictionary.addWord("gluten");
        dictionary.addWord("gladiolo");
        dictionary.addWord("gato");
        dictionary.addWord("luz");
        dictionary.addWord("oso");

        System.out.println("Diccionario de gramas:");
        dictionary.printEntries();
        System.out.println();

        ComparisonEngine engine = ComparisonEngine.getInstance();

        String palabra = "glucosa";
        System.out.println("Palabra buscada: " + palabra);

        SortedSet<String> similares = engine.matchingWords(dictionary, palabra);

        System.out.println("\nPalabras similares encontradas:");
        if (similares.isEmpty()) {
            System.out.println("No se encontraron coincidencias.");
        } else {
            similares.forEach(System.out::println);
        }
    }
}

