package com.bayo.controllertesting.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.bayo.controllertesting.service.GoodbyeService;

public class GoodbyeControllerUnitTest {

	private GoodbyeController goodbyeController;

	@BeforeEach
	void setup() {
		GoodbyeService goodbyeService = Mockito.mock( GoodbyeService.class );
		when(goodbyeService.getGoodByeMessage( "friend" )).thenReturn( "Goodbye friend" );
		when(goodbyeService.getGoodByeMessage( "Timmy" )).thenReturn( "Goodbye Timmy" );
		this.goodbyeController = new GoodbyeController( goodbyeService );
	}

	@Test
	void shouldGetDefaultGoodByeMessage() {
		assertEquals ("Goodbye friend", goodbyeController.goodbye( "friend" ));
	}

	@Test
	void shouldGetCustomGoodbyeMessage() {
		assertEquals ("Goodbye Timmy", goodbyeController.goodbye( "Timmy" ));
	}
}
