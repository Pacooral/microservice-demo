package org.software.productservice.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.software.productservice.mapper.ProductMapper;
import org.software.productservice.po.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@Slf4j
public class ProductController {
    private final ProductMapper productMapper;

    @GetMapping("/findByProductId/{productId}")
    public Product findByProductId(@PathVariable Long productId) throws InterruptedException {
        Product product = productMapper.findByProductId(productId);
        //Thread.sleep(2000);
        log.info("-------------OK /findByProductId/{productId}--------------------");
        log.info("product="+product.toString());
        return product;
    }

    @GetMapping("/queryAllProduct")
    public List<Product> findByProductId(){
        List<Product> productList = productMapper.queryAllProduct();
        log.info("-------------OK queryAllProduct--------------------");
        return productList;
    }
}
