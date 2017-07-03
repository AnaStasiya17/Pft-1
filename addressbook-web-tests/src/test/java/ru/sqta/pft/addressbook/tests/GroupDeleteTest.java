package ru.sqta.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.sqta.pft.addressbook.model.GroupData;


public class GroupDeleteTest extends TestBase {


    @Test
    public void testGroupDelete() {
        app.getNavigationHelper().goToPageGroup();
        if (!app.getAppHelper().isThereAGroup()) {
            app.getAppHelper().createGroup(new GroupData("test1",
                    null, null));
        }
        app.getAppHelper().selectGroup();
        app.getAppHelper().deleteGroup();
        app.getAppHelper().returnToGroupPage();
    }
}
