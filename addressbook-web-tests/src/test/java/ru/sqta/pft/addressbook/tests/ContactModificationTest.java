package ru.sqta.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.sqta.pft.addressbook.model.GroupDataContact;

/**
 * Created by Анастасия Цыбулько on 30.06.2017.
 */
public class ContactModificationTest extends TestBase {
    @Test
    public void testModificationContact() {
        app.getNavigationHelper().goToHomePage();
        if (!app.getAppHelper().isThereAContact()) {
            app.getAppHelper().createContact((new GroupDataContact("field1", "field2", "field3", "field4", "test1")), true);
        }
        app.getAppHelper().selectContact();
        app.getAppHelper().editContact();
        app.getAppHelper().enterFieldContactCreate(new GroupDataContact("2", "3", "4", "NewYork", null), false);
        app.getAppHelper().submitMofification();
        app.getAppHelper().returnHomePage();
    }
}
