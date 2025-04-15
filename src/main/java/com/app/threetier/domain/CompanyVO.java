package com.app.threetier.domain;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class CompanyVO {
//    Date타입은 String으로 받기!
    private Long id;
    private String companyName;
    private String getToWorkDateTime;
    private String leaveWorkDateTime;
}
