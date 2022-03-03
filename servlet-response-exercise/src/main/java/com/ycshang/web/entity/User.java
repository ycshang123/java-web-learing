package com.ycshang.web.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: java-web-learning
 * @description:
 * @author: ycshang
 * @create: 2022-03-03 13:37
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    private String account;
    private String password;
}