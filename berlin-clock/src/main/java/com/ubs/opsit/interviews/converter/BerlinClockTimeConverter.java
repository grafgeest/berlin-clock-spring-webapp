package com.ubs.opsit.interviews.converter;

import com.ubs.opsit.interviews.TimeConverter;
import com.ubs.opsit.interviews.bean.Clock;
import com.ubs.opsit.interviews.bean.Time;
import com.ubs.opsit.interviews.service.ClockService;
import com.ubs.opsit.interviews.service.impl.ClockServiceImpl;
import com.ubs.opsit.interviews.util.parser.Parser;
import com.ubs.opsit.interviews.util.parser.TimeParser;
import com.ubs.opsit.interviews.util.validator.AbstractPatternValidator;
import com.ubs.opsit.interviews.util.validator.TimeValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.ubs.opsit.interviews.util.Constants.TIME_PATTERN;


public class BerlinClockTimeConverter implements TimeConverter {

    private static final Logger LOG = LoggerFactory.getLogger(BerlinClockTimeConverter.class);
    private Parser parser;
    private ClockService clockService;

    public BerlinClockTimeConverter() {
        this.parser = new TimeParser(new TimeValidator(TIME_PATTERN));
        this.clockService = new ClockServiceImpl();
    }

    @Override
    public String convertTime(String aTime) {
        LOG.info(String.format("European time [%s]", aTime));
        Time time = parser.parseStringToTime(aTime);
        Clock clock = clockService.setCurrentTime(time);
        String rez = clock.toString();
        LOG.info(String.format("Berlin clock time \n %s", rez));
        return rez;
    }
}
