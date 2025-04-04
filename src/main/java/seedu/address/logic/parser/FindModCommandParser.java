package seedu.address.logic.parser;

import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.model.mod.ModuleCode.VALIDATION_REGEX;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

import seedu.address.logic.commands.FindModCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.person.ModContainsKeywordsPredicate;

/**
 * Parses input arguments and creates a new FindModCommand object.
 */
public class FindModCommandParser implements Parser<FindModCommand> {

    private static final Logger logger = Logger.getLogger(FindModCommandParser.class.getName());

    /**
     * Parses the given {@code String} of arguments in the context of the FindModCommand
     * and returns a FindModCommand object for execution.
     *
     * @param args The input arguments provided by the user.
     * @return A new FindModCommand object containing the parsed module keywords.
     * @throws ParseException if the user input does not conform to the expected format.
     */
    public FindModCommand parse(String args) throws ParseException {
        logger.info("Received input arguments: " + args);

        String trimmedArgs = args.trim();
        logger.info("Trimmed input arguments: '" + trimmedArgs + "'");

        if (trimmedArgs.isEmpty()) {
            logger.warning("Empty arguments detected, throwing ParseException.");
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, FindModCommand.MESSAGE_USAGE));
        }

        String[] nameKeywords = trimmedArgs.split("\\s+");
        logger.info("Split keywords: " + Arrays.toString(nameKeywords));

        for (String keyword : nameKeywords) {
            if (!keyword.matches(VALIDATION_REGEX)) {
                logger.log(Level.SEVERE, "Invalid module format detected: {0}", keyword);
                throw new ParseException(
                        String.format("ModuleCode format invalid!\n" + MESSAGE_INVALID_COMMAND_FORMAT,
                                FindModCommand.MESSAGE_USAGE));
            }
        }

        logger.info("All keywords are valid.");

        FindModCommand command = new FindModCommand(new ModContainsKeywordsPredicate(Arrays.asList(nameKeywords)));
        logger.info("Successfully created FindModCommand with predicate: " + command);

        return command;
    }
}
