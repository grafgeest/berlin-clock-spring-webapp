package com.ubs.opsit.interviews.util.parser.impl;

import com.ubs.opsit.interviews.bean.Time;
import com.ubs.opsit.interviews.exception.IllegalTimeFormatException;
import com.ubs.opsit.interviews.util.parser.Parser;
import com.ubs.opsit.interviews.util.validator.AbstractPatternValidator;

/**
 * A simple String parser. The parser reads an
 * String from an input parameter and convert it.
 * Ignores all elements that are not valid
 */
public class TimeParser implements Parser {

    private AbstractPatternValidator validator;

    public TimeParser(AbstractPatternValidator validator) {
        this.validator = validator;
    }

    @Override
    public Time parseStringToTime(String inTime) throws IllegalTimeFormatException {

        validator.validate(inTime);
        int hour = Integer.parseInt(inTime.substring(0,2));
        int minute = Integer.parseInt(inTime.substring(3,5));
        int second = Integer.parseInt(inTime.substring(6,8));

        return new Time(hour, minute, second);
    }
}
