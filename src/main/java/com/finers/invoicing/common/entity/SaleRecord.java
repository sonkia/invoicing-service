package com.finers.invoicing.common.entity;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

/**
 * 销售产品
 */
@Setter
@Getter
public class SaleRecord {
    /**
     * id
     */
    private String id;
    /**
     * 商品名称
     */
    private String productName;
    /**
     * 商品id
     */
    private String productId;
    /**
     * 整件销售数量
     */
    private Integer unitSaleCount;
    /**
     * 单品销售数量
     */
    private Integer singleSaleCount;
    /**
     * 售价额
     */
    private Double saleroom;
    /**
     * 利润
     */
    private Double profit;
    /**
     * 用户id
     */
    private String userId;
    /**
     * 用户名称
     */
    private String userName;
    /**
     * 用户名称
     */
    private Timestamp createdTime;


}
