package com.finers.invoicing.common;

import lombok.Getter;
import lombok.Setter;

/**
 * 分页
 */
@Setter
@Getter
public class Pagination {
    /**
     * 每页数量
     */
    private int pageSize;
    /**
     * 页码
     */
    private int pageNo;
    /**
     * 总数
     */
    private int total;

}
