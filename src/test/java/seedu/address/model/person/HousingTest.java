package seedu.address.model.person;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

public class HousingTest {

    @Test
    public void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new Housing(null));
    }

    @Test
    public void constructor_invalidHousing_throwsIllegalArgumentException() {
        String invalidHousing = "";
        assertThrows(IllegalArgumentException.class, () -> new Housing(invalidHousing));
    }

    @Test
    public void isValidHousing() {
        // null housing
        assertThrows(NullPointerException.class, () -> Housing.isValidHousing(null));

        // invalid housing
        assertFalse(Housing.isValidHousing("")); // empty string
        assertFalse(Housing.isValidHousing(" ")); // spaces only

        // valid housing
        assertTrue(Housing.isValidHousing("Lighthouse Block 29/3/J"));
        assertTrue(Housing.isValidHousing("-")); // one character
        assertTrue(Housing.isValidHousing("UTown Residence North Tower Floor 10 Unit 204 Room B")); // long housing
    }

    @Test
    public void equals() {
        Housing housing = new Housing("Valid Housing");

        // same values -> returns true
        assertTrue(housing.equals(new Housing("Valid Housing")));

        // same object -> returns true
        assertTrue(housing.equals(housing));

        // null -> returns false
        assertFalse(housing.equals(null));

        // different types -> returns false
        assertFalse(housing.equals(5.0f));

        // different values -> returns false
        assertFalse(housing.equals(new Housing("Other Valid Housing")));
    }
}
