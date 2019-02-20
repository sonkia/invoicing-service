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

    /**
     * 新增
     * @param productType
     * @return
     */
    @Override
    public Reply add(ProductType productType) {
        productType.setId(Generator.genUUID());
        productTypeMapper.add(productType);
        return ReplyUtil.success();
    }

    /**
     * 更新
     * @param productType
     * @return
     */
    @Override
    public Reply update(ProductType productType) {
        productTypeMapper.update(productType);
        return ReplyUtil.success();
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @Override
    public Reply delete(String id) {
        productTypeMapper.delete(id);
        return ReplyUtil.success();
    }

    /**
     * 分页查询列表
     * @param condition
     * @param pageNo
     * @param pageSize
     * @return
     */
    @Override
    public Reply list(String condition,Integer pageNo,Integer pageSize) {
        return ReplyUtil.success(productTypeMapper.list(condition,(pageNo - 1) * pageSize,pageSize));
    }

    /**
     * 查询名称列表
     * @return
     */
    @Override
    public Reply listProductTypeNames() {
        return ReplyUtil.success(productTypeMapper.getProductTypeNames());
    }

    /**
     * 检查重名
     * @param name
     * @param id
     * @return
     */
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

    /**
     * 检查重复code
     * @param code
     * @param id
     * @return
     */
    @Override
    public Reply checkCodeRepeat(String code, String id) {
        Reply reply = ReplyUtil.success();
        Integer count = productTypeMapper.checkCodeRepeat(code,id);
        reply.setData(false);
        if(count > 0) {
            reply.setData(true);
        }
        return reply;
    }
}

