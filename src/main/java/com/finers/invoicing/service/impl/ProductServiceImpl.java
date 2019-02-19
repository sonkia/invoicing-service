package com.finers.invoicing.service.impl;

import com.finers.invoicing.common.Reply;
import com.finers.invoicing.common.entity.Product;
import com.finers.invoicing.common.mapper.ProductMapper;
import com.finers.invoicing.service.ProductService;
import com.finers.invoicing.utils.Generator;
import com.finers.invoicing.utils.ReplyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductMapper productMapper;

    @Override
    public Reply add(Product product) {
        product.setId(Generator.genUUID());
        productMapper.add(product);
        return ReplyUtil.success();
    }

    @Override
    public Reply list(String condition,Integer pageNo,Integer pageSize) {
        return ReplyUtil.success(productMapper.list(condition,(pageNo - 1) * pageSize,pageSize));
    }

    @Override
    public Reply checkNameRepeat(String name, String id) {
        Reply reply = ReplyUtil.success();
        Integer count = productMapper.checkNameRepeat(name,id);
        reply.setData(false);
        if(count > 0) {
            reply.setData(true);
        }
        return reply;
    }
}

