package com.finers.invoicing.handler.command;

import com.finers.invoicing.common.Reply;
import com.finers.invoicing.common.entity.Product;
import com.finers.invoicing.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/invoicing/product")
public class ProductCommand {

    @Autowired
    ProductService productService;

    /**
     * 新增
     * @param product
     * @return
     */
    @PostMapping
    public Reply add(@RequestBody Product product) {
        return productService.add(product);
    }

    /**
     * 修改
     * @param product
     * @return
     */
    @PutMapping
    public Reply update(@RequestBody Product product) {
        return productService.update(product);
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public Reply delete(@PathVariable("id") String id) {
        return productService.delete(id);
    }
}
