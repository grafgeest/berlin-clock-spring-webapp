package com.ubs.opsit.interviews.service.impl;

import com.ubs.opsit.interviews.bean.Clock;
import com.ubs.opsit.interviews.bean.Time;
import com.ubs.opsit.interviews.service.ClockService;
import com.ubs.opsit.interviews.util.CharArrayUtils;
import org.junit.Before;
import org.junit.Test;

import static com.ubs.opsit.interviews.util.Constants.OFF;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ClockServiceImplTest {

    private ClockService clockService;
    private Time time = mock(Time.class);

    @Before
    public void setUp() throws Exception {
        this.clockService = new ClockServiceImpl();
    }

    @Test
    public void testSetCurrentTimeAndCheckSeconds() throws Exception {
        when(time.getSecond()).thenReturn(1);
        Clock clock = clockService.setCurrentTime(time);
        assertEquals(OFF, clock.getSecond());
    }

    @Test
    public void testSetCurrentTimeAndCheckFirstHoursLine() throws Exception {
        when(time.getHour()).thenReturn(5);
        Clock clock = clockService.setCurrentTime(time);
        assertEquals("ROOO", CharArrayUtils.toString(clock.getFirstHoursLine()));
    }

    @Test
    public void testSetCurrentTimeAndCheckFirstAndSecondHoursLine() throws Exception {
        when(time.getHour()).thenReturn(12);
        Clock clock = clockService.setCurrentTime(time);
        assertEquals("RROO", CharArrayUtils.toString(clock.getFirstHoursLine()));
        assertEquals("RROO", CharArrayUtils.toString(clock.getSecondHoursLine()));
    }

    @Test
    public void testSetCurrentTimeAndCheckFirstMinuterLine() throws Exception {
        when(time.getMinute()).thenReturn(16);
        Clock clock = clockService.setCurrentTime(time);
        assertEquals("YYROOOOOOOO", CharArrayUtils.toString(clock.getFirstMinutesLine()));
    }

    @Test
    public void testSetCurrentTimeAndCheckFirstAndSecondMinuterLine() throws Exception {
        when(time.getMinute()).thenReturn(16);
        Clock clock = clockService.setCurrentTime(time);
        assertEquals("YYROOOOOOOO", CharArrayUtils.toString(clock.getFirstMinutesLine()));
        assertEquals("YOOO", CharArrayUtils.toString(clock.getSecondMinutesLine()));
    }

}