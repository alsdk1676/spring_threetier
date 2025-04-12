package com.app.threetier.service;

import com.app.threetier.domain.ProductVO;

import java.util.List;
import java.util.Optional;

public interface ProductService {

//    상품 등록
    public void write(ProductVO productVO);

//    상품 단일 조회
    public Optional<ProductVO> getProductById(Long id);

//    상품 전체 조회
    public List<ProductVO> getListProduct();

//    상품 수정
    public void edit(ProductVO productVO);

//    상품 삭제
    public void remove(Long id);

}
