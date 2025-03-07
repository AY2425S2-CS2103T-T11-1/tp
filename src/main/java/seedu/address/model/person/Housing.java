package seedu.address.model.person;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Represents a Person's housing in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidHousing(String)}
 */
public class Housing {

    public static final String MESSAGE_CONSTRAINTS =
            "Housing can take any values, and it should not be blank";

    /*
     * The first character of the housing information must not be a whitespace,
     * otherwise " " (a blank string) becomes a valid input.
     */
    public static final String VALIDATION_REGEX = "[^\\s].*";

    public final String value;

    /**
     * Constructs an {@code Housing}.
     *
     * @param housing Valid housing information.
     */
    public Housing(String housing) {
        requireNonNull(housing);
        checkArgument(isValidHousing(housing), MESSAGE_CONSTRAINTS);
        value = housing;
    }

    /**
     * Returns true if a given string is a valid email.
     */
    public static boolean isValidHousing(String test) {
        return test.matches(VALIDATION_REGEX);
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
        if (!(other instanceof Housing)) {
            return false;
        }

        Housing otherHousing = (Housing) other;
        return value.equals(otherHousing.value);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

}
