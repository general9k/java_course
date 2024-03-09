package ru.rodionov.servlets.server.validator;

import ru.rodionov.servlets.server.dto.CreateUserDTO;
import ru.rodionov.servlets.server.entity.Gender;
import ru.rodionov.servlets.server.util.LocalDateFormatter;

public class CreateUserValidator implements Validator<CreateUserDTO> {
    public static final CreateUserValidator INSTANCE = new CreateUserValidator();

    @Override
    public ValidationResult isValid(CreateUserDTO object) {
        ValidationResult validationResult = new ValidationResult();
        if (!LocalDateFormatter.isValid(object.getBirthday())) {
            validationResult.add(Error.of("invalid birthday", "Birthday is invalid"));
        }
        if (Gender.find(object.getGender()).isEmpty()) {
            validationResult.add(Error.of("invalid.gender", "Gender is invalid"));
        }
        return validationResult;
    }

    public static CreateUserValidator getInstance() {
        return INSTANCE;
    }
}
