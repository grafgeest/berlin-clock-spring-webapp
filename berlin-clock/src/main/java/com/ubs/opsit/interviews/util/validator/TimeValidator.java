package com.ubs.opsit.interviews.util.validator;

import com.ubs.opsit.interviews.exception.IllegalTimeFormatException;
import org.apache.commons.lang.StringUtils;

public class TimeValidator extends AbstractPatternValidator {

    public TimeValidator(String PatternValidator) {
        super(PatternValidator);
    }

    /**
     * Validate String by next time format HH:mm:ss
     * @param arg
     * @return if pass return true otherwise throws exception
     * @throws IllegalTimeFormatException
     */
    @Override
    public boolean validate(String arg) throws IllegalTimeFormatException {
        if (StringUtils.isBlank(arg)) {
            throw new IllegalTimeFormatException("Time could not allowed to be null or empty");
        }
        if (!matchString(arg)) {
            throw new IllegalTimeFormatException(String.format("Time [%s] doesn't match to required format HH:mm:ss", arg));
        }

        return true;
    }
}
