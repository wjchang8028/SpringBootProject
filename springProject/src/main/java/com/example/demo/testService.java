package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class testService {

	@Autowired(required = false)
	private testMapper testmapper;

	String test() {
		String a = testmapper.getinfo();
		System.out.println(a);

		return a;
	}

}
