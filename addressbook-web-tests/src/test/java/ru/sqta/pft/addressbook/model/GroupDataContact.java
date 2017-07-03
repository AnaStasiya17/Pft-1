package ru.sqta.pft.addressbook.model;

public class GroupDataContact {
    private final String name;
    private final String secondName;
    private final String lastName;
    private final String address;
    private final String groupContact;

    public GroupDataContact(String name, String secondName, String lastName, String address, String groupContact) {
        this.name = name;
        this.secondName = secondName;
        this.lastName = lastName;
        this.address = address;
        this.groupContact = groupContact;
    }

    public String getName() {
        return name;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return address;
    }
    public String getGroupContact(){
        return groupContact;

    }
}
