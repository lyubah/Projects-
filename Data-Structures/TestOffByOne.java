import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestOffByOne {
    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offByOne = new OffByOne();

    @Test
    public void offByOne() {
        Assert.assertTrue(offByOne.equalChars('a', 'b'));
        Assert.assertTrue(offByOne.equalChars('b', 'a'));
        Assert.assertTrue(offByOne.equalChars('&', '%'));
        Assert.assertTrue(offByOne.equalChars('A', 'B'));
        Assert.assertTrue(offByOne.equalChars('B', 'A'));
        Assert.assertFalse(offByOne.equalChars('A', 'g'));
        Assert.assertFalse(offByOne.equalChars('q', 'w'));
        Assert.assertFalse(offByOne.equalChars('A', 'b'));
        Assert.assertFalse(offByOne.equalChars('H', 'W'));
        Assert.assertFalse(offByOne.equalChars('6', 's'));
        Assert.assertFalse(offByOne.equalChars('7', '9'));
        Assert.assertFalse(offByOne.equalChars('g', 'g'));
    }

}
