package xyz.grafgeest.berlinclock;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import xyz.grafgeest.berlinclock.controller.TimeController;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTest {

    @Autowired
    private TimeController timeController;

    @Test
    public void contextLoads() throws Exception {
        assertThat(timeController).isNotNull();
    }

}