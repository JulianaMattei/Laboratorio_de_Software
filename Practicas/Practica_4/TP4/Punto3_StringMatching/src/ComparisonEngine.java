import java.util.*;

public class ComparisonEngine {

    private static ComparisonEngine instance =  new ComparisonEngine();

    private ComparisonEngine(){}

    public static ComparisonEngine getInstance(){ return instance; }

    public SortedSet<String> matchingWords(GrammaDictionary dictionary, String str) {
        Set<String> candidates = new HashSet<>();
        List<String> grams = QGrammaMaker.getInstance(dictionary.getWindow()).getQGrammas(str);

        for (String g : grams) {
            List<String> words = dictionary.getDictionary().get(g);
            if (words != null) candidates.addAll(words);
        }

        SortedSet<String> result = new TreeSet<>();
        for (String w : candidates) {
            if (levenshtein(str, w) < 3) {
                result.add(w);
            }
        }
        return result;
    }

    public int levenshtein(String a, String b) {
        int[][] dp = new int[a.length() + 1][b.length() + 1];
        for (int i = 0; i <= a.length(); i++) dp[i][0] = i;
        for (int j = 0; j <= b.length(); j++) dp[0][j] = j;
        for (int i = 1; i <= a.length(); i++) {
            for (int j = 1; j <= b.length(); j++) {
                int cost = (a.charAt(i - 1) == b.charAt(j - 1)) ? 0 : 1;
                dp[i][j] = Math.min(Math.min(
                                dp[i - 1][j] + 1,
                                dp[i][j - 1] + 1),
                        dp[i - 1][j - 1] + cost);
            }
        }
        return dp[a.length()][b.length()];
    }

}
