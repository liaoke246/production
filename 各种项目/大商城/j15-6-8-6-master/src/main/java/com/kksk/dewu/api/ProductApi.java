package com.kksk.dewu.api;

import com.kksk.dewu.model.Product;
import com.kksk.dewu.service.ProductService;
import com.kksk.dewu.model.Paging;
import com.kksk.dewu.model.Result;
import com.kksk.dewu.param.BasePageParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/api/product")
@Controller
public class ProductApi {

    @Autowired
    private ProductService productService;

    @ResponseBody
    @GetMapping("/page")
    public Result<Paging<Product>> pageQuery(BasePageParam param) {

        Result<Paging<Product>> result = new Result<>();

        result.setSuccess(true);
        result.setData(productService.pageQueryProduct(param));
        return result;
    }

}
