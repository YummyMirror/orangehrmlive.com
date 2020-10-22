package com.orangehrmlive.page.element;

import com.orangehrmlive.annotation.PageFragment;
import com.orangehrmlive.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@PageFragment
public class NavigationMenu extends BasePage {
    private static final Logger logger = LoggerFactory.getLogger(NavigationMenu.class);

    public void open(String... menuItems) {
        assert menuItems != null && menuItems.length > 0;
        List<String> itemsToSelect = arrayToListString(menuItems);
        outOfLoop:
        for (int i = 0; i < getTopMenuItems().size(); i++) {
            WebElement topMenuItem = getTopMenuItems().get(i);
            if (topMenuItem.getText().equalsIgnoreCase(itemsToSelect.get(0))) {
                super.click(topMenuItem);
                logger.info("'" + itemsToSelect.get(0) + "' menu item is opened");

                for (int j = 0; j < getChildrenOf(getTopMenuItems().get(i)).size(); j++) {
                    WebElement topItem = getTopMenuItems().get(i);
                    WebElement subMenuItem = getChildrenOf(topItem).get(j);
                    if (subMenuItem.getText().equalsIgnoreCase(itemsToSelect.get(1))) {
                        super.click(subMenuItem);
                        logger.info("'" + itemsToSelect.get(1) + "' sub-menu item is opened");

                        for (int k = 0; k < getChildrenOf(getChildrenOf(getTopMenuItems().get(i)).get(j)).size(); k++) {
                            WebElement topItem2 = getTopMenuItems().get(i);
                            WebElement subItem2 = getChildrenOf(topItem2).get(j);
                            List<WebElement> subSubItems2 = getChildrenOf(subItem2);
                            WebElement subSubMenuItem = subSubItems2.get(k);
                            if (subSubMenuItem.getText().equalsIgnoreCase(itemsToSelect.get(2))) {
                                super.click(subSubMenuItem);
                                logger.info("'" + itemsToSelect.get(2) + "' sub-sub-menu item is opened");
                                break outOfLoop;
                            }
                        }
                    }
                }
            }
        }
    }

    private List<String> arrayToListString(String[] array) {
        return Arrays.stream(array)
                     .map(String::toLowerCase)
                     .collect(Collectors.toList());
    }

    private List<WebElement> getTopMenuItems() {
        return findAll(By.xpath("//li[contains(@class, 'main-menu-first-level-list-item')]/a"));
    }

    private List<WebElement> getChildrenOf(WebElement parent) {
        return parent.findElements(By.xpath(".//following-sibling::ul/li/a"));
    }
}
