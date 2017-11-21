package com.ubs.opsit.interviews.util.validator;

import org.apache.commons.lang.StringUtils;

public class TimeValidator extends AbstractPatternValidator {

    public TimeValidator(String PatternValidator) {
        super(PatternValidator);
    }

    @Override
    public boolean validate(String arg) throws IllegalArgumentException {
        if (StringUtils.isBlank(arg)) {
            throw new IllegalArgumentException("Time could not allowed to be null or empty");
        }
        if (!matchString(arg)) {
            throw new IllegalArgumentException(String.format("Time [%s] doesn't match to required format HH:mm:ss", arg));
        }

        return true;
    }
}
