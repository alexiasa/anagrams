import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Scanner;


public class ListOfAnagrams {
    /**
     * ListOfAnagrams class contains a Hashtable field anagramList consisting of a
     * String key and an Anagram object value.
     */
    public Hashtable<String, Anagram> anagramList;

    /**
     * @param word word is the first word in the input file where words are found.
     *             This constructor requires a word parameter used to create the first Anagram object.
     */
    public ListOfAnagrams(String word) {
        anagramList = new Hashtable<>();
        this.addNewAnagram(word);
    }

    /**
     * Default constructor for ListOfAnagrams simply creates a new Hashtable as anagramList.
     */
    public ListOfAnagrams() {
        anagramList = new Hashtable<>();
    }


    /**
     * @param word is the original word to be added to the list of Anagrams. A new Anagram object is
     *             created from this word.
     */
    public void addNewAnagram(String word) {
        Anagram newGram = new Anagram(word);
        anagramList.put(newGram.getKey(), newGram);
    }

    /**
     * @param word word is the original word to be added to the Anagram object's values field.
     * @param computedKey is the key that identifies the original word in relation to others and is used to
     *                    find the existing, corresponding entry in the ListOfAnagrams object.
     */
    public void addToAnagram(String word, String computedKey) {
        anagramList.get(computedKey).addValue(word);

    }

    /**
     * This method prints all of the anagrams contained in the ListOfAnagrams object.
     */
    public void printAllAnagrams() {
        for (String key : anagramList.keySet()) {
            ArrayList<String> values = anagramList.get(key).getValues();
            String anagrams = values.toString().replaceAll("\\[|]", "");

            if(values.size() > 1) {
                System.out.printf("%s are anagrams.\n", anagrams);
            }
            else {
                System.out.printf("%s has no anagrams.\n", anagrams);
            }
        }

    }

    /**
     * @param key key is the computed key of a word.
     *            This function returns the corresponding Anagram values as a String.
     */
    public String getAnagrams(String key) {
        String anagramValues = anagramList.get(key).getValues().toString();
        return anagramValues.replaceAll("\\[|]", "");
    }

    /**
     * @param word word is the original word that is a possible anagram of an existing entry. Word's key is computed
     *             to find a corresponding match.
     * @return This function returns an Anagram object that corresponds with the computed key of the original word.
     */
    public Anagram findAnagram(String word) {
        return anagramList.get(Anagram.computeKey(word));
    }

    /**
     * @param computedKey computedKey is the key of a word. It is computed by sorting the word's letters
     *                    in alphabetical order.
*      @param gramList gramList is a Hashtable of Anagram String keys and Anagram values.
     * @return Returns a boolean that verifies if the key is contained in the ListOfAnagrams object's Hashtable.
     */
    public static boolean checkAnagrams(String computedKey, Hashtable<String, Anagram> gramList) {
        return gramList.containsKey(computedKey);

    }

    /**
     * @param args default
     * @throws FileNotFoundException if input file is not found.
     * This method accepts a filename as input and reads each line of the file to locate and create
     * list of anagrams. Once the file has been read, the user can search for a word's anagrams.
     */
    public static void main(String [] args) throws FileNotFoundException {
        Scanner input = new Scanner(System.in);
        String filename = input.nextLine();
        //String filename = "text.txt";
        FileInputStream textFile = new FileInputStream(filename);
        Scanner anagramsIn = new Scanner(textFile);

        if (anagramsIn.hasNext()) {
            ListOfAnagrams allTheAnagrams = new ListOfAnagrams();

            while(anagramsIn.hasNext()) {
                String possibleAnagram = anagramsIn.nextLine();
                String possibleKey = Anagram.computeKey(possibleAnagram);

                if (checkAnagrams(possibleKey, allTheAnagrams.anagramList)) {
                    allTheAnagrams.addToAnagram(possibleAnagram, possibleKey);
                } else {
                    allTheAnagrams.addNewAnagram(possibleAnagram);
                }
            }

                anagramsIn.close();
                //print all the anagrams
                allTheAnagrams.printAllAnagrams();

                // Search for specific anagrams
                Scanner userIn = new Scanner(System.in);
                //System.out.println("search:");
                String searchTerm = userIn.nextLine();
                String searchKey = Anagram.computeKey(searchTerm);

                if (checkAnagrams(searchKey, allTheAnagrams.anagramList)) {
                    String someAnagrams = allTheAnagrams.getAnagrams(searchKey);
                    System.out.printf("The anagrams of %s are %s.", searchTerm, someAnagrams);

                } else {
                    System.out.printf("%s has no anagrams.", searchTerm);
                }
        }
        else {
            System.out.println("Not a valid filename. Quitting.");
        }


    }








}
