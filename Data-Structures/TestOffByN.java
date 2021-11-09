import org.junit.Test;

import static org.junit.Assert.*;

public class TestOffByN {
    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offByN = new OffByN(5);

    @Test
    public void offByN() {

        assertTrue(offByN.equalChars('f', 'a'));
        assertTrue(offByN.equalChars('a', 'f'));
        assertFalse(offByN.equalChars('F', 'a'));
        assertFalse(offByN.equalChars('6', 'f'));
        assertFalse(offByN.equalChars('q', 'x'));
        assertFalse(offByN.equalChars('g', 'g'));
        assertFalse(offByN.equalChars('S', '!'));
        assertFalse(offByN.equalChars('%', '!'));
        assertFalse(offByN.equalChars('6', '7'));

    }

}
