import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class GrammaDictionary {

    private Map<String, List<String>> dictionary;
    private int window;

    public GrammaDictionary(int window) {
        this.window = window;
        this.dictionary = new HashMap<>();
    }

    public int getWindow() { return this.window; }
    public Map<String, List<String>> getDictionary() { return this.dictionary; }

    public void addWord(String word) {
        List<String> grams = QGrammaMaker.getInstance(window).getQGrammas(word);
        for (String g : grams) {
            dictionary.computeIfAbsent(g, k -> new ArrayList<>()).add(word);
        }
    }

    public List<String> getWord(String key) {
        return this.dictionary.get(key);
    }

    public void printEntries() {
        for (Entry<String, List<String>> entry : this.dictionary.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
