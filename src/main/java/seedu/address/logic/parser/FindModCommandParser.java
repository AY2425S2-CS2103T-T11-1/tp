package seedu.address.logic.parser;

import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;

import java.util.Arrays;
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
     * @throws ParseException if the user input does not conform the expected format
     */
    public FindModCommand parse(String args) throws ParseException {
        logger.info("Parsing arguments: " + args);

        String trimmedArgs = args.trim();

        if (trimmedArgs.isEmpty()) {
            logger.warning("Empty arguments detected, throwing ParseException.");
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, FindModCommand.MESSAGE_USAGE));
        }

        String[] nameKeywords = trimmedArgs.split("\\s+");
        logger.info("Parsed keywords: " + Arrays.toString(nameKeywords));

        FindModCommand command = new FindModCommand(new ModContainsKeywordsPredicate(Arrays.asList(nameKeywords)));
        logger.info("Created FindModCommand with predicate: " + command);

        return command;
    }
}

