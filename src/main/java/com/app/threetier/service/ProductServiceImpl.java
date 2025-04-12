package com.app.threetier.service;

import com.app.threetier.domain.ProductVO;
import com.app.threetier.repository.ProductDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductDAO productDAO;

//    상품 등록
    @Override
    public void write(ProductVO productVO) {
        productDAO.save(productVO);
    }

//    상품 단일 조회
    @Override
    public Optional<ProductVO> getProductById(Long id) {
        return productDAO.findById(id);
    }

//    상품 전체 조회
    @Override
    public List<ProductVO> getListProduct() {
        return productDAO.findAll();
    }
}
