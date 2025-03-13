package seedu.address.storage;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import seedu.address.model.mod.Mod;

/**
 * Jackson-friendly version of {@link Mod}.
 */
public class JsonAdaptedMod {
    private final String moduleCode;
    private final String title;

    /**
     * Constructs a {@code JsonAdaptedMod} with the given module details.
     */
    @JsonCreator
    public JsonAdaptedMod(@JsonProperty("moduleCode") String moduleCode, @JsonProperty("title") String title) {
        this.moduleCode = moduleCode;
        this.title = title;
    }

    /**
     * Converts a given {@code Mod} into this class for Jackson use.
     */
    public JsonAdaptedMod(Mod source) {
        moduleCode = source.getModuleCode().toString();
        title = source.getTitle().toString();
    }

    /**
     * Converts this Jackson-friendly adapted mod object into the model's {@code Mod} object.
     */
    public Mod toModelType() {
        return new Mod(moduleCode, title);
    }
}
