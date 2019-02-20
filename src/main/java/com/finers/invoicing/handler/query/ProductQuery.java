package com.finers.invoicing.handler.query;

import com.finers.invoicing.common.Reply;
import com.finers.invoicing.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Component
@RestController
@RequestMapping("/api/invoicing/product")
public class ProductQuery {

    @Autowired
    ProductService productService;

    /**
     * 获取列表
     * @param condition
     * @param pageNo
     * @param pageSize
     * @return
     */
    @GetMapping
    public Reply list(@RequestParam String condition,@RequestParam Integer pageNo,@RequestParam Integer pageSize) {
        if(pageNo == null || pageNo <= 0){
            pageNo = 1;
        }
        if(pageSize == null || pageSize <= 0){
            pageSize = 20;
        }
        return productService.list(condition,pageNo,pageSize);
    }

    /**
     * 检查重名
     * @param name
     * @param id
     * @return
     */
    @GetMapping("/name/repeat")
    public Reply list(@RequestParam String name, @RequestParam String id) {

        return productService.checkNameRepeat(name,id);
    }

    /**
     * 查询重复code
     * @param code
     * @param id
     * @return
     */
    @GetMapping("/code/repeat")
    public Reply checkCodeRepeat(@RequestParam String code, @RequestParam String id) {

        return productService.checkCodeRepeat(code,id);
    }
}
