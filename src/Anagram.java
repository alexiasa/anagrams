import java.util.ArrayList;
import java.util.Arrays;

/**
 */
public class Anagram {
    private String key;
    private ArrayList<String> values = new ArrayList<>();

    /**
     * @param newWord the default Anagram constructor requires a new word String. This new word will be the first entry
     *                in values. The key is computed from this word.
     */
    public Anagram(String newWord) {
        this.key = computeKey(newWord);
        this.values.add(newWord);

    }

    /**
     * @param word will be a value of the Anagram. We sort this alphabetically to find the key
     * @return the computed key (sorted alphabetically) of the word as a string
     */
    public static String computeKey(String word) {
        char[] wordChars = word.toCharArray();
        Arrays.sort(wordChars);
        return new String(wordChars);
    }

    /**
     * @return this.values
     */
    public ArrayList<String> getValues() {
        return this.values;
    }

    public String getKey() {
        return this.key;
    }

    /**
     * accepts a word and adds it to the Anagram object's values
     * @param anagramWord is an original word that contains the same letters as the Anagram object's key
     */
    public void addValue(String anagramWord) {
        this.values.add(anagramWord);
    }
}
