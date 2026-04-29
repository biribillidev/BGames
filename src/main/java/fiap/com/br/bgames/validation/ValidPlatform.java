package fiap.com.br.bgames.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = PlatformValidator.class)
@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidPlatform {

    String message() default "Plataforma deve ser: PC, PlayStation, Xbox ou Nintendo Switch";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}