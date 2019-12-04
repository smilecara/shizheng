package com.rua.demo.mapper.contract;

import com.rua.demo.entity.contract.ContractDTO;
import com.rua.demo.entity.contract.ContractRequestDTO;
import com.rua.demo.entity.contract.SubContractDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ContractMapper {
    List<ContractDTO> listContracts(ContractRequestDTO contractRequestDTO);

    int createContract(ContractDTO contractDTO);

    int updateContract(ContractDTO contractDTO);

    ContractDTO getContractByContractUid(String contractUid);

    int createSubContract(SubContractDTO subContractDTO);
}
