package com.testings.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/rest/strings")
public class MainController {

    public List<String> strings = new ArrayList<>();

    @GetMapping
    public List<String> getListOfSomeStrings() {
        strings.addAll(Arrays.asList("Dog, Cat, Lion"));
        return strings;
    }

}
