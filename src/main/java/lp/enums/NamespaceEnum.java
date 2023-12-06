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
    TEMPORARY_CSS_FILE("file:///C://temp/temporaryCSS.css"),
    INPUT_LABEL_STYLE("input-label-style");

    private final String text;

    NamespaceEnum(String text) {
        this.text = text;
    }
}
