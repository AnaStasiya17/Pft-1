package ru.sqta.pft.addressbook.model;

public class GroupData {

    @Override
    public boolean equals(Object o) {
        GroupData groupData = (GroupData) o;

          if (id != groupData.id) return false;
        return name != null ? name.equals(groupData.name) : groupData.name == null;
    }

    @Override
    public int hashCode() {
        int result = id;
         result = 31 * result + (name != null ? name.hashCode() : 0);
            return result;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
         this.id = id;
          }



    @Override
    public String toString() {
        return "GroupData{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    private int id;
    private  String name;
    private  String header;
    private  String footer;

    public GroupData() {
        this.id = id;
        this.name = name;
        this.header = header;
        return;

    }
    public GroupData withId(int id) {
         this.id = id;
            return this;
          }


    public String getName() {
        return name;
    }

    public String getHeader() {
        return header;
    }public GroupData withHeader(String header) {
        this.header = header;
        return this; }

    public GroupData withName(String name) {
          this.name = name;
            return this;
    }

   public GroupData withFooter(String footer) {
         this.footer = footer;
            return this;
          }

    public String getFooter() {
        return footer;
    }


}
