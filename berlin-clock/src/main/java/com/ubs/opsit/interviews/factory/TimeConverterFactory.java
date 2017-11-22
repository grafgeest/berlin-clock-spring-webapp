package com.ubs.opsit.interviews.factory;

import com.ubs.opsit.interviews.TimeConverter;
import com.ubs.opsit.interviews.converter.BerlinClockTimeConverter;
import com.ubs.opsit.interviews.service.ClockService;
import com.ubs.opsit.interviews.service.impl.ClockServiceImpl;
import com.ubs.opsit.interviews.util.parser.impl.TimeParser;
import com.ubs.opsit.interviews.util.validator.TimeValidator;

import static com.ubs.opsit.interviews.util.Constants.TIME_PATTERN;


/**
 * Create a new instance of TimeConverter.
 */
public class TimeConverterFactory {

    public static TimeConverter newInstance() {
        return new BerlinClockTimeConverter(new TimeParser(new TimeValidator(TIME_PATTERN)), new ClockServiceImpl());
    }

    public static TimeConverter newInstance(TimeParser parser, ClockService service) {
        return new BerlinClockTimeConverter(parser, service);
    }
}
