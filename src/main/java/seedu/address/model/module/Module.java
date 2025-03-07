package seedu.address.model.module;

import seedu.address.commons.util.ToStringBuilder;

import java.util.Objects;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

/**
 * Represents an NUS Module in NUSMates
 * Guarantees: details are present and not null, field values are validated, immutable.
 */
public class Module {
    // Identity fields
    private final ModuleCode moduleCode;
    private final Title title;

    /**
     * Every field must be present and not null.
     */
    public Module(ModuleCode moduleCode, Title title) {
        requireAllNonNull(moduleCode, title);
        this.moduleCode = moduleCode;
        this.title = title;
    }

    /**
     *
     * @return The NUS module's module code
     */
    public ModuleCode getModuleCode() {
        return this.moduleCode;
    }

    /**
     *
     * @return The NUS module's title
     */
    public Title getTitle() {
        return this.title;
    }

    /**
     * Returns true if both modules have the same code.
     * This defines a weaker notion of equality between two modules.
     */
    public boolean isSameModule(Module otherModule) {
        if (otherModule == this) {
            return true;
        }

        return otherModule != null
                && otherModule.getModuleCode().equals(this.getModuleCode());
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