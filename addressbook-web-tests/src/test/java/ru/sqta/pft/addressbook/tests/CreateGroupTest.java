package ru.sqta.pft.addressbook.tests;


import org.testng.Assert;
import org.testng.annotations.Test;
import ru.sqta.pft.addressbook.model.GroupData;

import java.util.Set;


public class CreateGroupTest extends TestBase {

    @Test
    public void testCreateGroup() {
        app.goTo().groupPage();
        Set<GroupData> before = app.group().all();
        GroupData group = new GroupData().withName("test1");
        app.group().create(group);
        Set<GroupData> after = app.group().all();
        Assert.assertEquals(after.size(), before.size() + 1);
        before.add(group);
        Assert.assertEquals(before, after);
    }
}


