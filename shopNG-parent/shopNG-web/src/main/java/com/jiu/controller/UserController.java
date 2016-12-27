package com.jiu.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jiu.mapper.UserMapper;
import com.jiu.model.User;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = { "User" })
@Controller
public class UserController
{
  private Logger logger = Logger.getLogger(UserController.class);
  
  @Autowired
  private UserMapper userService;

  /*
   *  http://localhost:8080/getUserInfo
   */

  @ApiOperation(value="getUserInfo",notes="requires noting")
  @RequestMapping(value="/getUserInfo",method=RequestMethod.GET)
  @ResponseBody
  public User getUserInfo() {
      User user = userService.findUserInfo();
      if(user!=null){
          System.out.println("user.getName():"+user.getName());
          logger.info("user.getAge():"+user.getAge());
      }
      return user;
  }
}
