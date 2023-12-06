package lp.fe.javafx;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import lp.enums.NamespaceEnum;

public class LeftSide {

    private final BorderPane leftPane;
    private final VBox flowPanes;
    private String functionPaneStyle = NamespaceEnum.BLUE_STYLE.getText();
    private final double widthSize;

    public LeftSide(Scene scene, HBox mainPane) {
        widthSize = scene.getWidth() / 2;
        leftPane = new BorderPane();
        leftPane.setPrefWidth(widthSize);
        mainPane.getChildren().add(leftPane);

        flowPanes = new VBox();
        leftPane.setCenter(new ScrollPane(flowPanes));
    }

    public void initInputPane() {
        FlowPane inputPane = new FlowPane();
        inputPane.setAlignment(Pos.CENTER);
        leftPane.setTop(inputPane);

        addLabel(inputPane, NamespaceEnum.K_TEXT.getText());
        addTextField(inputPane);
        addLabel(inputPane, NamespaceEnum.N_TEXT.getText());
        addTextField(inputPane);
    }

    public void addVariationPane() {
        addFunctionPane(NamespaceEnum.VARIATION_TEXT.getText(), NamespaceEnum.VARIATION_FORMULA.getText());
    }

    private void addFunctionPane(String text, String formulaText) {
        FlowPane functionPane = new FlowPane();
        functionPane.setAlignment(Pos.CENTER_LEFT);
        functionPane.setPrefSize(widthSize - 5, 150);
        functionPane.getStyleClass().add(functionPaneStyle);
        functionPaneStyle = functionPaneStyle.equals(NamespaceEnum.BLUE_STYLE.getText()) ?
                NamespaceEnum.LIGHT_BLUE_STYLE.getText() : NamespaceEnum.BLUE_STYLE.getText();
        flowPanes.getChildren().add(functionPane);
        Label title = new Label(text);
        title.getStyleClass().add(NamespaceEnum.FUNCTION_TITLE_STYLE.getText());
        Label formula = new Label(formulaText);
        formula.getStyleClass().add(NamespaceEnum.FUNCTION_TITLE_STYLE.getText());
        Button button = new Button(NamespaceEnum.COUNT.getText());
        functionPane.getChildren().addAll(title, formula, button);
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
