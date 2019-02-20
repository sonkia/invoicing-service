package com.finers.invoicing.handler.command;

import com.finers.invoicing.common.Reply;
import com.finers.invoicing.common.entity.Product;
import com.finers.invoicing.common.entity.ProductType;
import com.finers.invoicing.service.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/invoicing/product/type")
public class ProductTypeCommand {

    @Autowired
    ProductTypeService productTypeService;

    /**
     * 新增
     * @param productType
     * @return
     */
    @PostMapping
    public Reply add(@RequestBody ProductType productType) {
        return productTypeService.add(productType);
    }

    /**
     * 修改
     * @param productType
     * @return
     */
    @PutMapping
    public Reply update(@RequestBody ProductType productType) {
        return productTypeService.update(productType);
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public Reply delete(@PathVariable String id) {
        return productTypeService.delete(id);
    }
}
