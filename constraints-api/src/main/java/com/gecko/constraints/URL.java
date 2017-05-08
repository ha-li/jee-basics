package com.gecko.constraints;

import com.gecko.constraints.validator.UrlValidationForString;
import com.gecko.constraints.validator.UrlValidationForUrl;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by hlieu on 04/30/17.
 */
@Documented
@Target ({FIELD, ANNOTATION_TYPE, PARAMETER, METHOD, CONSTRUCTOR})
@Retention (RUNTIME)
@Constraint (validatedBy={UrlValidationForString.class, UrlValidationForUrl.class})
public @interface URL {
   //String message () default "Invalid Url";
   String message () default "{com.gecko.constraints.URL.message}";
   Class <?>[] groups () default {};
   Class <? extends Payload>[] payload () default {};

   // define 3 additional annotation attributes to set
   String protocol () default "";
   String host () default "";
   int port () default -1;
}
