package com.opensource.web.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class SpringMvcController {
	
	@RequestMapping(value="/mvc",method=RequestMethod.GET)
	public ModelAndView actindex(){
		ModelAndView model = new ModelAndView();
		model.setViewName("/index");
		return model;
	}
}
