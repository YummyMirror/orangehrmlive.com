package com.orangehrmlive.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
@ToString(of = {"id", "title"})
public class JobTitle {
    private Integer id;
    private String title;
    private String description;
}
