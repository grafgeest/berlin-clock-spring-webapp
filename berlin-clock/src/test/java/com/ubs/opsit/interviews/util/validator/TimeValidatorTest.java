package com.ubs.opsit.interviews.util.validator;

import com.ubs.opsit.interviews.exception.IllegalTimeFormatException;
import org.junit.Before;
import org.junit.Test;

import static com.ubs.opsit.interviews.TestConstants.MIDNIGHT;
import static com.ubs.opsit.interviews.TestConstants.NOT_TIME;
import static com.ubs.opsit.interviews.util.Constants.TIME_PATTERN;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TimeValidatorTest {

    private TimeValidator timeValidator;

    @Before
    public void setUp() throws Exception {
        timeValidator = new TimeValidator(TIME_PATTERN);
    }

    @Test
    public void testValidateTime() throws Exception {
        timeValidator.validate(MIDNIGHT);
    }

    @Test(expected = IllegalTimeFormatException.class)
    public void testValidateNull() throws Exception {
        timeValidator.validate(null);
    }

    @Test(expected = IllegalTimeFormatException.class)
    public void testValidateNotTime() throws Exception {
        timeValidator.validate(NOT_TIME);
    }

    @Test(expected = IllegalTimeFormatException.class)
    public void testValidateIncorrectTime() throws Exception {
        timeValidator.validate("25:00:00");
    }

    @Test
    public void testMatchInvalidString() {
        assertFalse(timeValidator.matchString(NOT_TIME));
    }

    @Test
    public void testMatchValidString() {
        assertTrue(timeValidator.matchString(MIDNIGHT));
    }

}