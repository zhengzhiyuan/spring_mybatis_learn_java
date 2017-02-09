package com.zzy.sml.mapper;

import org.springframework.stereotype.Component;

import com.zzy.sml.domain.Advpos;

@Component
public interface TestMapper {

    public Advpos findAdvposById(int id);

    // public List<Advpos> findAdvposByIssueType(int issueType);
    //
    // public int addAdvpos(Advpos advpos);
}
