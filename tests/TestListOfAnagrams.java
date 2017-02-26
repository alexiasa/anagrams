import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


/**
 */

class TestListOfAnagrams {

     Anagram setUpGram(String testWord) {
        return new Anagram(testWord);

    }

    ListOfAnagrams setUpList(String testWord) {
         return new ListOfAnagrams(testWord);
    }



    @Test
    void testAddNewAnagram() {
        ListOfAnagrams testList = setUpList("range");
        testList.addNewAnagram("cat");

        Assertions.assertEquals("act", testList.findAnagram("cat").getKey());

    }

    @Test
    void testAddToAnagram() {
        ListOfAnagrams testList = setUpList("range");
        String testWord = "anger";
        testList.addToAnagram(testWord, Anagram.computeKey(testWord));

        Assertions.assertEquals("aegnr", testList.findAnagram("range").getKey() );

    }

    @Test
    void testPrintAllAnagrams() {
        ListOfAnagrams testList = setUpList("range");
        testList.printAllAnagrams();


    }

    @Test
    void testFindAnagram(){
        ListOfAnagrams testList = setUpList("range");

        String testValue = testList.findAnagram("anger").getValues().toString();
        Assertions.assertEquals("[range]", testValue);


    }

    @Test
    void testCheckAnagrams() {
        ListOfAnagrams testList = setUpList("range");
        boolean testCheck = testList.checkAnagrams(Anagram.computeKey("anger"));

        Assertions.assertEquals(true, testCheck);



    }

    @Test
    void testMain() {

    }

}