package com.ubs.opsit.interviews.converter;

import com.ubs.opsit.interviews.TimeConverter;
import com.ubs.opsit.interviews.bean.BerlinClock;
import com.ubs.opsit.interviews.bean.Time;
import com.ubs.opsit.interviews.service.ClockService;
import com.ubs.opsit.interviews.util.parser.Parser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Implementation of the BerlinClock formatter
 */
public class BerlinClockTimeConverter implements TimeConverter {

    private static final Logger LOG = LoggerFactory.getLogger(BerlinClockTimeConverter.class);
    private Parser parser;
    private ClockService clockService;

    public BerlinClockTimeConverter(Parser parser, ClockService clockService) {
        this.parser = parser;
        this.clockService = clockService;
    }

    @Override
    public String convertTime(String aTime) {
        LOG.info(String.format("European time [%s]", aTime));
        Time time = parser.parseStringToTime(aTime);
        BerlinClock clock = clockService.setCurrentTime(time);
        String result = clock.toString();
        LOG.info(String.format("Berlin clock time \n %s", result));
        return result;
    }
}
