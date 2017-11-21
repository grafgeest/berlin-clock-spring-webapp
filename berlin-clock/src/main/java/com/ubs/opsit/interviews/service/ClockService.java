package com.ubs.opsit.interviews.service;

import com.ubs.opsit.interviews.bean.Clock;
import com.ubs.opsit.interviews.bean.Time;

public interface ClockService {
    Clock setCurrentTime(Time time);
}
