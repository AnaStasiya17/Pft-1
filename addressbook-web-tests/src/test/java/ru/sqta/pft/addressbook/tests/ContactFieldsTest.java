package ru.sqta.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.sqta.pft.addressbook.model.ContactData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactFieldsTest extends TestBase{

    @Test(invocationCount = 5)
    public void testContactPhonees() {
        app.goTo().contactPage();
        ContactData contact = app.contact().all().iterator().next();
        ContactData contactDataFromEditForm = app.contact().info(contact);
        assertThat(contact.getAllPhones(), equalTo(mergePhones(contactDataFromEditForm)));
        assertThat(contact.getAllEmails(), equalTo(mergeEmails(contactDataFromEditForm)));
        assertThat(contact.getAllAddress(), equalTo(cleaned(contactDataFromEditForm.getAllAddress())));
    }

    private String mergePhones(ContactData contact) {
        return Arrays.asList(contact.getTestHome(), contact.getTestMobile(), contact.getTestWork())
                .stream().filter((s) -> ! s.equals(""))
                .map(ContactFieldsTest::cleaned)
                .collect(Collectors.joining("\n"));
    }

    private String mergeEmails(ContactData contact) {
        return Arrays.asList(contact.getTestEmail(), contact.getTestEmail2())
                .stream().filter((s) -> ! s.equals("")).collect(Collectors.joining("\n"));
    }

    public static String cleaned(String phone) {
        return phone.replaceAll("\\s", "").replaceAll("[-()]", "");
    }

}
