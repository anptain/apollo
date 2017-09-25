package com.xairball.apollo.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController extends AbstractController{
	private final static Logger LOGGER = LoggerFactory.getLogger(HomeController.class);
	@RequestMapping("/")
	public String index(){
		return "hi";
	}
}