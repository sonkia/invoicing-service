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

    @PostMapping
    public Reply add(@RequestBody Product product) {
        return productService.add(product);
    }

    @PutMapping
    public Reply update(@RequestBody Product product) {
        return null;
    }

    @DeleteMapping("/id")
    public Reply delete(@PathVariable String id) {
        return null;
    }
}
