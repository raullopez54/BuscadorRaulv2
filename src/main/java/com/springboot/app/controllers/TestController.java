package com.springboot.app.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.springboot.app.persistence.models.TestModel;
import com.springboot.app.services.TestService;
import java.util.List;


@Controller
public class TestController
{

  @Autowired
  TestService iService;


  @ResponseBody
  @RequestMapping(value = "/test",
                  method = RequestMethod.POST,
                  produces = MediaType.APPLICATION_JSON_VALUE)
  public List<TestModel> test(@RequestBody TestModel obj) throws Exception
  {
    List<TestModel> x = iService.testService(obj);

    return x;
  }

}
