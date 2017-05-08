package com.gecko.constraints;

import com.gecko.constraints.validator.NonMethodValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by hlieu on 04/29/17.
 */
@Target (value = {FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER})
@Retention (RUNTIME)
@Documented
@Constraint (validatedBy = NonMethodValidator.class)
public @interface NonMethod {
   String message () default "applies to non methods only";
   Class<?> [] groups () default {};
   Class <? extends Payload>[] payload () default {};
}
