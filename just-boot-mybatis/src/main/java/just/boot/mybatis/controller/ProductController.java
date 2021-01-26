package just.boot.mybatis.controller;

import just.boot.mybatis.entity.Product;
import just.boot.mybatis.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Tenton Lien
 */
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("{id}")
    public Product retrieveProductInfo(@PathVariable String id) {
        return productService.getOne(id);
    }
}
