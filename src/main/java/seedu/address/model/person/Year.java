package seedu.address.model.person;

/**
 * Represents the year of study of an NUS student.
 * Guarantees: immutable; is valid as declared in {@link #isValidYear(String)}
 */
public enum Year {
    YEAR_1(1), YEAR_2(2), YEAR_3(3), YEAR_4(4), YEAR_5(5), YEAR_6(6);

    public static final String MESSAGE_CONSTRAINTS = "Year should be 1, 2, 3, 4, 5, or 6.";
    public static final String VALIDATION_REGEX = "[1-6]";
    public final int value;

    Year(int year) {
        this.value = year;
    }

    /**
     * Returns true if a given string is a valid year.
     */
    public static boolean isValidYear(String test) {
        return test.matches(VALIDATION_REGEX);
    }

    /**
     * Converts a user input string into a corresponding Year
     * @return The corresponding Year from 1-6
     * @throws IllegalArgumentException if year is invalid
     */
    public static Year fromString(String year) {
        if (!isValidYear(year)) {
            throw new IllegalArgumentException(MESSAGE_CONSTRAINTS);
        }
        switch (Integer.parseInt(year)) {
        case 1: return YEAR_1;
        case 2: return YEAR_2;
        case 3: return YEAR_3;
        case 4: return YEAR_4;
        case 5: return YEAR_5;
        case 6: return YEAR_6;
        default: throw new IllegalArgumentException(MESSAGE_CONSTRAINTS);
        }
    }

    @Override
    public String toString() {
        return "Year " + value;
    }
}
