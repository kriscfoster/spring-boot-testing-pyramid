package com.bayo.controllertesting.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bayo.controllertesting.service.GoodbyeService;

@RestController
public class GoodbyeController {

	private GoodbyeService goodbyeService;

	public GoodbyeController(GoodbyeService goodbyeService) {
		this.goodbyeService = goodbyeService;
	}

	@GetMapping("/goodbye")
	public String goodbye(@RequestParam(defaultValue = "friend") String name) {
		System.out.printf( name );
		return goodbyeService.getGoodByeMessage( name );
	}
}
