package com.orangehrmlive.page.element;

import com.orangehrmlive.annotation.PageFragment;
import com.orangehrmlive.base.BasePage;
import org.openqa.selenium.By;

@PageFragment
public class ConfirmDialog extends BasePage {
    public void confirmAction() {
        super.click(By.id("dialogDeleteBtn"));
    }
}
