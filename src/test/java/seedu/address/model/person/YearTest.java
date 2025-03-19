package seedu.address.model.person;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

public class YearTest {

    @Test
    public void isValidYear() {
        // null year
        assertThrows(NullPointerException.class, () -> Year.isValidYear(null));

        // invalid year
        assertFalse(Year.isValidYear("")); // empty string
        assertFalse(Year.isValidYear(" ")); // spaces only
        assertFalse(Year.isValidYear("Computer Science")); // not a number

        assertFalse(Year.isValidYear("-1")); // out of range
        assertFalse(Year.isValidYear("0")); // out of range
        assertFalse(Year.isValidYear("7")); // out of range
        assertFalse(Year.isValidYear("1.5")); // not a whole number
        assertFalse(Year.isValidYear("1.0")); // not an integer

        // valid year
        assertTrue(Year.isValidYear("1"));
        assertTrue(Year.isValidYear("2"));
        assertTrue(Year.isValidYear("3"));
        assertTrue(Year.isValidYear("4"));
        assertTrue(Year.isValidYear("5"));
        assertTrue(Year.isValidYear("6"));
    }

    @Test
    public void year_fromString() {
        // null year
        assertThrows(NullPointerException.class, () -> Year.fromString(null));

        // invalid year
        assertThrows(IllegalArgumentException.class, () -> Year.fromString("")); // empty string
        assertThrows(IllegalArgumentException.class, () -> Year.fromString(" ")); // spaces only
        // not a number
        assertThrows(IllegalArgumentException.class, () -> Year.fromString("Computer Science"));
        assertThrows(IllegalArgumentException.class, () -> Year.fromString("-1")); // out of range
        assertThrows(IllegalArgumentException.class, () -> Year.fromString("0")); // out of range
        assertThrows(IllegalArgumentException.class, () -> Year.fromString("7")); // out of range
        // not an integer
        assertThrows(IllegalArgumentException.class, () -> Year.fromString("1.5"));
        assertThrows(IllegalArgumentException.class, () -> Year.fromString("1.0"));

        // valid year
        assertTrue(Year.fromString("1") == Year.YEAR_1);
        assertTrue(Year.fromString("2") == Year.YEAR_2);
        assertTrue(Year.fromString("3") == Year.YEAR_3);
        assertTrue(Year.fromString("4") == Year.YEAR_4);
        assertTrue(Year.fromString("5") == Year.YEAR_5);
        assertTrue(Year.fromString("6") == Year.YEAR_6);
    }

    @Test
    public void year_toString() {
        assertTrue(Year.YEAR_1.toString().equals("Year 1"));
        assertTrue(Year.YEAR_2.toString().equals("Year 2"));
        assertTrue(Year.YEAR_3.toString().equals("Year 3"));
        assertTrue(Year.YEAR_4.toString().equals("Year 4"));
        assertTrue(Year.YEAR_5.toString().equals("Year 5"));
        assertTrue(Year.YEAR_6.toString().equals("Year 6"));
    }
}
