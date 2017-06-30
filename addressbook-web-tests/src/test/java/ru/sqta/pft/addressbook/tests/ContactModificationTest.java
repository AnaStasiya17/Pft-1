package ru.sqta.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.sqta.pft.addressbook.model.GroupDataContact;

/**
 * Created by Анастасия Цыбулько on 30.06.2017.
 */
public class ContactModificationTest extends  TestBase {
    @Test
    public void testModificationContact() {
        app.getNavigationHelper().goToHomePage();
        app.getAppHelper().editContact();
        app.getAppHelper().enterFieldGroupCreate(new GroupDataContact("field1", "field2","field3","field4"));
        app.getAppHelper().submitMofification();
        app.getAppHelper().returnHomePage();


    }
}