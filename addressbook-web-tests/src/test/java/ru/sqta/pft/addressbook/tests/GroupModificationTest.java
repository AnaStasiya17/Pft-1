package ru.sqta.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.sqta.pft.addressbook.model.GroupData;

/**
 * Created by Анастасия Цыбулько on 30.06.2017.
 */
public class GroupModificationTest extends TestBase {
    @Test
    public void testGroupModification() {
        app.getNavigationHelper().goToPageGroup();
        if (!app.getAppHelper().isThereAGroup()) {
               app.getAppHelper().createGroup(new GroupData("test1",
                    null, null));
               }
        app.getAppHelper().initGroupCreate();
        app.getAppHelper().initGroupModification();
        app.getAppHelper().enterFieldGroupCreate(new GroupData("test1","test1","footer2"));
        app.getAppHelper().submitMofification();
        app.getAppHelper().returnToGroupPage();
    }
}
