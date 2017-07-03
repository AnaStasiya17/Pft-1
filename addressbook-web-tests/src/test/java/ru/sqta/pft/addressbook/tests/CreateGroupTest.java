package ru.sqta.pft.addressbook.tests;


import org.testng.annotations.Test;
import ru.sqta.pft.addressbook.model.GroupData;


public class CreateGroupTest extends TestBase {

    @Test
    public void testCreateGroup() {
        app.getNavigationHelper().goToPageGroup();
        app.getAppHelper().createGroup(new GroupData("test1", null, null));


    }

}
