package seedu.address.ui;

import javafx.animation.FadeTransition;
import javafx.application.Platform;
import javafx.scene.control.Label;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Popup;
import javafx.util.Duration;

/**
 * Utility class for showing a small disappearing message message.
 */
public class PopupMessage {

    /**
     * Displays a temporary message that disappears after a few seconds.
     *
     * @param parent The parent Region (HBox, VBox, StackPane) to show the message in.
     * @param message The message to display.
     */
    public static void showMessage(Region parent, String message) {
        Platform.runLater(() -> {
            Label messageLabel = new Label(message);
            messageLabel.setFont(new Font(14));
            messageLabel.setTextFill(Color.WHITE);
            messageLabel.setStyle(
                    "-fx-background-color: rgba(0, 0, 0, 0.75); " + "-fx-padding: 10px; -fx-background-radius: 5;");

            Popup popup = new Popup();
            popup.getContent().add(messageLabel);
            popup.setAutoHide(true);

            // Position at the bottom center of the window
            double centerX = parent.getScene().getWindow().getX() + parent.getScene().getWidth() / 2
                    - messageLabel.getWidth() / 2;
            double centerY = parent.getScene().getWindow().getY() + parent.getScene().getHeight() - 50;
            popup.setX(centerX);
            popup.setY(centerY);

            // Fade out effect
            FadeTransition fadeOut = new FadeTransition(Duration.seconds(2), messageLabel);
            fadeOut.setFromValue(1.0);
            fadeOut.setToValue(0.0);
            fadeOut.setOnFinished(e -> popup.hide());

            popup.show(parent.getScene().getWindow());
            fadeOut.play();
        });
    }
}


