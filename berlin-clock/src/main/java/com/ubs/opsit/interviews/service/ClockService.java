package com.ubs.opsit.interviews.service;

import com.ubs.opsit.interviews.bean.BerlinClock;
import com.ubs.opsit.interviews.bean.Time;

public interface ClockService {
    BerlinClock setCurrentTime(Time time);
}
