package lp.fe.javafx;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import lp.enums.NamespaceEnum;

public class LeftSide {

    private final VBox leftPane;

    public LeftSide(Scene scene, HBox mainPane) {
        leftPane = new VBox();
        leftPane.setPrefWidth(scene.getWidth() / 2);
        mainPane.getChildren().add(leftPane);
    }

    public void initInputPane() {
        FlowPane inputPane = new FlowPane();
        inputPane.setAlignment(Pos.CENTER);
        leftPane.getChildren().add(inputPane);

        addLabel(inputPane, NamespaceEnum.K_TEXT.getText());
        addTextField(inputPane);
        addLabel(inputPane, NamespaceEnum.N_TEXT.getText());
        addTextField(inputPane);
    }

    private void addLabel(FlowPane inputPane, String text) {
        Label label = new Label(text);
        label.getStyleClass().add(NamespaceEnum.INPUT_LABEL_STYLE.getText());
        label.setFont(new Font(45));
        inputPane.getChildren().add(label);
    }

    private void addTextField(FlowPane inputPane) {
        TextField textField = new TextField();
        textField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches(NamespaceEnum.NUMBER_REGEX.getText())) {
                textField.setText(oldValue);
            }
        });
        inputPane.getChildren().add(textField);
    }

}
