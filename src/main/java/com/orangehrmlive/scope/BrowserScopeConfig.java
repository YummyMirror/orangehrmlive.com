package com.orangehrmlive.scope;

import com.orangehrmlive.annotation.LazyBean;
import com.orangehrmlive.annotation.LazyConfiguration;

@LazyConfiguration
public class BrowserScopeConfig {
    @LazyBean
    public static BrowserScopePostProcessor browserScopePostProcessor() {
        return new BrowserScopePostProcessor();
    }
}
