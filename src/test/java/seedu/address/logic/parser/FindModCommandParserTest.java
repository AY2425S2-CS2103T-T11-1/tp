package seedu.address.logic.parser;

import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseSuccess;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import seedu.address.logic.commands.FindModCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.person.ModContainsKeywordsPredicate;


public class FindModCommandParserTest {

    private final FindModCommandParser parser = new FindModCommandParser();

    @Test
    public void parse_validArgs_returnsFindCommand() throws ParseException {
        // Test with a single module
        String userInput = "CS2100";
        ModContainsKeywordsPredicate expectedPredicate = new ModContainsKeywordsPredicate(Arrays.asList("CS2100"));
        FindModCommand expectedCommand = new FindModCommand(expectedPredicate);
        assertParseSuccess(parser, userInput, expectedCommand);

        // Test with multiple modules
        userInput = "CS2100 CS2103T";
        expectedPredicate = new ModContainsKeywordsPredicate(Arrays.asList("CS2100", "CS2103T"));
        expectedCommand = new FindModCommand(expectedPredicate);
        assertParseSuccess(parser, userInput, expectedCommand);
    }

    @Test
    public void parse_emptyArgs_throwsParseException() {
        String userInput = "";
        String expectedMessage = String.format(MESSAGE_INVALID_COMMAND_FORMAT, FindModCommand.MESSAGE_USAGE);
        assertParseFailure(parser, userInput, expectedMessage);
    }

    @Test
    public void parse_multipleSpaces_throwsParseException() {
        String userInput = "CS2100 CS2103T";
        ModContainsKeywordsPredicate expectedPredicate = new ModContainsKeywordsPredicate(
                Arrays.asList("CS2100", "CS2103T"));
        FindModCommand expectedCommand = new FindModCommand(expectedPredicate);
        assertParseSuccess(parser, userInput, expectedCommand);
    }

    @Test
    public void parse_invalidModuleCode_throwsParseException() {
        String userInput = "qweqweqwe";
        String expectedMessage = String.format("ModuleCode format invalid!\n" + MESSAGE_INVALID_COMMAND_FORMAT,
                FindModCommand.MESSAGE_USAGE);
        assertParseFailure(parser, userInput, expectedMessage);
    }

    @Test
    public void parse_notAllValidModuleCode_throwsParseException() {
        String userInput = "qweqweqwe CS2103T";
        String expectedMessage = String.format("ModuleCode format invalid!\n" + MESSAGE_INVALID_COMMAND_FORMAT,
                FindModCommand.MESSAGE_USAGE);
        assertParseFailure(parser, userInput, expectedMessage);
    }

    @Test
    public void parse_notAllValidModuleCode_throwsParseException2() {
        String userInput = "CS2103T 123123";
        String expectedMessage = String.format("ModuleCode format invalid!\n" + MESSAGE_INVALID_COMMAND_FORMAT,
                FindModCommand.MESSAGE_USAGE);
        assertParseFailure(parser, userInput, expectedMessage);
    }
}
