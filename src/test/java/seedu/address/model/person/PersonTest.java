package seedu.address.model.person;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.logic.commands.CommandTestUtil.VALID_EMAIL_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_HOUSING_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_LINK_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_MAJOR_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_NAME_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_PHONE_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_TAG_HUSBAND;
import static seedu.address.logic.commands.CommandTestUtil.VALID_YEAR_BOB;
import static seedu.address.testutil.Assert.assertThrows;
import static seedu.address.testutil.TypicalPersons.ALICE;
import static seedu.address.testutil.TypicalPersons.BOB;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.Test;
import seedu.address.model.mod.ModuleCode;
import seedu.address.model.tag.Tag;
import seedu.address.testutil.PersonBuilder;

public class PersonTest {

    @Test
    public void constructor() {
        // name is null -> throws NullPointerException
        assertThrows(NullPointerException.class,
                () -> new Person(null, null, null, null, null, null, null, null));
        assertThrows(NullPointerException.class,
                () -> new Person(null, new Phone(VALID_PHONE_BOB), new Email(VALID_EMAIL_BOB),
                        Year.fromString(VALID_YEAR_BOB), new Major(VALID_MAJOR_BOB),
                        new Housing(VALID_HOUSING_BOB), new Link(VALID_LINK_BOB),
                        new HashSet<Tag>()));

        // name is not null -> returns Person object
        assertDoesNotThrow(
                () -> new Person(new Name("Alice"), null, null, null, null, null, null, null));
    }

    @Test
    public void asObservableList_modifyList_throwsUnsupportedOperationException() {
        Person person = new PersonBuilder().build();
        assertThrows(UnsupportedOperationException.class, () -> person.getTags().remove(0));
    }

    @Test
    public void isSamePerson() {
        // same object -> returns true
        assertTrue(ALICE.isSamePerson(ALICE));

        // null -> returns false
        assertFalse(ALICE.isSamePerson(null));

        // same name, all other attributes different -> returns true
        Person editedAlice =
                new PersonBuilder(ALICE).withPhone(VALID_PHONE_BOB).withEmail(VALID_EMAIL_BOB)
                        .withHousing(VALID_HOUSING_BOB).withTags(VALID_TAG_HUSBAND).build();
        assertTrue(ALICE.isSamePerson(editedAlice));

        // different name, all other attributes same -> returns false
        editedAlice = new PersonBuilder(ALICE).withName(VALID_NAME_BOB).build();
        assertFalse(ALICE.isSamePerson(editedAlice));

        // name differs in case, all other attributes same -> returns false
        Person editedBob = new PersonBuilder(BOB).withName(VALID_NAME_BOB.toLowerCase()).build();
        assertFalse(BOB.isSamePerson(editedBob));

        // name has trailing spaces, all other attributes same -> returns false
        String nameWithTrailingSpaces = VALID_NAME_BOB + " ";
        editedBob = new PersonBuilder(BOB).withName(nameWithTrailingSpaces).build();
        assertFalse(BOB.isSamePerson(editedBob));
    }

    @Test
    public void equals() {
        // same values -> returns true
        Person aliceCopy = new PersonBuilder(ALICE).build();
        assertTrue(ALICE.equals(aliceCopy));

        // same object -> returns true
        assertTrue(ALICE.equals(ALICE));

        // null -> returns false
        assertFalse(ALICE.equals(null));

        // different type -> returns false
        assertFalse(ALICE.equals(5));

        // different person -> returns false
        assertFalse(ALICE.equals(BOB));

        // different name -> returns false
        Person editedAlice = new PersonBuilder(ALICE).withName(VALID_NAME_BOB).build();
        assertFalse(ALICE.equals(editedAlice));

        // different phone -> returns false
        editedAlice = new PersonBuilder(ALICE).withPhone(VALID_PHONE_BOB).build();
        assertFalse(ALICE.equals(editedAlice));

        // different email -> returns false
        editedAlice = new PersonBuilder(ALICE).withEmail(VALID_EMAIL_BOB).build();
        assertFalse(ALICE.equals(editedAlice));

        // different year -> returns false
        editedAlice = new PersonBuilder(ALICE).withYear(VALID_YEAR_BOB).build();
        assertFalse(ALICE.equals(editedAlice));

        // different major -> returns false
        editedAlice = new PersonBuilder(ALICE).withMajor(VALID_MAJOR_BOB).build();
        assertFalse(ALICE.equals(editedAlice));

        // different housing -> returns false
        editedAlice = new PersonBuilder(ALICE).withHousing(VALID_HOUSING_BOB).build();
        assertFalse(ALICE.equals(editedAlice));

        // different link -> returns false
        editedAlice = new PersonBuilder(ALICE).withLink(VALID_LINK_BOB).build();
        assertFalse(ALICE.equals(editedAlice));

        // different tags -> returns false
        editedAlice = new PersonBuilder(ALICE).withTags(VALID_TAG_HUSBAND).build();
        assertFalse(ALICE.equals(editedAlice));
    }

    @Test
    public void getModulesMethod() {
        Set<ModuleCode> expected = new HashSet<ModuleCode>();
        expected.add(new ModuleCode("CS2103T"));
        assertEquals(expected, ALICE.getModules());

        Person emptyAlice = new Person(new Name("Alice"), null, null, null, null, null, null, null);
        assertEquals(new HashSet<ModuleCode>(), emptyAlice.getModules());
    }

    @Test
    public void toStringMethod() {
        String expected = Person.class.getCanonicalName() + "{name=" + ALICE.getName() + ", phone="
                + ALICE.getPhone() + ", email=" + ALICE.getEmail() + ", year=" + ALICE.getYear()
                + ", major=" + ALICE.getMajor() + ", housing=" + ALICE.getHousing() + ", tags="
                + ALICE.getTags() + ", modules=" + ALICE.getModules() + ", link=" + ALICE.getLink()
                + "}";
        assertEquals(expected, ALICE.toString());
    }
}
