package com.ubs.opsit.interviews.converter;

import com.ubs.opsit.interviews.TimeConverter;
import com.ubs.opsit.interviews.exception.IllegalTimeFormatException;
import com.ubs.opsit.interviews.factory.TimeConverterFactory;
import org.junit.Before;
import org.junit.Test;

import static com.ubs.opsit.interviews.TestConstants.*;
import static org.junit.Assert.*;

public class BerlinClockTimeConverterTest {

    private TimeConverter timeConverter;

    @Before
    public void setUp() throws Exception {
        timeConverter = TimeConverterFactory.newInstance();
    }

    @Test
    public void testConvertMidnightTime() throws Exception {
        assertEquals(BERLIN_MIDNIGHT, timeConverter.convertTime(MIDNIGHT));
    }

    @Test
    public void testConvert_23_59_59_Time() throws Exception {
        assertEquals(BERLIN_TIME_23_59_59, timeConverter.convertTime(TIME_23_59_59));
    }

    @Test (expected = IllegalTimeFormatException.class)
    public void testConvertInvalidTime() throws Exception {
        timeConverter.convertTime(INVALID_TIME);
    }



}