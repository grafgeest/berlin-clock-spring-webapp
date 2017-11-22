package xyz.grafgeest.berlinclock.config;

import com.ubs.opsit.interviews.TimeConverter;
import com.ubs.opsit.interviews.factory.TimeConverterFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;

@Configuration
@ComponentScan
public class Config {
    @Bean
    public TimeConverter getTimeConverter() {
        return TimeConverterFactory.newInstance();
    }

    @Bean
    public MethodValidationPostProcessor methodValidationPostProcessor() {
        return new MethodValidationPostProcessor();
    }
}
