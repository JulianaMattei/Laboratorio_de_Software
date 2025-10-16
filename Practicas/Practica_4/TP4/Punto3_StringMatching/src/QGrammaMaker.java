import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.List;

public class QGrammaMaker {

    private int window;
    private static QGrammaMaker instance;

    private QGrammaMaker(int window) {
        this.window = window;
    }

    public static QGrammaMaker getInstance(int window) {
        if (instance == null) {
            instance = new QGrammaMaker(window);
        }
        return instance;
    }

    public int getWindow() {
        return window;
    }
    public void setWindow(int window) {
        this.window = window;
    }

    public List<String> getQGrammas(String str) {
        String formatted = "#" + str.toLowerCase() + "$";
        List<String> grams = new ArrayList<>();

        for (int i=0; i <= formatted.length() - window; i++) {
            grams.add(formatted.substring(i, i + window));
        }
        return grams;
    }

}
