package seedu.address.ui;

import java.util.Comparator;

import javafx.fxml.FXML;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import seedu.address.model.person.Person;

/**
 * An UI component that displays information of a {@code Person}.
 */
public class PersonCard extends UiPart<Region> {

    private static final String FXML = "PersonListCard.fxml";

    /**
     * Note: Certain keywords such as "location" and "resources" are reserved keywords in JavaFX.
     * As a consequence, UI elements' variable names cannot be set to such keywords
     * or an exception will be thrown by JavaFX during runtime.
     *
     * @see <a href="https://github.com/se-edu/addressbook-level4/issues/336">The issue on AddressBook level 4</a>
     */

    public final Person person;

    @FXML
    private HBox cardPane;
    @FXML
    private Label name;
    @FXML
    private Label id;
    @FXML
    private Label phone;
    @FXML
    private Label year;
    @FXML
    private Label major;
    @FXML
    private Label housing;
    @FXML
    private Label email;
    @FXML
    private FlowPane tags;
    @FXML
    private FlowPane modules;
    @FXML
    private Hyperlink link;

    /**
     * Creates a {@code PersonCode} with the given {@code Person} and index to display.
     */
    public PersonCard(Person person, int displayedIndex) {
        super(FXML);
        this.person = person;
        id.setText(displayedIndex + ". ");
        name.setText(person.getName().fullName);

        // For non-mandatory fields don't show if is null.
        // Managed: https://stackoverflow.com/a/28559958
        phone.setText(person.getPhone() != null ? person.getPhone().value : "");
        phone.setVisible(person.getPhone() != null);
        phone.setManaged(person.getPhone() != null);

        year.setText(person.getYear() != null ? String.valueOf(person.getYear()) : "");
        year.setVisible(person.getYear() != null);
        year.setManaged(person.getYear() != null);

        major.setText(person.getMajor() != null ? person.getMajor().value : "");
        major.setVisible(person.getMajor() != null);
        major.setManaged(person.getMajor() != null);

        housing.setText(person.getHousing() != null ? person.getHousing().value : "");
        housing.setVisible(person.getHousing() != null);
        housing.setManaged(person.getHousing() != null);

        email.setText(person.getEmail() != null ? person.getEmail().value : "");
        email.setVisible(person.getEmail() != null);
        email.setManaged(person.getEmail() != null);

        person.getTags().stream()
                .sorted(Comparator.comparing(tag -> tag.tagName))
                .forEach(tag -> tags.getChildren().add(new Label(tag.tagName)));
        person.getModules().stream()
                .sorted(Comparator.comparing(module -> module.value))
                .forEach(module -> modules.getChildren().add(new Label(module.value)));
        if (person.getLink() == null) {
            link.setDisable(true);
        } else {
            link.setOnAction(event -> {
                Clipboard.copyToClipboard(person.getLink().value);
                PopupMessage.showMessage(cardPane, "Link copied!");
            });
        }
    }

        }
    }
}
