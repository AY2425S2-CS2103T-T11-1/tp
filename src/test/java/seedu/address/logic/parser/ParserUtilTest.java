package seedu.address.logic.parser;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.logic.parser.ParserUtil.MESSAGE_INVALID_INDEX;
import static seedu.address.testutil.Assert.assertThrows;
import static seedu.address.testutil.TypicalIndexes.INDEX_FIRST_PERSON;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.person.Email;
import seedu.address.model.person.Housing;
import seedu.address.model.person.Major;
import seedu.address.model.person.Name;
import seedu.address.model.person.Phone;
import seedu.address.model.person.Year;
import seedu.address.model.tag.Tag;

public class ParserUtilTest {
    private static final String INVALID_NAME = "R@chel";
    private static final String INVALID_PHONE = "+651234";
    private static final String INVALID_HOUSING = " ";
    private static final String INVALID_YEAR = "0";
    private static final String INVALID_MAJOR = " ";
    private static final String INVALID_EMAIL = "example.com";
    private static final String INVALID_TAG = "#friend";

    private static final String VALID_NAME = "Rachel Walker";
    private static final String VALID_PHONE = "12345678";
    private static final String VALID_HOUSING = "123 Main Street #0505";
    private static final String VALID_YEAR = "1";
    private static final String VALID_MAJOR = "Computer Science";
    private static final String VALID_EMAIL = "rachel@example.com";
    private static final String VALID_TAG_1 = "friend";
    private static final String VALID_TAG_2 = "neighbour";

    private static final String WHITESPACE = " \t\r\n";

    @Test
    public void parseIndex_invalidInput_throwsParseException() {
        assertThrows(ParseException.class, () -> ParserUtil.parseIndex("10 a"));
    }

    @Test
    public void parseIndex_outOfRangeInput_throwsParseException() {
        assertThrows(ParseException.class, MESSAGE_INVALID_INDEX, ()
                -> ParserUtil.parseIndex(Long.toString(Integer.MAX_VALUE + 1)));
    }

    @Test
    public void parseIndex_validInput_success() throws Exception {
        assertEquals(INDEX_FIRST_PERSON, ParserUtil.parseIndex("1"));
        assertEquals(INDEX_FIRST_PERSON, ParserUtil.parseIndex("  1  "));
    }

