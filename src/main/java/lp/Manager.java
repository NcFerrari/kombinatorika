package lp;

import lp.be.service.LoggerService;
import lp.be.serviceimpl.LoggerServiceImpl;
import lp.enums.NamespaceEnum;
import lp.fe.javafx.MainApp;
import org.apache.log4j.Logger;

public class Manager {

    private static Manager manager;
    private final LoggerService loggerService = LoggerServiceImpl.getInstance(Manager.class);
    private final Logger log = loggerService.getLog();

    public static void getInstance() {
        if (manager == null) {
            manager = new Manager();
            javafx.application.Application.launch(MainApp.class);
        }
    }

    private Manager() {
        log.info(NamespaceEnum.START_APPLICATION_TEXT.getText());
    }

    public static void main(String[] args) {
        getInstance();
    }

}
