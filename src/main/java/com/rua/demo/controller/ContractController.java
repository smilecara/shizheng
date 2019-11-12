package com.rua.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import static org.springframework.web.bind.annotation.RequestMethod.GET;


@Controller
@RequestMapping(value = "/contract")
public class ContractController {


    @RequestMapping(value = "/list-parent", method = GET)
    public String listParent() {

        return "list-parent";
    }

    @RequestMapping(value = "/list-child", method = GET)
    public String listChild() {

        return "list-child";
    }

    @RequestMapping(value = "/form-parent", method = GET)
    public String formParent() {

        return "form-parent";
    }

    @RequestMapping(value = "/form-child", method = GET)
    public String formChild() {

        return "form-child";
    }


    @ResponseBody
    @RequestMapping(value = "/parentData", method = GET)
    public String parentData() {

        return "{\"code\":0,\"msg\":\"\",\"count\":1000,\"data\":[" +
                "{\"project_name\":\"市一路\",\"start_date\":\"2019-11-11\",\"end_date\":\"2019-11-14\",\"balance\":\"100\",\"total_budget\":\"500\",\"tech_budget\":200,\"settle_budget\":200,\"extra_budget\":100}, " +
                "{\"project_name\":\"市二路\",\"start_date\":\"2019-11-11\",\"end_date\":\"2019-11-22\",\"balance\":\"100\",\"total_budget\":\"500\",\"tech_budget\":200,\"settle_budget\":200,\"extra_budget\":100}," +
                "{\"project_name\":\"市三路\",\"start_date\":\"2019-11-10\",\"end_date\":\"2019-12-12\",\"balance\":\"100\",\"total_budget\":\"500\",\"tech_budget\":200,\"settle_budget\":200,\"extra_budget\":100}   ]}";
    }

    @ResponseBody
    @RequestMapping(value = "/childData", method = GET)
    public String childData() {

        return "{\"code\":0,\"msg\":\"\",\"count\":1000,\"data\":[" +
                "{\"project_name\": \"市一路\",\"project_type\": \"技术\",\"part_a\":\"甲方1\",\"part_b\":\"乙方1\",\"cost\":200,\"start_date\":\"2019-11-11\",\"end_date\":\"2019-11-11\",\"created_person\":\"张三\",\"checked_person\":\"李四\",\"sign_date\":\"2019-11-11\"}, " +
                "{\"project_name\": \"市二路\",\"project_type\": \"技术\",\"part_a\":\"甲方1\",\"part_b\":\"乙方1\",\"cost\":200,\"start_date\":\"2019-11-11\",\"end_date\":\"2019-11-11\",\"created_person\":\"张三\",\"checked_person\":\"李四\",\"sign_date\":\"2019-11-11\"}, " +
                "{\"project_name\": \"市三路\",\"project_type\": \"技术\",\"part_a\":\"甲方1\",\"part_b\":\"乙方1\",\"cost\":200,\"start_date\":\"2019-11-11\",\"end_date\":\"2019-11-11\",\"created_person\":\"张三\",\"checked_person\":\"李四\",\"sign_date\":\"2019-11-11\"}   ]}";
    }

    @ResponseBody
    @RequestMapping(value = "/data", method = GET)
    public String data() {

        return null;
    }

}