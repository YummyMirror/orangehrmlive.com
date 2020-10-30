package com.orangehrmlive.page.element.navigationItem;

import com.orangehrmlive.model.BaseMenuItem;

public interface NavigationMenuItem<T extends BaseMenuItem> {
    void create(T menuItem, boolean isValid);

    void update(T menuItem, boolean isValid);

    void delete(T menuItem);
}
