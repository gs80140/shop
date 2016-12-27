package com.jiu.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
 

@Api(tags = { "Hello" })
@Controller
public class HelloController
{
  private Logger logger = Logger.getLogger(HelloController.class);
  
  /*
  *   http://localhost:8080/hello?name=cn.7player
   */

  @ApiOperation(value="test hello",notes="requires the id of user")
  @RequestMapping(value="/hello",method=RequestMethod.GET)
  public String greeting(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
      logger.info("hello");
      model.addAttribute("name", name);
      return "hello";
  }
}
