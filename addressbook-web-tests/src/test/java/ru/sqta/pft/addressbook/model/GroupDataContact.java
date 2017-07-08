package ru.sqta.pft.addressbook.model;

public class GroupDataContact {
    public void setId(int id) {
           this.id = id;
         }

   private int id;
    private final String name;
    private final String secondName;
    private final String lastName;
    private final String address;
    private final String groupContact;

    public GroupDataContact(int id,String name, String secondName, String lastName, String address, String groupContact) {
        this.id = 0;
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

    @Override
    public String toString() {
        return "GroupDataContact{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GroupDataContact that = (GroupDataContact) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (lastName != null ? !lastName.equals(that.lastName) : that.lastName != null) return false;
        return address != null ? address.equals(that.address) : that.address == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        return result;
    }
    public int getId() { return id; }

      //public String getFirstname() {  return firstname;  }
}
