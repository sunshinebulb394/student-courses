package com.georgebanin.studentcourses.entity;



import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.springframework.stereotype.Component;


import javax.xml.validation.ValidatorHandler;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class ObjectsValidator<T> {

    private final ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    private final Validator validator = factory.getValidator();

    public void validate (T objectToValidate){
        Set<ConstraintViolation<T>> violationSet = validator.validate(objectToValidate);
        if(!violationSet.isEmpty()){
            var errorMessages = violationSet.stream().map(ConstraintViolation::getMessage).collect(Collectors.toSet());
            throw new ObjectNotValidException(errorMessages);
        }
    }
}
