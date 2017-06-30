package ru.sqta.pft.addressbook.tests;


import org.testng.annotations.Test;
import ru.sqta.pft.addressbook.model.GroupDataContact;
import ru.sqta.pft.addressbook.model.GroupData;


public class CreateContactTest extends TestBase {

    @Test
    public void createNewContact() {
        app.getNavigationHelper().goToContactPage();
        app.getAppHelper().enterFieldGroupCreate(new GroupDataContact("name", "secondname", "lastname", "address"));
        app.getAppHelper().submitContact();
        app.getAppHelper().returnHomePage();
    }

}