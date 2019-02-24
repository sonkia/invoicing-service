package com.finers.invoicing.service;

import com.finers.invoicing.common.Reply;
import com.finers.invoicing.common.entity.Product;
import org.springframework.stereotype.Service;

@Service
public interface ProductService {

    Reply add(Product product);

    Reply update(Product product);

    Reply delete(String id);

    Reply list(String condition,Integer pageNo,Integer pageSize);

    Reply queryById(String id);

    Reply checkNameRepeat(String name,String id);

    Reply checkCodeRepeat(String code,String id);
}
