package com.jiu.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
 

@Api(tags = { "Home" })
@Controller
public class HomeController
{
  private Logger logger = Logger.getLogger(HomeController.class);
  
  @ApiOperation(value="index",notes="requires the id of user")
  @RequestMapping(value="/",method=RequestMethod.GET)
  public String index(Model model) 
  {
      logger.info("hello");
      model.addAttribute("name", "");
      return "home/home";
  }
}
