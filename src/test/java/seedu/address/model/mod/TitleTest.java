package seedu.address.model.mod;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

public class TitleTest {

    @Test
    public void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new Title(null));
    }

    @Test
    public void constructor_invalidTitle_throwsIllegalArgumentException() {
        String invalidTitle = "";
        assertThrows(IllegalArgumentException.class, () -> new Title(invalidTitle));
    }

    @Test
    public void isValidTitle() {
        // null title
        assertThrows(NullPointerException.class, () -> Title.isValidTitle(null));

        // invalid titles
        assertFalse(Title.isValidTitle("")); // empty string
        assertFalse(Title.isValidTitle(" ")); // spaces only
        assertFalse(Title.isValidTitle(" Leading space")); // leading whitespace

        // valid titles
        assertTrue(Title.isValidTitle("Software Engineering")); // this module
        assertTrue(Title.isValidTitle("Data Structures & Algorithms")); // special characters allowed
        assertTrue(Title.isValidTitle("French 4")); // alphanumeric allowed
    }

    @Test
    public void equals() {
        Title title = new Title("Software Engineering");

        // same values -> returns true
        assertTrue(title.equals(new Title("Software Engineering")));

        // same object -> returns true
        assertTrue(title.equals(title));

        // null -> returns false
        assertFalse(title.equals(null));

        // different types -> returns false
        assertFalse(title.equals("String"));

        // different values -> returns false
        assertFalse(title.equals(new Title("Linear Algebra")));
    }
}
