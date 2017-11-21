package com.ubs.opsit.interviews.service.impl;

import com.ubs.opsit.interviews.bean.Clock;
import com.ubs.opsit.interviews.bean.Time;
import com.ubs.opsit.interviews.service.ClockService;

import static com.ubs.opsit.interviews.util.Constants.OFF;
import static com.ubs.opsit.interviews.util.Constants.STEP;

public class ClockServiceImpl implements ClockService {

    @Override
    public Clock setCurrentTime(Time time) {
        Clock clock = new Clock();
        setUpSeconds(time.getSecond(), clock);
        setUpFirstHourLine(time.getHour(), clock);
        setUpSecondHourLine(time.getHour(), clock);
        setUpFirstMinuteLine(time.getMinute(), clock);
        setUpSecondMinuteLine(time.getMinute(), clock);

        return clock;
    }

    private void setUpSeconds(int seconds, Clock clock) {
        if (seconds != 0 && seconds % 2 != 0) {
            clock.setSecond(OFF);
        }
    }

    private void setUpFirstHourLine(int hour, Clock clock) {
        int currentLineHour = hour / STEP;
        Character[] firstLine = clock.getFirstHoursLine();
        for (int i = firstLine.length-1; i >= currentLineHour; i--) {
            firstLine[i] = OFF;
        }
        clock.setFirstHoursLine(firstLine);
    }

    private void setUpSecondHourLine(int hour, Clock clock) {
        int currentLineHour = hour % STEP;
        Character[] line = clock.getSecondHoursLine();
        for (int i = line.length-1; i >= currentLineHour; i--) {
            line[i] = OFF;
        }
        clock.setSecondHoursLine(line);
    }

    private void setUpFirstMinuteLine(int minutes, Clock clock) {
        int currentMinutes = minutes / STEP;
        Character[] line = clock.getFirstMinutesLine();
        for (int i = line.length - 1; i >= currentMinutes; i--) {
            line[i] = OFF;
        }
        clock.setFirstMinutesLine(line);
    }

    private void setUpSecondMinuteLine(int minutes, Clock clock) {
        int currentMinutes = minutes % STEP;
        Character[] line = clock.getSecondMinutesLine();
        for (int i = line.length - 1; i >= currentMinutes; i--) {
            line[i] = OFF;
        }
        clock.setSecondMinutesLine(line);
    }
}
