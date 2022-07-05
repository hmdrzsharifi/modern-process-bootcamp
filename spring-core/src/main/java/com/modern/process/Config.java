package com.modern.process;

import com.modern.process.domain.Engine;
import com.modern.process.domain.Trailer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.modern.process")
public class Config {

    @Bean
    public Engine engine(){
        Engine engine = new Engine();
        engine.setType("v8");
        engine.setVolume(5);
        return engine;
    }

    @Bean
    public Trailer trailer(){
        Trailer trailer = new Trailer();
        return trailer;
    }
}
