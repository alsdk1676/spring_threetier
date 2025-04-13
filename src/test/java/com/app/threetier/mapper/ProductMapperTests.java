package com.app.threetier.mapper;

import com.app.threetier.domain.ProductVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
@Slf4j
public class ProductMapperTests {

    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private ProductVO productVO;

    //    상품 등록
    @Test
    public void productInsert() {
        ProductVO productVO = new ProductVO();
        productVO.setProductName("상품5");
        productVO.setProductPrice(500000);
        productVO.setProductStock(50);
        productVO.setProductBrand("브랜드5");
        productMapper.insert(productVO);
        log.info(productVO.toString());
    }

//    상품 단일 조회
    @Test
    public void productSelect(){
        ProductVO productVO = new ProductVO();
//        productVO.setProductName("상품5");
//        productVO.setProductPrice(500000);
//        productVO.setProductStock(50);
//        productVO.setProductBrand("브랜드5");
        productVO.setId(3L);
        productMapper.select(productVO.getId()).map(ProductVO::toString).ifPresent(log::info);
    }

//    상품 전체 조회
    @Test
    public void productSelectAll(){
        productMapper.selectAll().stream().map(ProductVO::toString).forEach(log::info);
    }

//    상품 수정
    @Test
    public void productUpdate(){
        ProductVO productVO = new ProductVO();
        productVO.setId(2L);
        productVO.setProductName("상품2 수정함");
        productVO.setProductPrice(250000);
        productVO.setProductStock(25);
        productVO.setProductBrand("브랜드2 수정함");
        productMapper.update(productVO);
        log.info(productVO.toString());
    }

}
