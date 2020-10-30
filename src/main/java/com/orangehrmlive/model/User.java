package com.orangehrmlive.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
@ToString(of = {"username", "password"})
public class User extends BaseMenuItem {
    private Integer id;
    private String employeeName;
    private String username;
    private String password;
}
