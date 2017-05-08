package com.gecko.validation;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.executable.ExecutableValidator;
import javax.validation.metadata.BeanDescriptor;
import java.io.PrintStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Set;

/**
 * Created by hlieu on 04/28/17.
 */
public class UniversalValidator {

   // private static UniversalValidator mInstance;
   private static ValidatorFactory validatorFactory;
   private static Validator validator;
   private static ExecutableValidator methodValidator;

   static {
      validatorFactory = Validation.buildDefaultValidatorFactory ();
      validator = validatorFactory.getValidator ();
      // mInstance = newInstance ();
   }

   /* public static UniversalValidator newInstance () {
      if (mInstance == null) {
         mInstance = new UniversalValidator ();
      }
      return mInstance;
   } */

   // do some validation 101
   public static <T> void validate (T t) {
      Set<ConstraintViolation<T>> violations = validator.validate(t);
      if(!violations.isEmpty ()) {
         throw new ConstraintViolationException ("Invalid object based on constraints.", violations);
      }
   }

   public static <T> void validateProperty (T t, String propertyName, Class<?> ... groups) {
      Set<ConstraintViolation<T>> violations = validator.validateProperty (t, propertyName, groups);
      if (!violations.isEmpty()) {
         throw new ConstraintViolationException ( "Invalid property based on constraints. ", violations);
      }
   }

   public static <T> void validateValue (Class<T> beanType, String propertyName, Object value, Class<?>... groups)  {
      Set<ConstraintViolation<T>> violations = validator.validateValue (beanType, propertyName, value, groups);
      if ( !violations.isEmpty() ) {
         throw new ConstraintViolationException ( "Invalid value based on constraints. ", violations);
      }
   }

   public static <T> BeanDescriptor constraints (T t) {
      return validator.getConstraintsForClass (t.getClass());
   }

   public static void violation (ConstraintViolationException exception, PrintStream out) {
      for (ConstraintViolation violation : exception.getConstraintViolations ()) {
         out.println (violation.getRootBeanClass () + ": " + violation.getPropertyPath () + " " + violation.getMessage ());
      }
   }

   private static ExecutableValidator forExecutables () {
      return validator.forExecutables ();
   }

   public static <T> void validateParameters (T t, Method method, Object[] parameterValues, Class<?>... groups) {
      if (methodValidator == null) {
         methodValidator = forExecutables ();
      }

      Set<ConstraintViolation<T>> violations = methodValidator.validateParameters(t,method, parameterValues, groups);
      if (!violations.isEmpty() ) {
         throw new ConstraintViolationException ("Invalid method parameters. ", violations);
      }
   }

   public static <T> void validateReturnValue (T t, Method method, Object returnValue, Class<?>... groups) {
      if (methodValidator == null) {
         methodValidator = forExecutables ();
      }

      Set<ConstraintViolation<T>> violations = methodValidator.validateReturnValue(t, method, returnValue, groups);
      if (!violations.isEmpty() ) {
         throw new ConstraintViolationException ("Invalid method return value. ", violations);
      }
   }

   public static <T> void validateConstructorParameters (Constructor<? extends T> constructor, Object[] parameterValues, Class<?>... groups) {
      if (methodValidator == null) {
         methodValidator = forExecutables ();
      }

      Set<ConstraintViolation<T>> violations = methodValidator.validateConstructorParameters(constructor, parameterValues, groups);
      if (!violations.isEmpty() ) {
         throw new ConstraintViolationException ("Invalid method return value. ", violations);
      }
   }

   public static <T> void validateConstructorReturnValue (Constructor<? extends T> constructor, T createdObject, Class<?>... groups) {
      if (methodValidator == null) {
         methodValidator = forExecutables ();
      }

      Set<ConstraintViolation<T>> violations = methodValidator.validateConstructorReturnValue(constructor, createdObject, groups);
      if (!violations.isEmpty() ) {
         throw new ConstraintViolationException ("Invalid method return value. ", violations);
      }
   }

   public static void destroy () {
      validatorFactory.close();
   }
}
