import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 */
public class TestAnagramClass {

    private Anagram setUp(String testWord) {
        return new Anagram(testWord);
    }

    @Test
    void testComputeKey() {
        String actual = Anagram.computeKey("range");
        String expected = "aegnr";
        Assertions.assertEquals(expected, actual);
        System.out.printf("Expected %s, got %s", expected, actual);
        System.out.println();

    }

    @Test
    void testGetValues() {
        Anagram testGram = setUp("range");

        String expected = "[range]";
        String actual = testGram.getValues().toString();
        Assertions.assertEquals(expected, actual);
        System.out.printf("Expected %s, got %s", expected, actual);
        System.out.println();

    }

    @Test
    void testSetValues() {
        Anagram testGram = setUp("range");

        String testWord = "anger";
        String expected = "[range, anger]";
        testGram.addValue(testWord);

        String actual = testGram.getValues().toString();

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void testAnagramDefault() {
        Anagram testGram = setUp("range");
        String expectedKey = "aegnr";
        String expectedValue = "[range]";

        Assertions.assertEquals(expectedKey, testGram.getKey());
        Assertions.assertEquals(expectedValue, testGram.getValues().toString());

        System.out.println(testGram.getValues());
        System.out.println(testGram.getKey());

    }

    @Test
    void testGetKey() {
        Anagram testGram = setUp("range");
        String expectedKey = Anagram.computeKey("range");
        String actualKey = testGram.getKey();

        Assertions.assertEquals(expectedKey, actualKey);




    }


}
