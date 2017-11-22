package com.ubs.opsit.interviews.util.parser;

import com.ubs.opsit.interviews.bean.Time;
import com.ubs.opsit.interviews.exception.IllegalTimeFormatException;

public interface Parser {
    Time parseStringToTime(String inTime) throws IllegalTimeFormatException;
}
