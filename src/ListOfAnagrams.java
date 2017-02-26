/**
 */

import java.util.Hashtable;

public class ListOfAnagrams {
    private Hashtable<String, Anagram> anagramList = new Hashtable<>();

    public ListOfAnagrams(String word) {
        this.addNewAnagram(word);

    }

    public void addNewAnagram(String word) {
        Anagram newGram = new Anagram(word);
        anagramList.put(newGram.getKey(), newGram);
    }

    public void addToAnagram(String word, String computedKey) {
        anagramList.get(computedKey).addValue(word);

    }

    public void printAllAnagrams() {
        for (String key : anagramList.keySet()) {
            System.out.println(key + ":" + anagramList.get(key).getValues());
        }




    }

    public Anagram findAnagram(String word) {
        return anagramList.get(Anagram.computeKey(word));
    }

    public boolean checkAnagrams(String computedKey) {
        return anagramList.containsKey(computedKey);

    }

    public static void main(String [] args) {


    }








}
