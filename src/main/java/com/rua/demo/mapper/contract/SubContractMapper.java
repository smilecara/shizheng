package com.rua.demo.mapper.contract;

import com.rua.demo.entity.contract.SubContractDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SubContractMapper {
    int createSubContract(SubContractDTO subContractDTO);
}
