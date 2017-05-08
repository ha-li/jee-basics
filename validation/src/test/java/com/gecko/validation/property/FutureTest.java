package com.gecko.validation.property;

import com.gecko.test.beans.TestBean;
import com.gecko.validation.UniversalValidator;
import org.junit.Test;

import javax.validation.ConstraintViolationException;
import java.util.Calendar;

/**
 * Created by hlieu on 04/29/17.
 */
public class FutureTest {

   @Test
   public void test_future () {
      TestBean bean = new TestBean ();

      Calendar calendar = Calendar.getInstance ();
      calendar.set(Calendar.YEAR, 2017);
      calendar.set(Calendar.DAY_OF_MONTH, 21);
      calendar.set(Calendar.MONTH, 8);
      bean.setOffload (calendar.getTime ());

      UniversalValidator.validate (bean);
   }

   @Test(expected = ConstraintViolationException.class)
   public void test_past () {
      TestBean bean = new TestBean ();

      Calendar calendar = Calendar.getInstance ();
      calendar.set(Calendar.YEAR, 2016);
      calendar.set(Calendar.DAY_OF_MONTH, 21);
      calendar.set(Calendar.MONTH, 8);
      bean.setOffload (calendar.getTime ());

      UniversalValidator.validate (bean);
   }

   @Test(expected = ConstraintViolationException.class)
   public void test_created_date_future () {
      TestBean bean = new TestBean ();

      Calendar calendar = Calendar.getInstance ();
      calendar.set(Calendar.YEAR, 2019);
      calendar.set(Calendar.DAY_OF_MONTH, 21);
      calendar.set(Calendar.MONTH, 8);
      bean.setCreatedDate (calendar.getTime ());

      UniversalValidator.validate (bean);
   }

   @Test//(expected = ConstraintViolationException.class)
   public void test_created_date_past () {
      TestBean bean = new TestBean ();

      Calendar calendar = Calendar.getInstance ();
      calendar.set(Calendar.YEAR, 2016);
      calendar.set(Calendar.DAY_OF_MONTH, 21);
      calendar.set(Calendar.MONTH, 8);
      bean.setCreatedDate (calendar.getTime ());

      UniversalValidator.validate (bean);
   }
}
