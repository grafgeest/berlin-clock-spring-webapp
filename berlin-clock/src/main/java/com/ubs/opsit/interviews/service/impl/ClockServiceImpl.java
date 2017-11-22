package com.ubs.opsit.interviews.service.impl;

import com.ubs.opsit.interviews.bean.BerlinClock;
import com.ubs.opsit.interviews.bean.Time;
import com.ubs.opsit.interviews.service.ClockService;

import static com.ubs.opsit.interviews.util.Constants.OFF;
import static com.ubs.opsit.interviews.util.Constants.STEP;

/**
 * The class provides time from European to Berlin format
 */
public class ClockServiceImpl implements ClockService {

    /**
     * Creates and returns the new BerlinClock converted from Time
     * @param time contains current time in the European format
     * @return BerlinClock with current time
     */
    @Override
    public BerlinClock setCurrentTime(Time time) {
        BerlinClock clock = new BerlinClock();
        setUpSeconds(time.getSecond(), clock);
        setUpFirstHourLine(time.getHour(), clock);
        setUpSecondHourLine(time.getHour(), clock);
        setUpFirstMinuteLine(time.getMinute(), clock);
        setUpSecondMinuteLine(time.getMinute(), clock);

        return clock;
    }

    /**
     * SetUps seconds according to BerlinClock format
     * @param seconds
     * @param clock
     */
    private void setUpSeconds(int seconds, BerlinClock clock) {
        if (seconds != 0 && seconds % 2 != 0) {
            clock.setSecond(OFF);
        }
    }

    /**
     * SetUps hours according to BerlinClock format
     * Each 5th hour will be represented
     * @param hour
     * @param clock
     */
    private void setUpFirstHourLine(int hour, BerlinClock clock) {
        int currentLineHour = hour / STEP;
        Character[] firstLine = clock.getFirstHoursLine();
        for (int i = firstLine.length-1; i >= currentLineHour; i--) {
            firstLine[i] = OFF;
        }
        clock.setFirstHoursLine(firstLine);
    }


    /**
     * SetUps hours according to BerlinClock format
     * Each hour between STEPs will be represented
     * @param hour
     * @param clock
     */
    private void setUpSecondHourLine(int hour, BerlinClock clock) {
        int currentLineHour = hour % STEP;
        Character[] line = clock.getSecondHoursLine();
        for (int i = line.length-1; i >= currentLineHour; i--) {
            line[i] = OFF;
        }
        clock.setSecondHoursLine(line);
    }

    /**
     * SetUps minutes according to BerlinClock format
     * Each 5th minute will be represented
     * @param minutes
     * @param clock
     */
    private void setUpFirstMinuteLine(int minutes, BerlinClock clock) {
        int currentMinutes = minutes / STEP;
        Character[] line = clock.getFirstMinutesLine();
        for (int i = line.length - 1; i >= currentMinutes; i--) {
            line[i] = OFF;
        }
        clock.setFirstMinutesLine(line);
    }

    /**
     * SetUps minutes according to BerlinClock format
     * Each minute between STEPs will be represented
     * @param minutes
     * @param clock
     */
    private void setUpSecondMinuteLine(int minutes, BerlinClock clock) {
        int currentMinutes = minutes % STEP;
        Character[] line = clock.getSecondMinutesLine();
        for (int i = line.length - 1; i >= currentMinutes; i--) {
            line[i] = OFF;
        }
        clock.setSecondMinutesLine(line);
    }
}
