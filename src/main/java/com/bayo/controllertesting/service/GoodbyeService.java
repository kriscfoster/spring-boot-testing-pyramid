package com.bayo.controllertesting.service;

import org.springframework.stereotype.Service;
@Service
public class GoodbyeService {
	public String getGoodByeMessage(String name) {return String.format("Goodbye %s!", name);}
}
