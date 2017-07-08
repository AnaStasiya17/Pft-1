package ru.sqta.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.sqta.pft.addressbook.model.GroupDataContact;

import java.util.Comparator;
import java.util.List;

/**
 * Created by Анастасия Цыбулько on 30.06.2017.
 */
public class ContactModificationTest extends TestBase {

    @Test(enabled = false)
    public void testContactModification() {

        app.goTo().goToHomePage();

        if (!app.contact().isThereAContact()) {
            app.goTo().goToAddNewContactPage();
            app.contact().createContact(new GroupDataContact(
                    5, " bbb", "ccc",
                    "ddd", "eee", "test1"), true);
        }
        List<GroupDataContact> before = app.contact().getContactList();
        app.contact().selectContact(before.size() - 1);
        app.group().initContactModification(before.size() - 1);
        GroupDataContact contact = new GroupDataContact(6, "First",
                "sec", "Last", null, "test1");
        app.contact().enterFieldContactCreate(contact, false);
        app.contact().submitMofification();
        app.contact().returnHomePage();
        List<GroupDataContact> after = app.contact().getContactList();

        Assert.assertEquals(after.size(), before.size());

        //удаляем из списка строку до модификации
        before.remove(before.size() - 1);
        // упорядочиваем списки перед сравнением
        contact.setId(after.stream().max(Comparator.comparingInt(GroupDataContact::getId)).get().getId());
        //добавляем в список строку, которая появляется после модфикации
        before.add(contact);
        Comparator<? super GroupDataContact> byId = Comparator.comparingInt(GroupDataContact::getId);
        before.sort(byId);
        after.sort(byId);

        Assert.assertEquals(before, after);
    }
}



