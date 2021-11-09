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

    static CharacterComparator offByOne = new OffByOne();

    @Test
    public void isPalindrome() {
        assertFalse(palindrome.isPalindrome("persiflage"));
        assertTrue(palindrome.isPalindrome("poop"));
        assertFalse(palindrome.isPalindrome("cat"));
        assertTrue(palindrome.isPalindrome("mom"));
        assertFalse(palindrome.isPalindrome(null));
        assertTrue(palindrome.isPalindrome("l"));
        assertTrue(palindrome.isPalindrome(""));
        assertTrue(palindrome.isPalindrome(" "));
        assertTrue(palindrome.isPalindrome("flake", offByOne));
        assertTrue(palindrome.isPalindrome("acdb", offByOne));
        assertTrue(palindrome.isPalindrome("f", offByOne));
        assertTrue(palindrome.isPalindrome("", offByOne));
        assertTrue(palindrome.isPalindrome(" ", offByOne));
        assertTrue(palindrome.isPalindrome("wow", null));
        assertFalse(palindrome.isPalindrome(null, offByOne));
        assertFalse(palindrome.isPalindrome("pokemon", offByOne));
        assertFalse(palindrome.isPalindrome("lol", offByOne));
        assertFalse(palindrome.isPalindrome("dood", offByOne));
    }
}
