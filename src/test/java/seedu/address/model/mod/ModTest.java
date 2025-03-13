package seedu.address.model.mod;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class ModTest {

    private static final ModuleCode MODULE_CODE_CS2103T = new ModuleCode("CS2103T");
    private static final Title TITLE_CS2103T = new Title("Software Engineering");
    private static final Mod MOD_CS_2103_T = new Mod(MODULE_CODE_CS2103T, TITLE_CS2103T);

    @Test
    public void isSameModule() {
        // same object -> returns true
        assertTrue(MOD_CS_2103_T.isSameModule(MOD_CS_2103_T));

        // null -> returns false
        assertFalse(MOD_CS_2103_T.isSameModule(null));

        // same module code, different title -> returns true
        Mod edited2103 = new Mod(MODULE_CODE_CS2103T, new Title("SE"));
        assertTrue(MOD_CS_2103_T.isSameModule(edited2103));

        // different module code, all other attributes same -> returns false
        edited2103 = new Mod(new ModuleCode("CS2103"), TITLE_CS2103T);
        assertFalse(MOD_CS_2103_T.isSameModule(edited2103));

        // different module code with same value -> returns true
        edited2103 = new Mod(new ModuleCode("CS2103T"), TITLE_CS2103T);
        assertTrue(MOD_CS_2103_T.isSameModule(edited2103));
    }

    @Test
    public void equals() {
        // same object -> returns true
        assertTrue(MOD_CS_2103_T.equals(MOD_CS_2103_T));

        // null -> returns false
        assertFalse(MOD_CS_2103_T.equals(null));

        // different type -> returns false
        assertFalse(MOD_CS_2103_T.equals("String"));
    }

    @Test
    public void toStringMethod() {
        String expected = Mod.class.getCanonicalName() + "{module code=" + MOD_CS_2103_T.getModuleCode()
                + ", title=" + MOD_CS_2103_T.getTitle() + "}";
        assertEquals(expected, MOD_CS_2103_T.toString());
    }
}
