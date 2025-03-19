package seedu.address.logic.commands;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.logic.Messages.MESSAGE_PERSONS_LISTED_OVERVIEW;
import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.address.testutil.TypicalPersons.ALICE;
import static seedu.address.testutil.TypicalPersons.BENSON;
import static seedu.address.testutil.TypicalPersons.CARL;
import static seedu.address.testutil.TypicalPersons.DANIEL;
import static seedu.address.testutil.TypicalPersons.ELLE;
import static seedu.address.testutil.TypicalPersons.FIONA;
import static seedu.address.testutil.TypicalPersons.GEORGE;
import static seedu.address.testutil.TypicalPersons.getTypicalAddressBook;

import java.util.Arrays;
import java.util.Collections;

import org.junit.jupiter.api.Test;

import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;
import seedu.address.model.person.ModContainsKeywordsPredicate;

/**
 * Contains integration tests (interaction with the Model) for {@code FindModCommand}.
 */
public class FindModCommandTest {
    private Model model = new ModelManager(getTypicalAddressBook(), new UserPrefs());
    private Model expectedModel = new ModelManager(getTypicalAddressBook(), new UserPrefs());

    @Test
    public void equals() {
        ModContainsKeywordsPredicate firstPredicate =
                new ModContainsKeywordsPredicate(Collections.singletonList("CS2100"));
        ModContainsKeywordsPredicate secondPredicate =
                new ModContainsKeywordsPredicate(Collections.singletonList("CS2103T"));

        FindModCommand findFirstCommand = new FindModCommand(firstPredicate);
        FindModCommand findSecondCommand = new FindModCommand(secondPredicate);

        // same object -> returns true
        assertTrue(findFirstCommand.equals(findFirstCommand));

        // same values -> returns true
        FindModCommand findFirstCommandCopy = new FindModCommand(firstPredicate);
        assertTrue(findFirstCommand.equals(findFirstCommandCopy));

        // different types -> returns false
        assertFalse(findFirstCommand.equals(1));

        // null -> returns false
        assertFalse(findFirstCommand.equals(null));

        // different module -> returns false
        assertFalse(findFirstCommand.equals(findSecondCommand));
    }

    @Test
    public void execute_noPersonFound() {
        String expectedMessage = String.format(MESSAGE_PERSONS_LISTED_OVERVIEW, 0);
        ModContainsKeywordsPredicate predicate = preparePredicate("CS1010");
        FindModCommand command = new FindModCommand(predicate);
        expectedModel.updateFilteredPersonList(predicate);
        assertCommandSuccess(command, model, expectedMessage, expectedModel);
        assertEquals(Collections.emptyList(), model.getFilteredPersonList());
    }

    @Test
    public void execute_singlePersonFound() {
        String expectedMessage = String.format(MESSAGE_PERSONS_LISTED_OVERVIEW, 1);
        ModContainsKeywordsPredicate predicate = preparePredicate("CS3230");
        FindModCommand command = new FindModCommand(predicate);
        expectedModel.updateFilteredPersonList(predicate);
        assertCommandSuccess(command, model, expectedMessage, expectedModel);
        assertEquals(Arrays.asList(FIONA), model.getFilteredPersonList());
    }

    @Test
    public void execute_multiplePersonsFound() {
        String expectedMessage = String.format(MESSAGE_PERSONS_LISTED_OVERVIEW, 6);
        ModContainsKeywordsPredicate predicate = preparePredicate("CS2103T");
        FindModCommand command = new FindModCommand(predicate);
        expectedModel.updateFilteredPersonList(predicate);
        assertCommandSuccess(command, model, expectedMessage, expectedModel);
        assertEquals(Arrays.asList(ALICE, BENSON, CARL, DANIEL, ELLE, GEORGE), model.getFilteredPersonList());
    }

    @Test
    public void toStringMethod() {
        ModContainsKeywordsPredicate predicate = new ModContainsKeywordsPredicate(Arrays.asList("CS2100"));
        FindModCommand findModCommand = new FindModCommand(predicate);
        String expected = FindModCommand.class.getCanonicalName() + "{predicate=" + predicate + "}";
        assertEquals(expected, findModCommand.toString());
    }

    /**
     * Parses {@code userInput} into a {@code ModContainsKeywordsPredicate}.
     */
    private ModContainsKeywordsPredicate preparePredicate(String userInput) {
        return new ModContainsKeywordsPredicate(Arrays.asList(userInput.split("\\s+")));
    }
}
