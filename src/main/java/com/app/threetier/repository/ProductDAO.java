package com.app.threetier.repository;

import com.app.threetier.domain.ProductVO;
import com.app.threetier.mapper.ProductMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class ProductDAO {
    private final ProductMapper productMapper;

//    상품 등록
    public void save(ProductVO productVO) {
        productMapper.insert(productVO);
    }

//    상품 조회
    public Optional<ProductVO> findById(Long id) {
        return productMapper.select(id);
    }

//    상품 전체 조회
    public List<ProductVO> findAll() {
        return productMapper.selectAll();
    }

}
