package ru.sqta.pft.addressbook.tests;

import org.testng.annotations.Test;

/**
 * Created by Анастасия Цыбулько on 30.06.2017.
 */
public class ContactDeleteTest extends TestBase {
    @Test
    public void testModificationContact() {
        app.getNavigationHelper().goToHomePage();
        app.getAppHelper().enterContact();
        app.getAppHelper().deleteContact();
    }
}
