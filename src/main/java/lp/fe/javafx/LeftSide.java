package lp.fe.javafx;

import javafx.collections.FXCollections;
import javafx.collections.ObservableMap;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import lp.be.mathematic.Combinatorics;
import lp.enums.MathOperationEnum;
import lp.enums.NamespaceEnum;

public class LeftSide {

    private final BorderPane leftPane;
    private final VBox flowPanes;
    private String functionPaneStyle = NamespaceEnum.BLUE_STYLE.getText();
    private final double widthSize;
    private final ObservableMap<NamespaceEnum, Label> labelMap = FXCollections.observableHashMap();
    private final Combinatorics combinatorics = new Combinatorics();
    private TextField kTextField;
    private TextField nTextField;

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
        kTextField = addTextField(inputPane);
        addLabel(inputPane, NamespaceEnum.N_TEXT.getText());
        nTextField = addTextField(inputPane);
    }

    public void addVariationPane() {
        addFunctionPane(MathOperationEnum.VARIATION);
    }

    public void addPermutationPane() {
        addFunctionPane(MathOperationEnum.PERMUTATION);
    }

    private void addFunctionPane(MathOperationEnum moe) {
        FlowPane functionPane = new FlowPane();
        functionPane.setHgap(20);
        functionPane.setAlignment(Pos.CENTER);
        functionPane.setPrefSize(widthSize - 5, 150);
        functionPane.getStyleClass().add(functionPaneStyle);
        functionPaneStyle = functionPaneStyle.equals(NamespaceEnum.BLUE_STYLE.getText()) ?
                NamespaceEnum.LIGHT_BLUE_STYLE.getText() : NamespaceEnum.BLUE_STYLE.getText();
        flowPanes.getChildren().add(functionPane);
        Label title = new Label(moe.getTitle());
        title.getStyleClass().add(NamespaceEnum.FUNCTION_TITLE_STYLE.getText());
        Label formula = new Label(moe.getFormulaText());
        formula.getStyleClass().add(NamespaceEnum.FUNCTION_TITLE_STYLE.getText());
        ImageView formulaImage = new ImageView();
        formulaImage.setImage(moe.getImage());
        formulaImage.setFitWidth(150);
        formulaImage.setFitHeight(75);
        Label result = new Label();
        result.getStyleClass().add(NamespaceEnum.FUNCTION_TITLE_STYLE.getText());
        labelMap.put(moe.getNamespace(), result);
        Button showButton = new Button(NamespaceEnum.COUNT.getText());
        functionPane.getChildren().addAll(title, formula, formulaImage, result, showButton);
    }

    private void addLabel(FlowPane inputPane, String text) {
        Label label = new Label(text);
        label.getStyleClass().add(NamespaceEnum.INPUT_LABEL_STYLE.getText());
        label.setFont(new Font(45));
        inputPane.getChildren().add(label);
    }

    private TextField addTextField(FlowPane inputPane) {
        TextField textField = new TextField();
        textField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches(NamespaceEnum.NUMBER_REGEX.getText())) {
                textField.setText(oldValue);
            }
            count();
        });
        inputPane.getChildren().add(textField);
        return textField;
    }

    private void count() {
        if (kTextField.getText().isBlank() || nTextField.getText().isBlank()) {
            return;
        }
        int k = Integer.parseInt(kTextField.getText());
        int n = Integer.parseInt(nTextField.getText());
        labelMap.get(NamespaceEnum.VARIATION_TEXT).setText(String.valueOf(combinatorics.variation(k, n)));
        labelMap.get(NamespaceEnum.PERMUTATION_TEXT).setText(String.valueOf(combinatorics.permutation(n)));
    }

}
