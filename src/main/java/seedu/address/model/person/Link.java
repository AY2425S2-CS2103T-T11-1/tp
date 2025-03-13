package seedu.address.model.person;
import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Represents a Person's NUSMods link in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidEmail(String)}
 */
public class Link {
    public static final String MESSAGE_CONSTRAINTS =
        "Link needs to be a valid NUSMods timetable link";
    public final String value;

    /**
     * Constructs an {@code Link}.
     *
     * @param link A valid NUSMods timetable link.
     */
    public Link(String link) {
        requireNonNull(link);
        checkArgument(isValidLink(link));
        value = link;
    }

    /**
     * Returns if a given string is a valid timetable.
     */
    public static boolean isValidLink(String test) {
        return true;
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof Link)) {
            return false;
        }

        Link otherLink = (Link) other;
        return value.equals(otherLink.value);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

}
