package com.ubs.opsit.interviews.util.parser;

import com.ubs.opsit.interviews.bean.Time;
import com.ubs.opsit.interviews.util.parser.impl.TimeParser;
import com.ubs.opsit.interviews.util.validator.AbstractPatternValidator;
import com.ubs.opsit.interviews.util.validator.TimeValidator;
import org.junit.Before;
import org.junit.Test;

import static com.ubs.opsit.interviews.TestConstants.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TimeParserTest {
    private Parser parser;
    private AbstractPatternValidator validator = mock(TimeValidator.class);

    @Before
    public void setUp() throws Exception {
        parser = new TimeParser(validator);
    }

    @Test
    public void parseMidnightToTime() throws Exception {
        when(validator.validate(INVALID_TIME)).thenReturn(true);
        Time time = parser.parseStringToTime(MIDNIGHT);
        assertEquals(0, time.getHour());
        assertEquals(0, time.getMinute());
        assertEquals(0, time.getSecond());
    }

    @Test
    public void parseTIME_23_59_59_ToTime() throws Exception {
        when(validator.validate(INVALID_TIME)).thenReturn(true);
        Time time = parser.parseStringToTime(TIME_23_59_59);
        assertEquals(23, time.getHour());
        assertEquals(59, time.getMinute());
        assertEquals(59, time.getSecond());
    }

    @Test(expected = IllegalArgumentException.class)
    public void parseInvalidTimeToTime() throws Exception {
        when(validator.validate(INVALID_TIME)).thenThrow(IllegalArgumentException.class);
        Time time = parser.parseStringToTime(INVALID_TIME);
        assertNull(time);
    }

    @Test(expected = IllegalArgumentException.class)
    public void parseNotTimeToTime() throws Exception {
        when(validator.validate(NOT_TIME)).thenThrow(IllegalArgumentException.class);
        Time time = parser.parseStringToTime(NOT_TIME);
        assertNull(time);
    }

}