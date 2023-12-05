package lp;

import lp.be.mathematic.Combinatorics;
import lp.be.service.LoggerService;
import lp.be.serviceimpl.LoggerServiceImpl;

import org.apache.log4j.Logger;

public class Manager {

    private static Manager manager;
    private final LoggerService loggerService = LoggerServiceImpl.getInstance(Manager.class);
    private final Logger log = loggerService.getLog();
    private final Combinatorics combinatorics = new Combinatorics();

    public static Manager getInstance() {
        if (manager == null) {
            manager = new Manager();
        }
        return manager;
    }

    private Manager() {
        log.info(combinatorics.variation(2, 3));
    }

    public static void main(String[] args) {
        getInstance();
    }

}
