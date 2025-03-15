package seedu.address.model.person;
import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

import java.util.HashSet;
import java.util.Set;

// import java.util.regex.Matcher;
// import java.util.regex.Pattern;

/**
 * Represents a Person's NUSMods link in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidEmail(String)}
 */
public class Link {
    public static final String MESSAGE_CONSTRAINTS =
        "Link needs to be a valid NUSMods timetable link";
    private static final String URL_PREFIX = "https://nusmods.com/timetable/";

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
     * Extract Module Codes from a given link.
     */
    public static Set<String> extractCodes(String test) {
        Set<String> codes = new HashSet<>();

        int queryStart = test.indexOf('?');
        if (queryStart == -1 || queryStart == test.length() - 1) {
            return codes; // no query parameters
        }

        String queryString = test.substring(queryStart + 1);
        String[] pairs = queryString.split("&");

        for (String pair : pairs) {
            int equalPos = pair.indexOf('=');
            if (equalPos != -1) {
                codes.add(pair.substring(0, equalPos));
            } else {
                codes.add(pair); // handles case with no '='
            }
        }
        return codes;
    }

    /**
     * Returns if a given string is a valid timetable.
     */
    public static boolean isValidLink(String test) {
        // return true;
        return test.startsWith(URL_PREFIX);
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
