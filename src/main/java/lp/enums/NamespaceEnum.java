package lp.enums;

import lombok.Getter;

@Getter
public enum NamespaceEnum {

    EMPTY_STRING(""),
    START_APPLICATION_TEXT("Application started"),
    TITLE("Kombinatorika"),
    //    NUMBER_REGEX("\\d*(\\.\\d*)?"), <-Takhle by to bylo pro desetiny :)
    NUMBER_REGEX("\\d*"),
    K_TEXT("k="),
    N_TEXT("n="),
    VARIATION_TEXT("VARIACE"),
    VARIATION_FORMULA("V(k, n)"),
    VARIATION_FORMULA_IMAGE("images/variace.png"),
    COUNT("Zobraz"),
    TEMPORARY_CSS_FILE("file:///C://temp/temporaryCSS.css"),
    BLUE_STYLE("blue-style"),
    LIGHT_BLUE_STYLE("light-blue-style"),
    FUNCTION_TITLE_STYLE("function-style"),
    INPUT_LABEL_STYLE("input-label-style");

    private final String text;

    NamespaceEnum(String text) {
        this.text = text;
    }
}
