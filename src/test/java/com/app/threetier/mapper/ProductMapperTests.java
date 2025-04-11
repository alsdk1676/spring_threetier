package com.app.threetier.mapper;

import com.app.threetier.domain.ProductVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class ProductMapperTests {

    @Autowired
    private ProductMapper productMapper;

    @Test
    public void productInsert() {
        ProductVO productVO = new ProductVO();
        productVO.setProductName("상품5");
        productVO.setProductPrice(300000);
        productVO.setProductBrand("브랜드5");
        productMapper.insert(productVO);
    }

    @Test
    public void productSelect(){
    }
}
