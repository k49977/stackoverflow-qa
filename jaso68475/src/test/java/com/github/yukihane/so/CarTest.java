package com.github.yukihane.so;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;



public class CarTest {

    private static Validator validator;

    @BeforeAll
    public static void setUpValidator() {
        final ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void manufacturerIsNull() {
        final Car car = new Car(null, "DD-AB-123", 4);

        final Set<ConstraintViolation<Car>> constraintViolations = validator.validate(car);

        assertEquals(1, constraintViolations.size());
        assertEquals("must not be null", constraintViolations.iterator().next().getMessage());
    }

    @Test
    public void licensePlateTooShort() {
        final Car car = new Car("Morris", "D", 4);

        final Set<ConstraintViolation<Car>> constraintViolations = validator.validate(car);

        assertEquals(1, constraintViolations.size());
        assertEquals(
            "size must be between 2 and 14",
            constraintViolations.iterator().next().getMessage());
    }

    @Test
    public void seatCountTooLow() {
        final Car car = new Car("Morris", "DD-AB-123", 1);

        final Set<ConstraintViolation<Car>> constraintViolations = validator.validate(car);

        assertEquals(1, constraintViolations.size());
        assertEquals(
            "must be greater than or equal to 2",
            constraintViolations.iterator().next().getMessage());
    }

    @Test
    public void carIsValid() {
        final Car car = new Car("Morris", "DD-AB-123", 2);

        final Set<ConstraintViolation<Car>> constraintViolations = validator.validate(car);

        assertEquals(0, constraintViolations.size());
    }
}
