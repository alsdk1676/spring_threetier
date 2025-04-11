package com.app.threetier.domain;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
@Data
public class MemberVO implements Serializable { // Serializable : 직렬화가 되는 객체
    private Long id;
    private String memberEmail;
    private String memberPassword;
    private String memberName;
}
