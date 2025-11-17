package com.quicklunch.store.dto;

import com.quicklunch.store.common.utils.JsonUtils;
import jakarta.validation.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ValidationTest {
    
    private static Validator validator;

    @BeforeEach
    public void setUp() {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        validator = validatorFactory.getValidator();
    }

    @Test
    public void validateTest() {


        Car car = new Car(
                List.of(new Part()),
                List.of("a", ""),
                null);

        Map<String, String> errorMessages = new HashMap<>();
        for (ConstraintViolation<Car> violation : validator.validate(car)) {
            errorMessages.put(violation.getPropertyPath().toString(),
                    violation.getMessage());

        }

        System.out.println(JsonUtils.toJson(errorMessages));

    }
}

class Car {

    private List<Part> partList;

    private List<String> nameList;

    @Digits()
    private GearBox gearBox;

    public Car(List<Part> partList, List<String> nameList, GearBox gearBox) {
        this.partList = partList;
        this.nameList = nameList;
        this.gearBox = gearBox;
    }
}


class Part {
    @NotBlank(message = "car part name must not be null")
    private String name;
}


class GearBox {
    @NotBlank
    private String name;
}
