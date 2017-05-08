package com.gecko.constraints;

import com.gecko.constraints.impl.PdufaValidation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by hlieu on 05/7/17.
 */
@Documented
@Target ({TYPE})
@Retention (RUNTIME)
@Constraint (validatedBy = {PdufaValidation.class})
public @interface Pdufa {
   String message () default "This trail will not be sent for FDA Approval.";
   Class <?>[] groups () default {};
   Class <? extends Payload>[] payload () default {};

}
