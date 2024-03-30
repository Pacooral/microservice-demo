package org.software.productclient.Client;

import org.software.productclient.model.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "product-service",fallback = ProductServiceFallback.class)
public interface ProductServiceClient {
    @GetMapping("/findByProductId/{productId}")
    Product findByProductId(@RequestParam(value = "productId") Long productId);

    @GetMapping("queryAllProduct")
    List<Product> queryAllProduct();

    @GetMapping("queryAll")
    List<Product> queryAll();
}
