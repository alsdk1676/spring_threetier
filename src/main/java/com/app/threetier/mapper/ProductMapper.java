package com.app.threetier.mapper;

import com.app.threetier.domain.ProductVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface ProductMapper {

//    상품 등록
    public void insert(ProductVO productVO);

//    상품 단일 조회
    public Optional<ProductVO> select(Long id);

//    상품 전체 조회
    public List<ProductVO> selectAll();

}
