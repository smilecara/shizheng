package com.rua.demo.entity.contract;

import com.alibaba.fastjson.annotation.JSONField;
import com.rua.demo.common.PageableRequestDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ContractRequestDTO extends PageableRequestDTO {
    @JSONField(name = "project_name")
    private String projectName;
}
