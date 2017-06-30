package ru.sqta.pft.addressbook.model;

public class GroupDataContact {
    private final String name;
    private final String secondName;
    private final String lastName;
    private final String address;

    public GroupDataContact(String name, String secondName, String lastName, String address) {
        this.name = name;
        this.secondName = secondName;
        this.lastName = lastName;
        this.address = address;
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
}
