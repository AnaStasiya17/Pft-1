package ru.sqta.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.sqta.pft.addressbook.model.ContactData;
import ru.sqta.pft.addressbook.model.Contacts;

/**
 * Created by Анастасия Цыбулько on 30.06.2017.
 */
public class ContactDeleteTest extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().contactPage();
        if (app.contact().all().size() == 0) {
            app.contact().create(new ContactData().withTestFirstName("testFirstName")
                    .withTestLastName("testLastName").withTestAddress("testAddress").withTestHome("testHome").withTestWork("testWork")
                    .withTestMobile("testMobile").withTestEmail("testEmail"), true);
        }
    }

    @Test
    public void testContactDeletion() {
        Contacts before = app.db().contacts();
        ContactData deletedContact = before.iterator().next();
        app.contact().delete(deletedContact);
        Assert.assertEquals(app.contact().count(), before.size() - 1);
        Contacts after = app.db().contacts();
        MatcherAssert.assertThat(after, CoreMatchers.equalTo(before.without(deletedContact)));
        verifyContactListInUI();

    }


}
