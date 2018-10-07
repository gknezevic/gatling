package com.testings.controllers;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/rest/numbers")
public class OtherController {

    public List<Number> numbers = new ArrayList<>();

    @GetMapping
    public List<Number> getListOfSomeNumbers() {
        numbers.addAll(Arrays.asList(15, 12223.23, 0));
        return numbers;
    }

}
