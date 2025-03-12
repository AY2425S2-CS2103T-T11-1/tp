package seedu.address.model.module;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Represents the Module Code of an NUS course
 * Guarantees: immutable; is valid as declared in
 * {@link #isValidModuleCode(String)}
 */
public class ModuleCode {
    public static final String MESSAGE_CONSTRAINTS = "Module Code should be of the format prefix-code-suffix, where:\n"
            + "1. The prefix has length 2-4 composed of capitalized letters.\n"
            + "2. The code is a 4-digit number.\n"
            + "3. The suffix has length 0-5, which can be composed of capitalized letters and/or numbers.\n";

    /*
     * The module code must start with a 2-4 letter prefix,
     * followed by a 4-digit number, and may be followed with a 1-2 letter suffix.
     * All letters must be capitalized
     *
     */
    public static final String VALIDATION_REGEX = "[A-Z]{2,4}\\d{4}[A-Z0-9]{0,5}";

    public final String value;

    /**
     * Constructs a {@code ModuleCode}.
     *
     * @param moduleCode A valid module code.
     */
    public ModuleCode(String moduleCode) {
        requireNonNull(moduleCode);
        checkArgument(isValidModuleCode(moduleCode), MESSAGE_CONSTRAINTS);
        this.value = moduleCode;
    }

    /**
     * Returns if a given string is a valid module code.
     */
    public static boolean isValidModuleCode(String test) {
        return test.matches(VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return this.value;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof ModuleCode)) {
            return false;
        }

        ModuleCode otherModuleCode = (ModuleCode) other;
        return this.value.equals(otherModuleCode.value);
    }

    @Override
    public int hashCode() {
        return this.value.hashCode();
    }
}
