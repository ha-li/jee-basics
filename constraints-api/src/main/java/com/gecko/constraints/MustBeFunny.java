package com.gecko.constraints;

import com.gecko.constraints.validator.MustBeFunnyValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by hlieu on 04/23/17.
 */
@Target ({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER})
@Retention (RUNTIME)
@Documented
@Constraint (validatedBy = MustBeFunnyValidator.class)
public @interface MustBeFunny {

   String message () default "is not \"funny\"";
   Class<?> [] groups () default {};
   Class<? extends Payload>[] payload () default {};

}
