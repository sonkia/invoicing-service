package com.finers.invoicing.service;

import com.finers.invoicing.common.Reply;
import com.finers.invoicing.common.entity.ProductType;
import org.springframework.stereotype.Service;

@Service
public interface ProductTypeService {

    Reply add(ProductType productType);

    Reply list(String condition, Integer pageNo, Integer pageSize);

    Reply listProductTypeNames();

    Reply checkNameRepeat(String name,String id);
}
