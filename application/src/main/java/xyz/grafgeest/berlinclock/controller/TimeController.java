package xyz.grafgeest.berlinclock.controller;

import com.ubs.opsit.interviews.TimeConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import xyz.grafgeest.berlinclock.service.TimeService;

@RestController
public class TimeController {

    @Autowired
    private TimeConverter timeConverter;

    @Autowired
    private TimeService timeService;

    @GetMapping("/get-berlin-clock-time")
    public  @ResponseBody String getBerlinClockTime() {
        return timeConverter.convertTime(timeService.getCurrentTime());
    }
}
