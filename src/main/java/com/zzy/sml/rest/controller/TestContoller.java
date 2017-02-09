package com.zzy.sml.rest.controller;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zzy.sml.domain.Advpos;
import com.zzy.sml.service.TestService;

@RestController
@RequestMapping(value = "/api/v1/test")
public class TestContoller {
    
    @Autowired
    private Logger logger;
    @Autowired
    private TestService testService;

    @RequestMapping(path = "/advpos/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Advpos query(@PathVariable int id) {
        logger.info("id is {}", id);
        Advpos advpos = testService.findAdvposById(id);
        return advpos;
    }
}
