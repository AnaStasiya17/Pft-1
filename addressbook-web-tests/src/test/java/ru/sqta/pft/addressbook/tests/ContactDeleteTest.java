package ru.sqta.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.sqta.pft.addressbook.model.GroupDataContact;

/**
 * Created by Анастасия Цыбулько on 30.06.2017.
 */
public class ContactDeleteTest extends TestBase {
    @Test
    public void testModificationContact() {
        app.getNavigationHelper().goToHomePage();
        if (app.getAppHelper().isThereAContact()) {
            app.getNavigationHelper().goToContactPage();
            app.getAppHelper().createContact(new GroupDataContact(
                    "name", "secondname",
                    "lastname", "address", "test1"), true);
        }

        app.getAppHelper().enterContact();
        app.getAppHelper().deleteContact();
    }
}
