import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }
//     Uncomment this class once you've created your Palindrome class.

    @Test
    public void testIsPalindrome() {
        boolean d1 = palindrome.isPalindrome("cat");
        boolean d2 = palindrome.isPalindrome("ThisihT");
        boolean d3 = palindrome.isPalindrome("thisihT");
        boolean d4 = palindrome.isPalindrome("T");
        boolean d5 = palindrome.isPalindrome("");

        assertFalse(d1);
        assertTrue(d2);
        assertFalse(d3);
        assertTrue(d4);
        assertTrue(d5);
    }
}
