package org.software.productclient.Client;

import lombok.extern.slf4j.Slf4j;
import org.software.productclient.model.Product;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Slf4j
public class ProductServiceFallback implements ProductServiceClient{
    @Override
    public Product findByProductId(Long productId) {
        log.info("findByProductId callback");
        return null;
    }

    @Override
    public List<Product> queryAllProduct() {
        log.info("queryAllProduct callback");
        return null;
    }

    @Override
    public List<Product> queryAll() {
        return null;
    }
}
