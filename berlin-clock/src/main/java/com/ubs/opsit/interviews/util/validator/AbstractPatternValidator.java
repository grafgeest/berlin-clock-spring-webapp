package com.ubs.opsit.interviews.util.validator;

import com.ubs.opsit.interviews.exception.IllegalTimeFormatException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class AbstractPatternValidator {
    private Pattern pattern;
    private Matcher matcher;

    protected AbstractPatternValidator(String PatternValidator){
        pattern = Pattern.compile(PatternValidator);
    }

    /**
     * Validate string via pattern with regular expression
     * @param inString String for validation
     * @return true valid format, false invalid format
    
     */
    protected boolean matchString(final String inString){
        matcher = pattern.matcher(inString);
        return matcher.matches();
    }

    public abstract boolean validate(final String arg) throws IllegalTimeFormatException;
}