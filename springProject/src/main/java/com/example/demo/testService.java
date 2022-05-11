package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class testService {

	@Autowired(required = false)
	public testMapper testmapper;

	public String test() {
		String a = testmapper.getinfo();

		return a;
	}

}
