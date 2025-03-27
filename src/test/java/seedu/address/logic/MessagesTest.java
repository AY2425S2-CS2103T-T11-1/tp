package seedu.address.logic;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static seedu.address.testutil.TypicalPersons.ALICE;

import org.junit.jupiter.api.Test;

import seedu.address.model.person.Person;
import seedu.address.testutil.PersonBuilder;

public class MessagesTest {

    @Test
    public void format_success() {
        assertEquals(Messages.format(ALICE),
                "Alice Pauline; Phone: 94351253; Email: alice@example.com; Year: Year 1; Major: Computer Science; "
                        + "Housing: 123, Jurong West Ave 6, #08-111; "
                        + "Link: https://nusmods.com/timetable/sem-2/share?CS2103T=LEC:G12; Tags: [friends]");

        Person emptyPerson = new PersonBuilder().withName("Alice Pauline").withEmail(null)
                .withHousing(null).withLink(null).withMajor(null).withPhone(null).withYear(null)
                .build();
        assertEquals(Messages.format(emptyPerson), "Alice Pauline; ");
    }

}
