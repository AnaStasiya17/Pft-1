package ru.sqta.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.sqta.pft.addressbook.model.GroupData;
import java.util.Set;

import java.util.Comparator;
import java.util.List;

/**
 * Created by Анастасия Цыбулько on 30.06.2017.
 */
public class GroupModificationTest extends TestBase {
    @BeforeMethod
   public void ensurePreconditions() {
    app.goTo().groupPage();
    if (app.group().all().size() == 0) {
      app.group().create(new GroupData().withName("test1"));
   }
  }
    @Test
    public void testGroupModification() {
        Set<GroupData> before = app.group().all();
          GroupData modifiedGroup = before.iterator().next();
          // int index = before.size() - 1;
           GroupData group = new GroupData().withId(modifiedGroup.getId()).withName("test1").
                    withHeader("test2").withFooter("test3");
            app.group().modify(group);
            Set<GroupData> after = app.group().all();
        Assert.assertEquals(after.size(), before.size() );
        before.remove(modifiedGroup);
        before.add(group);
        Assert.assertEquals(before, after);
    }


}
