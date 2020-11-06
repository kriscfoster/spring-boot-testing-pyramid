package com.kriscfoster.controllertesting.service;

import org.springframework.stereotype.Service;

@Service
public class WelcomeService {
    public String getWelcomeMessage(String name) {
        return String.format("Welcome %s!", name);
    }
}
