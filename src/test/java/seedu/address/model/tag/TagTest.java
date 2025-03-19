package seedu.address.model.tag;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

public class TagTest {

    @Test
    public void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new Tag(null));
    }

    @Test
    public void constructor_invalidTagName_throwsIllegalArgumentException() {
        String invalidTagName = "";
        assertThrows(IllegalArgumentException.class, () -> new Tag(invalidTagName));
    }

    @Test
    public void isValidTagName() {
        // null tag name
        assertThrows(NullPointerException.class, () -> Tag.isValidTagName(null));
    }

    @Test
    public void equals() {
        Tag friendTag = new Tag("friend");
        Tag familyTag = new Tag("family");

        // same values -> returns true
        Tag friendTagCopy = new Tag("friend");
        assertTrue(friendTag.equals(friendTagCopy));

        // same object -> returns true
        assertTrue(friendTag.equals(friendTag));
        assertTrue(familyTag.equals(familyTag));

        // null -> returns false
        assertFalse(friendTag.equals(null));

        // different types -> returns false
        assertFalse(friendTag.equals(5.0f));
    }

}
