package com.zzy.sml.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zzy.sml.domain.Advpos;
import com.zzy.sml.mapper.TestMapper;

@Service
public class TestService {

    @Autowired
    TestMapper testMapper;

    public Advpos findAdvposById(int id) {
        return testMapper.findAdvposById(id);
    }

}
