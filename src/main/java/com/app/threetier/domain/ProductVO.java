package com.app.threetier.domain;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class ProductVO {
    private Long id;
    private String productName;
//    Integer도 가능 (매핑 더 잘된다!)
//    검증할 때 null로 비교하기 위해서 int -> Integer
//    클래스 타입의 기본 값이 null
    private int productPrice;
    private int productStock;
    private String productBrand;
}
