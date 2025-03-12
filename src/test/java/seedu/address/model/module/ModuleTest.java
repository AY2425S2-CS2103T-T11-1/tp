package seedu.address.model.module;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class ModuleTest {

    private static final ModuleCode MODULE_CODE_CS2103T = new ModuleCode("CS2103T");
    private static final Title TITLE_CS2103T = new Title("Software Engineering");
    private static final Module MODULE_CS2103T = new Module(MODULE_CODE_CS2103T, TITLE_CS2103T);

    @Test
    public void isSameModule() {
        // same object -> returns true
        assertTrue(MODULE_CS2103T.isSameModule(MODULE_CS2103T));

        // null -> returns false
        assertFalse(MODULE_CS2103T.isSameModule(null));

        // same module code, different title -> returns true
        Module edited2103 = new Module(MODULE_CODE_CS2103T, new Title("SE"));
        assertTrue(MODULE_CS2103T.isSameModule(edited2103));

        // different module code, all other attributes same -> returns false
        edited2103 = new Module(new ModuleCode("CS2103"), TITLE_CS2103T);
        assertFalse(MODULE_CS2103T.isSameModule(edited2103));

        // different module code with same value -> returns true
        edited2103 = new Module(new ModuleCode("CS2103T"), TITLE_CS2103T);
        assertTrue(MODULE_CS2103T.isSameModule(edited2103));
    }

    @Test
    public void equals() {
        // same object -> returns true
        assertTrue(MODULE_CS2103T.equals(MODULE_CS2103T));

        // null -> returns false
        assertFalse(MODULE_CS2103T.equals(null));

        // different type -> returns false
        assertFalse(MODULE_CS2103T.equals("String"));
    }

    @Test
    public void toStringMethod() {
        String expected = Module.class.getCanonicalName() + "{module code=" + MODULE_CS2103T.getModuleCode()
                + ", title=" + MODULE_CS2103T.getTitle() + "}";
        assertEquals(expected, MODULE_CS2103T.toString());
    }
}
