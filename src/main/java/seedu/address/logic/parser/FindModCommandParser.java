package seedu.address.logic.parser;

import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;

import java.util.Arrays;

import seedu.address.logic.commands.FindModCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.person.ModContainsKeywordsPredicate;

/**
 * Parses input arguments and creates a new FindModCommand object.
 */
public class FindModCommandParser implements Parser<FindModCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the FindModCommand
     * and returns a FindModCommand object for execution.
     *
     * @param args The input arguments provided by the user.
     * @return A new FindModCommand object containing the parsed module keywords.
     * @throws ParseException if the user input does not conform to the expected format.
     */
    public FindModCommand parse(String args) throws ParseException {
        String trimmedArgs = args.trim();
        if (trimmedArgs.isEmpty()) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, FindModCommand.MESSAGE_USAGE));
        }

        String[] nameKeywords = trimmedArgs.split("\\s+");

        return new FindModCommand(new ModContainsKeywordsPredicate(Arrays.asList(nameKeywords)));
    }

}
