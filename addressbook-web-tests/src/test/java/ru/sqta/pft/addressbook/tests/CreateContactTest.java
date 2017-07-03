package ru.sqta.pft.addressbook.tests;


import org.testng.annotations.Test;
import ru.sqta.pft.addressbook.model.GroupDataContact;


public class CreateContactTest extends TestBase {

    @Test
    public void createNewContact() {
        app.getNavigationHelper().goToContactPage();
        app.getAppHelper().createContact(new GroupDataContact("name", "secondname",
                "lastname", "address", "test1"), true);
        app.getAppHelper().submitContact();
        app.getAppHelper().returnHomePage();
    }

}