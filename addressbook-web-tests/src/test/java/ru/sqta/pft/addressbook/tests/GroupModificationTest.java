package ru.sqta.pft.addressbook.tests;

import org.junit.Test;
import ru.sqta.pft.addressbook.model.GroupData;

/**
 * Created by Анастасия Цыбулько on 30.06.2017.
 */
public class GroupModificationTest extends TestBase {
    @Test
    public void testGroupModification() {
        app.getNavigationHelper().goToPageGroup();
        app.getAppHelper().initGroupCreate();
        app.getAppHelper().initGroupModification();
        app.getAppHelper().enterFieldGroupCreate(new GroupData("modificate","hed2","footer2"));
        app.getAppHelper().submitMofification();
        app.getAppHelper().returnToGroupPage();
    }
}
