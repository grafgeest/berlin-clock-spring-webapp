package xyz.grafgeest.berlinclock.config;

import com.ubs.opsit.interviews.converter.BerlinClockTimeConverter;
import com.ubs.opsit.interviews.TimeConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
    @Bean
    public TimeConverter getTimeConverter() {
        return new BerlinClockTimeConverter();
    }
}
