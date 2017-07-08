package ru.sqta.pft.addressbook.tests;


import org.testng.Assert;
import org.testng.annotations.Test;
import ru.sqta.pft.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;


public class CreateGroupTest extends TestBase {

    @Test
    public void testCreateGroup() {
        app.getNavigationHelper().goToPageGroup();

        List<GroupData> before = app.getAppHelper().getGroupList();
        GroupData group = new GroupData("test2",
                null, null);
        app.getAppHelper().createGroup(group);
        List<GroupData> after = app.getAppHelper().getGroupList();
        Assert.assertEquals(after.size(), before.size() + 1);
        before.add(group);
        Comparator<? super GroupData> byId = Comparator.comparingInt(GroupData::getId);
          before.sort(byId);
            after.sort(byId);
            Assert.assertEquals(before, after);
    }

}
