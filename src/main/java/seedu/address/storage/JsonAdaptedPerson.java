package seedu.address.storage;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.person.Email;
import seedu.address.model.person.Housing;
import seedu.address.model.person.Link;
import seedu.address.model.person.Major;
import seedu.address.model.person.Name;
import seedu.address.model.person.Person;
import seedu.address.model.person.Phone;
import seedu.address.model.person.Year;
import seedu.address.model.tag.Tag;

/**
 * Jackson-friendly version of {@link Person}.
 */
class JsonAdaptedPerson {

    public static final String MISSING_FIELD_MESSAGE_FORMAT = "Person's %s field is missing!";

    private final String name;
    private final String phone;
    private final String email;
    private final String year;
    private final String major;
    private final String housing;
    private final String link;
    private final List<JsonAdaptedTag> tags = new ArrayList<>();

    /**
     * Constructs a {@code JsonAdaptedPerson} with the given person details.
     */
    @JsonCreator
    public JsonAdaptedPerson(@JsonProperty("name") String name, @JsonProperty("phone") String phone,
            @JsonProperty("email") String email, @JsonProperty("year") String year,
            @JsonProperty("major") String major, @JsonProperty("housing") String housing,
            @JsonProperty("link") String link, @JsonProperty("tags") List<JsonAdaptedTag> tags) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.year = year;
        this.major = major;
        this.housing = housing;
        this.link = link;
        if (tags != null) {
            this.tags.addAll(tags);
        }
    }

    /**
     * Converts a given {@code Person} into this class for Jackson use.
     */
    public JsonAdaptedPerson(Person source) {
        name = source.getName().fullName;
        phone = source.getPhone() != null ? source.getPhone().value : null;
        email = source.getEmail() != null ? source.getEmail().value : null;
        year = source.getYear() != null ? String.valueOf(source.getYear().value) : null;
        major = source.getMajor() != null ? source.getMajor().value : null;
        housing = source.getHousing() != null ? source.getHousing().value : null;
        link = source.getLink() != null ? source.getLink().value : null;
        tags.addAll(source.getTags().stream()
                .map(JsonAdaptedTag::new)
                .collect(Collectors.toList()));
    }

    /**
     * Converts this Jackson-friendly adapted person object into the model's {@code Person} object.
     *
     * @throws IllegalValueException if there were any data constraints violated in the adapted
     *         person.
     */
    public Person toModelType() throws IllegalValueException {
        final List<Tag> personTags = new ArrayList<>();
        for (JsonAdaptedTag tag : tags) {
            personTags.add(tag.toModelType());
        }

        if (name == null) {
            throw new IllegalValueException(
                    String.format(MISSING_FIELD_MESSAGE_FORMAT, Name.class.getSimpleName()));
        }
        if (!Name.isValidName(name)) {
            throw new IllegalValueException(Name.MESSAGE_CONSTRAINTS);
        }
        final Name modelName = new Name(name);

        Phone modelPhone;
        if (phone != null) {
            if (!Phone.isValidPhone(phone)) {
                throw new IllegalValueException(Phone.MESSAGE_CONSTRAINTS);
            }
            modelPhone = new Phone(phone);
        } else {
            modelPhone = null;
        }

        Email modelEmail;
        if (email != null) {
            if (!Email.isValidEmail(email)) {
                throw new IllegalValueException(Email.MESSAGE_CONSTRAINTS);
            }
            modelEmail = new Email(email);
        } else {
            modelEmail = null;
        }

        Year modelYear;
        if (year != null) {
            if (!Year.isValidYear(year)) {
                throw new IllegalValueException(Year.MESSAGE_CONSTRAINTS);
            }
            modelYear = Year.fromString(year);
        } else {
            modelYear = null;
        }

        Link modelLink;
        if (link != null) {
            if (!Link.isValidLink(link)) {
                throw new IllegalValueException(Link.MESSAGE_CONSTRAINTS);
            }
            modelLink = new Link(link);
        } else {
            modelLink = null;
        }

        Major modelMajor;
        if (major != null) {
            if (!Major.isValidMajor(major)) {
                throw new IllegalValueException(Major.MESSAGE_CONSTRAINTS);
            }
            modelMajor = new Major(major);
        } else {
            modelMajor = null;
        }

        Housing modelHousing;
        if (housing != null) {
            if (!Housing.isValidHousing(housing)) {
                throw new IllegalValueException(Housing.MESSAGE_CONSTRAINTS);
            }
            modelHousing = new Housing(housing);
        } else {
            modelHousing = null;
        }

        final Set<Tag> modelTags = new HashSet<>(personTags);
        return new Person(modelName, modelPhone, modelEmail, modelYear, modelMajor, modelHousing,
                modelLink, modelTags);
    }

}
