package com.ubs.opsit.interviews.util.parser;

import com.ubs.opsit.interviews.bean.Time;

public interface Parser {
    Time parseStringToTime(String inTime) throws IllegalArgumentException;
}
