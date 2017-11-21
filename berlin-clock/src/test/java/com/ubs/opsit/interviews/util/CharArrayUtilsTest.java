package com.ubs.opsit.interviews.util;

import org.junit.Test;

import static com.ubs.opsit.interviews.util.Constants.*;
import static org.junit.Assert.assertEquals;

public class CharArrayUtilsTest {

    @Test
    public void testCharacterToString() throws Exception {
        Character[] testChar = new Character[] {OFF, YELLOW, RED};
        assertEquals("OYR",CharArrayUtils.toString(testChar));
    }

    @Test
    public void testNull() throws Exception {
        assertEquals("null", CharArrayUtils.toString(null));
    }

    @Test
    public void testToString() throws Exception {
        Integer[] testInt = new Integer[] {0, 1, 2};
        assertEquals("012", CharArrayUtils.toString(testInt));
    }

}