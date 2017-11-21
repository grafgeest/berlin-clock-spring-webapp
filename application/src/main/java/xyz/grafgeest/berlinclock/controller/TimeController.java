package xyz.grafgeest.berlinclock.controller;

import com.ubs.opsit.interviews.TimeConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TimeController {

    @Autowired
    private TimeConverter timeConverter;

    @GetMapping("/")
    public String home() {
        return timeConverter.convertTime("00:00:00");
    }


}
