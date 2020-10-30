package com.orangehrmlive.page.userManagement.impl;

import com.orangehrmlive.annotation.Page;
import com.orangehrmlive.base.BasePage;
import com.orangehrmlive.model.User;
import com.orangehrmlive.page.userManagement.SystemUserViewPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static com.orangehrmlive.locator.userManagement.SystemUserViewPageLocators.ADD_BUTTON;
import static com.orangehrmlive.locator.userManagement.SystemUserViewPageLocators.ALL_ROWS;
import static org.openqa.selenium.support.ui.ExpectedConditions.urlContains;

@Page
public class SystemUserViewPageImpl extends BasePage implements SystemUserViewPage {
    private static final Logger logger = LoggerFactory.getLogger(SystemUserViewPageImpl.class);

    @Override
    public Set<User> getUsers() {
        Set<User> users = this.getAllRows().stream()
                              .skip(2)
                              .map(row -> {
                                  List<WebElement> cells = row.findElements(By.xpath("./td"));
                                  return new User().setId(Integer.parseInt(cells.get(0).findElement(By.xpath("./input")).getAttribute("value")))
                                                   .setUsername(cells.get(1).findElement(By.xpath("./a")).getText())
                                                   .setEmployeeName(cells.get(3).getText());
                              })
                              .collect(Collectors.toSet());
        logger.info("Collection of System Users is retrieved and equals '" + users.size() + "'");
        return users;
    }

    private List<WebElement> getAllRows() {
        return super.findAll(ALL_ROWS.locator());
    }

    @Override
    public void clickAddButton() {
        super.click(ADD_BUTTON.locator());
        super.wait.condition(urlContains("saveSystemUser"));
    }

    @Override
    public void openUser(User user) {
        //TODO
    }

    @Override
    public void deleteUser(User user) {
        //TODO
    }
}
