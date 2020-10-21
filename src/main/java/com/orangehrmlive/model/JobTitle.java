package com.orangehrmlive.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.File;

@Getter
@Setter
@Accessors(chain = true)
@ToString(of = {"id", "title"})
@EqualsAndHashCode(of = {"id", "title"})
public class JobTitle {
    private Integer id;
    private String title;
    private String description;
    private String specification;
    private String note;

    public File getSpecification() {
        return new File(specification);
    }

    public JobTitle setSpecification(File specification) {
        this.specification = specification.getPath();
        return this;
    }
}
