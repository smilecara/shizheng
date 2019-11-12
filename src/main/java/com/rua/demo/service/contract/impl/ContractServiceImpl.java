package com.rua.demo.service.contract.impl;

import com.github.pagehelper.PageInfo;
import com.rua.demo.entity.contract.ContractDTO;
import com.rua.demo.entity.contract.ContractRequestDTO;
import com.rua.demo.service.contract.ContractService;
import org.springframework.stereotype.Component;

@Component
public class ContractServiceImpl implements ContractService {
    @Override
    public PageInfo<ContractDTO> listContracts(ContractRequestDTO contractRequestDTO) {
        return null;
    }

    @Override
    public int createContract(ContractDTO contractDTO) {
        return 0;
    }

    @Override
    public int updateContract(ContractDTO contractDTO) {
        return 0;
    }

    @Override
    public ContractDTO getContractByContractUid(String contractUid) {
        return null;
    }
}
