package com.zzy.sml.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Advpos {
    private Integer id;
    @JsonProperty("prod_id")
    private Integer prodId;
    private String posName;
    private Integer posType;
    @JsonIgnore
    private Integer isReturn;
    private Integer issueType;
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProdId() {
        return prodId;
    }

    public void setProdId(Integer prodId) {
        this.prodId = prodId;
    }

    public String getPosName() {
        return posName;
    }

    public void setPosName(String posName) {
        this.posName = posName;
    }

    public Integer getPosType() {
        return posType;
    }

    public void setPosType(Integer posType) {
        this.posType = posType;
    }

    public Integer getIsReturn() {
        return isReturn;
    }

    public void setIsReturn(Integer isReturn) {
        this.isReturn = isReturn;
    }

    public Integer getIssueType() {
        return issueType;
    }

    public void setIssueType(Integer issueType) {
        this.issueType = issueType;
    }

}
