package seedu.address.ui;

import javafx.scene.input.ClipboardContent;

/**
 * Utility class for clipboard operations.
 */
public class Clipboard {

    /**
     * Copies the given text to the system clipboard.
     *
     * @param text The text to copy.
     */
    public static void copyToClipboard(String text) {
        javafx.scene.input.Clipboard clipboard = javafx.scene.input.Clipboard.getSystemClipboard();
        ClipboardContent content = new ClipboardContent();
        content.putString(text);
        clipboard.setContent(content);
    }
}
