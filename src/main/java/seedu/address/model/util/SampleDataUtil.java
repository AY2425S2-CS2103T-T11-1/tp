package seedu.address.model.util;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

import seedu.address.model.AddressBook;
import seedu.address.model.ReadOnlyAddressBook;
import seedu.address.model.mod.Mod;
import seedu.address.model.person.Email;
import seedu.address.model.person.Housing;
import seedu.address.model.person.Major;
import seedu.address.model.person.Name;
import seedu.address.model.person.Person;
import seedu.address.model.person.Phone;
import seedu.address.model.person.Year;
import seedu.address.model.tag.Tag;

/**
 * Contains utility methods for populating {@code AddressBook} with sample data.
 */
public class SampleDataUtil {
    public static Person[] getSamplePersons() {
        return new Person[] {
            new Person(new Name("Abi"), new Phone("87438807"), new Email("abihalim@example.com"),
                    Year.YEAR_2, new Major("Computer Science"),
                    new Housing("Blk 30 Geylang Street 29, #06-40"),
                    getTagSet("friends"),
                    getModuleSet("CS1101 Programming Methodology", "CS1231 Discrete Structures",
                        "CS2106 Introduction to Operating Systems")),
            new Person(new Name("Yuexi"), new Phone("99272758"), new Email("yuexi@example.com"),
                    Year.YEAR_2, new Major("Computer Science"),
                    new Housing("Blk 30 Lorong 3 Serangoon Gardens, #07-18"),
                    getTagSet("colleagues", "friends"),
                    getModuleSet("CS2103T Software Engineering",
                        "CS2101 Effective Communication for Computing Professionals")),
            new Person(new Name("Shashwat"), new Phone("93210283"), new Email("shashwat@example.com"),
                    Year.YEAR_4, new Major("Computer Science"),
                    new Housing("Blk 11 Ang Mo Kio Street 74, #11-04"),
                    getTagSet("neighbours"),
                    getModuleSet()),
            new Person(new Name("Huazhi"), new Phone("91031282"), new Email("huazhi@example.com"),
                    Year.YEAR_2, new Major("Computer Science"),
                    new Housing("Blk 436 Serangoon Gardens Street 26, #16-43"),
                    getTagSet("family"),
                    getModuleSet("CS2109S Introduction to AI and Machine Learning")),
        };
    }

    public static ReadOnlyAddressBook getSampleAddressBook() {
        AddressBook sampleAb = new AddressBook();
        for (Person samplePerson : getSamplePersons()) {
            sampleAb.addPerson(samplePerson);
        }
        return sampleAb;
    }

    /**
     * Returns a tag set containing the list of strings given.
     */
    public static Set<Tag> getTagSet(String... strings) {
        return Arrays.stream(strings)
                .map(Tag::new)
                .collect(Collectors.toSet());
    }

    /**
     * Returns a module set containing the list of strings given.
     */
    public static Set<Mod> getModuleSet(String... strings) {
        return Arrays.stream(strings)
                .map((s) -> {
                    return new Mod(s.substring(0, s.indexOf(' ')), s.substring(s.indexOf(' ') + 1));
                }).collect(Collectors.toSet());
    }

}
