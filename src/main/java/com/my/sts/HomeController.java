package com.my.sts;

import java.text.DateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		List<String> names = Arrays.asList("jeong", "pro", "jdk", "java");
		names.parallelStream().map((x) ->{return x.concat("s");}).forEach(x -> System.out.println(x));
		
		return "home";
	}
	
	// TODO : REST API »£√‚
	@ResponseBody
	@RequestMapping(value="/VesionCheck", method= RequestMethod.GET)
	public HashMap<String, String> test2() {
	     HashMap<String, String> map = new HashMap<>();
	     map.put("serverversion", "1.0.0.1");
	     return map;
	}
}
