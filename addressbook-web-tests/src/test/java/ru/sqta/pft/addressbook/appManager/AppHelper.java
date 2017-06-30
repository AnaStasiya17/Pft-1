package ru.sqta.pft.addressbook.appManager;

import com.sun.javafx.binding.ExpressionHelperBase;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.sqta.pft.addressbook.model.GroupData;


/**
 * Created by Анастасия Цыбулько on 30.06.2017.
 */
public class AppHelper extends HelperBase{
    public AppHelper(FirefoxDriver wd){
        super(wd);

    }

    public void returnToGroupPage() {
        click(By.linkText("group page"));
    }

    public void submitGroupCreate() {
        click(By.name("submit"));
    }

    public void enterFieldGroupCreate(GroupData groupData) {
        type(By.name("group_name"), groupData.getName());
        type(By.name("group_header"), groupData.getHeader());
        type(By.name("group_footer"), groupData.getFooter());
    }


    public void initGroupCreate() {
        click(By.name("new"));
    }

    public void selectGroup() {
        click(By.name("selected[]"));
    }

    public void deleteGroup() {
        click(By.name("delete"));
    }
}
