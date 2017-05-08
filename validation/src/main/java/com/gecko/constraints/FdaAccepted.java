package com.gecko.constraints;

import com.gecko.constraints.impl.FdaAcceptedValidation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by hlieu on 05/7/17.
 */
@Documented
@Target ({ElementType.METHOD, ElementType.CONSTRUCTOR, ElementType.ANNOTATION_TYPE, ElementType.FIELD, ElementType.TYPE})
@Retention (RetentionPolicy.RUNTIME)
@Constraint (validatedBy=FdaAcceptedValidation.class)
public @interface FdaAccepted {
   String message () default "This is not a FDA accepted correction";
   Class <?>[] groups () default {};
   Class <? extends Payload>[] payload () default {};
}
