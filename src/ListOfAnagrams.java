/**
 */

import java.util.Hashtable;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class ListOfAnagrams {
    private Hashtable<String, Anagram> anagramList;

    public ListOfAnagrams(String word) {
        anagramList = new Hashtable<>();
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

    public static void main(String [] args) throws FileNotFoundException {
        Scanner input = new Scanner(System.in);
        //String filename = input.nextLine();
        String filename = "../text.txt";
        File textFile = new File(filename);
        if(textFile.exists()) {
            Scanner anagramsIn = new Scanner(textFile);
            for(int i = 0; i < textFile.length(); i++) {
                String possibleAnagram = anagramsIn.nextLine();

            }
        }
        else {
            System.out.println("Not a valid filename. Please try again:");
            filename = input.nextLine();
        }


    }








}
