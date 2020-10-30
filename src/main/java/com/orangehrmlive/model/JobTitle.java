package com.orangehrmlive.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
@ToString(of = {"title"})
@EqualsAndHashCode(of = {"title"}, callSuper = false)
public class JobTitle extends BaseMenuItem {
    private Integer id;
    private String title;
    private String description;
    private String note;
}
