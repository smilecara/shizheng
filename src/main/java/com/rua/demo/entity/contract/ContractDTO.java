package com.rua.demo.entity.contract;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
public class ContractDTO {
    @JSONField(name = "contract_uid")
    private String contractUid;
    @JSONField(name = "project_name")
    private String projectName;
    @JSONField(name = "tech_budget")
    private BigDecimal techBudget;
    @JSONField(name = "settle_budget")
    private BigDecimal settleBudget;
    @JSONField(name = "extra_budget")
    private BigDecimal extraBudget;
    @JSONField(name = "total_budget")
    private BigDecimal totalBudget;
    @JSONField(name = "organizer_advice")
    private String organizerAdvice;
    @JSONField(name = "start_date", format = "yyyy-MM-dd")
    private Date startDate;
    @JSONField(name = "end_date", format = "yyyy-MM-dd")
    private Date endDate;
    @JSONField(name = "archive")
    private Integer archive;

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
