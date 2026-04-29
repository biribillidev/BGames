package fiap.com.br.bgames.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.List;

public class PlatformValidator implements ConstraintValidator<ValidPlatform, String> {

    private static final List<String> PLATFORMS = List.of(
            "PC",
            "PlayStation",
            "Xbox",
            "Nintendo Switch"
    );

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        if (value == null) {
            return true; // deixa o @NotNull cuidar disso
        }

        return PLATFORMS.stream()
                .anyMatch(p -> p.equalsIgnoreCase(value));
    }
}