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

    public static void getInstance() {
        if (manager == null) {
            manager = new Manager();
        }
    }

    private Manager() {
        log.info("WELCOME TO MATHEMATIC");
        count();
    }

    private void count() {
        log.info(combinatorics.variation(2, 3));
        log.info(combinatorics.permutation(4));
        log.info(combinatorics.variation(3, 8) - combinatorics.permutation(4));
        combinatorics.count();
        log.info(combinatorics.factorial(7));
    }

    public static void main(String[] args) {
        getInstance();
    }

}
