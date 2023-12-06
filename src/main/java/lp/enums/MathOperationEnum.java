package lp.enums;

import javafx.scene.image.Image;

import java.util.Objects;

public enum MathOperationEnum {

    VARIATION(NamespaceEnum.VARIATION_TEXT, NamespaceEnum.VARIATION_FORMULA, NamespaceEnum.VARIATION_FORMULA_IMAGE),
    PERMUTATION(NamespaceEnum.PERMUTATION_TEXT, NamespaceEnum.PERMUTATION_FORMULA,
            NamespaceEnum.PERMUTATION_FORMULA_IMAGE);

    private final NamespaceEnum title;
    private final NamespaceEnum formulaText;
    private final NamespaceEnum imagePath;

    MathOperationEnum(NamespaceEnum title, NamespaceEnum formulaText, NamespaceEnum imagePath) {
        this.title = title;
        this.formulaText = formulaText;
        this.imagePath = imagePath;
    }
//

    public String getTitle() {
        return title.getText();
    }

    public String getFormulaText() {
        return formulaText.getText();
    }

    public Image getImage() {
        return new Image(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream(imagePath.getText())));
    }

    public NamespaceEnum getNamespace() {
        return title;
    }
}
