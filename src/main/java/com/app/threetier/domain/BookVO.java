package com.app.threetier.domain;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class BookVO {
    private Long id;
    private String bookTitle;
    private String bookAuthor;
    private int bookPrice;
    private int bookStock;
}
