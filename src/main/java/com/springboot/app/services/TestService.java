package com.springboot.app.services;

import com.springboot.app.persistence.models.TestModel;
import java.util.List;


public interface TestService
{

  public List<TestModel> testService(TestModel obj) throws Exception;

}
