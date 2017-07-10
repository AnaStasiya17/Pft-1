package ru.sqta.pft.addressbook.model;

public class ContactData {
    private String testFirstName;
    private String testLastName;
    private String testAddress;
    private String testAddress2;
    private String testHome;
    private String testMobile;
    private String testWork;
    private String testEmail;

    public String getTestAddress2() {
        return testAddress2;
    }

    public ContactData withTestAddress2(String testAddress2) {
        this.testAddress2 = testAddress2;
        return this;
    }

    public String getTestEmail2() {
        return testEmail2;
    }

    public ContactData withTestEmail2(String testEmail2) {
        this.testEmail2 = testEmail2;
        return this;
    }

    private String testEmail2;
    private String group;
    private String allPhones;
    private String allAddress;

    public ContactData withAllAddress(String allAddress) {
        this.allAddress = allAddress;
        return this;
    }

    public ContactData withAllEmails(String allEmails) {
        this.allEmails = allEmails;
        return this;
    }

    private String allEmails;


    public String getAllAddress() {
        return allAddress;
    }

    public String getAllEmails() {
        return allEmails;
    }

    public String getAllPhones() {
        return allPhones;
    }

    public ContactData withAllPhones(String allPhones) {
        this.allPhones = allPhones;
        return this;
    }

    private int id = Integer.MIN_VALUE;

    public ContactData withTestFirstName(String testFirstName) {
        this.testFirstName = testFirstName;
        return this;
    }

    public ContactData withTestLastName(String testLastName) {
        this.testLastName = testLastName;
        return this;
    }

    public ContactData withTestAddress(String testAddress) {
        this.testAddress = testAddress;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContactData that = (ContactData) o;

        if (id != that.id) return false;
        if (testFirstName != null ? !testFirstName.equals(that.testFirstName) : that.testFirstName != null)
            return false;
        return testLastName != null ? testLastName.equals(that.testLastName) : that.testLastName == null;
    }

    @Override
    public int hashCode() {
        int result = testFirstName != null ? testFirstName.hashCode() : 0;
        result = 31 * result + (testLastName != null ? testLastName.hashCode() : 0);
        result = 31 * result + id;
        return result;
    }

    public ContactData withTestHome(String testHome) {
        this.testHome = testHome;
        return this;
    }

    public ContactData withTestMobile(String testMobile) {
        this.testMobile = testMobile;
        return this;
    }

    public ContactData withTestWork(String testWork) {
        this.testWork = testWork;
        return this;
    }

    public ContactData withTestEmail(String testEmail) {
        this.testEmail = testEmail;
        return this;
    }

    public ContactData withGroup(String group) {
        this.group = group;
        return this;
    }

    public ContactData withId(int id) {
        this.id = id;
        return this;
    }

    public int getId() {
        return id;
    }

    public String getTestFirstName() {
        return testFirstName;
    }

    public String getTestLastName() {
        return testLastName;
    }

    public String getTestAddress() {
        return testAddress;
    }

    public String getTestHome() {
        return testHome;
    }

    public String getTestMobile() {
        return testMobile;
    }

    public String getTestWork() {
        return testWork;
    }

    public String getTestEmail() {
        return testEmail;
    }

    public String getGroup() {
        return group;
    }

    @Override
    public String toString() {
        return "ContactData{" +
                "testLastName='" + testLastName + '\'' +
                ", id='" + id + '\'' +
                '}';
    }

}
