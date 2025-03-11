package seedu.address.model.person;

import static java.util.Objects.requireNonNull;

/**
 * Represents a Person's remark in the address book.
 * A {@code Remark} is immutable and always valid.
 */
public class Remark {
    /** The remark text associated with a person. */
    public final String value;

    /**
     * Constructs a {@code Remark}.
     *
     * @param remark The remark text. Must not be null.
     */
    public Remark(String remark) {
        requireNonNull(remark);
        value = remark;
    }

    /**
     * Returns the string representation of the remark.
     *
     * @return The remark text.
     */
    @Override
    public String toString() {
        return value;
    }

    /**
     * Checks if this remark is equal to another object.
     *
     * @param other The other object to compare.
     * @return {@code true} if the other object is a {@code Remark} with the same value, otherwise {@code false}.
     */
    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Remark // instanceof handles nulls
                && value.equals(((Remark) other).value)); // state check
    }

    /**
     * Returns the hash code of this remark.
     *
     * @return The hash code value for this remark.
     */
    @Override
    public int hashCode() {
        return value.hashCode();
    }
}
