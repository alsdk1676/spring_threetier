package com.app.threetier.domain;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
@Data
public class UserVO implements Serializable {
    private Long id;
    private String userEmail;
    private String userPassword;
    private String userName;
}
