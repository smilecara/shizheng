package com.rua.demo.entity.contract;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
public class SubContractDTO {
    @JSONField(name = "contract_uid")
    private String contractUid;
    @JSONField(name = "parent_contract_uid")
    private String parentContractUid;
    @JSONField(name = "project_name")
    private String projectName;
    @JSONField(name = "project_type")
    private String projectType;
    @JSONField(name = "part_a")
    private String partA;
    @JSONField(name = "part_b")
    private String partB;
    @JSONField(name = "start_date", format = "yyyy-MM-dd")
    private Date startDate;
    @JSONField(name = "end_date", format = "yyyy-MM-dd")
    private Date endDate;
    @JSONField(name = "cost")
    private BigDecimal cost;
    @JSONField(name = "description")
    private String description;
    @JSONField(name = "created_person")
    private String createdPerson;
    @JSONField(name = "checked_person")
    private String checkedPerson;
    @JSONField(name = "sign_date")
    private Date signDate;
    @JSONField(name = "archive")
    private Integer archive;

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
