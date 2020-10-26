package com.orangehrmlive.page.element.impl;

import com.orangehrmlive.annotation.PageFragment;
import com.orangehrmlive.base.BasePage;
import com.orangehrmlive.page.element.ConfirmDialog;

import static com.orangehrmlive.locator.element.ConfirmDialogLocators.CONFIRM_BUTTON;

@PageFragment
public class ConfirmDialogImpl extends BasePage implements ConfirmDialog {
    @Override
    public void confirmAction() {
        super.click(CONFIRM_BUTTON.locator());
    }
}
