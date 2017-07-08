package ru.sqta.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.sqta.pft.addressbook.model.ContactData;
import ru.sqta.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Анастасия Цыбулько on 30.06.2017.
 */
public class ContactModificationTest extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().contactPage();
        if (app.contact().all().size() == 0) {
            app.contact().createContact(new ContactData().withTestFirstName("testFirstName")
                    .withTestLastName("testLastName").withTestAddress("testAddress").withTestHome("testHome")
                    .withTestMobile("testMobile").withTestEmail("testEmail").withGroup("[none]"), true);
        }
    }

    @Test
    public void testContactModification() {
        Contacts before = app.contact().all();
        ContactData modifiedContact = before.iterator().next();
        ContactData contact = new ContactData().withTestFirstName("testFirstName")
                .withTestLastName("testLastName").withTestAddress("testAddress").withTestHome("testHome")
                .withTestMobile("testMobile").withTestEmail("testEmail");
        app.contact().modify(modifiedContact);
        Contacts after = app.contact().all();
        Assert.assertEquals(after.size(), before.size());
        assertThat(after, equalTo(before.without(contact).withAdded(modifiedContact)));
    }

}
