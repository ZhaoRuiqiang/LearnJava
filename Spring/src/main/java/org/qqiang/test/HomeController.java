package org.qqiang.test;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.qqiang.test.parser.ParserService;
import org.qqiang.test.parser.ParserType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
	@ResponseBody
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return formattedDate;
	}
	
	@Autowired
	private ParserService parserService;

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	@ResponseBody
	public String testParserFactory() {
		parserService.doParse("Srilekha", ParserType.JSON);
		parserService.doParse("Srilekha", ParserType.XML);
		return "home";
	}
	
}
