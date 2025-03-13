package seedu.address.model.person;

import java.util.List;
import java.util.function.Predicate;

import seedu.address.commons.util.StringUtil;
import seedu.address.commons.util.ToStringBuilder;

/**
 * Tests that a {@code Person}'s {@code Mod} matches any of the keywords given.
 */
public class ModContainsKeywordsPredicate implements Predicate<Person> {
    private final List<String> keywords;

    public ModContainsKeywordsPredicate(List<String> keywords) {
        this.keywords = keywords;
    }

    @Override
    public boolean test(Person person) {
        return person.getModules().stream()
                .anyMatch(mod -> keywords.stream()
                        .anyMatch(keyword -> StringUtil.containsWordIgnoreCase(
                                mod.getModuleCode().toString(), keyword))
                );

    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof ModContainsKeywordsPredicate)) {
            return false;
        }

        ModContainsKeywordsPredicate otherNameContainsKeywordsPredicate = (ModContainsKeywordsPredicate) other;
        return keywords.equals(otherNameContainsKeywordsPredicate.keywords);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).add("keywords", keywords).toString();
    }
}
