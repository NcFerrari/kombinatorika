package lp.fe.javafx;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import lp.enums.NamespaceEnum;

import java.awt.Dimension;
import java.awt.Toolkit;

public class MainApp extends Application {

    private final Toolkit tools = Toolkit.getDefaultToolkit();
    private final Dimension src = tools.getScreenSize();

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle(NamespaceEnum.TITLE.getText());
        HBox mainPane = new HBox();
        Scene scene = new Scene(mainPane, src.getWidth() / 2, src.getHeight() / 2);
        primaryStage.setScene(scene);
        primaryStage.show();

        dynamicDevelopmentStyling(scene);

        LeftSide leftSide = new LeftSide(scene, mainPane);
        leftSide.initInputPane();


//        Label label = new Label("Variace");
//        Label label3 = new Label("V(k, n)");
//        Button button2 = new Button("Vypočítej");
//        mainPane.getChildren().addAll(label);
    }

    private void dynamicDevelopmentStyling(Scene scene) {
        Thread t = new Thread(() -> {
            while (true) {
                Platform.runLater(() -> {
                    scene.getStylesheets().remove(NamespaceEnum.TEMPORARY_CSS_FILE.getText());
                    scene.getStylesheets().add(NamespaceEnum.TEMPORARY_CSS_FILE.getText());
                });
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });
        t.setDaemon(true);
        t.start();
    }
}
