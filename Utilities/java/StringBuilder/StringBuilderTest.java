package java.StringBuilder;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StringBuilderTest {

    StringBuilder stringBuilder;

    @Before
    public void setUp() {
        stringBuilder = new StringBuilder();
    }

    @Test
    public void testAdd() {
        stringBuilder.add("Hello World");
        Assert.assertEquals(false, stringBuilder.isEmpty());
    }

    @Test
    public void testAddNull() {
        stringBuilder.add(null);
        Assert.assertEquals(false, stringBuilder.isEmpty());
    }

    @Test
    public void testClear() {
        stringBuilder.add(null);
        stringBuilder.clear();
        Assert.assertEquals(true, stringBuilder.isEmpty());
    }

    @Test
    public void testClone() {
        StringBuilder cloned = stringBuilder.clone();
        Assert.assertEquals(false, cloned == stringBuilder);
        Assert.assertEquals(true, cloned.values != stringBuilder.values);
    }

    @Test
    public void testEquals() {
        StringBuilder x = stringBuilder.clone();
        x.add("Hello");
        stringBuilder.add("Hello");
        Assert.assertEquals(true, x.equals(stringBuilder));
    }

    @Test
    public void testGetValues() {
        stringBuilder.add("Test");
        ArrayList<String> words = stringBuilder.getValues();
        Assert.assertEquals("Test", words.get(0));
    }

    @Test
    public void testIsEmpty() {
        stringBuilder.add("Hello");
        Assert.assertEquals(false, stringBuilder.isEmpty());
        stringBuilder.remove("Hello");
        Assert.assertEquals(true, stringBuilder.isEmpty());
    }

    @Test
    public void testRemove() {
        stringBuilder.add("Hello");
        stringBuilder.remove("x");
        Assert.assertEquals(false, stringBuilder.isEmpty());
        stringBuilder.remove("Hello");
        Assert.assertEquals(true, stringBuilder.isEmpty());
    }

    @Test
    public void testSetValues() {
        ArrayList<String> values = new ArrayList<String>();
        values.add("Test");
        stringBuilder.setValues(values);
        Assert.assertEquals("Test", stringBuilder.getValues().get(0));
    }

    @Test
    public void testToString() {
        stringBuilder.add("Hello ");
        stringBuilder.add("World");
        Assert.assertEquals("Hello World", stringBuilder.toString());
    }

    @Test
    public void testIsUnique() {
        Assert.assertEquals(false, stringBuilder.isUnique("HelloWorld"));
        Assert.assertEquals(true, stringBuilder.isUnique(""));
        Assert.assertEquals(true, stringBuilder.isUnique(null));
    }

    @Test
    public void testIsPermutation() {
        Assert.assertEquals(true, stringBuilder.isPermutation("Hello", "olleH"));
        Assert.assertEquals(false, stringBuilder.isPermutation("Hell", "olleH"));
        Assert.assertEquals(true, stringBuilder.isPermutation(null, null));
        Assert.assertEquals(false, stringBuilder.isPermutation(null, "olleH"));
    }

    @Test
    public void testCharChange() {
        Assert.assertEquals("Hello%World", stringBuilder.changeChar("Hello World", ' ', '%'));
        Assert.assertEquals("Hello World", stringBuilder.changeChar("Hello World", 'q', '%'));
    }

    @Test
    public void testIsPalindrome() {
        Assert.assertEquals(true, stringBuilder.isPalindrome("ABA"));
        Assert.assertEquals(true, stringBuilder.isPalindrome("ABBA"));
        Assert.assertEquals(false, stringBuilder.isPalindrome("ABCA"));
        Assert.assertEquals(true, stringBuilder.isPalindrome(""));
        Assert.assertEquals(true, stringBuilder.isPalindrome(null));
    }

    @Test
    public void testIsReverse() {
        Assert.assertEquals(true, stringBuilder.isReverse("ABC", "CBA"));
        Assert.assertEquals(false, stringBuilder.isReverse("ABB", "CBA"));
    }
}
