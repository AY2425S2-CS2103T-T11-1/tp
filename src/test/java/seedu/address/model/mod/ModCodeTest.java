package seedu.address.model.mod;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

public class ModCodeTest {

    @Test
    public void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new ModuleCode(null));
    }

    @Test
    public void constructor_invalidModuleCode_throwsIllegalArgumentException() {
        String invalidModuleCode = "";
        assertThrows(IllegalArgumentException.class, () -> new ModuleCode(invalidModuleCode));
    }

    @Test
    public void isValidModuleCode() {
        // null module code
        assertThrows(NullPointerException.class, () -> ModuleCode.isValidModuleCode(null));

        // invalid module code
        assertFalse(ModuleCode.isValidModuleCode("1231")); // only numbers
        assertFalse(ModuleCode.isValidModuleCode("CS2040#")); // contains non-alphanumeric characters
        assertFalse(ModuleCode.isValidModuleCode("CS 2030 S")); // contains spaces
        assertFalse(ModuleCode.isValidModuleCode("CS")); // doesn't contain 4 digit number
        assertFalse(ModuleCode.isValidModuleCode("CS230S")); // contains less than 4 digits
        assertFalse(ModuleCode.isValidModuleCode("SIGMA1101")); // prefix longer than 4 characters


        // valid module code
        assertTrue(ModuleCode.isValidModuleCode("CS2103T")); // this module
        assertTrue(ModuleCode.isValidModuleCode("MA1522")); // no suffix
        assertTrue(ModuleCode.isValidModuleCode("CS2040DE")); // contains suffix
        assertTrue(ModuleCode.isValidModuleCode("UTOB2001AIS")); // 4 character prefix with suffix
        assertTrue(ModuleCode.isValidModuleCode("DMA1402L01")); // 3 character prefix, 3 character suffix with number
        assertTrue(ModuleCode.isValidModuleCode("cs2101"));
    }

    @Test
    public void equals() {
        ModuleCode moduleCode = new ModuleCode("CS2103T");

        // same values -> returns true
        assertTrue(moduleCode.equals(new ModuleCode("CS2103T")));

        // same object -> returns true
        assertTrue(moduleCode.equals(moduleCode));

        // null -> returns false
        assertFalse(moduleCode.equals(null));

        // different types -> returns false
        assertFalse(moduleCode.equals("String"));

        // different values -> returns false
        assertFalse(moduleCode.equals(new ModuleCode("CS2103")));
    }
}
