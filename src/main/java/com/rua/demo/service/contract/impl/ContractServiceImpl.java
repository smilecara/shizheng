package com.rua.demo.service.contract.impl;

import com.github.pagehelper.PageInfo;
import com.rua.demo.entity.contract.ContractDTO;
import com.rua.demo.entity.contract.ContractRequestDTO;
import com.rua.demo.mapper.contract.ContractMapper;
import com.rua.demo.service.contract.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ContractServiceImpl implements ContractService {

    @Autowired
    private ContractMapper contractMapper;

    @Override
    public PageInfo<ContractDTO> listContracts(ContractRequestDTO contractRequestDTO) {
        return null;
    }

    @Override
    public int createContract(ContractDTO contractDTO) {
        return contractMapper.createContract(contractDTO);
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
