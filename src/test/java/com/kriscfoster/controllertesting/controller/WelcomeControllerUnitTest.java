package com.kriscfoster.controllertesting.controller;

import com.kriscfoster.controllertesting.service.WelcomeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class WelcomeControllerUnitTest {

    WelcomeController welcomeController;

    @BeforeEach
    void setup() {
        WelcomeService welcomeService = Mockito.mock(WelcomeService.class);
        when(welcomeService.getWelcomeMessage("Stranger")).thenReturn("Welcome Stranger!");
        when(welcomeService.getWelcomeMessage("John")).thenReturn("Welcome John!");
        this.welcomeController = new WelcomeController(welcomeService);
    }

    @Test
    void shouldGetDefaultWelcomeMessage() {
        assertEquals("Welcome Stranger!", welcomeController.welcome("Stranger"));
    }

    @Test
    void shouldGetCustomWelcomeMessage() {
        assertEquals("Welcome John!", welcomeController.welcome("John"));
    }
}
