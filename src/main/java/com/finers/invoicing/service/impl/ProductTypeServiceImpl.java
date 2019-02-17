package com.finers.invoicing.service.impl;

import com.finers.invoicing.common.Reply;
import com.finers.invoicing.common.entity.ProductType;
import com.finers.invoicing.common.mapper.ProductTypeMapper;
import com.finers.invoicing.service.ProductTypeService;
import com.finers.invoicing.utils.Generator;
import com.finers.invoicing.utils.ReplyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductTypeServiceImpl implements ProductTypeService {

    @Autowired
    ProductTypeMapper productTypeMapper;

    @Override
    public Reply add(ProductType productType) {
        productType.setId(Generator.genUUID());
        productTypeMapper.add(productType);
        return ReplyUtil.success();
    }

    @Override
    public Reply list(String condition,Integer pageNo,Integer pageSize) {
        return ReplyUtil.success(productTypeMapper.list(condition,(pageNo - 1) * pageSize,pageSize));
    }

    @Override
    public Reply listProductTypeNames() {
        return ReplyUtil.success(productTypeMapper.getProductTypeNames());
    }

    @Override
    public Reply checkNameRepeat(String name, String id) {
        Reply reply = ReplyUtil.success();
        Integer count = productTypeMapper.checkNameRepeat(name,id);
        reply.setData(false);
        if(count > 0) {
            reply.setData(true);
        }
        return reply;
    }
}

