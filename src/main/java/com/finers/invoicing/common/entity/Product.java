package com.finers.invoicing.common.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * 产品
 */
@Setter
@Getter
public class Product {
    /**
     * id
     */
    private String id;
    /**
     * 名称
     */
    private String name;
    /**
     * 编码
     */
    private String code;
    /**
     * 类型
     */
    private String productType;
    /**
     * 描述
     */
    private String description;
    /**
     * 整件中单品数量
     */
    private Integer unitCount;

}
