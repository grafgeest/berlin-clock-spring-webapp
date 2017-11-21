package com.ubs.opsit.interviews;

import com.ubs.opsit.interviews.converter.BerlinClockTimeConverter;
import org.junit.Before;
import org.junit.Test;

import static com.ubs.opsit.interviews.TestConstants.MIDNIGHT;
import static org.junit.Assert.assertEquals;

public class BerlinClockTimeConverterTest {

    private TimeConverter timeConverter;

    @Before
    public void init(){
        timeConverter = new BerlinClockTimeConverter();
    }

    @Test
    public void convertTime() throws Exception {
        String time = timeConverter.convertTime(MIDNIGHT);
        assertEquals(MIDNIGHT, time);

    }

}