package com.cdeh.msa.rickandmorty.config;

import com.cdeh.msa.rickandmorty.service.impl.CharactersServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoggerConfig {

    @Bean
    public Logger loggerUtil(){
      return LogManager.getLogger(LoggerConfig.class);
    }
}
