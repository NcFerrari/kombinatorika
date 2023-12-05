package lp.be.serviceimpl;

import lp.be.service.LoggerService;
import org.apache.log4j.Logger;

public class LoggerServiceImpl implements LoggerService {
    private static LoggerService loggerService;
    private static Logger log;

    public static <T> LoggerService getInstance(Class<T> classLogging) {
        if (loggerService == null) {
            loggerService = new LoggerServiceImpl();
        }

        log = Logger.getLogger(classLogging);
        return loggerService;
    }

    private LoggerServiceImpl() {
    }

    public Logger getLog() {
        return log;
    }
}
