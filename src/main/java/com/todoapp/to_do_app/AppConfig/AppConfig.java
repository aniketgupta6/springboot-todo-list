package com.todoapp.to_do_app.AppConfig;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class AppConfig {
    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
