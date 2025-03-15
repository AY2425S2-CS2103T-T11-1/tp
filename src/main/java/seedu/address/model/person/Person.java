package seedu.address.model.person;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import seedu.address.commons.util.ToStringBuilder;
import seedu.address.model.mod.Mod;
import seedu.address.model.tag.Tag;

/**
 * Represents a Person in the address book.
 * Guarantees: details are present and not null, field values are validated,
 * immutable.
 */
public class Person {

    // Identity fields
    private final Name name;
    private final Phone phone;
    private final Email email;

    // Data fields
    private final Year year;
    private final Major major;
    private final Housing housing;
    private final Set<Tag> tags = new HashSet<>();
    private final Set<Mod> modules = new HashSet<>();
    private final Link link;


    /**
     * Every field must be present and not null.
     */
    public Person(Name name, Phone phone, Email email, Year year, Major major, Housing housing,
            Link link, Set<Tag> tags) {
        requireAllNonNull(name, phone, email, year, housing, tags);
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.year = year;
        this.major = major;
        this.housing = housing;
        this.link = link;
        this.tags.addAll(tags);
        this.modules.addAll(modules);
    }

    public Name getName() {
        return name;
    }

    public Phone getPhone() {
        return phone;
    }

    public Email getEmail() {
        return email;
    }

    public Year getYear() {
        return year;
    }

    public Major getMajor() {
        return major;
    }

    public Housing getHousing() {
        return housing;
    }

    public Link getLink() {
        return link;
    }

    /**
     * Returns an immutable tag set, which throws
     * {@code UnsupportedOperationException} if modification is attempted.
     */
    public Set<Tag> getTags() {
        return Collections.unmodifiableSet(tags);
    }

    /**
     * Returns an immutable module set, which throws
     * {@code UnsupportedOperationException} if modification is attempted.
     */
    public Set<Mod> getModules() {
        return Collections.unmodifiableSet(modules);
    }

    /**
     * Returns true if both persons have the same name.
     * This defines a weaker notion of equality between two persons.
     */
    public boolean isSamePerson(Person otherPerson) {
        if (otherPerson == this) {
            return true;
        }

        return otherPerson != null
                && otherPerson.getName().equals(getName());
    }

    /**
     * Returns true if both persons have the same identity and data fields.
     * This defines a stronger notion of equality between two persons.
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof Person)) {
            return false;
        }

        Person otherPerson = (Person) other;
        return name.equals(otherPerson.name)
                && phone.equals(otherPerson.phone)
                && email.equals(otherPerson.email)
                && year.equals(otherPerson.year)
                && major.equals(otherPerson.major)
                && housing.equals(otherPerson.housing)
                && link.equals(otherPerson.link)
                && tags.equals(otherPerson.tags)
                && modules.equals(otherPerson.modules);
    }

    @Override
    public int hashCode() {
        // use this method for custom fields hashing instead of implementing your own
        return Objects.hash(name, phone, email, year, major, housing, link, tags, modules);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .add("name", name)
                .add("phone", phone)
                .add("email", email)
                .add("year", year)
                .add("major", major)
                .add("housing", housing)
                .add("tags", tags)
                .add("modules", modules)
                .add("link", link)
                .toString();
    }

}
