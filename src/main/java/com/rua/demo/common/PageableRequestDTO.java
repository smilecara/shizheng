package com.rua.demo.common;

import com.alibaba.fastjson.annotation.JSONField;
import com.rua.demo.common.enumeration.SortOrderEnum;
import org.apache.commons.lang3.EnumUtils;
import org.apache.commons.lang3.StringUtils;

public class PageableRequestDTO {
    
    @JSONField(name = "page_no")
    private Integer pageNo;
    
    @JSONField(name = "page_size")
    private Integer pageSize;
    
    @JSONField(name = "sort_key")
    private String sortKey;
    
    @JSONField(name = "sort_order")
    private String sortOrder;
    
    public boolean isPageable(){
        return !(null == pageNo || null == pageSize);
    }
    
    public boolean isSortable(){
        return !StringUtils.isBlank(sortKey);
    }
    
    public Integer getPageOffset(){
        if(!isPageable()){
            return 0;
        }
        return (pageNo -1) * pageSize;
    }

    public Integer getPageNo() {
        return null == pageNo ? null : (pageNo > 0 ? pageNo : 1);
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return null == pageSize ? null : (pageSize > 0 ? pageSize : 20);
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getSortKey() {
        return sortKey;
    }

    public void setSortKey(String sortKey) {
        this.sortKey = sortKey;
    }

    public String getSortOrder() {
        if(StringUtils.isBlank(sortOrder)){
            return SortOrderEnum.ASC.name();
        }
        SortOrderEnum order = EnumUtils.getEnum(SortOrderEnum.class, sortOrder.toUpperCase());
        return null == order ? SortOrderEnum.ASC.name() : order.name();
    }

    public void setSortOrder(String sortOrder) {
        this.sortOrder = sortOrder;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("PageableRequestDTO [pageNo=");
        builder.append(pageNo);
        builder.append(", pageSize=");
        builder.append(pageSize);
        builder.append(", sortKey=");
        builder.append(sortKey);
        builder.append(", sortOrder=");
        builder.append(sortOrder);
        builder.append("]");
        return builder.toString();
    }
}
