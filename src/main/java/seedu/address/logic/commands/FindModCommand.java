package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;

import seedu.address.commons.util.ToStringBuilder;
import seedu.address.logic.Messages;
import seedu.address.model.Model;
import seedu.address.model.person.ModContainsKeywordsPredicate;

/**
 * Finds and lists all persons in address book whose name contains any of the argument keywords.
 * Keyword matching is case insensitive.
 */
public class FindModCommand extends Command {

    public static final String COMMAND_WORD = "findMod";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Finds all people who are enrolled in any of "
            + "the specified modules (case-insensitive) and displays them as a list with index numbers.\n"
            + "Parameters: MODULE_CODE [MORE_MODULE_CODES]...\n"
            + "Example: " + COMMAND_WORD + "CS2100 CS2103T";

    private final ModContainsKeywordsPredicate predicate;

    public FindModCommand(ModContainsKeywordsPredicate predicate) {
        this.predicate = predicate;
    }

    @Override
    public CommandResult execute(Model model) {
        requireNonNull(model);
        model.updateFilteredPersonList(predicate);
        return new CommandResult(
                String.format(Messages.MESSAGE_PERSONS_LISTED_OVERVIEW, model.getFilteredPersonList().size()));
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof FindModCommand)) {
            return false;
        }

        FindModCommand otherFindCommand = (FindModCommand) other;
        return predicate.equals(otherFindCommand.predicate);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .add("predicate", predicate)
                .toString();
    }
}
