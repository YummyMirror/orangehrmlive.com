package com.orangehrmlive.scope;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.support.SimpleThreadScope;

public class BrowserScope extends SimpleThreadScope {
    @Override
    public Object get(String name, ObjectFactory<?> objectFactory) {
        Object driver = super.get(name, objectFactory);
        if (((RemoteWebDriver) driver).getSessionId() == null) {
            super.remove(name);
            driver = super.get(name, objectFactory);
        }
        return driver;
    }

    @Override
    public void registerDestructionCallback(String name, Runnable callback) {
    }
}
