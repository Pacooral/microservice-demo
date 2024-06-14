package org.example.userservice.po;

import lombok.Data;

@Data
public class User {
    private String userID;

    private String username;

    private String password;

    private String nickname;

    private Integer age;

    private Integer gender;
}
