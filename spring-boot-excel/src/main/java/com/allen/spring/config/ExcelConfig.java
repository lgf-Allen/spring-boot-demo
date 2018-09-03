package com.allen.spring.config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ExcelConfig {

    @Bean
    public List status() {
        List<String> status = new ArrayList<String>();
        status.add("Talking");
        status.add("Available");
        status.add("Case Follow Up");
        status.add("Checker");
        status.add("Break");
        status.add("Training");
        status.add("Meeting");
        status.add("Lunch");
        status.add("Miss");
        return status;
    }
    
    @Bean
    public List items() {
        List<String> items = new ArrayList<String>();
        items.add("Name");
        items.add("ID");
        items.add("On");
        items.add("Off");
        items.add("Sign On (hr)");
        
        items.add("Dur.(hr)");
        items.add("Count");
        items.add("Avg.");
        items.add("%");

        items.add("Dur.(hr)");
        items.add("Count");
        items.add("Avg.");
        items.add("%");
        
        items.add("Dur.(hr)");
        items.add("Count");
        items.add("Avg.");
        items.add("%");
        
        items.add("Dur.(hr)");
        items.add("Count");
        items.add("Avg.");
        items.add("%");

        items.add("Dur.(hr)");
        items.add("Count");
        items.add("Avg.");
        items.add("%");
        
        items.add("Dur.(hr)");
        items.add("Count");
        items.add("Avg.");
        items.add("%");
        
        items.add("Dur.(hr)");
        items.add("Count");
        items.add("Avg.");
        items.add("%");
        
        items.add("Dur.(hr)");
        items.add("Count");
        items.add("Avg.");
        items.add("%");
        
        items.add("Dur.(hr)");
        items.add("Count");
        items.add("Avg.");
        items.add("%");
        
        return items;
    }
    
}
