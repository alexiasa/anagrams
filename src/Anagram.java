import java.util.ArrayList;
import java.util.Arrays;


/**
 * This class contains fields String key and String Arraylist values
 */
public class Anagram {
    private String key;
    private ArrayList<String> values = new ArrayList<>();

    /**
     * @param newWord The default Anagram constructor requires String newWord as a parameter. This new word will
     *                be the first entry in values. The key is computed from this word.
     */
    public Anagram(String newWord) {
        this.key = computeKey(newWord);
        this.values.add(newWord);

    }

    /**
     * @param word This parameter will be a value of the Anagram. It is sorted alphabetically to compute the key.
     * @return The computed key is returned as a String (sorted alphabetically).
     */
    public static String computeKey(String word) {
        char[] wordChars = word.toCharArray();
        Arrays.sort(wordChars);
        return new String(wordChars);
    }

    /**
     * @return The String ArrayList of values of the Anagram object is returned.
     */
    public ArrayList<String> getValues() {
        return this.values;
    }

    /**
     * @return The key field of the Anagram object is returned as a String.
     */
    public String getKey() {
        return this.key;
    }

    /**
     * addValue accepts a word and adds it to the Anagram object's values by appending to the ArrayList.
     * @param anagramWord anagramWord is an original word that contains the same letters as the Anagram object's key.
     */
    public void addValue(String anagramWord) {
        this.values.add(anagramWord);
    }
}
