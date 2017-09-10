package com.springboot.app.persistence.mappers;

import com.springboot.app.persistence.models.TestModel;
import java.util.List;


public interface TestMapper
{

  public List<TestModel> testMapper(TestModel obj) throws Exception;

}
