package com.orangehrmlive.page.element.navigationItem;

import com.orangehrmlive.annotation.LazyAutowired;
import com.orangehrmlive.annotation.LazyService;
import com.orangehrmlive.page.element.navigationItem.impl.JobTitleComponent;
import com.orangehrmlive.page.element.navigationItem.impl.SystemUserComponent;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

@LazyService
public class NavigationMenuItemFactory {
    private final Map<String, Supplier<NavigationMenuItem>> MAP = new HashMap<>();

    @LazyAutowired
    private JobTitleComponent jobTitleComponent;

    @LazyAutowired
    private SystemUserComponent systemUserComponent;

    public NavigationMenuItemFactory() {
        this.MAP.put("jobTitle", JOB_TITLE_CONSUMER);
        this.MAP.put("systemUser", SYSTEM_USER_CONSUMER);
    }

    private final Supplier<NavigationMenuItem> JOB_TITLE_CONSUMER = () -> this.jobTitleComponent;
    private final Supplier<NavigationMenuItem> SYSTEM_USER_CONSUMER = () -> this.systemUserComponent;

    public NavigationMenuItem get(String item) {
        return this.MAP.get(item)
                       .get();
    }
}
