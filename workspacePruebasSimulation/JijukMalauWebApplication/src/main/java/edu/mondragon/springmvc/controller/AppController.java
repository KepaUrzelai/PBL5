package edu.mondragon.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
@RequestMapping("/")
public class AppController {

	@RequestMapping(value = { "/"}, method = RequestMethod.GET)
	public String homePage(ModelMap model) {
		return "home";
	}

	@RequestMapping(value = { "/login"}, method = RequestMethod.GET)
	public String productsPage(ModelMap model) {
		return "login";
	}

	@RequestMapping(value = { "/register"}, method = RequestMethod.GET)
	public String contactUsPage(ModelMap model) {
		return "register";
	}
}