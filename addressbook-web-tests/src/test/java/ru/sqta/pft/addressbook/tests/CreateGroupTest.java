package ru.sqta.pft.addressbook.tests;


import org.testng.annotations.Test;
import ru.sqta.pft.addressbook.model.GroupData;


public class  CreateGroupTest extends TestBase {

    @Test


    public void testCreateGroup() {
        app.getNavigationHelper().goToPageGroup();
        app.getAppHelper().initGroupCreate();
        app.getAppHelper().enterFieldGroupCreate(new GroupData("name", "hed", "other"));
        app.getAppHelper().submitGroupCreate();
        app.getAppHelper().returnToGroupPage();
    }

}
