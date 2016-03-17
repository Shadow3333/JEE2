package monapp.utilitaire;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;
import org.primefaces.validate.bean.ClientConstraint;

import EmailClientValidationConstraint.EmailClientValidationConstraint;
import monapp.validators.EmailConstraintValidator;

@Target({METHOD,FIELD,ANNOTATION_TYPE})
@Retention(RUNTIME)
@Constraint(validatedBy=EmailConstraintValidator.class)
@ClientConstraint(resolvedBy=EmailClientValidationConstraint.class)
@Documented
public @interface Email {
    
   String message() default "Invalid Mail";
    
   Class<?>[] groups() default {};

   Class<? extends Payload>[] payload() default {};  
   
}