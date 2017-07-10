package ru.sqta.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.sqta.pft.addressbook.model.ContactData;
import ru.sqta.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTest extends TestBase {

    @Test(invocationCount = 5)
    public void testContactCreation() {
        app.goTo().contactPage();
        Contacts before = app.contact().all();
        ContactData contact = new ContactData().withTestFirstName("testFirstName")
                .withTestLastName("testLastName").withTestAddress("testAddress").withTestHome("testHome")
                .withTestMobile("+ 7 28323").withTestWork("9(3213)3133").withTestEmail("testEmail").withGroup("[none]");
        app.contact().createContact(contact, true);
        Contacts after = app.contact().all();
        Assert.assertEquals(after.size(), before.size() + 1);
        assertThat(after, equalTo(
                before.withAdded(contact.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
    }

    @Test(enabled = false)
    public void testBadContactCreation() {
        app.goTo().contactPage();
        Contacts before = app.contact().all();
        ContactData contact = new ContactData().withTestFirstName("testFirstName''~!@#@@#@!!@#$%^&*()_")
                .withTestLastName("testLastName").withTestAddress("testAddress").withTestHome("testHome")
                .withTestMobile("+ 7 28323").withTestWork("9(3213)3133").withTestEmail("testEmail").withGroup("[none]");
        app.contact().createContact(contact, true);
        Assert.assertEquals(app.contact().count(), before.size());
        Contacts after = app.contact().all();
        assertThat(after, equalTo(
                before.withAdded(contact.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
    }

}
