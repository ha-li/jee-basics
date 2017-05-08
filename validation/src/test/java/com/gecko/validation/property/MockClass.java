package com.gecko.validation.property;

import javax.validation.constraints.AssertTrue;

/**
 * Created by hlieu on 04/29/17.
 */
public class MockClass {

   @AssertTrue
   public Boolean getTrue (boolean switchBoolean) {
      return Boolean.FALSE;
   }
}
