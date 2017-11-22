package xyz.grafgeest.berlinclock.controller;

import com.ubs.opsit.interviews.TimeConverter;
import com.ubs.opsit.interviews.converter.BerlinClockTimeConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import xyz.grafgeest.berlinclock.service.TimeService;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;

@RestController
@Validated
public class TimeController {

    private static final Logger log = LoggerFactory.getLogger(TimeController.class);

    @Autowired
    private TimeConverter timeConverter;

    @Autowired
    private TimeService timeService;

    public static final String TIME_PATTERN = "(?:[01]\\d|2[01234]):(?:[012345]\\d):(?:[012345]\\d)";

    @GetMapping("/get-server-berlin-clock-time")
    public  @ResponseBody String getCurrentServerBerlinClockTime() {
        log.info("Requested server berlin clock time");
        return timeConverter.convertTime(timeService.getCurrentTime());
    }

    @GetMapping("/get-berlin-clock-time")
    public  @ResponseBody String getBerlinClockTime(@Valid @Pattern(regexp = TIME_PATTERN) @RequestParam(value = "time", required = true) String time) {
        log.info(String.format("Requested server berlin clock time [%s]", time));
        return timeConverter.convertTime(time);
    }
}
