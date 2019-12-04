package com.rua.demo.service.contract.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rua.demo.entity.contract.ContractDTO;
import com.rua.demo.entity.contract.ContractRequestDTO;
import com.rua.demo.entity.contract.SubContractDTO;
import com.rua.demo.mapper.contract.ContractMapper;
import com.rua.demo.mapper.contract.SubContractMapper;
import com.rua.demo.service.contract.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ContractServiceImpl implements ContractService {

    @Autowired
    private ContractMapper contractMapper;

    @Autowired
    private SubContractMapper subContractMapper;

    @Override
    public PageInfo<ContractDTO> listContracts(ContractRequestDTO contractRequestDTO) {
        PageHelper.startPage(contractRequestDTO.getPageNum(), contractRequestDTO.getPageSize());
        List<ContractDTO> contractDTOS = contractMapper.listContracts(contractRequestDTO);
        PageInfo<ContractDTO> contractDTOPageInfo = new PageInfo<>(contractDTOS);
        return contractDTOPageInfo;
    }

    @Override
    public int createContract(ContractDTO contractDTO) {
        return contractMapper.createContract(contractDTO);
    }

    @Override
    public int updateContract(ContractDTO contractDTO) {
        return contractMapper.updateContract(contractDTO);
    }

    @Override
    public ContractDTO getContractByContractUid(String contractUid) {
        return contractMapper.getContractByContractUid(contractUid);
    }

    @Override
    public int createSubContract(SubContractDTO subContractDTO) {
        return subContractMapper.createSubContract(subContractDTO);
    }
}
