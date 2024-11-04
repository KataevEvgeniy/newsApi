package org.kataew.newsapi.dtos;

import lombok.Data;

@Data
public class SignUpRequest {
    private String username;
    private String password;
}
