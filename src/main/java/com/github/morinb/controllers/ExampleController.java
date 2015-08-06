package com.github.morinb.controllers;

import com.github.morinb.dtos.ExampleData;
import com.github.morinb.services.ExampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Baptiste on 06/08/2015.
 */
@RestController
public class ExampleController {
    @Autowired
    private ExampleService service;

    @RequestMapping("/exampleData")
    public List<ExampleData> example() {
        return service.getExampleDatas();
    }
}
