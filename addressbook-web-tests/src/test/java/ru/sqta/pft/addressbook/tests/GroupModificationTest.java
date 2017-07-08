package ru.sqta.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.sqta.pft.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;

/**
 * Created by Анастасия Цыбулько on 30.06.2017.
 */
public class GroupModificationTest extends TestBase {
    @Test
    public void testGroupModification() {
        app.getNavigationHelper().goToHomePage();

        if (!app.getAppHelper().isThereAGroup()) {
            app.getAppHelper().createGroup(new GroupData("test1",
                    null, null));
        }
        List<GroupData> before = app.getAppHelper().getGroupList();
        app.getAppHelper().selectGroup(before.size() - 1);
        app.getAppHelper().initGroupModification();
        GroupData group = new GroupData(before.get(before.size() - 1).getId(), "test1", "test1", "footer2");
        app.getAppHelper().enterFieldGroupCreate(group);
        app.getAppHelper().submitMofification();
        app.getAppHelper().returnToGroupPage();

        List<GroupData> after = app.getAppHelper().getGroupList();
        Assert.assertEquals(after.size(), before.size());
        before.remove(before.size() - 1);
        before.add(group);
        Comparator<? super GroupData> byId = Comparator.comparingInt(GroupData::getId);
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);
    }
}
