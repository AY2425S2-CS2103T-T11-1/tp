package seedu.address.model.mod;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.Objects;

import seedu.address.commons.util.ToStringBuilder;

/**
 * Represents an NUS Module in NUSMates
 * Guarantees: details are present and not null, field values are validated, immutable.
 */
public class Mod {
    // Identity fields
    private final ModuleCode moduleCode;
    private final Title title;

    /**
     * Every field must be present and not null.
     */
    public Mod(ModuleCode moduleCode, Title title) {
        requireAllNonNull(moduleCode, title);
        this.moduleCode = moduleCode;
        this.title = title;
    }

    /**
     * Gets the module code
     * @return The NUS module's module code
     */
    public ModuleCode getModuleCode() {
        return this.moduleCode;
    }

    /**
     * Gets the module title
     * @return The NUS module's title
     */
    public Title getTitle() {
        return this.title;
    }

    /**
     * Returns true if both modules have the same code.
     * This defines a weaker notion of equality between two modules.
     */
    public boolean isSameModule(Mod otherMod) {
        if (otherMod == this) {
            return true;
        }

        return otherMod != null
                && otherMod.getModuleCode().equals(this.getModuleCode());
    }

    @Override
    public int hashCode() {
        // use this method for custom fields hashing instead of implementing your own
        return Objects.hash(moduleCode, title);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .add("module code", moduleCode)
                .add("title", title)
                .toString();
    }
}