    @Test
    public void parseName_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> ParserUtil.parseName((String) null));
    }

    @Test
    public void parseName_invalidValue_throwsParseException() {
        assertThrows(ParseException.class, () -> ParserUtil.parseName(INVALID_NAME));
    }

    @Test
    public void parseName_validValueWithoutWhitespace_returnsName() throws Exception {
        assertEquals(new Name(VALID_NAME), ParserUtil.parseName(VALID_NAME));
    }

    @Test
    public void parseName_validValueWithWhitespace_returnsTrimmedName() throws Exception {
        assertEquals(new Name(VALID_NAME), ParserUtil.parseName(WHITESPACE + VALID_NAME + WHITESPACE));
    }

    @Test
    public void parsePhone_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> ParserUtil.parsePhone((String) null));
    }

    @Test
    public void parsePhone_invalidValue_throwsParseException() {
        assertThrows(ParseException.class, () -> ParserUtil.parsePhone(INVALID_PHONE));
    }

    @Test
    public void parsePhone_validValueWithoutWhitespace_returnsPhone() throws Exception {
        assertEquals(new Phone(VALID_PHONE), ParserUtil.parsePhone(VALID_PHONE));
    }

    @Test
    public void parsePhone_validValueWithWhitespace_returnsTrimmedPhone() throws Exception {
        assertEquals(new Phone(VALID_PHONE), ParserUtil.parsePhone(WHITESPACE + VALID_PHONE + WHITESPACE));
    }

    @Test
    public void parseHousing_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> ParserUtil.parseHousing((String) null));
    }

    @Test
    public void parseHousing_invalidValue_throwsParseException() {
        assertThrows(ParseException.class, () -> ParserUtil.parseHousing(INVALID_HOUSING));
    }

    @Test
    public void parseHousing_validValueWithoutWhitespace_returnsHousing() throws Exception {
        assertEquals(new Housing(VALID_HOUSING), ParserUtil.parseHousing(VALID_HOUSING));
    }

    @Test
    public void parseHousing_validValueWithWhitespace_returnsTrimmedHousing() throws Exception {
        assertEquals(new Housing(VALID_HOUSING), ParserUtil.parseHousing(WHITESPACE + VALID_HOUSING + WHITESPACE));
    }

    @Test
    public void parseYear_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> ParserUtil.parseYear((String) null));
    }

    @Test
    public void parseYear_invalidValue_throwsParseException() {
        assertThrows(ParseException.class, () -> ParserUtil.parseYear(INVALID_YEAR));
    }

    @Test
    public void parseYear_validValueWithoutWhitespace_returnsYear() throws Exception {
        assertEquals(Year.fromString(VALID_YEAR), ParserUtil.parseYear(VALID_YEAR));
    }

    @Test
    public void parseMajor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> ParserUtil.parseMajor((String) null));
    }

    @Test
    public void parseMajor_invalidValue_throwsParseException() {
        assertThrows(ParseException.class, () -> ParserUtil.parseMajor(INVALID_MAJOR));
    }

    @Test
    public void parseMajor_validValueWithoutWhitespace_returnsMajor() throws Exception {
        assertEquals(new Major(VALID_MAJOR), ParserUtil.parseMajor(VALID_MAJOR));
    }

    @Test
    public void parseMajor_validValueWithWhitespace_returnsTrimmedMajor() throws Exception {
        assertEquals(new Major(VALID_MAJOR), ParserUtil.parseMajor(WHITESPACE + VALID_MAJOR + WHITESPACE));
    }

    @Test
    public void parseEmail_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> ParserUtil.parseEmail((String) null));
    }

    @Test
    public void parseEmail_invalidValue_throwsParseException() {
        assertThrows(ParseException.class, () -> ParserUtil.parseEmail(INVALID_EMAIL));
    }

    @Test
    public void parseEmail_validValueWithoutWhitespace_returnsEmail() throws Exception {
        assertEquals(new Email(VALID_EMAIL), ParserUtil.parseEmail(VALID_EMAIL));
    }

    @Test
    public void parseEmail_validValueWithWhitespace_returnsTrimmedEmail() throws Exception {
        assertEquals(new Email(VALID_EMAIL), ParserUtil.parseEmail(WHITESPACE + VALID_EMAIL + WHITESPACE));
    }

    @Test
    public void parseTag_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> ParserUtil.parseTag(null));
    }

    @Test
    public void parseTag_invalidValue_throwsParseException() {
        assertThrows(ParseException.class, () -> ParserUtil.parseTag(INVALID_TAG));
    }

    @Test
    public void parseTag_validValueWithoutWhitespace_returnsTag() throws Exception {
        assertEquals(new Tag(VALID_TAG_1), ParserUtil.parseTag(VALID_TAG_1));
    }

    @Test
    public void parseTag_validValueWithWhitespace_returnsTrimmedTag() throws Exception {
        assertEquals(new Tag(VALID_TAG_1), ParserUtil.parseTag(WHITESPACE + VALID_TAG_1 + WHITESPACE));
    }

    @Test
    public void parseTags_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> ParserUtil.parseTags(null));
    }

    @Test
    public void parseTags_collectionWithInvalidTags_throwsParseException() {
        assertThrows(ParseException.class, () -> ParserUtil.parseTags(Arrays.asList(VALID_TAG_1, INVALID_TAG)));
    }

    @Test
    public void parseTags_emptyCollection_returnsEmptySet() throws Exception {
        assertTrue(ParserUtil.parseTags(Collections.emptyList()).isEmpty());
    }

    @Test
    public void parseTags_collectionWithValidTags_returnsTagSet() throws Exception {
        Set<Tag> expectedTagSet = new HashSet<>(Arrays.asList(new Tag(VALID_TAG_1), new Tag(VALID_TAG_2)));
        assertEquals(expectedTagSet, ParserUtil.parseTags(Arrays.asList(VALID_TAG_1, VALID_TAG_2)));
    }
}
