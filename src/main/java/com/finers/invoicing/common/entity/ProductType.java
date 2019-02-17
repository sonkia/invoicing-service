package com.finers.invoicing.common.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * 产品类型
 */
@Setter
@Getter
public class ProductType {
    /**
     * id
     */
    private String id;
    /**
     * 名称
     */
    private String name;
    /**
     * 产品类型编码
     */
    private String code;
    /**
     * 描述
     */
    private String description;

}
