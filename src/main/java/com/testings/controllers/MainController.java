package com.testings.controllers;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/rest/strings")
public class MainController {

    public List<String> strings;
    public static final List<String> animals = Arrays.asList("Dog, Cat, Lion");
    public static final List<String> continets = Arrays.asList("Europe, South America, Africa");

    @GetMapping
    public List<String> getListOfSomeStrings() {
        strings = new ArrayList<>();
        strings.addAll(animals);
        strings.addAll(continets);
        return strings;
    }

    @PostMapping
    public List<String> setListOfSomeStrings(@RequestBody Map<String, String> params) {
        strings = new ArrayList<>();
        strings.add(params.getOrDefault("input", ""));
        return strings;
    }

    @RequestMapping("/animals")
    public List<String> getListOfAnimals() {
        strings = new ArrayList<>();
        strings.addAll(Arrays.asList("Dog, Cat, Lion"));
        return strings;
    }


}
