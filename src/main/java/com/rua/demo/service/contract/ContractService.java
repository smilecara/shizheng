package com.rua.demo.service.contract;

import com.github.pagehelper.PageInfo;
import com.rua.demo.entity.contract.ContractDTO;
import com.rua.demo.entity.contract.ContractRequestDTO;
import com.rua.demo.entity.contract.SubContractDTO;

public interface ContractService {
    PageInfo<ContractDTO> listContracts(ContractRequestDTO contractRequestDTO);

    int createContract(ContractDTO contractDTO);

    int updateContract(ContractDTO contractDTO);

    ContractDTO getContractByContractUid(String contractUid);

    int createSubContract(SubContractDTO subContractDTO);
}
