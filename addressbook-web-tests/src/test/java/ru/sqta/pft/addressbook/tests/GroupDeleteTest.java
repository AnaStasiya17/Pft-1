package ru.sqta.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.sqta.pft.addressbook.model.GroupData;

import java.util.List;

public class GroupDeleteTest extends TestBase {


    @Test
    public void testGroupDelete() {
        app.getNavigationHelper().goToPageGroup();

        if (!app.getAppHelper().isThereAGroup()) {
            app.getAppHelper().createGroup(new GroupData("test1",
                    null, null));
        }
        List<GroupData> before = app.getAppHelper().getGroupList();
        app.getAppHelper().selectGroup(before.size() - 1);
        app.getAppHelper().deleteGroup();
        app.getAppHelper().returnToGroupPage();
        List<GroupData> after = app.getAppHelper().getGroupList();
        Assert.assertEquals(after.size(), before.size() - 1);
        before.remove(before.size() - 1);
        Assert.assertEquals(before, after);
    }
}
