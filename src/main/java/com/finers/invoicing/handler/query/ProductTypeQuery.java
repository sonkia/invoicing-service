package com.finers.invoicing.handler.query;

import com.finers.invoicing.common.Reply;
import com.finers.invoicing.service.ProductTypeService;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Component
@RestController
@RequestMapping("/api/invoicing/product/type")
public class ProductTypeQuery {

    @Autowired
    ProductTypeService productTypeService;

    @GetMapping
    public Reply list(@RequestParam String condition,@RequestParam Integer pageNo,@RequestParam Integer pageSize) {
        if(pageNo == null || pageNo <= 0){
            pageNo = 1;
        }
        if(pageSize == null || pageSize < 1){
            pageSize = 20;
        }
        return productTypeService.list(condition,pageNo,pageSize);
    }

    @GetMapping("/names")
    public Reply listProductTypeNames() {
        return productTypeService.listProductTypeNames();
    }

    @GetMapping("/name/repeat")
    public Reply list(@RequestParam String name, @RequestParam String id) {

        return productTypeService.checkNameRepeat(name,id);
    }

}
