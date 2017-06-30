package ru.sqta.pft.addressbook.tests;

import org.testng.annotations.Test;

public class GroupDeleteTest extends TestBase {

    
    @Test
    public void testGroupDelete() {
        app.getNavigationHelper().goToPageGroup();
        app.getAppHelper().selectGroup();
        app.getAppHelper().deleteGroup();
        app.getAppHelper().returnToGroupPage();
    }


}
