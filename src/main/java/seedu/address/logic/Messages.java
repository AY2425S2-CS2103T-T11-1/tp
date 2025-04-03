package seedu.address.logic;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import seedu.address.logic.parser.Prefix;
import seedu.address.model.person.Person;

/**
 * Container for user visible messages.
 */
public class Messages {

    public static final String MESSAGE_UNKNOWN_COMMAND = "Unknown command";
    public static final String MESSAGE_INVALID_COMMAND_FORMAT = "Invalid command format! \n%1$s";
    public static final String MESSAGE_INVALID_PERSON_DISPLAYED_INDEX =
            "The person index provided is invalid";
    public static final String MESSAGE_PERSONS_LISTED_OVERVIEW = "%1$d persons listed!";
    public static final String MESSAGE_PERSON_LISTED_OVERVIEW = "1 person listed!";
    public static final String MESSAGE_DUPLICATE_FIELDS =
            "Multiple values specified for the following single-valued field(s): ";

    /**
     * Returns an error message indicating the duplicate prefixes.
     */
    public static String getErrorMessageForDuplicatePrefixes(Prefix... duplicatePrefixes) {
        assert duplicatePrefixes.length > 0;

        Set<String> duplicateFields =
                Stream.of(duplicatePrefixes).map(Prefix::toString).collect(Collectors.toSet());

        return MESSAGE_DUPLICATE_FIELDS + String.join(" ", duplicateFields);
    }

    /**
     * Formats the {@code person} for display to the user.
     */
    public static String format(Person person) {
        final StringBuilder builder = new StringBuilder();
        builder.append(person.getName())
                .append("; ");
        if (person.getPhone() != null) {
            builder.append("Phone: ")
                    .append(person.getPhone())
                    .append("; ");
        }
        if (person.getEmail() != null) {
            builder.append("Email: ")
                    .append(person.getEmail())
                    .append("; ");
        }
        if (person.getYear() != null) {
            builder.append("Year: ")
                    .append(person.getYear())
                    .append("; ");
        }
        if (person.getMajor() != null) {
            builder.append("Major: ")
                    .append(person.getMajor())
                    .append("; ");
        }
        if (person.getHousing() != null) {
            builder.append("Housing: ")
                    .append(person.getHousing())
                    .append("; ");
        }
        if (person.getLink() != null) {
            builder.append("Link: ")
                    .append(person.getLink())
                    .append("; ");
        }
        if (!person.getTags().isEmpty()) {
            builder.append("Tags: ");
            person.getTags().forEach(builder::append);
        }

        int length = builder.length();
        if (length > 0 && builder.charAt(length - 2) == ';') {
            builder.delete(length - 2, length);
        }

        return builder.toString();
    }

}
