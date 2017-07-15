package ru.sqta.pft.addressbook.generator;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.thoughtworks.xstream.XStream;
import ru.sqta.pft.addressbook.model.ContactData;
import ru.sqta.pft.addressbook.model.GroupData;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dmitriy on 11.07.2017.
 */
public class ContactDataGenerator {
    @Parameter(names = "-c", description = "Contact count", required = true)
    public int count;

    @Parameter(names = "-f", description = "Target file", required = true)
    public String file;

    @Parameter(names = "-d", description = "Data format", required = true)
    public String format;

    public static void main(String[] args) throws IOException {
        ContactDataGenerator generator = new ContactDataGenerator();
        JCommander jCommander = new JCommander(generator);
        try {
            jCommander.parse(args);
        } catch (ParameterException ex) {
            jCommander.usage();
            return;
        }
        generator.run();
    }

    private void run() throws IOException {
        List<ContactData> contacts = generateContacts(count);
        if (format.equals("csv")) {
            saveAsCsv(contacts, new File(file));
        } else if (format.equals("xml")) {
            saveAsXml(contacts, new File(file));
        } else if (format.equals("json")) {
            saveAsGson(contacts, new File(file));
        } else {
            System.out.println("Unrecognized format " + format);
        }
    }

    private void saveAsXml(List<ContactData> contacts, File file) throws IOException {
        XStream xstream = new XStream();
        xstream.processAnnotations(GroupData.class);
        String xml = xstream.toXML(contacts);
        Writer writer = new FileWriter(file);
        writer.write(xml);
        writer.close();
    }


    private void saveAsGson(List<ContactData> contacts, File file) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().excludeFieldsWithoutExposeAnnotation().create();
        String json = gson.toJson(contacts);
        try (Writer writer = new FileWriter(file)) {
            writer.write(json);
        }
    }

    private void saveAsCsv(List<ContactData> contacts, File file) throws IOException {
        Writer writer = new FileWriter(file);
        for (ContactData contact : contacts) {
            writer.write(String.format("%s;%s;%s;%s;%s;%s\n",
                    contact.getTestFirstName(),
                    contact.getTestLastName(),
                    contact.getTestAddress(),
                    contact.getTestEmail(),
                    contact.getTestMobile(),
                    contact.getGroup()));
        }
        writer.close();
    }

    private List<ContactData> generateContacts(int count) {
        List<ContactData> contacts = new ArrayList<ContactData>();
        for (int i = 0; i < count; i++) {
            contacts.add(new ContactData()
                    .withTestFirstName(String.format("firstname%s", i))
                    .withTestLastName(String.format("lastname%s", i))
                    .withTestAddress(String.format("address%s", i))
                    .withTestEmail(String.format("email@mail.com", i))
                    .withTestMobile(String.format("12345 %s", i))
                    .withGroup(String.format("test1", i))
                    .withGroup("[none]"));
        }
        return contacts;
    }
}