package com.finers.invoicing.common.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * 产品
 */
@Setter
@Getter
public class ProductBak {
    /**
     * id
     */
    private String id;
    /**
     * 名称
     */
    private String name;
    /**
     * 类型
     */
    private String productType;
    /**
     * 描述
     */
    private String description;
    /**
     * 整件进价
     */
    private Double unitPurchasePrice;
    /**
     * 整件中单品数量
     */
    private Integer unitCount;
    /**
     * 单个进价
     */
    private Double singlePurchasePrice;
    /**
     * 整件售价
     */
    private Double unitSalePrice;
    /**
     * 单个售价
     */
    private Double singleSalePrice;
    /**
     * 用户id
     */
    private String userId;
    /**
     * 用户名称
     */
    private String userName;

}
